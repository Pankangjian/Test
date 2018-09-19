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
	 * ����send
	 * ����DatagramSocket,����˿ں�
	 * ����DatagramPacket,ָ������,����,��ַ,�˿�
	 * ʹ��DatagramSocket����DatagramPacket
	 * �ر�DatagramSocket
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// String str = "��ã�";
		Scanner in = new Scanner(System.in);
		DatagramSocket socket = new DatagramSocket();
		while (true) {
			String line = in.nextLine();
			if (line.equals("quit")) {
				break;
			}
			DatagramPacket packet = new DatagramPacket(line.getBytes(),
					line.getBytes().length, InetAddress.getByName("127.0.0.1"),// ip
					12345);// �˿�
			socket.send(packet); // ��������
		}
		socket.close(); // ��IO���ر�
	}
}
