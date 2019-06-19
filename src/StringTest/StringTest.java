package StringTest;

public class StringTest {
	public static void main(String[] args) {
		String str2 = new String("str")+new String("01");
		String str3=str2.intern();
		String str1 = "str01";
		
		System.out.println(str3 == str1);// #8
	}

}
