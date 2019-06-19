package MyThread.ThreadExecutor2;

public class WorkThread extends Thread {

	private volatile boolean isRunning = false;
	Runnable executor;

	public boolean getIsRunning() {
		return isRunning;
	}

	private Runnable runnable = null;

	public void setRunnable(Runnable runnable, Runnable executor) {
		if (!isRunning) {
			this.runnable = runnable;
			this.setIsRunning(true);
			this.executor = executor;

		} else {
			System.out.println("线程忙");
		}
	}

	public synchronized void setIsRunning(boolean isRunning) {
		if (isRunning) {
			this.notify();
		}
		this.isRunning = isRunning;
	}

	@Override
	public synchronized void run() {
		while (true) {
			if (!isRunning) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				runnable.run();
				this.setIsRunning(false);

				System.out.println("尝试唤醒");
				this.runnable = null;
				synchronized (executor) {
					executor.notify();
				}
			}
		}

	}

}
