package TestProject.src.TestPackage;

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
				
				in.read(bArr);
				
				if((int)(new String(bArr).charAt(0)) != 0){
					
					if(bArr[0] == 'n'){
						System.out.println("�޼��� ����");
						break;
					}
					
					System.out.println("���� �޼��� : " + new String(bArr));
					bArr = new byte[100];
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(" - ����");
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
