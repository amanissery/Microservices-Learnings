package com.anoop.microservices.currencyexchangeservice;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyExchangeRepository extends CrudRepository<ExchangeValue, Long> {

	@Query("Select * from ExchangeValue where fromCurrency=?0 and toCurrency=?1 allow filtering")
	public ExchangeValue findByFromAndTo(String from, String to);

//	@Query("Select * from customer where lastname=?0")
//	public List<Customer> findByLastName(String lastName);
	
}
