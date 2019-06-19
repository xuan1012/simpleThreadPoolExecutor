package com.chinasofti.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlieCopyBuffered {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader("d:\\tmp\\HelloWorld.java"));
			bw = new BufferedWriter(new FileWriter("d:\\tmp\\Sea.java"));

			String line = null;
			int lineNum=1;
			while ((line = br.readLine()) != null) {
				bw.write(lineNum +"\t"+line);
				bw.newLine();
				lineNum++;
			}
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
