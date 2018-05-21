package TestProject.src.TestPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Test{
	
	public void testClient() throws IOException {
		
		Socket socket = null;
		OutputStream out =null;
		InputStream in = null;
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		try{
//			server.Server(); 
			
			System.out.println("클라이언드 대기 ");
//			InetAddress.getLocalHost().getHostAddress()
//			"192.168.20.50"
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 182);
			
			if(socket.isConnected()){
				System.out.println("열림");
				
			}
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			socket_In si = new socket_In(in); 
			socket_Out so = new socket_Out(out);

			try {
				si.start();
				so.start();
				si.join();
//				so.join();
			} catch (Exception e) {
			}
			
//			new socket_In(in).start();	//입력받는 스레드
//			new socket_Out(out).start();	//입력하는 스레드
			
		}catch(Exception ex){
		}finally{
			if(socket == null){
				System.out.println("서버에 연결실패");
			}else{
				System.out.println("서버 닫음");
				socket.close();
			}
		}
		
	}


}
