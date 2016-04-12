
package sortable.iochallenge.parsing_json;

/**
 * This represents a Product with its attributes: product_name, manufacturer, family, model,
 * announced_date
 *
 * @author bhling
 *
 */
public class Product {

  private String product_name;
  private String manufacturer;
  private String family;
  private String model;
  private String announced_date;

  /**
   * This creates a Product given product_name, manufacturer, family, model, annound_date
   *
   * @param product_name the name of the product
   * @param manufacturer the maker of the product
   * @param family the family of the product
   * @param model the model of the product
   * @param announced_date the announced date of the product
   */
  public Product(String product_name, String manufacturer, String family, String model,
      String announced_date) {
    super();
    this.product_name = product_name;
    this.manufacturer = manufacturer;
    this.family = family;
    this.model = model;
    this.announced_date = announced_date;
  }

  /**
   * @return the name of the product
   */
  public String getProduct_name() {
    return this.product_name;
  }

  /**
   * @return the manufacturer of the product
   */
  public String getManufacturer() {
    return this.manufacturer;
  }

  /**
   * @return the family of the product
   */
  public String getFamily() {
    return this.family;
  }

  /**
   * @return the model of the product
   */
  public String getModel() {
    return this.model;
  }

  /**
   * @return the announced date of the product
   */
  public String getAnnounced_date() {
    return this.announced_date;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + (this.announced_date == null ? 0 : this.announced_date.hashCode());
    result = (prime * result) + (this.family == null ? 0 : this.family.hashCode());
    result = (prime * result) + (this.manufacturer == null ? 0 : this.manufacturer.hashCode());
    result = (prime * result) + (this.model == null ? 0 : this.model.hashCode());
    result = (prime * result) + (this.product_name == null ? 0 : this.product_name.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Product other = (Product) obj;
    if (this.announced_date == null) {
      if (other.announced_date != null) {
        return false;
      }
    } else if (!this.announced_date.equals(other.announced_date)) {
      return false;
    }
    if (this.family == null) {
      if (other.family != null) {
        return false;
      }
    } else if (!this.family.equals(other.family)) {
      return false;
    }
    if (this.manufacturer == null) {
      if (other.manufacturer != null) {
        return false;
      }
    } else if (!this.manufacturer.equals(other.manufacturer)) {
      return false;
    }
    if (this.model == null) {
      if (other.model != null) {
        return false;
      }
    } else if (!this.model.equals(other.model)) {
      return false;
    }
    if (this.product_name == null) {
      if (other.product_name != null) {
        return false;
      }
    } else if (!this.product_name.equals(other.product_name)) {
      return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Product [product_name=" + this.product_name + ", manufacturer=" + this.manufacturer
        + ", family=" + this.family + ", model=" + this.model + ", announced_date="
        + this.announced_date + "]";
  }

}
