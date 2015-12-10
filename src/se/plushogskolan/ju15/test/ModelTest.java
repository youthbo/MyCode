package se.plushogskolan.ju15.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;

import se.plushogskolan.ju15.model.CalculatorModel;
import se.plushogskolan.ju15.beans.Records;
import se.plushogskolan.ju15.javafx.CalculatorWindow;

public class ModelTest {
	
	CalculatorModel cm = new CalculatorModel();
	@BeforeClass
	public static void loadData() {
		try (BufferedReader bf = new BufferedReader(new FileReader("rates.csv"))) {
			String line = bf.readLine();
			line = bf.readLine();
			while (line != null) {
				String[] s = line.split(";");
				// System.out.println(s[0]);
				Records record = new Records(s[0], s[1], s[2], s[3], s[4], s[5]);
				CalculatorWindow.RatesData.add(record);
				line = bf.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testYearAverage(){
		//2015
		BigDecimal result = cm.getYearAverage("EUR", 2015);		
		assertEquals(9.3649, result.doubleValue(),0.0001);
		result = cm.getYearAverage("USD", 2015);		
		assertEquals(8.4263, result.doubleValue(),0.0001);
		result = cm.getYearAverage("GBP", 2015);		
		assertEquals(12.9051, result.doubleValue(),0.0001);
		result = cm.getYearAverage("CHF", 2015);		
		assertEquals(8.7889, result.doubleValue(),0.0001);
		result = cm.getYearAverage("CNY", 2015);		
		assertEquals(1.3580, result.doubleValue(),0.0001);
		//2014
		result = cm.getYearAverage("EUR", 2014);		
		assertEquals(9.0987, result.doubleValue(),0.0001);
		result = cm.getYearAverage("USD", 2014);		
		assertEquals(6.8636, result.doubleValue(),0.0001);
		result = cm.getYearAverage("GBP", 2014);		
		assertEquals(11.2967, result.doubleValue(),0.0001);
		result = cm.getYearAverage("CHF", 2014);		
		assertEquals(7.4923, result.doubleValue(),0.0001);
		result = cm.getYearAverage("CNY", 2014);		
		assertEquals(1.1170, result.doubleValue(),0.0001);
		//2013
		result = cm.getYearAverage("EUR", 2013);
		assertEquals(8.9504, result.doubleValue(), 0.0001);
		result = cm.getYearAverage("USD", 2013);
		assertEquals(6.5455, result.doubleValue(), 0.0001);
		result = cm.getYearAverage("GBP", 2013);
		assertEquals(10.7080, result.doubleValue(), 0.0001);
		result = cm.getYearAverage("CHF", 2013);
		assertEquals(7.3031, result.doubleValue(), 0.0001);
		result = cm.getYearAverage("CNY", 2013);
		assertEquals(1.0699, result.doubleValue(), 0.0001);
	}
	
	@Test
	public void testMonthAverage(){
		BigDecimal result = cm.getMonthAverage("EUR", 2014, 3);		
		assertEquals(8.8666, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("USD", 2014, 3);		
		assertEquals(6.4135, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("GBP", 2014, 3);		
		assertEquals(10.6672, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("CHF", 2014, 3);		
		assertEquals(7.2848, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("CNY", 2014, 3);		
		assertEquals(1.0439, result.doubleValue(),0.0001);
		
		result = cm.getMonthAverage("EUR", 2014,9);		
		assertEquals(9.1952, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("USD", 2014, 9);		
		assertEquals(7.1315, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("GBP", 2014, 9);		
		assertEquals(11.6292, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("CHF", 2014, 9);		
		assertEquals(7.6135, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("CNY", 2014, 9);		
		assertEquals(1.1595, result.doubleValue(),0.0001);
		
		result = cm.getMonthAverage("EUR", 2015,2);		
		assertEquals(9.4854, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("USD", 2015, 2);		
		assertEquals(8.3568, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("GBP", 2015, 2);		
		assertEquals(12.8133, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("CHF", 2015, 2);		
		assertEquals(8.9424, result.doubleValue(),0.0001);
		result = cm.getMonthAverage("CNY", 2015, 2);		
		assertEquals(1.3591, result.doubleValue(),0.0001);
	}
	
	@Test
	public void testPeriodAverage(){
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d MMM uuuu",Locale.US);
		LocalDate from = LocalDate.parse("7 Nov 2014",formatter);
		LocalDate to = LocalDate.parse("25 Jan 2015",formatter);
		BigDecimal result = cm.getAverage("EUR",from, to);		
		assertEquals(9.3734, result.doubleValue(),0.0001);
		result = cm.getAverage("USD",from, to);		
	    assertEquals(7.7072, result.doubleValue(),0.0001);
		result = cm.getAverage("GBP",from, to);		
	    assertEquals(11.9571, result.doubleValue(),0.0001);
	    result = cm.getAverage("CHF",from, to);		
	    assertEquals(8.0046, result.doubleValue(),0.0001);
	    result = cm.getAverage("CNY",from, to);		
	    assertEquals(1.2562, result.doubleValue(),0.0001);
		
	}
	
	@Test
	public void testGetyearhighlow() {			
		// 2015
		BigDecimal result = cm.getYearHigh("EUR", 2015);
		assertEquals(9.6339, result.doubleValue(), 0.0001);
		result = cm.getYearLow("EUR", 2015);
		assertEquals(9.1075, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("USD", 2015);
		assertEquals(8.8261, result.doubleValue(), 0.0001);
		result = cm.getYearLow("USD", 2015);
		assertEquals(7.8064, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("GBP", 2015);
		assertEquals(13.5870, result.doubleValue(), 0.0001);
		result = cm.getYearLow("GBP", 2015);
		assertEquals(12.0192, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("CHF", 2015);
		assertEquals(9.4967, result.doubleValue(), 0.0001);
		result = cm.getYearLow("CHF", 2015);
		assertEquals(7.8431, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("CNY", 2015);
		assertEquals(1.4434, result.doubleValue(), 0.0001);
		result = cm.getYearLow("CNY", 2015);
		assertEquals(1.2698, result.doubleValue(), 0.0001);
		// 2014
		result = cm.getYearHigh("EUR", 2014);
		assertEquals(9.5602, result.doubleValue(), 0.0001);
		result = cm.getYearLow("EUR", 2014);
		assertEquals(8.7566, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("USD", 2014);
		assertEquals(7.8309, result.doubleValue(), 0.0001);
		result = cm.getYearLow("USD", 2014);
		assertEquals(6.3492, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("GBP", 2014);
		assertEquals(12.1803, result.doubleValue(), 0.0001);
		result = cm.getYearLow("GBP", 2014);
		assertEquals(10.5485, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("CHF", 2014);
		assertEquals(7.9302, result.doubleValue(), 0.0001);
		result = cm.getYearLow("CHF", 2014);
		assertEquals(7.1073, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("CNY", 2014);
		assertEquals(1.2752, result.doubleValue(), 0.0001);
		result = cm.getYearLow("CNY", 2014);
		assertEquals(1.0325, result.doubleValue(), 0.0001);
		// 2013
		result = cm.getYearHigh("EUR", 2013);
		assertEquals(9.0580, result.doubleValue(), 0.0001);
		result = cm.getYearLow("EUR", 2013);
		assertEquals(8.8417, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("USD", 2013);
		assertEquals(6.5920, result.doubleValue(), 0.0001);
		result = cm.getYearLow("USD", 2013);
		assertEquals(6.4226, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("GBP", 2013);
		assertEquals(10.7643, result.doubleValue(), 0.0001);
		result = cm.getYearLow("GBP", 2013);
		assertEquals(10.6157, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("CHF", 2013);
		assertEquals(7.4129, result.doubleValue(), 0.0001);
		result = cm.getYearLow("CHF", 2013);
		assertEquals(7.1994, result.doubleValue(), 0.0001);
		result = cm.getYearHigh("CNY", 2013);
		assertEquals(1.0785, result.doubleValue(), 0.0001);
		result = cm.getYearLow("CNY", 2013);
		assertEquals(1.0516, result.doubleValue(), 0.0001);

	}
	
	@Test
	public void testGetmonthhighlow() {	
		//2013
		BigDecimal result = cm.getMonthHigh("EUR", 2013,12);
		assertEquals(9.0580, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("EUR", 2013,12);
		assertEquals(8.8417, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("USD", 2013,12);
		assertEquals(6.5920, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("USD", 2013,12);
		assertEquals(6.4226, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("GBP", 2013,12);
		assertEquals(10.7643, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("GBP", 2013,12);
		assertEquals(10.6157, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("CHF", 2013,12);
		assertEquals(7.4129, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("CHF", 2013,12);
		assertEquals(7.1994, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("CNY", 2013,12);
		assertEquals(1.0785, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("CNY", 2013,12);
		assertEquals(1.0516, result.doubleValue(), 0.0001);
		// 2014
		result = cm.getMonthHigh("EUR", 2014, 2);
		assertEquals(8.9767, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("EUR", 2014, 2);
		assertEquals(8.7719, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("USD", 2014, 2);
		assertEquals(6.5488, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("USD", 2014, 2);
		assertEquals(6.4392, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("GBP", 2014, 2);
		assertEquals(10.8932, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("GBP", 2014, 2);
		assertEquals(10.6157, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("CHF", 2014, 2);
		assertEquals(7.3584, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("CHF", 2014, 2);
		assertEquals(7.1633, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("CNY", 2014, 2);
		assertEquals(1.0722, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("CNY", 2014, 2);
		assertEquals(1.0543, result.doubleValue(), 0.0001);
		// 2015
		result = cm.getMonthHigh("EUR", 2015, 6);
		assertEquals(9.3897, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("EUR", 2015, 6);
		assertEquals(9.1996, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("USD", 2015, 6);
		assertEquals(8.5543, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("USD", 2015, 6);
		assertEquals(8.0972, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("GBP", 2015, 6);
		assertEquals(13.0890, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("GBP", 2015, 6);
		assertEquals(12.7226, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("CHF", 2015, 6);
		assertEquals(9.0662, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("CHF", 2015, 6);
		assertEquals(8.7796, result.doubleValue(), 0.0001);
		result = cm.getMonthHigh("CNY", 2015, 6);
		assertEquals(1.4010, result.doubleValue(), 0.0001);
		result = cm.getMonthLow("CNY", 2015, 6);
		assertEquals(1.3264, result.doubleValue(), 0.0001);
	}
	
	@Test
	public void testPeriodhighlow(){
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("d MMM uuuu",Locale.getDefault());
		LocalDate from = LocalDate.parse("17 jan 2014",formatter);
		LocalDate to= LocalDate.parse("3 mar 2015",formatter);
		BigDecimal result = cm.getHighMark("EUR",from, to );		
		assertEquals(9.6061, result.doubleValue(), 0.0001);
		result = cm.getLowMark("EUR",from,to);		
		assertEquals(8.7566, result.doubleValue(), 0.0001);
		result = cm.getHighMark("USD",from, to );		
		assertEquals(8.4246, result.doubleValue(), 0.0001);
		result = cm.getLowMark("USD",from,to);		
		assertEquals(6.3492, result.doubleValue(), 0.0001);
		result = cm.getHighMark("GBP",from, to );		
		assertEquals(12.9870, result.doubleValue(), 0.0001);
		result = cm.getLowMark("GBP",from,to);		
		assertEquals(10.5485, result.doubleValue(), 0.0001);
		result = cm.getHighMark("CHF",from, to );		
		assertEquals(9.4967, result.doubleValue(), 0.0001);
		result = cm.getLowMark("CHF",from,to);		
		assertEquals(7.1073, result.doubleValue(), 0.0001);
		result = cm.getHighMark("CNY",from, to );		
		assertEquals(1.3723, result.doubleValue(), 0.0001);
		result = cm.getLowMark("CNY",from,to);		
		assertEquals(1.0325, result.doubleValue(), 0.0001);
	}
	
	@Test
	public void testGetMaxDelta(){
		String result = cm.getMaxDeltaCurrency(LocalDate.parse("20151115",DateTimeFormatter.BASIC_ISO_DATE), 
				                  LocalDate.parse("20151105",DateTimeFormatter.BASIC_ISO_DATE));
		assertEquals("USD", result);
		result = cm.getMaxDeltaCurrency(LocalDate.parse("20140911",DateTimeFormatter.BASIC_ISO_DATE), 
                LocalDate.parse("20150519",DateTimeFormatter.BASIC_ISO_DATE));
        assertEquals("GBP", result);
		
	}
	
	@Test
	public void testGetMaxVolatility(){
		String result = cm.getMaxVolatilityCurrency(LocalDate.parse("20151016",DateTimeFormatter.BASIC_ISO_DATE), 
				                  LocalDate.parse("20151115",DateTimeFormatter.BASIC_ISO_DATE));
		assertEquals("GBP", result);
		result = cm.getMaxVolatilityCurrency(LocalDate.parse("20140911",DateTimeFormatter.BASIC_ISO_DATE), 
                LocalDate.parse("20150519",DateTimeFormatter.BASIC_ISO_DATE));
        assertEquals("CHF", result);
	}
	
	@Test
	public void testGetAverage(){
		BigDecimal result = cm.getAverage("EUR", LocalDate.parse("2015-11-14"), LocalDate.parse("2015-11-30"), DayOfWeek.MONDAY);
		assertEquals(9.2737, result.doubleValue(), 0.0001);
		result = cm.getAverage("USD", LocalDate.parse("2015-11-16"), LocalDate.parse("2015-11-30"), DayOfWeek.MONDAY);
		assertEquals(8.7260, result.doubleValue(), 0.0001);
		result = cm.getAverage("GBP", LocalDate.parse("2015-11-17"), LocalDate.parse("2015-11-30"), DayOfWeek.MONDAY);
		assertEquals(13.1755, result.doubleValue(), 0.0001);
		result = cm.getAverage("CHF", LocalDate.parse("2015-11-17"), LocalDate.parse("2015-11-29"), DayOfWeek.MONDAY);
		assertEquals(8.5543, result.doubleValue(), 0.0001);
		result = cm.getAverage("CNY", LocalDate.parse("2014-02-02"), LocalDate.parse("2015-05-15"), DayOfWeek.WEDNESDAY);
		assertEquals(1.1927, result.doubleValue(), 0.0001);
		
	}

}
