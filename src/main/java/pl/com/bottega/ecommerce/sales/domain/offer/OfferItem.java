/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class OfferItem {

  private Product product;

  private int quantity;

  // discount
  private String discountCause;

  private Money discount;


  public OfferItem(Product product, int quantity,
      String discountCause,
      Money discount) {
    this.product = product;
    this.quantity = quantity;
    this.discountCause = discountCause;
    this.discount = discount;

  }


  public Money evaluateTotalCost() {

    return product.getProductPrice().multiply(quantity).subtract(discount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discount, discountCause,
        quantity);
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OfferItem offerItem = (OfferItem) o;
    return quantity == offerItem.quantity &&
        Objects.equals(product, offerItem.product) &&
        Objects.equals(discountCause, offerItem.discountCause) &&
        Objects.equals(discount, offerItem.discount);
  }

  /**
   * @param delta acceptable percentage difference
   * @return
   */
  public boolean sameAs(OfferItem other, double delta) {
    if (getProductPrice() == null) {
      if (other.getProductPrice() != null) {
        return false;
      }
    } else if (!getProductPrice().equals(other.getProductPrice())) {
      return false;
    }
    if (product.getProductName() == null) {
      if (other.getProduct().getProductName() != null) {
        return false;
      }
    } else if (!product.getProductName().equals(other.getProduct().getProductName())) {
      return false;
    }

    if (getProduct().getProductId() == null) {
      if (other.getProduct().getProductId() != null) {
        return false;
      }
    } else if (!getProduct().getProductId().equals(other.getProduct().getProductName())) {
      return false;
    }
    if (getProduct().getProductType() == null) {
      if (other.getProduct().getProductType() != null) {
        return false;
      }
    } else if (!getProduct().getProductType().equals(other.getProduct().getProductType())) {
      return false;
    }

    if (quantity != other.quantity) {
      return false;
    }

    Money max;
    Money min;
    if (evaluateTotalCost().getDenomination().compareTo(other.evaluateTotalCost().getDenomination())
        > 0) {
      max = evaluateTotalCost();
      min = other.evaluateTotalCost();
    } else {
      max = other.evaluateTotalCost();
      min = evaluateTotalCost();
    }

    BigDecimal difference = max.getDenomination().subtract(min.getDenomination());
    BigDecimal acceptableDelta = max.getDenomination().multiply(BigDecimal.valueOf(delta / 100));

    return acceptableDelta.compareTo(difference) > 0;
  }

  private Money getProductPrice() {
    return product.getProductPrice();
  }

  public String getProductId() {
    return product.getProductId();
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getDiscountCause() {
    return discountCause;
  }

  public void setDiscountCause(String discountCause) {
    this.discountCause = discountCause;
  }

  public Money getDiscount() {
    return discount;
  }

  public void setDiscount(Money discount) {
    this.discount = discount;
  }
}
