/**
 *
 */
package sortable.iochallenge.parsing_json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author bhling
 *
 */
public class ProcessMatching {

  private List<Result> results;

  /**
   *
   */
  public ProcessMatching() {
    super();
    this.results = new ArrayList<Result>();
  }

  public List<Result> process(List<Product> productList, Map<String, List<Listing>> listingsMap)
      throws IndexOutOfBoundException {
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
          if (productFamily == null && productModel != null) {
            if (title.contains(productModel)) {
              temp.add(listing);
            }
          } else if (productFamily != null && productModel == null) {
            if (title.contains(productFamily)) {
              temp.add(listing);
            }
          } else if (productFamily != null && productModel != null) {
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
