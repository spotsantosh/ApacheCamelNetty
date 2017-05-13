package com.santosh.acnetty;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer {
	static Logger LOG = LoggerFactory.getLogger(Consumer.class);

	public static void main(String[] args) {
		try {
			CamelContext context = new DefaultCamelContext();
			context.addRoutes(createRouteBuilder());
			context.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static RoutesBuilder createRouteBuilder() {
		return new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("netty:tcp://localhost:8095")	// read socket
				.process( new Processor() {

					int count = 0;
					long startMs = 0;
					
					@Override
					public void process(Exchange msg) throws Exception {
						if(count++ == 0){
							startMs = System.currentTimeMillis();
						}
						else if(count % 10000 == 0 || count == 1){
							System.out.println(
									" Received " + count + "th\t msg:" + msg.getIn().getBody()
									+ " After " + (System.currentTimeMillis() - startMs) + "ms.");
						}
						
					}
				})
				;
				
			}
		};
	}

}
