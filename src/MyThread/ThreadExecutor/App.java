package MyThread.ThreadExecutor;

import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(3);
		tpe.execute(() -> {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " " + i + "第一个");
			}
		});
		tpe.execute(() -> {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " " + i + "第二个");
			}
		});
		tpe.execute(() -> {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " " + i + "第三个");
			}
		});
		tpe.execute(() -> {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " " + i + "第四个");
			}
		});
		tpe.execute(() -> {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " " + i + "第五个");
			}
		});
		tpe.execute(() -> {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " " + i + "第六个");
			}
		});
		tpe.execute(() -> {
			String name = Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name + " " + i + "第七个");
			}
			tpe.execute(() -> {
				String name1 = Thread.currentThread().getName();
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name1 + " " + i + "第七个里面的1");
				}
			});
			tpe.execute(() -> {
				String name2 = Thread.currentThread().getName();
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name2 + " " + i + "第七个里面的2");
				}
			});
			tpe.execute(() -> {
				String name3 = Thread.currentThread().getName();
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name3 + " " + i + "第七个里面的3");
				}
			});
			tpe.execute(() -> {
				String name4 = Thread.currentThread().getName();
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(name4 + " " + i + "第七个里面的4");
				}
			});
		});
	}

}
