package se.plushogskolan.ju15.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;

import se.plushogskolan.ju15.beans.Records;
import se.plushogskolan.ju15.javafx.CalculatorWindow;

public class CalculatorModel {

	/**
	 * Calculate the average value of a currency in a certain year
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param year
	 *            the year to calculate average value
	 * @return the average value of currency in given year
	 * @throws ArithmeticException
	 *             if the given year is not in data
	 */
	public BigDecimal getYearAverage(String currency, int year) throws ArithmeticException {
		BigDecimal sum = new BigDecimal(0);
		BigDecimal number = new BigDecimal(0);
		BigDecimal result = new BigDecimal(0);
		for (Records r : CalculatorWindow.RatesData) {
			// System.out.println(r.getDate().getYear());
			if (r.getDate().getYear() == year) {
				switch (currency) {
				case "EUR":
					sum = sum.add(r.getEurotosek(), MathContext.DECIMAL32);
					break;
				case "USD":
					sum = sum.add(r.getUsdtosek(), MathContext.DECIMAL32);
					break;
				case "GBP":
					sum = sum.add(r.getGbptosek(), MathContext.DECIMAL32);
					break;
				case "CHF":
					sum = sum.add(r.getChftosek(), MathContext.DECIMAL32);
					break;
				case "CNY":
					sum = sum.add(r.getCnytosek(), MathContext.DECIMAL32);
					break;

				}
				number = number.add(new BigDecimal(1));
			}
		}
		result = sum.divide(number, 4, RoundingMode.HALF_UP);
		return result;

	}

	/**
	 * Calculate the average value of a currency in a certain month
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param year
	 *            the year that the month is in
	 * @param month
	 *            the month to calculate
	 * @return the average value of the currency in given month
	 * @throws ArithmeticException
	 *             if the given year or month is not in data
	 */
	public BigDecimal getMonthAverage(String currency, int year, int month) throws ArithmeticException {
		BigDecimal sum = new BigDecimal(0);
		BigDecimal number = new BigDecimal(0);
		BigDecimal result = new BigDecimal(0);
		for (Records r : CalculatorWindow.RatesData) {

			if ((r.getDate().getYear() == year) && (r.getDate().getMonthValue() == month)) {
				switch (currency) {
				case "EUR":
					sum = sum.add(r.getEurotosek(), MathContext.DECIMAL32);
					break;
				case "USD":
					sum = sum.add(r.getUsdtosek(), MathContext.DECIMAL32);
					break;
				case "GBP":
					sum = sum.add(r.getGbptosek(), MathContext.DECIMAL32);
					break;
				case "CHF":
					sum = sum.add(r.getChftosek(), MathContext.DECIMAL32);
					break;
				case "CNY":
					sum = sum.add(r.getCnytosek(), MathContext.DECIMAL32);
					break;

				}
				number = number.add(new BigDecimal(1));
			}
		}

		result = sum.divide(number, 4, RoundingMode.HALF_UP);
		return result;
	}

	/**
	 * Calculate the average value of one currency in certain period
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param fromDate
	 *            the first date of the period
	 * @param toDate
	 *            the last date of the period
	 * @return the average value of the currency in given period
	 * @throws ArithmeticException
	 *             if the given period is not in data
	 */
	public BigDecimal getAverage(String currency, LocalDate fromDate, LocalDate toDate) throws ArithmeticException {
		BigDecimal sum = new BigDecimal(0);
		BigDecimal number = new BigDecimal(0);
		BigDecimal result = new BigDecimal(0);
		for (Records r : CalculatorWindow.RatesData) {

			if (r.getDate().equals(fromDate) || r.getDate().equals(toDate)
					|| ((r.getDate().isAfter(fromDate)) && (r.getDate().isBefore(toDate)))) {
				switch (currency) {
				case "EUR":
					sum = sum.add(r.getEurotosek(), MathContext.DECIMAL32);
					break;
				case "USD":
					sum = sum.add(r.getUsdtosek(), MathContext.DECIMAL32);
					break;
				case "GBP":
					sum = sum.add(r.getGbptosek(), MathContext.DECIMAL32);
					break;
				case "CHF":
					sum = sum.add(r.getChftosek(), MathContext.DECIMAL32);
					break;
				case "CNY":
					sum = sum.add(r.getCnytosek(), MathContext.DECIMAL32);
					break;

				}
				number = number.add(new BigDecimal(1));
			}
		}

		result = sum.divide(number, 4, RoundingMode.HALF_UP);
		return result;

	}

