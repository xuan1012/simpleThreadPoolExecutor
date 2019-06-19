package com.chinasofti.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileCopyStream {

	public static void main(String[] args) {
		FileInputStream str = null;
		FileOutputStream copy = null;
		try {
			str = new FileInputStream("user.txt");
			copy = new FileOutputStream("user2.txt");
			byte[] b = new byte[1024];
			while (str.read(b) != -1) {
				copy.write(b);
			}
			copy.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (str != null) {
					str.close();
				}
				if (copy != null) {
					copy.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
