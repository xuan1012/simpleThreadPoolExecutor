package MyThread;

public class XjadTest {
	public static void main(String[] args) {
		new Thread(() -> {
			System.out.println("lambda线程启动");
		}).start();

	}
}
