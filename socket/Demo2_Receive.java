import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class Demo2_Receive {
	/**
	 * @param args
	 * 2.接受Receive
	 * 创建DatagramSocket,指定端口号
	 * 创建DatagramPacket,指定数据,长度,
	 * 使用DatagramSocket接收DatagramPacket
	 * 关闭DatagramSocket
	 * 从DatagramPacket中获取数据
	 * 3.接收方获取IP和端口号
	 * String ip = packet.getAddress().getHostAddress();
	 * int port = packet.getPort();
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// 创建socket,相当于创建一个码头
		DatagramSocket socket = new DatagramSocket(12345);
		// 创建packet,相当于创建一个集装箱
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

		while (true) {
			socket.receive(packet);// 从集装箱获取数据
			byte[] arr = packet.getData();// 获取发送过来的有效字节个数
			int len = packet.getLength();
			String ip = packet.getAddress().getHostAddress();  //获取IP
			int port = packet.getPort();
			System.out.println(ip+":"+new String(arr, 0, len));
			System.out.println("端口:"+port);
			// socket.close();
		}
	}
}
