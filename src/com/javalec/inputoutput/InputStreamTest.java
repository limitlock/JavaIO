package com.javalec.inputoutput;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			// InputStream 을 이용하여 해달 프로젝트 폴더에 있는 파일을 읽는다.
			// inputStream 은 1byte 단위로 파일을 읽는다.(주로 이미지, 동영상을 읽을 때, 사용된다.)

			is = new FileInputStream("C:\\Program Files\\Java\\myapp\\JavaIO\\test.txt");
			while (true) {
				// read() 는 1byte 단위로 is를 읽는다.
				// read(byte[], off, len) 는 지정된 바이트 단위로 읽는다. (read()에 비해 속도가 빠르다)

				int i = is.read();
				System.out.println("데이터 : " + i);
				if (i == -1)
					break;
			}
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		} finally { // 사용하지 않는 객체는 메모리에서 제거한다.
			try {
				if (is != null) is.close();
			} catch (IOException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}

	}

}
