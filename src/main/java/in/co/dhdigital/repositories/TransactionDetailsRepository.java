package in.co.dhdigital.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.co.dhdigital.models.TransactionDetail;

@Repository
public interface TransactionDetailsRepository extends MongoRepository<TransactionDetail, Long>{

	Optional<TransactionDetail> findAllByAccountNumber(String accountNumber);

	List<TransactionDetail> findByAccountNumber(String accountNumber);

}
