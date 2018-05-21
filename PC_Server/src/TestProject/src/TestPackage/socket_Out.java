package TestProject.src.TestPackage;

import java.io.IOException;
import java.io.OutputStream;

public class socket_Out extends Thread{

	OutputStream out = null;
	java.util.Scanner sc = new java.util.Scanner(System.in);
	
	public socket_Out(OutputStream out) {
		this.out = out; 
	}
	
	public void run(){
		while(true){
			System.out.print("메세지 입력(n입력시 채팅종료), (s입력시 서버종료) : ");
			String str = sc.next();

			try {

				out.write(str.getBytes());
				if(str.equals("n")) break;

			} catch (IOException e) {
				System.out.println("메세지 입력 에러");
			}finally{
			}

			System.out.println("메세지 전송 완료");
		}
		try {
			out.close();
			System.out.println(" - message input exit");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
