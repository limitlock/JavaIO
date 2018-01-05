package com.javalec.inputoutput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		OutputStream os = null;
		try {

			os = new FileOutputStream("C:\\Program Files\\Java\\myapp\\JavaIO\\test.txt");

			/**
			 * String은 상수문자열이기 때문에, 기존의 저장되어있던 문자열은 삭제되고 새롭게 저장된 문자열만 기록된다.
			 */
			String str = "오늘 날씨가 참 좋습니다.";
			byte[] bs = str.getBytes(); // str 문자열을 byte 타입으로 전환하여 bs에 넣는다.
			os.write(bs);

		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}

	}

}
