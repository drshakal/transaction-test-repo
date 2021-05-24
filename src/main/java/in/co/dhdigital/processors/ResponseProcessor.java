package in.co.dhdigital.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.co.dhdigital.models.FaultType;
import in.co.dhdigital.models.TransactionDetail;
import in.co.dhdigital.models.TransactionDetailsResponse;

public class ResponseProcessor implements Processor{
	
	static Logger log =LoggerFactory.getLogger(ResponseProcessor.class);

	@Override
	public void process(Exchange ex) throws Exception {
		log.info("ResponseProcessor.process()");
		boolean faultOccurred = ex.getIn().getHeader("faultOccurred", Boolean.class);
		log.info("faultOccurred : "+ faultOccurred);
		
		TransactionDetailsResponse response = new TransactionDetailsResponse();
		FaultType fault = new FaultType();
		if (faultOccurred) {
			 fault = ex.getIn().getBody(FaultType.class);
			 response.setFault(fault);
			 response.setFaultOccurred(faultOccurred);
			 ex.getIn().setBody(response);
			 return;
		}
		
		List<TransactionDetail> transactionDetails =  ex.getIn().getBody(List.class);
		response.setFaultOccurred(faultOccurred);
		response.setTransactionDetails(transactionDetails);
		
		ex.getIn().setBody(response);
	}
	
	
	
}
