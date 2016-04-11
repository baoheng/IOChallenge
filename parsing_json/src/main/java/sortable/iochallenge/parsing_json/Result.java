/**
 *
 */
package sortable.iochallenge.parsing_json;

import java.util.List;

/**
 * @author bhling
 *
 */
public class Result {

  private String product_name;
  private List<Listing> listings;

  /**
   * @param product_name
   * @param listings
   */
  public Result(String product_name, List<Listing> listings) {
    super();
    this.product_name = product_name;
    this.listings = listings;
  }

  /**
   * @return the product_name
   */
  public String getProduct_name() {
    return this.product_name;
  }

  /**
   * @return the listings
   */
  public List<Listing> getListings() {
    return this.listings;
  }

}
