package MyThread.ThreadExecutor;

public class WorkThread extends Thread {
	/**
	 * 是否正在运行的标志
	 */
	private volatile boolean isRunning = false;

	public boolean getIsRunning() {
		return isRunning;
	}

	/**
	 * 任务
	 */
	private Runnable runnable = null;

	/**
	 * 提交任务
	 * 
	 * @param runnable
	 */
	public void setRunnable(Runnable runnable) {
		if (!isRunning) {
			this.runnable = runnable;
			this.setIsRunning(true);

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
				this.runnable = null;
			}
		}

	}

}
