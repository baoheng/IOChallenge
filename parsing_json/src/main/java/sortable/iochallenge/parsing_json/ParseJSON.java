
package sortable.iochallenge.parsing_json;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * This class parses text files with JSON format
 *
 * @author bhling
 *
 */
public class ParseJSON {

  /**
   * This takes the name of the products file locates in the class path read each line as JSON
   * Format and process objects with Gson library then store each product into Product class
   * finally, store each Product into the list and return it
   *
   * @param fileName the name of the product file
   * @return the list containing each product from the file
   * @throws IOException if cannot process the file
   */
  protected List<Product> createListProducts(String fileName) throws IOException {
    List<Product> list = new ArrayList<Product>();
    String line = "";
    BufferedReader input = null;
    Gson gson = new Gson();
    try {
      input = new BufferedReader(
          new InputStreamReader(new FileInputStream("products.txt"), StandardCharsets.UTF_8));
      while ((line = input.readLine()) != null) {
        list.add(gson.fromJson(line, Product.class));
      }

    } catch (FileNotFoundException e) {
      System.out.println("Cannot find file: products.txt.");
    } finally {
      if (input != null) {
        input.close();
      }
    }
    return list;
  }

  /**
   * This takes in the name of listings file locates in class path read each line as JSON format and
   * process objects with Gson library then store each listing into Listing class finally store each
   * Listing into a map with manufacturer as key and Listing as values and return the map
   *
   * @param fileName the name of listings file
   * @return the map containing manufacturer as key and their associated listings
   * @throws IOException if cannot process file
   */
  protected Map<String, List<Listing>> createMapListings(String fileName) throws IOException {
    Map<String, List<Listing>> map = new HashMap<String, List<Listing>>();
    String line = "";
    BufferedReader input = null;
    Gson gson = new Gson();
    try {
      input = new BufferedReader(
          new InputStreamReader(new FileInputStream("listings.txt"), StandardCharsets.UTF_8));
      while ((line = input.readLine()) != null) {
        Listing cur = gson.fromJson(line, Listing.class);
        if (map.containsKey(cur.getManufacturer())) {
          map.get(cur.getManufacturer()).add(cur);
        } else {
          List<Listing> currentList = new ArrayList<Listing>();
          currentList.add(cur);
          map.put(cur.getManufacturer(), currentList);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Cannot find file: products.txt.");
    } finally {
      if (input != null) {
        input.close();
      }
    }
    return map;
  }

}
