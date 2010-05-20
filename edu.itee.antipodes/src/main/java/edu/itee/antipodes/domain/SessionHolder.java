package edu.itee.antipodes.domain;

import java.io.Serializable;
import java.util.Hashtable;

public class SessionHolder implements Serializable{

	private String currency;
	private Hashtable<String, Double> cachedRates = new Hashtable<String, Double>();

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Hashtable<String, Double> getCachedRates() {
		return cachedRates;
	}

	public void setCachedRates(Hashtable<String, Double> cachedRates) {
		this.cachedRates = cachedRates;
	}
	
	
}
