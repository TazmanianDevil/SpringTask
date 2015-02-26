package com.hire;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;

public class Task1 {
	public static void main(String[] args) throws IOException {
		// Имена файлов захардкожены. По уму надо передавать через параметры командной строки
		String writeFile = "D:\\write.txt";
		String readFile = "D:\\read.txt";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(readFile), "Cp1251"))) {
			BufferedWriter bw = null;
			File f = new File (readFile);
			System.out.println(f.length());
			if (f.length() > 1024*1024*10) {
				bw = new BufferedWriter( new OutputStreamWriter(
						new GZIPOutputStream(new FileOutputStream(writeFile.replace(".txt", ".gz")))
						, "UTF-8"));
			} else {
				bw = new BufferedWriter( new OutputStreamWriter(
						new FileOutputStream(writeFile)
						, "UTF-8"));
			}
			int c = 0;
			while ((c = br.read())!= -1) {
				bw.write(c);
			}
			bw.flush();
			if (bw != null)
				bw.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
