package in.co.dhdigital.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "transaction_details")
public class TransactionDetail {

	@Id 
	private Long id;
	private String accountNumber;
	private double balance;
	private double credit;
	private double debit;
	private String type;
	private String description;
	private Date dateTime;
	


	@PersistenceConstructor
	public TransactionDetail(@JsonProperty("id") Long id, @JsonProperty("accountNumber") String accountNumber, @JsonProperty("balance") double balance, @JsonProperty("credit") double credit, @JsonProperty("debit") double debit, @JsonProperty("type") String type,
			@JsonProperty("description") String description, @JsonProperty("dateTime") Date dateTime) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.credit = credit;
		this.debit = debit;
		this.type = type;
		this.description = description;
		this.dateTime = dateTime;
	}


	public TransactionDetail(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public double getCredit() {
		return credit;
	}


	public void setCredit(double credit) {
		this.credit = credit;
	}


	public double getDebit() {
		return debit;
	}


	public void setDebit(double debit) {
		this.debit = debit;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateTime() {
		return dateTime;
	}


	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
