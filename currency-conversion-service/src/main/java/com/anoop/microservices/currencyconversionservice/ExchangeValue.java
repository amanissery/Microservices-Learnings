package com.anoop.microservices.currencyconversionservice;

import java.math.BigDecimal;



public class ExchangeValue {
	private String fromCurrency;
	private String toCurrency;

	private Integer id;
	private BigDecimal conversionMultiple;
	private Integer port;
	public ExchangeValue(String fromCurrency, String toCurrency, Integer id, BigDecimal conversionMultiple) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.id = id;
		this.conversionMultiple = conversionMultiple;
	}
	public ExchangeValue() {
		super();
	}
	
	public String getFromCurrency() {
		return fromCurrency;
	}
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	public String getToCurrency() {
		return toCurrency;
	}
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
	
	
	
}
