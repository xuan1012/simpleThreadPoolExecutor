package MyThread;

public class SynchronizedTset {
	public static void main(String[] args) {
		TestClass tc = new TestClass(100);
		ThreadClass t1 = new ThreadClass(tc);
		ThreadClass t2 = new ThreadClass(tc);
		t1.start();
		t2.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(tc.getCount());
	}
}

class TestClass {
	private int count;

	public int getCount() {
		return count;
	}

	public TestClass(int count) {
		this.count = count;
	}

	synchronized void sub() {
		count--;
	}
}

class ThreadClass extends Thread {
	private TestClass tc;

	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tc.sub();
		}
//		System.out.println(tc.getCount());
	}

	public ThreadClass(TestClass tc) {
		this.tc = tc;

	}
}