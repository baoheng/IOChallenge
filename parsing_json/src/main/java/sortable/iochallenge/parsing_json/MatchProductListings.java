package sortable.iochallenge.parsing_json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * This program is to match associate listings with their products. The keys are how to process JSON
 * and IO. This class is a control panel to handle different operations. All inputs files are
 * already inside class path. No need to pass any arguments;
 *
 * @author bhling
 *
 */
public class MatchProductListings {

  /**
   * This is a control panel to handle different operations
   *
   * @param args the arguments pass in the program (0 for this)
   * @throws IOException if cannot process files
   */
  public static void main(String[] args) throws IOException {
    ParseJSON pj = new ParseJSON();
    Map<String, List<Listing>> listingsMap = pj.createMapListings("listings.txt");
    List<Product> productList = pj.createListProducts("products.txt");
    ProcessMatching pm = new ProcessMatching();
    ProduceResults pr = new ProduceResults();
    pr.output(pm.process(productList, listingsMap));
  }

}