	/**
	 * Calculate the highest value of on currency in one year
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param year
	 *            the year to calculate
	 * @return the highest value of the currency in the given year
	 */
	public BigDecimal getYearHigh(String currency, int year) {
		BigDecimal max = new BigDecimal(0);
		for (Records r : CalculatorWindow.RatesData) {
			if (r.getDate().getYear() == year) {
				switch (currency) {
				case "EUR":
					if (r.getEurotosek().compareTo(max) == 1)
						max = r.getEurotosek();
					break;
				case "USD":
					if (r.getUsdtosek().compareTo(max) == 1)
						max = r.getUsdtosek();
					break;
				case "GBP":
					if (r.getGbptosek().compareTo(max) == 1)
						max = r.getGbptosek();
					break;
				case "CHF":
					if (r.getChftosek().compareTo(max) == 1)
						max = r.getChftosek();
					break;
				case "CNY":
					if (r.getCnytosek().compareTo(max) == 1)
						max = r.getCnytosek();
					break;
				}

			}
		}
		return max;
	}

	/**
	 * Calculate the lowest value of one currency in one year
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param year
	 *            the year to calculate
	 * @return the lowest value of the currency in the given year
	 */
	public BigDecimal getYearLow(String currency, int year) {
		BigDecimal min = new BigDecimal(100);
		for (Records r : CalculatorWindow.RatesData) {
			if (r.getDate().getYear() == year) {
				switch (currency) {
				case "EUR":
					if (r.getEurotosek().compareTo(min) == -1)
						min = r.getEurotosek();
					break;
				case "USD":
					if (r.getUsdtosek().compareTo(min) == -1)
						min = r.getUsdtosek();
					break;
				case "GBP":
					if (r.getGbptosek().compareTo(min) == -1)
						min = r.getGbptosek();
					break;
				case "CHF":
					if (r.getChftosek().compareTo(min) == -1)
						min = r.getChftosek();
					break;
				case "CNY":
					if (r.getCnytosek().compareTo(min) == -1)
						min = r.getCnytosek();
					break;
				}

			}
		}
		return min;
	}

	/**
	 * Calculate the highest value of a currency in a month
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param year
	 *            the year that the month is in
	 * @param month
	 *            the month to calculate
	 * @return the highest value of the currency in the given month
	 */
	public BigDecimal getMonthHigh(String currency, int year, int month) {
		BigDecimal max = new BigDecimal(0);
		for (Records r : CalculatorWindow.RatesData) {

			if ((r.getDate().getYear() == year) && (r.getDate().getMonthValue() == month)) {
				switch (currency) {
				case "EUR":
					if (r.getEurotosek().compareTo(max) == 1)
						max = r.getEurotosek();
					break;
				case "USD":
					if (r.getUsdtosek().compareTo(max) == 1)
						max = r.getUsdtosek();
					break;
				case "GBP":
					if (r.getGbptosek().compareTo(max) == 1)
						max = r.getGbptosek();
					break;
				case "CHF":
					if (r.getChftosek().compareTo(max) == 1)
						max = r.getChftosek();
					break;
				case "CNY":
					if (r.getCnytosek().compareTo(max) == 1)
						max = r.getCnytosek();
					break;
				}
			}
		}
		return max;
	}

	/**
	 * Calculate the lowest value of one currency in a month
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param year
	 *            the year that the month is in
	 * @param month
	 *            the month to calculate
	 * @return the lowest of the currency in the given month
	 */
	public BigDecimal getMonthLow(String currency, int year, int month) {
		BigDecimal min = new BigDecimal(100);
		for (Records r : CalculatorWindow.RatesData) {

			if ((r.getDate().getYear() == year) && (r.getDate().getMonthValue() == month)) {
				switch (currency) {
				case "EUR":
					if (r.getEurotosek().compareTo(min) == -1)
						min = r.getEurotosek();
					break;
				case "USD":
					if (r.getUsdtosek().compareTo(min) == -1)
						min = r.getUsdtosek();
					break;
				case "GBP":
					if (r.getGbptosek().compareTo(min) == -1)
						min = r.getGbptosek();
					break;
				case "CHF":
					if (r.getChftosek().compareTo(min) == -1)
						min = r.getChftosek();
					break;
				case "CNY":
					if (r.getCnytosek().compareTo(min) == -1)
						min = r.getCnytosek();
					break;
				}
			}
		}
		return min;
	}

