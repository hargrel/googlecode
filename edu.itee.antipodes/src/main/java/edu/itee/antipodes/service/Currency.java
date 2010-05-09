package edu.itee.antipodes.service;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import NET.webserviceX.www.CurrencyConvertor;
import NET.webserviceX.www.CurrencyConvertorLocator;
import NET.webserviceX.www.CurrencyConvertorSoap;

public class Currency {
	/**
	 * Converts amount from one currency to another
	 */
	public static double convert(double amount, String fromCurStr,
			String toCurStr) {
		// A real function might access a database or
		// web service. Here, we simply return a
		// plausible calculated value.

		double rate = 1;
		fromCurStr = "AUD";
		NET.webserviceX.www.Currency fromCur = NET.webserviceX.www.Currency.fromString("AUD");
		NET.webserviceX.www.Currency userCur = NET.webserviceX.www.Currency.fromString("RUB");
		// CurrentUser cu = new CurrentUser();
		// cu.getCurrentUserID();

		try {
			
			CurrencyConvertor cc = new CurrencyConvertorLocator();
			CurrencyConvertorSoap ccs = cc.getCurrencyConvertorSoap();
			rate = ccs.conversionRate(fromCur, userCur);
		} catch (ServiceException ex) {
		} catch (RemoteException ex) {
		}

		return amount * rate;// * cu.getCurrentUserID();
	}
}
