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
			
			System.out.println("Ŭ���̾�� ��� ");
//			InetAddress.getLocalHost().getHostAddress()
//			"192.168.20.50"
			socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 182);
			
			if(socket.isConnected()){
				System.out.println("����");
				
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
			
//			new socket_In(in).start();	//�Է¹޴� ������
//			new socket_Out(out).start();	//�Է��ϴ� ������
			
		}catch(Exception ex){
		}finally{
			if(socket == null){
				System.out.println("������ �������");
			}else{
				System.out.println("���� ����");
				socket.close();
			}
		}
		
	}


}
