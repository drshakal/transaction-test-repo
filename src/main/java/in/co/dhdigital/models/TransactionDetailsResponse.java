package in.co.dhdigital.models;

import java.util.List;

public class TransactionDetailsResponse {

	private List<TransactionDetail> transactionDetails;
	private FaultType fault;
	private boolean faultOccurred;
	
	
	
	public boolean isFaultOccurred() {
		return faultOccurred;
	}
	public void setFaultOccurred(boolean faultOccurred) {
		this.faultOccurred = faultOccurred;
	}
	
	public List<TransactionDetail> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(List<TransactionDetail> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public FaultType getFault() {
		return fault;
	}
	public void setFault(FaultType fault) {
		this.fault = fault;
	}
	
	
}
