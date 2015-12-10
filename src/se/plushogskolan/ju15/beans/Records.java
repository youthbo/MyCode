package se.plushogskolan.ju15.beans;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Records {
    private LocalDate date;
    private BigDecimal sektoeuro;
    private BigDecimal sektousd;
    private BigDecimal sektogbp;
    private BigDecimal sektochf;
    private BigDecimal sektocny;
    
    private BigDecimal eurotosek;
    private BigDecimal usdtosek;
    private BigDecimal gbptosek;
    private BigDecimal chftosek;
    private BigDecimal cnytosek;
    
    
	public Records(String date, String sektoeuro, String sektousd, String sektogbp, String sektochf,
			String sektocny) {
		super();
		BigDecimal one = new BigDecimal(1);
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMM d, uuuu",Locale.US);
		this.date = LocalDate.parse(date, formatter);
		//System.out.println(this.date);
		
		this.sektoeuro = new BigDecimal(sektoeuro);
		setEurotosek(one.divide(this.sektoeuro, 4, RoundingMode.HALF_UP));
		this.sektousd = new BigDecimal(sektousd);
		setUsdtosek(one.divide(this.sektousd, 4, RoundingMode.HALF_UP));
		this.sektogbp = new BigDecimal(sektogbp);
		setGbptosek(one.divide(this.sektogbp, 4, RoundingMode.HALF_UP));
		this.sektochf = new BigDecimal(sektochf);
		setChftosek(one.divide(this.sektochf, 4, RoundingMode.HALF_UP));
		this.sektocny = new BigDecimal(sektocny);
		setCnytosek(one.divide(this.sektocny, 4, RoundingMode.HALF_UP));
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public BigDecimal getSektoeuro() {
		return sektoeuro;
	}
	public void setSektoeuro(BigDecimal sektoeuro) {
		this.sektoeuro = sektoeuro;
	}
	public BigDecimal getSektousd() {
		return sektousd;
	}
	public void setSektousd(BigDecimal sektousd) {
		this.sektousd = sektousd;
	}
	public BigDecimal getSektogbp() {
		return sektogbp;
	}
	public void setSektogbp(BigDecimal sektogbp) {
		this.sektogbp = sektogbp;
	}
	public BigDecimal getSektochf() {
		return sektochf;
	}
	public void setSektochf(BigDecimal sektochf) {
		this.sektochf = sektochf;
	}
	public BigDecimal getSektocny() {
		return sektocny;
	}
	public void setSektocny(BigDecimal sektocny) {
		this.sektocny = sektocny;
	}

	public BigDecimal getEurotosek() {
		return eurotosek;
	}

	public void setEurotosek(BigDecimal eurotosek) {
		this.eurotosek = eurotosek;
	}

	public BigDecimal getUsdtosek() {
		return usdtosek;
	}

	public void setUsdtosek(BigDecimal usdtosek) {
		this.usdtosek = usdtosek;
	}

	public BigDecimal getGbptosek() {
		return gbptosek;
	}

	public void setGbptosek(BigDecimal gbptosek) {
		this.gbptosek = gbptosek;
	}

	public BigDecimal getChftosek() {
		return chftosek;
	}

	public void setChftosek(BigDecimal chftosek) {
		this.chftosek = chftosek;
	}

	public BigDecimal getCnytosek() {
		return cnytosek;
	}

	public void setCnytosek(BigDecimal cnytosek) {
		this.cnytosek = cnytosek;
	}
    
	
    
	
}
