package ����.src.����;

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
			System.out.print("�޼��� �Է�(n�Է½� ä������) : ");
			String str = sc.next();
			
			
			try {

				if(str.equals("n"))break;
				out.write(str.getBytes());
				
			} catch (IOException e) {
				System.out.println("�޼��� �Է� ����");
			}finally{
			}

			System.out.println("�޼��� ���� �Ϸ�");
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