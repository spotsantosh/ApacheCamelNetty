package com.santosh.acnetty;

import java.io.Serializable;
import java.util.Date;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
/**
 * POJO abstracting market data
 * Needs to be Serializable for socket communication
 * Has Annotations for camel-bindy 
 * @author santosh
 *
 */

@CsvRecord(separator=";", skipFirstLine=true)
public class QuoteData implements Serializable {
	
	@DataField(pos = 1)
	private String symbol;

	@DataField(pos = 2)
	private Long seqNumber;

	@DataField(pos = 3, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date dateTime;
	
	@DataField(pos = 4, precision = 2)
	private Double open;

	@DataField(pos = 5, precision = 2)
	private Double high;

	@DataField(pos = 6, precision = 2)
	private Double low;

	@DataField(pos = 7, precision = 2)
	private Double close;

	@DataField(pos = 8)
	private Long volume;

	private static final long serialVersionUID = 1L;

	public QuoteData(){}
	
	public QuoteData(String symbol, Long seqNumber, Date dateTime, Double open,
			Double high, Double low, Double close, Long volume) {
		super();
		this.symbol = symbol;
		this.seqNumber = seqNumber;
		this.dateTime = dateTime;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Long getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(Long seqNumber) {
		this.seqNumber = seqNumber;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "QuoteData [symbol=" + symbol + ", seqNumber=" + seqNumber
//				+ ", dateTime=" + dateTime + ", open=" + open + ", high="
//				+ high + ", low=" + low + ", close=" + close + ", volume="+ volume
				+ "]"
				;
	}
	

}
