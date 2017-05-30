package challenge1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class PqClient {
	
	private static Logger logger = Logger.getLogger(PqClient.class);
    private static Socket skt;
    private InputStream in;
    private OutputStream out;

    private final int _STOP_ = 0, _ADD_ = 1, _POLL_ = 2;

    PqClient(String ip, int port) {
        try {
            this.skt = new Socket(ip, port);
            this.in = skt.getInputStream();
            this.out = skt.getOutputStream();
                       
            System.out.println("Connected to distributed priority queue.");
        } catch(IOException e) {
            System.out.println("Could not connect with the distributed priority queue : " + e.getMessage());
        }
    }

    
    public void stop() throws IOException {
        out.write(_STOP_);
        out.flush();
        out.close();
    }

    public void add(Integer el) throws IOException {
        out.write(_ADD_);
        out.flush();
    }
    
    public static void main(String a[]) throws IOException
    {
    	String ip = "localhost";
    	int port = 6789;

    	PqClient pq = new PqClient("localhost" , port);    
    	pq.add(5);
    	pq.add(2);
    	pq.add(4);
    	int res = pq.poll();
    	System.out.println(res);
    }

    public int poll() throws IOException {
        out.write(_POLL_);
        out.flush();
        return in.read();
    }
}  

