package MyThread;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name);
		for (int i = 0; i < 100; i++) {
			System.out.println(name + "第" + i);
		}
	}

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		Thread mr = new Thread(new MyRunnable());
		mr.start();
		mt.start();
		new Thread() {
			@Override
			public void run() {
				super.run();
				System.out.println("匿名线程启动");
			}
		}.start();
		new Thread(() -> {
			System.out.println("lambda线程启动");
		}).start();

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + i);
		}

	}
}

class MyRunnable implements Runnable {
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println(t);
		String name = t.getName();
		System.out.println(name);
		for (int i = 0; i < 100; i++) {
			System.out.println(name + "第" + i);
		}
	}
}