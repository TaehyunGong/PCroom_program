package ����.src.����;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public void severs() throws IOException{
		
		ServerSocket serversocket = null;
		Socket socket = null;
		OutputStream out =null;
		InputStream in = null;
		
		try{
			
			serversocket = new ServerSocket(122);
			System.out.println("���� ����");
			socket = serversocket.accept();
			
			new socket_Out(socket.getOutputStream()).start();	//�Է��ϴ� ������
			new socket_In(socket.getInputStream()).start();	//�Է¹޴� ������

			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			socket_In si = new socket_In(in); 
			socket_Out so = new socket_Out(out);
			
			try {
				si.start();
				so.start();
				
				si.join();
				so.join();
			} catch (Exception e) {
				
			}
			
		}catch(Exception ex){
		}finally{
			socket.close();
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		new Server().severs();
	}

}
