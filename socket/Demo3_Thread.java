import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo3_Thread {
	/**
	 * �����Ͷ˺ͽ��ն�д�����߳�
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		new Receive().start();// �����߳�
		Thread.sleep(10);
		new Send().start();// �����߳�
	}
}

class Receive extends Thread {
	public void run() {
		// ����socket,�൱�ڴ���һ����ͷ
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			// ����packet,�൱�ڴ���һ����װ��
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

			while (true) {
				socket.receive(packet);// �Ӽ�װ���ȡ����
				byte[] arr = packet.getData();// ��ȡ���͹�������Ч�ֽڸ���
				int len = packet.getLength();
				String ip = packet.getAddress().getHostAddress(); // ��ȡIP
				int port = packet.getPort();
				System.out.println(ip + ":" + new String(arr, 0, len));
				System.out.println("�˿�:" + port);
				// socket.close();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	
class Send extends Thread {
	public void run() {
		try {
			Scanner in = new Scanner(System.in);
			DatagramSocket socket = new DatagramSocket();
			while (true) {
				String line = in.nextLine();
				if (line.equals("quit")) {
					break;
				}
				DatagramPacket packet = new DatagramPacket(line.getBytes(),
						line.getBytes().length,
						InetAddress.getByName("127.0.0.1"),// ip
						12345);// �˿�
				socket.send(packet); // ��������
			}
			socket.close(); // ��IO���ر�
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
