package challenge1;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.PriorityBlockingQueue;
import org.apache.log4j.Logger;

public class PrimeRandomizer {

	private static Logger logger = Logger.getLogger(PrimeRandomizer.class);
	private static ServerSocket serverSocket;
	public PriorityBlockingQueue<Integer> priorityBq;

	PrimeRandomizer(int port, int pq_size) throws IOException {
		serverSocket = new ServerSocket(port);
		this.priorityBq = new PriorityBlockingQueue<Integer>(pq_size);
	}

	public static void main(String argv[]) throws InterruptedException {
		try {
			PrimeRandomizer server = new PrimeRandomizer(6789, 20);

			while (true) {

				System.out.println("Waiting for a Randomizer to connect...");

				new Randomizer(serverSocket.accept(), server.priorityBq).start();

				int num=server.priorityBq.take();
				int temp=0;
				for(int i=2;i<=num/2;i++)
				{
			           temp=num%i;
				   if(temp==0)
				   {
					  System.out.println(num + " is Prime Number");
				      break;
				   }
				}
				
			}
		} catch (IOException e) {
			System.out.println("Exception occured :" + e.getStackTrace());
		}
	}
}
