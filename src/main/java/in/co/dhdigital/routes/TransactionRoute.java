package in.co.dhdigital.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import in.co.dhdigital.models.TransactionDetail;
import in.co.dhdigital.processors.ExceptionProcessor;
import in.co.dhdigital.processors.PostProcessor;
import in.co.dhdigital.processors.ResponseProcessor;
import in.co.dhdigital.services.TransactionDetailsService;


@Component
public class TransactionRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
      restConfiguration().component("jetty")
      .bindingMode(RestBindingMode.json)
      .dataFormatProperty("prettyPrint", "true")
      .port(8081);
      
    rest("/api/v1/transactiondetails")
    .consumes("application/json").produces("application/json")
    .get("/{accountnumber}").outType(TransactionDetail.class)
    .to("direct:get-transactiondetails")
    .post().outType(TransactionDetail.class)
    .to("direct:post-transactiondetails");
    
    from("direct:get-transactiondetails")
    .doTry().log("Inside get-transaction-details route")
    .bean(TransactionDetailsService.class, "getTransactionDetailsByAccountNumber")
   // .process("postProcessor")
    .bean(PostProcessor.class).doCatch(java.lang.Exception.class)
    .to("direct:exception")
    .endDoTry()
    //.process("responseProcessor");
    .bean(ResponseProcessor.class);
    
    from("direct:post-transactiondetails")
    .log("Inside post-transaction-detiails route")
    .bean(TransactionDetailsService.class, "insertTransactionDetail");
    
    
    from("direct:exception").bean(ExceptionProcessor.class);
    
    
	}

}
