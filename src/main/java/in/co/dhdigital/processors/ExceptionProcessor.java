package in.co.dhdigital.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.co.dhdigital.models.FaultType;

public class ExceptionProcessor implements Processor {
	
	static Logger log =LoggerFactory.getLogger(ExceptionProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		
		log.info("ExceptionProcessor.process()");
		Exception e ;
		try {
			 e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
			 log.error("Handled Exception :"+e.getMessage());
			 handleFault(exchange, e);
		}catch (Exception exp) {
			handleFault(exchange, exp);
		}
	}
	
	public void handleFault(Exchange ex, Exception e) {
		
		FaultType fault = new FaultType();
		
		fault.setDescription("Error occurred while calling database");
		fault.setType("Database Exception");
		fault.setSystem("ESB");
		fault.setNativeDescription(e.getMessage());
		fault.setNumber(500);
		fault.setRetryAfter("Two mins");
		
		ex.getIn().setBody(fault);
		ex.getIn().setHeader("faultOccurred", true);

	}
}
