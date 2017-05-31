package challenge1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;
import org.apache.log4j.Logger;

public class Randomizer extends Thread {

	private static Logger logger = Logger.getLogger(Randomizer.class);
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outPutStream;
	private PriorityBlockingQueue<Integer> priorityBq;

	public Randomizer(Socket socket, PriorityBlockingQueue<Integer> priorityBq) {
		try {
			this.socket = socket;
			this.inputStream = socket.getInputStream();
			this.outPutStream = socket.getOutputStream();
			this.priorityBq = priorityBq;

			logger.info("Client connected : " + socket.getInetAddress().toString());
			// System.out.println("Client connected : " +
			// socket.getInetAddress().toString());
		} catch (IOException e) {
			logger.info("Could not initialize communication properly. -- CommunicationThread.\n");
			// System.out.println("Could not initialize communication properly.
			// -- CommunicationThread.\n");
		}
	}

	@Override
	public void run() {

		boolean active = true;
		while (active) {
			int message_number;
			try {
				message_number = inputStream.read();

				switch (message_number) {
				case -1:
				case 0:

					active = false;
					break;
				case 1:

					int element_to_add = new Random(500).nextInt();
					priorityBq.add(element_to_add);
					break;
				case 2:

					int res = priorityBq.poll();
					outPutStream.write(res);
					outPutStream.flush();
					break;

				}

				inputStream.close();
				outPutStream.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
