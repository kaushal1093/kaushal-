package com.tech.task;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ImportResource({ "classpath:spring/camel-context.xml" })
public class CamelCxfApp {

    public static void main(String[] args) {
        SpringApplication.run(CamelCxfApp.class, args);
    }

    @Component
    static class Routes extends RouteBuilder {
        @Override
        public void configure() throws Exception {

      	  from("cxfrs://bean://createClaimCXFEndpoint?bindingStyle=SimpleConsumer")
    	  .log("Executing Employee #${body}")
    	  .choice()
    	  		.when(header("operationName").isEqualTo("createEmployees"))
    	  			.to("direct:createEmployee")
    	  		.when(header("operationName").isEqualTo("getEmployees"))
    	  			.to("direct:getEmployee")
    	  			.log("Completed Calls");
    	  
			  
			 

        }
    }

}


