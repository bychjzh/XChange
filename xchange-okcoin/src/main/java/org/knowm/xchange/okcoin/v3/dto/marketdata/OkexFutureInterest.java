package org.knowm.xchange.okcoin.v3.dto.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public class OkexFutureInterest {
  @JsonProperty("instrument_id")
  private String instrumentId;

  private BigDecimal amount;
  private String timestamp;

  public OkexFutureInterest() {}

  public String getInstrumentId() {
    return instrumentId;
  }

  public void setInstrumentId(String instrumentId) {
    this.instrumentId = instrumentId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Date getTimestamp() {
    return Date.from(Instant.parse(timestamp));
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "OkexFutureInterest{"
        + "instrumentId='"
        + instrumentId
        + '\''
        + ", amount="
        + amount
        + ", timestamp='"
        + getTimestamp()
        + '\''
        + '}';
  }
}
