package com.chinasofti.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("D:\\tmp\\a.txt");
		System.out.println(file);
		System.out.println(file.exists());
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(file.isFile() + ":" + file.isDirectory());
		File dir = new File("D:\\tmp");
		System.out.println(dir.isFile() + ":" + dir.isDirectory());

		File[] files = dir.listFiles();
		System.out.println(Arrays.toString(files));

		file.delete();
		System.out.println(file.exists());

		File newDir = new File("D:\\tmp\\abc");
		if (!newDir.exists()) {
			newDir.mkdir();
		}

	}

}
