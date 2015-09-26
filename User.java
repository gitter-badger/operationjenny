
public class User {

	private String id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String address;
	private String creditCard;
	private Byte[] profPic; //edit when we find a better way
	
	public User(String json) {
		if (json.startsWith("{")) {
			String[] fields = json.split("\"");
			id = fields[3];
			firstName = fields[7];
			lastName = fields[15];
			username = fields[23];
			password = fields[31];
			address = fields[39];
			creditCard = fields[47];
		}
	}
	
	public String getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
}
