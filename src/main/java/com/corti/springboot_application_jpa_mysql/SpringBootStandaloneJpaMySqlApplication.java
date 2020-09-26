package com.corti.springboot_application_jpa_mysql;

import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//import org.apache.logging.log4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.apache.logging.log4j.LogManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.corti.springboot_application_jpa_mysql.stocksymbol.StockSymbol;
import com.corti.springboot_application_jpa_mysql.stocksymbol.StockSymbolService;


//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootStandaloneJpaMySqlApplication  implements CommandLineRunner {
  private static Logger LOG = (Logger) LoggerFactory
      .getLogger(SpringBootStandaloneJpaMySqlApplication.class);

  @Autowired 
  private StockSymbolService stockSymbolService;
  
  public static void main(String[] args) {
    LOG.info("STARTING THE APPLICATION");
    SpringApplication.run(SpringBootStandaloneJpaMySqlApplication.class, args);
    LOG.info("APPLICATION FINISHED");
  }

  @PostConstruct
  public void init() {
    // Setting Spring Boot TimeZone
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

  }

  @Override
  public void run(String... args) {
    LOG.info("EXECUTING : command line runner");

    for (int i = 0; i < args.length; ++i) {
      LOG.info("args[{}]: {}", i, args[i]);
    }
    
    List<StockSymbol> stockSymbols = stockSymbolService.getAllStockSymbols();
    for (StockSymbol ss : stockSymbols) {
      LOG.info(ss.toString());
    }
    
    
    
  }
}
