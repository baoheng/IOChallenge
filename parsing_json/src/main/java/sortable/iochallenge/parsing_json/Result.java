
package sortable.iochallenge.parsing_json;

import java.util.List;

/**
 * This represents a Result with product_name and list of listings
 *
 * @author bhling
 *
 */
public class Result {

  private String product_name;
  private List<Listing> listings;

  /**
   * This creates a Result given a product_name and list of listings
   *
   * @param product_name the name of the product
   * @param listings the list of listings for this product
   */
  public Result(String product_name, List<Listing> listings) {
    super();
    this.product_name = product_name;
    this.listings = listings;
  }

  /**
   * @return the name of the product
   */
  public String getProduct_name() {
    return this.product_name;
  }

  /**
   * @return the list of listings
   */
  public List<Listing> getListings() {
    return this.listings;
  }

}
