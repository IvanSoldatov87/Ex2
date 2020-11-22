package MBank.core;

public class Client {
	
	
	int client_id;
	String username;
	String password;
	String type;
	String address;
	String email;
	String phone;
	String comment;
	
	
	public synchronized int getClient_id() {
		return client_id;
	}



	public synchronized void setClient_id(int client_id) {
		this.client_id = client_id;
	}



	public synchronized String getUsername() {
		return username;
	}



	public synchronized void setUsername(String username) {
		this.username = username;
	}



	public synchronized String getPassword() {
		return password;
	}



	public synchronized void setPassword(String password) {
		this.password = password;
	}



	public synchronized String getType() {
		return type;
	}



	public synchronized void setType(String type) {
		this.type = type;
	}



	public synchronized String getAddress() {
		return address;
	}



	public synchronized void setAddress(String address) {
		this.address = address;
	}



	public synchronized String getEmail() {
		return email;
	}



	public synchronized void setEmail(String email) {
		this.email = email;
	}



	public synchronized String getPhone() {
		return phone;
	}



	public synchronized void setPhone(String phone) {
		this.phone = phone;
	}



	public synchronized String getComment() {
		return comment;
	}



	public synchronized void setComment(String comment) {
		this.comment = comment;
	}
}
