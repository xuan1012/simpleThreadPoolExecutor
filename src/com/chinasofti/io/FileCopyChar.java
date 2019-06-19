package com.chinasofti.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyChar {
	public static void main(String[] args) {
		FileReader reader = null;
		FileWriter writer = null;
		try {
			reader = new FileReader("d:\\tmp\\HelloWorld.java");
			writer = new FileWriter("d:\\tmp\\C.java");
			char[] buf = new char[1024];// ��������
			while (reader.read(buf) != -1) {
				writer.write(buf);
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
