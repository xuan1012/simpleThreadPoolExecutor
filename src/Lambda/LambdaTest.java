package Lambda;

public class LambdaTest {

	public static void main(String[] args) {
		Thread th = new Thread(new Runnable() {
			public void run() {
				System.out.println("hello");
			}
		});
		th.start();
		Thread th1 = new Thread(() -> System.out.println("hello lambda"));
	}

}