	/**
	 * Calculate the highest value of a currency in certain period
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param fromDate
	 *            the first date of the period
	 * @param toDate
	 *            the last date of the period
	 * @return the highest value of the currency in given period
	 */
	public BigDecimal getHighMark(String currency, LocalDate fromDate, LocalDate toDate) {
		BigDecimal max = new BigDecimal(0);
		for (Records r : CalculatorWindow.RatesData) {
			if (r.getDate().equals(fromDate) || r.getDate().equals(toDate)
					|| ((r.getDate().isAfter(fromDate)) && (r.getDate().isBefore(toDate)))) {
				switch (currency) {
				case "EUR":
					if (r.getEurotosek().compareTo(max) == 1)
						max = r.getEurotosek();
					break;
				case "USD":
					if (r.getUsdtosek().compareTo(max) == 1)
						max = r.getUsdtosek();
					break;
				case "GBP":
					if (r.getGbptosek().compareTo(max) == 1)
						max = r.getGbptosek();
					break;
				case "CHF":
					if (r.getChftosek().compareTo(max) == 1)
						max = r.getChftosek();
					break;
				case "CNY":
					if (r.getCnytosek().compareTo(max) == 1)
						max = r.getCnytosek();
					break;

				}
			}
		}
		return max;
	}

	/**
	 * Calculate the lowest value of a currency in certain period
	 * 
	 * @param currency
	 *            the name of the currency
	 * @param fromDate
	 *            the first date of the period
	 * @param toDate
	 *            the last date of the period
	 * @return the lowest value of the currency in given period
	 */
	public BigDecimal getLowMark(String currency, LocalDate fromDate, LocalDate toDate) {
		BigDecimal min = new BigDecimal(100);
		for (Records r : CalculatorWindow.RatesData) {
			if (r.getDate().equals(fromDate) || r.getDate().equals(toDate)
					|| ((r.getDate().isAfter(fromDate)) && (r.getDate().isBefore(toDate)))) {
				switch (currency) {
				case "EUR":
					if (r.getEurotosek().compareTo(min) == -1)
						min = r.getEurotosek();
					break;
				case "USD":
					if (r.getUsdtosek().compareTo(min) == -1)
						min = r.getUsdtosek();
					break;
				case "GBP":
					if (r.getGbptosek().compareTo(min) == -1)
						min = r.getGbptosek();
					break;
				case "CHF":
					if (r.getChftosek().compareTo(min) == -1)
						min = r.getChftosek();
					break;
				case "CNY":
					if (r.getCnytosek().compareTo(min) == -1)
						min = r.getCnytosek();
					break;

				}
			}
		}
		return min;
	}

	/**
	 * Find the currency which has the maximum variation in 2 days.
	 * @param fromDate the first date
	 * @param toDate   the second date
	 * @return the name of the currency which has the maximum variation.
	 */
	public String getMaxDeltaCurrency(LocalDate fromDate, LocalDate toDate) {
		String max = "None";
		BigDecimal maxvalue = new BigDecimal(0);
		Records recordfrom = null;
		Records recordto = null;
		for (Records r : CalculatorWindow.RatesData) {

			// BigDecimal eurofrom;
			if (r.getDate().equals(fromDate)) {
				recordfrom = r;
			}
			if (r.getDate().equals(toDate)) {
				recordto = r;
			}
		}

		BigDecimal euro = recordfrom.getEurotosek().subtract(recordto.getEurotosek()).abs();
		BigDecimal usd = recordfrom.getUsdtosek().subtract(recordto.getUsdtosek()).abs();
		BigDecimal gbp = recordfrom.getGbptosek().subtract(recordto.getGbptosek()).abs();
		BigDecimal chf = recordfrom.getChftosek().subtract(recordto.getChftosek()).abs();
		BigDecimal cny = recordfrom.getCnytosek().subtract(recordto.getCnytosek()).abs();
		if (euro.compareTo(maxvalue) == 1) {
			maxvalue = euro;
			max = "EUR";
		}
		if (usd.compareTo(maxvalue) == 1) {
			maxvalue = usd;
			max = "USD";
		}
		if (gbp.compareTo(maxvalue) == 1) {
			maxvalue = gbp;
			max = "GBP";
		}
		if (chf.compareTo(maxvalue) == 1) {
			maxvalue = chf;
			max = "CHF";
		}
		if (cny.compareTo(maxvalue) == 1) {
			maxvalue = cny;
			max = "CNY";
		}
		return max;
	}

