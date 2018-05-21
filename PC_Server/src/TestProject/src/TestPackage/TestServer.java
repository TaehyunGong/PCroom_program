package TestProject.src.TestPackage;

import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

	ServerSocket serversocket;
	
	public TestServer() {
		serversocket = null;
	}

	public void Server(){
		Socket socket = null;
		try{
			System.out.println("서버1");
			serversocket = new ServerSocket(123);
			socket = serversocket.accept();
			System.out.println("왔음?");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
