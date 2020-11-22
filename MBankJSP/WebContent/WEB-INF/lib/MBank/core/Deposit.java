package MBank.core;

import java.util.Date;

public class Deposit {
	long deposit_id;
	int client_id;
	double balance;
	String type;
	long estimated_balanse;
	Date open_date;
	Date close_date;
	public long getDeposit_id() {
		return deposit_id;
	}
	public void setDeposit_id(long deposit_id) {
		this.deposit_id = deposit_id;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getEstimated_balanse() {
		return estimated_balanse;
	}
	public void setEstimated_balanse(long estimated_balanse) {
		this.estimated_balanse = estimated_balanse;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date date) {
		this.open_date = date;
	}
	public Date getClose_date() {
		return close_date;
	}
	public void setClose_date(Date close_date) {
		this.close_date = close_date;
	}

}
