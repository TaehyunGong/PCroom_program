package ����.src.����;

import java.io.IOException;
import java.io.InputStream;

public class socket_In extends Thread{
//�Է� �޴� Ŭ����

	InputStream in = null;
	byte[] bArr = new byte[100];
	
	public socket_In(InputStream in) {
		this.in = in; 
	}
	
	public void run(){
		try {
			while(true){
				
				if((int)(new String(bArr).charAt(0)) == 0){
					in.read(bArr);
					
					if(bArr[0] == 'n') System.out.println("����޼��� ������ ���� �Ƚ�Ŵ");
					
					System.out.println("���� �޼��� : " + new String(bArr));
					bArr = new byte[100];
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(" - Ŭ���̾�Ʈ�� �޼��� �Է��� ������");
		}
	}
	
}
