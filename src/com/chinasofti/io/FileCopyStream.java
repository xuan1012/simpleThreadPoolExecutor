package com.chinasofti.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyStream {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {

			fis = new FileInputStream("d:\\tmp\\HelloWorld.java");
			fos = new FileOutputStream("d:\\tmp\\C.java");
			byte[] buf = new byte[1024];// ��������
			while (fis.read(buf) != -1) {
				fos.write(buf);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if(fos!=null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
