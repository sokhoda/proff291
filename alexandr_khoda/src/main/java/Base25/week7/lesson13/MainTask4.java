package Base25.week7.lesson13;

public class MainTask4 {
	private static final String	FILEFOLDER	= "E:\\1\\Task4Chat\\";

	public static void main(String[] args) {
		ThreadServer server = new ThreadServer(FILEFOLDER);
		ThreadClient client = new ThreadClient(server, FILEFOLDER);

		client.start();
		server.start();

	}
}
