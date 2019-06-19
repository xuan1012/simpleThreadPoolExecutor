package SomeTest;

public class Z{
	public static void main(String[] args) {
		 try{
		     int x=100;
		     int y=0;

		     System.out.println("x/y="+x/y);

		     System.out.println("x/y计算结束");

		}catch(ArithmeticException e){

		     System.out.println("发生了数学异常，注意除数不能为0.");

		}

		System.out.println("main方法运行结束");

		}

}

