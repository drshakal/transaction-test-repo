package in.co.dhdigital.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.camel.Exchange;

import in.co.dhdigital.models.TransactionDetail;
import in.co.dhdigital.repositories.TransactionDetailsDao;

public class TransactionDetailsService {

	private final TransactionDetailsDao transactionDetailsDao;

	public TransactionDetailsService(TransactionDetailsDao transactionDetailsDao) {
		this.transactionDetailsDao = transactionDetailsDao;
	}
	
	public TransactionDetail insertTransactionDetail(TransactionDetail td) {
		return transactionDetailsDao.insertTransactionDetails(td);
	}
	
	public Collection<TransactionDetail> getAllTransactionDetails(){
		return transactionDetailsDao.getAllTransactionDetails();
	}
	
	public List<TransactionDetail> getTransactionDetailsByAccountNumber(Exchange ex){
		String accountNumber = ex.getIn().getHeader("accountnumber", String.class);
		System.out.println("accountNumber: "+accountNumber);
		return transactionDetailsDao.getTransactionDetailsByAccountNumber(accountNumber);
	}
}
