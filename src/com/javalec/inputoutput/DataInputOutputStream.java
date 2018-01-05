package com.javalec.inputoutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DataInputOutputStream {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		InputStream is = null;
		DataInputStream dis = null;

		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			is = new FileInputStream("C:\\Program Files\\Java\\myapp\\JavaIO\\DataInput_Test.txt");
			dis = new DataInputStream(is);
			String str = dis.readUTF(); // 왜 오류가 날까......스택오버플로우를 뒤져봐도 명확한 답을 얻기가 힘들다.

			os = new FileOutputStream("C:\\Program Files\\Java\\myapp\\JavaIO\\DataOutput_Test.txt");
			dos = new DataOutputStream(os);
			dos.writeUTF(str);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
