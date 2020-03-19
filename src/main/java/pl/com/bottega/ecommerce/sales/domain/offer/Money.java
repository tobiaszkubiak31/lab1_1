package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
  private String currency;
  private BigDecimal denomination;

  public Money(String currency, BigDecimal denomination) {
    this.currency = currency;
    this.denomination = denomination;
  }

  public String getCurrency() {
    return currency;
  }

  Money subtract(Money subtrahend){
    return new Money(currency, denomination.subtract(subtrahend.getDenomination()));
  }

  Money multiply(int factor){
    return new Money(currency, denomination.multiply(BigDecimal.valueOf(factor)));
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return Objects.equals(currency, money.currency) &&
        Objects.equals(denomination, money.denomination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, denomination);
  }

}
