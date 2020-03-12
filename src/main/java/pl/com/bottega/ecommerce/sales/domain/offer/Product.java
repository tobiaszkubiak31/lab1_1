package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
//:todo Make equals Methods
public class Product {
  private String productId;

  private Money productPrice;

  private String productName;

  private Date productSnapshotDate;

  private String productType;

  public Product(String productId, Money productPrice, String productName,
      Date productSnapshotDate, String productType) {
    this.productId = productId;
    this.productPrice = productPrice;
    this.productName = productName;
    this.productSnapshotDate = productSnapshotDate;
    this.productType = productType;
  }

  public BigDecimal evaluteTotalCostAfterDiscout(BigDecimal discount) {
    return productPrice.substract(discount);
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public Money getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Money productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Date getProductSnapshotDate() {
    return productSnapshotDate;
  }

  public void setProductSnapshotDate(Date productSnapshotDate) {
    this.productSnapshotDate = productSnapshotDate;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }
}
