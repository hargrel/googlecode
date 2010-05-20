package edu.itee.antipodes.service;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import de.istec.CurrencyConverter.CurrencyConverter.CurrencyConverterSoapProxy;

import NET.webserviceX.www.CurrencyConvertorLocator;
import NET.webserviceX.www.CurrencyConvertorSoapProxy;
import edu.itee.antipodes.utils.SpringApplicationContext;

public class Currency {

	private static final List<String> currencyList = Arrays.asList("AUD",
			"USD", "EUR", "AFA", "ALL", "DZD", "ARS", "AWG", "BSD", "BHD",
			"BDT", "BBD", "BZD", "BMD", "BTN", "BOB", "BWP", "BRL", "GBP",
			"BND", "BIF", "XOF", "XAF", "KHR", "CAD", "CVE", "KYD", "CLP",
			"CNY", "COP", "KMF", "CRC", "HRK", "CUP", "CYP", "CZK", "DKK",
			"DJF", "DOP", "XCD", "EGP", "SVC", "EEK", "ETB", "FKP", "GMD",
			"GHC", "GIP", "XAU", "GTQ", "GNF", "GYD", "HTG", "HNL", "HKD",
			"HUF", "ISK", "INR", "IDR", "IQD", "ILS", "JMD", "JPY", "JOD",
			"KZT", "KES", "KRW", "KWD", "LAK", "LVL", "LBP", "LSL", "LRD",
			"LYD", "LTL", "MOP", "MKD", "MGF", "MWK", "MYR", "MVR", "MTL",
			"MRO", "MUR", "MXN", "MDL", "MNT", "MAD", "MZM", "MMK", "NAD",
			"NPR", "ANG", "NZD", "NIO", "NGN", "KPW", "NOK", "OMR", "XPF",
			"PKR", "XPD", "PAB", "PGK", "PYG", "PEN", "PHP", "XPT", "PLN",
			"QAR", "ROL", "RUB", "WST", "STD", "SAR", "SCR", "SLL", "XAG",
			"SGD", "SKK", "SIT", "SBD", "SOS", "ZAR", "LKR", "SHP", "SDD",
			"SRG", "SZL", "SEK", "CHF", "SYP", "TWD", "TZS", "THB", "TOP",
			"TTD", "TND", "TRL", "AED", "UGX", "UAH", "UYU", "VUV", "VEB",
			"VND", "YER", "YUM", "ZMK", "ZWD", "TRY");

	public static List<String> getCurrencyTest() {
		return currencyList;
	}

	/**
	 * Converts amount from one currency to another
	 */
	public static String convert(double amount, String fromCurStr) {
		// A real function might access a database or
		// web service. Here, we simply return a
		// plausible calculated value.

		if (!SpringApplicationContext.IsCurrencyConversion()) {
			String result = String.format("%(,.2f %s", amount, fromCurStr);
			return result;
		}

		double rate = 1;

		Hashtable<String, Double> cachedRates = SpringApplicationContext
				.getSessionHolder().getCachedRates();

		String toCurStr = SpringApplicationContext.getSessionHolder()
				.getCurrency();
		String resultCurrencyStr = toCurStr;
		Double cachedRate = cachedRates.get(fromCurStr + toCurStr);

		if (toCurStr == null || toCurStr.equals("")) {
			resultCurrencyStr = fromCurStr;
		} else if (fromCurStr.equalsIgnoreCase(toCurStr)) {

		} else if (cachedRate != null) {
			rate = cachedRate;
		} else {
			resultCurrencyStr = fromCurStr;
			try {

				NET.webserviceX.www.Currency toCur = NET.webserviceX.www.Currency
						.fromString(toCurStr);
				NET.webserviceX.www.Currency fromCur = NET.webserviceX.www.Currency
						.fromString(fromCurStr);
				CurrencyConvertorSoapProxy ccsp = new CurrencyConvertorSoapProxy();
				rate = ccsp.conversionRate(fromCur, toCur);

				cachedRates.put(fromCurStr + toCurStr, rate);
				SpringApplicationContext.getSessionHolder().setCachedRates(
						cachedRates);
				resultCurrencyStr = toCurStr;
			} catch (IllegalArgumentException ex) {
			} catch (RemoteException ex) {
			} catch (Exception ex) {
				System.out.println("+++ 21 " + ex.getMessage());
			}
		}
		amount *= rate;

		String result = String.format("%(,.2f %s", amount, resultCurrencyStr);

		return result;

	}
}
