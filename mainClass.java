import java.io.IOException;


public class mainClass {

	
	public static void main(String[] args) throws IOException {
		DatabaseManager dataman = new DatabaseManager();
		dataman.addUser(dataman.getUsers());
	}
}
