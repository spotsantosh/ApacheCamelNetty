package com.santosh.acnetty;

import java.util.concurrent.Executors;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.BindyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer implements Runnable {
	static Logger LOG = LoggerFactory.getLogger(Producer.class);

	public static void main(String[] args) {
		System.out.println("Producer starting...");
		Executors.newSingleThreadExecutor().execute(new Producer());

	}

	@Override
	public void run() {
		try {
			CamelContext context = new DefaultCamelContext();
			context.addRoutes(createRouteBuilder());
			context.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private RouteBuilder createRouteBuilder(){

		return new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file:/home/santosh/workspace/ApacheCamelNetty/market_data/"
						+ "?fileName=AAPL_1m_2015-01-01_2017-05-01.csv"
						+ "&noop=true")
				.unmarshal()
				.bindy(BindyType.Csv, com.santosh.acnetty.QuoteData.class)
				.split(body())		// camel loads csv file as a list, split it to individual messages
				.to("netty:tcp://localhost:8095")	// send over socket
				;
				
			}
		};
		
	}

}
