package in.co.dhdigital.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.co.dhdigital.models.FaultType;
import in.co.dhdigital.models.TransactionDetail;

public class PostProcessor implements Processor {
	static Logger log =LoggerFactory.getLogger(PostProcessor.class);

	@Override
	public void process(Exchange ex) throws Exception {
		log.info("Inside PostProcessor.process()");
		List<TransactionDetail> transactionDetails = ex.getIn().getBody(List.class);
		try {
			if (transactionDetails != null && transactionDetails.size() >0) {
				ex.getIn().setHeader("faultOccurred", false);
			} else {
				log.warn("No Records found");
				ex.getIn().setHeader("faultOccurred", true);

				handleFault(ex);
			}
		} catch (Exception e) {
			log.error("Error : " + e.toString());
			handleFault(ex);
		}
	}

	public void handleFault(Exchange ex) {
		ex.getIn().setHeader("faultOccurred", true);

		FaultType fault = new FaultType();
		fault.setDescription("No Record Found");
		fault.setType("Client Exception");
		fault.setSystem("ESB");
		fault.setNativeDescription("No Record Found");
		fault.setNumber(401);
		fault.setRetryAfter("Two mins");
		ex.getIn().setBody(fault);
	}
}
