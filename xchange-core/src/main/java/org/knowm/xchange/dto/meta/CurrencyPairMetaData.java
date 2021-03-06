package org.knowm.xchange.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import org.knowm.xchange.currency.Currency;

public class CurrencyPairMetaData implements Serializable {

  /** Trading fee (fraction) */
  @JsonProperty("trading_fee")
  private final BigDecimal tradingFee;

  /** Trading fee tiers by volume (fraction). Sorted in ascending order by quantity */
  @JsonProperty("fee_tiers")
  private final FeeTier[] feeTiers;

  /** Minimum trade amount */
  @JsonProperty("min_amount")
  private final BigDecimal minimumAmount;

  /** Maximum trade amount */
  @JsonProperty("max_amount")
  private final BigDecimal maximumAmount;

  /** Minimum trade amount */
  @JsonProperty("counter_min_amount")
  private final BigDecimal counterMinimumAmount;

  /** Maximum trade amount */
  @JsonProperty("counter_max_amount")
  private final BigDecimal counterMaximumAmount;

  /** Decimal places for base amount */
  @JsonProperty("base_scale")
  private final Integer baseScale;

  /** Decimal places for counter amount */
  @JsonProperty("price_scale")
  private final Integer priceScale;

  /** Amount step size. If set, any amounts must be a multiple of this */
  @JsonProperty("amount_step_size")
  private final BigDecimal amountStepSize;

  /** Currency that will be used to change for this trade. */
  private final Currency tradingFeeCurrency;

  /** Is market order type allowed on this pair. */
  private final boolean marketOrderEnabled;

  /**
   * Constructor
   *
   * @param tradingFee Trading fee (fraction)
   * @param minimumAmount Minimum trade amount
   * @param maximumAmount Maximum trade amount
   * @param priceScale Price scale
   */
  public CurrencyPairMetaData(
      BigDecimal tradingFee,
      BigDecimal minimumAmount,
      BigDecimal maximumAmount,
      Integer priceScale,
      FeeTier[] feeTiers) {
    this(
        tradingFee,
        minimumAmount,
        maximumAmount,
        null,
        null,
        null,
        priceScale,
        feeTiers,
        null,
        null,
        true);
  }

  /**
   * Constructor
   *
   * @param tradingFee Trading fee (fraction)
   * @param minimumAmount Minimum trade amount
   * @param maximumAmount Maximum trade amount
   * @param priceScale Price scale
   * @param amountStepSize Amounts must be a multiple of this amount if set.
   */
  public CurrencyPairMetaData(
      BigDecimal tradingFee,
      BigDecimal minimumAmount,
      BigDecimal maximumAmount,
      Integer priceScale,
      FeeTier[] feeTiers,
      BigDecimal amountStepSize) {
    this(
        tradingFee,
        minimumAmount,
        maximumAmount,
        null,
        null,
        null,
        priceScale,
        feeTiers,
        amountStepSize,
        null,
        true);
  }

  /**
   * Constructor
   *
   * @param tradingFee Trading fee (fraction)
   * @param minimumAmount Minimum trade amount
   * @param maximumAmount Maximum trade amount
   * @param priceScale Price scale
   * @param amountStepSize Amounts must be a multiple of this amount if set.
   */
  public CurrencyPairMetaData(
      @JsonProperty("trading_fee") BigDecimal tradingFee,
      @JsonProperty("min_amount") BigDecimal minimumAmount,
      @JsonProperty("max_amount") BigDecimal maximumAmount,
      @JsonProperty("counter_min_amount") BigDecimal counterMinimumAmount,
      @JsonProperty("counter_max_amount") BigDecimal counterMaximumAmount,
      @JsonProperty("base_scale") Integer baseScale,
      @JsonProperty("price_scale") Integer priceScale,
      @JsonProperty("fee_tiers") FeeTier[] feeTiers,
      @JsonProperty("amount_step_size") BigDecimal amountStepSize,
      @JsonProperty("trading_fee_currency") Currency tradingFeeCurrency,
      @JsonProperty("market_order_enabled") boolean marketOrderEnabled) {

    this.tradingFee = tradingFee;
    this.minimumAmount = minimumAmount;
    this.maximumAmount = maximumAmount;
    this.counterMinimumAmount = counterMinimumAmount;
    this.counterMaximumAmount = counterMaximumAmount;
    this.baseScale = baseScale;
    this.priceScale = priceScale;
    if (feeTiers != null) {
      Arrays.sort(feeTiers);
    }
    this.feeTiers = feeTiers;
    this.amountStepSize = amountStepSize;
    this.tradingFeeCurrency = tradingFeeCurrency;
    this.marketOrderEnabled = marketOrderEnabled;
  }

  public BigDecimal getTradingFee() {

    return tradingFee;
  }

  public BigDecimal getMinimumAmount() {

    return minimumAmount;
  }

  public BigDecimal getMaximumAmount() {

    return maximumAmount;
  }

  public Integer getBaseScale() {
    return baseScale;
  }

  public Integer getPriceScale() {

    return priceScale;
  }

  public FeeTier[] getFeeTiers() {

    return feeTiers;
  }

  public BigDecimal getAmountStepSize() {

    return amountStepSize;
  }

  public Currency getTradingFeeCurrency() {
    return tradingFeeCurrency;
  }

  public BigDecimal getCounterMinimumAmount() {
    return counterMinimumAmount;
  }

  public BigDecimal getCounterMaximumAmount() {
    return counterMaximumAmount;
  }

  public boolean isMarketOrderEnabled() {
    return marketOrderEnabled;
  }

  @Override
  public String toString() {

    return "CurrencyPairMetaData [tradingFee="
        + tradingFee
        + ", minimumAmount="
        + minimumAmount
        + ", maximumAmount="
        + maximumAmount
        + ", baseScale="
        + baseScale
        + ", priceScale="
        + priceScale
        + ", amountStepSize="
        + amountStepSize
        + ", tradingFeeCurrency="
        + tradingFeeCurrency
        + "]";
  }
}
