package com.anoop.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal  quantity){
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<ExchangeValue> responseEntity = new RestTemplate().getForEntity
				("http://localhost:8000/currency-exchange/from/{from}/to/{to}"
				, ExchangeValue.class, uriVariables);
		
		
		ExchangeValue response = responseEntity.getBody();
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean();
		currencyConversionBean.setId(response.getId());
		currencyConversionBean.setFromCurrency(response.getFromCurrency());
		currencyConversionBean.setToCurrency(response.getToCurrency());
		currencyConversionBean.setConversionMultiple(response.getConversionMultiple());
		currencyConversionBean.setPort(response.getPort());
		currencyConversionBean.setQuantity(quantity);
		currencyConversionBean.setTotalAmount(quantity.multiply(response.getConversionMultiple()));
		return currencyConversionBean;
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal  quantity){
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		response.setQuantity(quantity);
		response.setTotalAmount(quantity.multiply(response.getConversionMultiple()));
		return response;
	}
}