	/**
	 * Find the currency which has the maximum variation in given period
	 * @param fromDate the first date of the period
	 * @param toDate   the last date of the period
	 * @return the name of the currency which has the maximum variation
	 */
	public String getMaxVolatilityCurrency(LocalDate fromDate, LocalDate toDate) {
		String max = "None";
		BigDecimal maxvalue = new BigDecimal(0);
		BigDecimal eur = getHighMark("EUR", fromDate, toDate).subtract(getLowMark("EUR", fromDate, toDate));
		BigDecimal usd = getHighMark("USD", fromDate, toDate).subtract(getLowMark("USD", fromDate, toDate));
		BigDecimal gbp = getHighMark("GBP", fromDate, toDate).subtract(getLowMark("GBP", fromDate, toDate));
		BigDecimal chf = getHighMark("CHF", fromDate, toDate).subtract(getLowMark("CHF", fromDate, toDate));
		BigDecimal cny = getHighMark("CNY", fromDate, toDate).subtract(getLowMark("CNY", fromDate, toDate));
		if (eur.compareTo(maxvalue) == 1) {
			maxvalue = eur;
			max = "EUR";
		}
		if (usd.compareTo(maxvalue) == 1) {
			maxvalue = usd;
			max = "USD";
		}
		if (gbp.compareTo(maxvalue) == 1) {
			maxvalue = gbp;
			max = "GBP";
		}
		if (chf.compareTo(maxvalue) == 1) {
			maxvalue = chf;
			max = "CHF";
		}
		if (cny.compareTo(maxvalue) == 1) {
			maxvalue = cny;
			max = "CNY";
		}

		return max;
	}

	/**
	 * Calculate the average value of a currency  per week day in a given period.
	 * @param currency the name of the currency
	 * @param fromDate the first date of the period
	 * @param toDate   the last date of the period
	 * @param weekDay  the week day
	 * @return         the average value of the currency per week day in the given period
	 * @throws ArithmeticException if there in no given week day in the period 
	 */
	public BigDecimal getAverage(String currency, LocalDate fromDate, LocalDate toDate, DayOfWeek weekDay)
			throws ArithmeticException {
		BigDecimal sum = new BigDecimal(0);
		BigDecimal count = new BigDecimal(0);
		BigDecimal avg = new BigDecimal(0);
		for (Records r : CalculatorWindow.RatesData) {
			if (r.getDate().equals(fromDate) || r.getDate().equals(toDate)
					|| ((r.getDate().isAfter(fromDate)) && (r.getDate().isBefore(toDate)))) {
				if (r.getDate().getDayOfWeek() == weekDay) {
					switch (currency) {
					case "EUR":
						sum = sum.add(r.getEurotosek(), MathContext.DECIMAL32);
						break;
					case "USD":
						sum = sum.add(r.getUsdtosek(), MathContext.DECIMAL32);
						break;
					case "GBP":
						sum = sum.add(r.getGbptosek(), MathContext.DECIMAL32);
						break;
					case "CHF":
						sum = sum.add(r.getChftosek(), MathContext.DECIMAL32);
						break;
					case "CNY":
						sum = sum.add(r.getCnytosek(), MathContext.DECIMAL32);
						break;
					}
					count = count.add(new BigDecimal(1));
				}
			}
		}
		avg = sum.divide(count, 4, RoundingMode.HALF_UP);
		
		return avg;

	}
}
