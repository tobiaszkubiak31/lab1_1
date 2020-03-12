package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;

public class Money {
  private String currency;
  private BigDecimal denomination;

  public Money(String currency, BigDecimal denomination) {
    this.currency = currency;
    this.denomination = denomination;
  }

  public BigDecimal substract(BigDecimal value) {
    return denomination.subtract(value);
  }
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getDenomination() {
    return denomination;
  }

  public void setDenomination(BigDecimal denomination) {
    this.denomination = denomination;
  }

  public boolean compareTo(BigDecimal evaluateTotalCost) {
    if(denomination.compareTo(evaluateTotalCost) > 0){
      return true;
    }
    else {
      return false;
    }


  }
}
