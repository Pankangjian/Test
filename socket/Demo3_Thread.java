import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo3_Thread {
	/**
	 * 将发送端和接收端写进多线程
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		new Receive().start();// 启动线程
		Thread.sleep(10);
		new Send().start();// 启动线程
	}
}

class Receive extends Thread {
	public void run() {
		// 创建socket,相当于创建一个码头
		try {
			DatagramSocket socket = new DatagramSocket(12345);
			// 创建packet,相当于创建一个集装箱
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

			while (true) {
				socket.receive(packet);// 从集装箱获取数据
				byte[] arr = packet.getData();// 获取发送过来的有效字节个数
				int len = packet.getLength();
				String ip = packet.getAddress().getHostAddress(); // 获取IP
				int port = packet.getPort();
				System.out.println(ip + ":" + new String(arr, 0, len));
				System.out.println("端口:" + port);
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
						12345);// 端口
				socket.send(packet); // 发送数据
			}
			socket.close(); // 把IO流关闭
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
