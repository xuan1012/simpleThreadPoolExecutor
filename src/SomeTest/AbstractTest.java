package SomeTest;

public abstract class AbstractTest {

	public abstract void call();// 抽象方法，方法体以分号结束，只有声明，不需要实现

	public void message() {
		System.out.println("我是抽象类的普通方法");
	}// 抽象类中包含普通的方法
	public static void main(String[] args) {
		
	}
}
