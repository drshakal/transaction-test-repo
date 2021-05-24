package in.co.dhdigital.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import in.co.dhdigital.models.TransactionDetail;

@Component
public class TransactionDetailsDao {

	private final TransactionDetailsRepository transactionDetailsRepository;

	public TransactionDetailsDao(TransactionDetailsRepository transactionDetailsRepository) {
		this.transactionDetailsRepository = transactionDetailsRepository;
	}
	
	public TransactionDetail insertTransactionDetails(TransactionDetail td) {
		return transactionDetailsRepository.save(td);
	}
	
	public List<TransactionDetail> getTransactionDetailsByAccountNumber(String accountNumber){

		return transactionDetailsRepository.findByAccountNumber(accountNumber);
	}
	
	public Collection<TransactionDetail> getAllTransactionDetails(){
		return transactionDetailsRepository.findAll();
	}
}
