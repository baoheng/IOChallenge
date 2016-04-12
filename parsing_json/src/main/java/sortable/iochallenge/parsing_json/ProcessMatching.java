
package sortable.iochallenge.parsing_json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This finds matching listings to its products
 *
 * @author bhling
 *
 */
public class ProcessMatching {

  private List<Result> results;

  /**
   * This creates ProcessMatching instance and initialize results List
   */
  public ProcessMatching() {
    super();
    this.results = new ArrayList<Result>();
  }

  /**
   * This fins matching products and listings and put them into result list
   *
   * @param productList the list of products
   * @param listingsMap the map containing listings with different manufacturer
   * @return the list of result for each product and their associate listings
   */
  public List<Result> process(List<Product> productList, Map<String, List<Listing>> listingsMap) {
    for (int i = 0; i < productList.size(); i++) {
      Product product = productList.get(i);
      CharSequence productName = product.getProduct_name();
      String productManufacturer = product.getManufacturer();
      CharSequence productFamily = product.getFamily();
      CharSequence productModel = product.getModel();

      List<Listing> currentList = listingsMap.get(productManufacturer);
      List<Listing> temp = new ArrayList<Listing>();
      if (currentList != null) {
        for (int j = 0; j < currentList.size(); j++) {
          Listing listing = currentList.get(j);
          String title = listing.getTitle();
          if ((productFamily == null) && (productModel != null)) {
            if (title.contains(productModel)) {
              temp.add(listing);
            }
          } else if ((productFamily != null) && (productModel == null)) {
            if (title.contains(productFamily)) {
              temp.add(listing);
            }
          } else if ((productFamily != null) && (productModel != null)) {
            if (title.contains(productFamily) && title.contains(productModel)) {
              temp.add(listing);
            }
          }
        }
      }
      if (productName != null) {
        this.results.add(new Result(productName.toString(), temp));
      }
    }
    return this.results;
  }

}
