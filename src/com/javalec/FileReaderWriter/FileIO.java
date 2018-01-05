package com.javalec.FileReaderWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIO {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		/**
		 * Reader, Writer 의 하위클래스로 문자 인코딩 변환에 관한 자동변환기능을 가지고 있다.
		 * 
		 * FileInputStream, FileOutputStream FileReader, FileWriter 차이점 1.위의 것은 byte 단위로
		 * 파일을 읽고 쓰며, 밑에 것은 byte를 char로 변환하여 읽고 쓴다. 
		 * 2.한글문자는 1byte가 넘기 때문에 버퍼를 이용하여 변환과정을 거쳐야하지만, 밑에것을 사용하는 경우 별도의 버퍼 처리 없이 사용이가능하다.
		 */

		int i = 0;

		File file = new File("file.txt");

		FileReader fr = null;
		FileWriter fw = null;

		InputStreamReader isr = null;

		try {
			isr = new InputStreamReader(System.in); // 콘솔창에서 들어오는 값을 읽겠다.
			fw = new FileWriter(file, true); // true로 boolean 값을 true로 주면 덮어씌우기가 아니라 append 한다.

			while ((i = isr.read()) != -1) { // 읽을게 없을 때까지 while을 돌린다. i는 byte를 정수화 한것이다.
				fw.write(i);
			}

			// 문자 입력이 완료되면 flush() 메소드를 통해, FileWriter의 버퍼에 저장된 입력받은 문자를 "file.txt" 파일에 쓴다.
			fw.flush();

			fr = new FileReader(file); // file.txt에 들어있는 문자열 값을 읽는다.

			while ((i = fr.read()) != -1) { // file.txt 파일의 끝까지 읽으면서 콘솔에 출력한다.
				System.out.print((char) i); // int(32)를 char(16)로 형변환하는 것은 큰것에서 작은 것이니 명시적으로 선언한다.
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally { // InputStreamReader, FileReader, FileWriter를 닫아준다.
			if (isr != null)
				try {
					isr.close();
				} catch (IOException e) {
				}
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
				}
			if (fw != null)
				try {
					fw.close();
				} catch (IOException e) {
				}
		}
	}

}
