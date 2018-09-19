import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class Demo2_Receive {
	/**
	 * @param args
	 * 2.����Receive
	 * ����DatagramSocket,ָ���˿ں�
	 * ����DatagramPacket,ָ������,����,
	 * ʹ��DatagramSocket����DatagramPacket
	 * �ر�DatagramSocket
	 * ��DatagramPacket�л�ȡ����
	 * 3.���շ���ȡIP�Ͷ˿ں�
	 * String ip = packet.getAddress().getHostAddress();
	 * int port = packet.getPort();
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// ����socket,�൱�ڴ���һ����ͷ
		DatagramSocket socket = new DatagramSocket(12345);
		// ����packet,�൱�ڴ���һ����װ��
		DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

		while (true) {
			socket.receive(packet);// �Ӽ�װ���ȡ����
			byte[] arr = packet.getData();// ��ȡ���͹�������Ч�ֽڸ���
			int len = packet.getLength();
			String ip = packet.getAddress().getHostAddress();  //��ȡIP
			int port = packet.getPort();
			System.out.println(ip+":"+new String(arr, 0, len));
			System.out.println("�˿�:"+port);
			// socket.close();
		}
	}
}
