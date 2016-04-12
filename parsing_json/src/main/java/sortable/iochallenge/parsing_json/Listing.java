
package sortable.iochallenge.parsing_json;

/**
 * This represents a Listing with title, manufacturer, currency, price
 *
 * @author bhling
 *
 */
public class Listing {

  private String title;
  private String manufacturer;
  private String currency;
  private String price;

  /**
   * This creates a Listings given title, manufacturer, currency and price
   *
   * @param title the title of the listing
   * @param manufacturer the manufacturer of the listing
   * @param currency the currency for this listing
   * @param price the price of this listing
   */
  public Listing(String title, String manufacturer, String currency, String price) {
    super();
    this.title = title;
    this.manufacturer = manufacturer;
    this.currency = currency;
    this.price = price;
  }

  /**
   * @return the title of the listing
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @return the manufacturer of the listing
   */
  public String getManufacturer() {
    return this.manufacturer;
  }

  /**
   * @return the currency for the listing
   */
  public String getCurrency() {
    return this.currency;
  }

  /**
   * @return the price for this listing
   */
  public String getPrice() {
    return this.price;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + (this.currency == null ? 0 : this.currency.hashCode());
    result = (prime * result) + (this.manufacturer == null ? 0 : this.manufacturer.hashCode());
    result = (prime * result) + (this.price == null ? 0 : this.price.hashCode());
    result = (prime * result) + (this.title == null ? 0 : this.title.hashCode());
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
    Listing other = (Listing) obj;
    if (this.currency == null) {
      if (other.currency != null) {
        return false;
      }
    } else if (!this.currency.equals(other.currency)) {
      return false;
    }
    if (this.manufacturer == null) {
      if (other.manufacturer != null) {
        return false;
      }
    } else if (!this.manufacturer.equals(other.manufacturer)) {
      return false;
    }
    if (this.price == null) {
      if (other.price != null) {
        return false;
      }
    } else if (!this.price.equals(other.price)) {
      return false;
    }
    if (this.title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!this.title.equals(other.title)) {
      return false;
    }
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Listing [title=" + this.title + ", manufacturer=" + this.manufacturer + ", currency="
        + this.currency + ", price=" + this.price + "]";
  }

}
