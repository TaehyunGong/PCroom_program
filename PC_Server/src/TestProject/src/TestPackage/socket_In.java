package TestProject.src.TestPackage;

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
				
				in.read(bArr);
				
				if((int)(new String(bArr).charAt(0)) != 0){
					
					if(bArr[0] == 'n'){
						System.out.println("메세지 종료");
						break;
					}
					
					System.out.println("받은 메세지 : " + new String(bArr));
					bArr = new byte[100];
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(" - 종료");
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
