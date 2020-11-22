package MBank.core;

//import java.sql.Date;
import java.util.Date;

public class Activity {
	long id;
	int client_id;
	double amount;
	java.util.Date activity_date;
	double commission;
	String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getActivity_date() {
		return (Date) activity_date;
	}
	public void setActivity_date(java.util.Date date) {
		this.activity_date = date;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
