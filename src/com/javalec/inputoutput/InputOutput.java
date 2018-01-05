package com.javalec.inputoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutput {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		/**
		 * 파일 처리에 관련된 클래스는 InputStream, OutputStream 과 Reader, Writer 가 있으며, 전자가 더 많이 사용된다.
		 * 전자는 1byte 단위, 후자는 2byte 단위이다.
		 */

		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream("C:\\Program Files\\Java\\myapp\\JavaIO\\test.txt");
			os = new FileOutputStream("C:\\Program Files\\Java\\myapp\\JavaIO\\test_cop1y.txt");

			byte[] bs = new byte[5];
			while (true) {
				int count = is.read(bs); // 5byte 단위로 test.txt를 읽어온다. 당연히 read() 보다 빠르다.
				if (count == -1)
					break;
				// 5byte단위로 끝어서 복사할 때, 끝부분에 남는 경우
				// ex) 만나서 반가워요. -> [만나서 반/가워요.]끝에 1byte가 남는다.
				// 남는 1byte가 error를 일으키기 때문에 끝부분의 경우 별도로 설정을 해준다.
				// [가/워/요/./ /] 이렇게 남을 때, 0에서 count 즉 읽은 부분까지만 복사하라고 설정한다.
				os.write(bs, 0, count);
			}

			//
			// while (true) {
			// int i = is.read();
			// if (i == -1)
			// break;
			// os.write(i); // 읽어드린 문자열의 바이트 값인 i를 test_copy.txt에 복사한다.
			// }

		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 사용하지 않는 객체는 메모리에서 제거한다.
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
