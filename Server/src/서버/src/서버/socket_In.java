package 서버.src.서버;

import java.io.IOException;
import java.io.InputStream;

public class socket_In extends Thread{
//입력 받는 클래스

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
					
					if(bArr[0] == 'n') System.out.println("종료메세지 하지만 종료 안시킴");
					
					System.out.println("받은 메세지 : " + new String(bArr));
					bArr = new byte[100];
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(" - 클라이언트가 메세지 입력을 꺼버림");
		}
	}
	
}
