import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Demo1_send {
	/**
	 * @param args
	 * 发送send
	 * 创建DatagramSocket,随机端口号
	 * 创建DatagramPacket,指定数据,长度,地址,端口
	 * 使用DatagramSocket发送DatagramPacket
	 * 关闭DatagramSocket
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// String str = "你好！";
		Scanner in = new Scanner(System.in);
		DatagramSocket socket = new DatagramSocket();
		while (true) {
			String line = in.nextLine();
			if (line.equals("quit")) {
				break;
			}
			DatagramPacket packet = new DatagramPacket(line.getBytes(),
					line.getBytes().length, InetAddress.getByName("127.0.0.1"),// ip
					12345);// 端口
			socket.send(packet); // 发送数据
		}
		socket.close(); // 把IO流关闭
	}
}
