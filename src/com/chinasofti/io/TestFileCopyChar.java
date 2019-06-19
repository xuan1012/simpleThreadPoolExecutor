package com.chinasofti.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileCopyChar {
	public static void main(String[] args) {
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader("user.txt");
			writer = new FileWriter("user2.txt");
			char[] c = new char[1024];
			while (reader.read(c) != -1) {
				writer.write(c);
			}
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
