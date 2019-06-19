package misc;

import java.lang.reflect.*;
import java.util.Date;

public class ReflectionTest {
	public static void main(String[] args) {
		// 得到类
		Class<Dogs> dogsClass = Dogs.class;
		System.out.println(dogsClass.getSimpleName());
		Class<?> dogsClass2 = new Dogs(3).getClass();
		System.out.println(dogsClass2);
		try {
			Class<?> dogsClass3 = Class.forName("misc.Dogs");
			System.out.println(dogsClass3.getCanonicalName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 得到属性
		Field[] fieldArr = dogsClass.getDeclaredFields();
		for (Field field : fieldArr) {
			System.out.println(field + "类型" + field.getType());
		}
		// 得到方法
		Method[] methodArr = dogsClass.getDeclaredMethods();
		for (Method method : methodArr) {
			System.out.println(method);
		}
		// 得到构造器
		Constructor<?>[] constructorArr = dogsClass.getDeclaredConstructors();
		for (Constructor<?> constructor : constructorArr) {
			System.out.println(constructor);
		}
		// 操作
		try {
			Dogs dog = dogsClass.newInstance();
			dog.setAge(5);
			dog.setName("来福");
			dog.setBirthday(new Date());
			System.out.println(dog);
			Dogs dog1 = new Dogs(2);

			Field ageField = dogsClass.getDeclaredField("age");
			ageField.setAccessible(true);
			int age = ageField.getInt(dog);
			int age1 = ageField.getInt(dog1);
			System.out.println(age);
			System.out.println(age1);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}
}

class Dogs {
	private int age;
	private String name;
	private Date birthday;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Dogs [age=" + age + ", name=" + name + ", birthday=" + birthday + "]";
	}

	public Dogs() {

	}

	public Dogs(int age) {
		this.age = age;
	}

}