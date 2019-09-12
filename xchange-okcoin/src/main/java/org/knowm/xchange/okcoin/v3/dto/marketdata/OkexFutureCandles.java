package org.knowm.xchange.okcoin.v3.dto.marketdata;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import lombok.Data;

@Data
public class OkexFutureCandles {
  protected Date date;
  protected BigDecimal open;
  protected BigDecimal height;
  protected BigDecimal low;
  protected BigDecimal close;
  protected BigDecimal amount;

  public OkexFutureCandles(Object[] kline) {
    this.date = Date.from(Instant.parse(String.valueOf(kline[0])));
    this.open = new BigDecimal(String.valueOf(kline[1]));
    this.height = new BigDecimal(String.valueOf(kline[2]));
    this.low = new BigDecimal(String.valueOf(kline[3]));
    this.close = new BigDecimal(String.valueOf(kline[4]));
    this.amount = new BigDecimal(String.valueOf(kline[5]));
  }
}
