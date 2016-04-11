package sortable.iochallenge.parsing_json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * @author bhling
 *
 */
public class MatchProductListings {

  public static void main(String[] args) throws IOException, IndexOutOfBoundException {
    Map<String, List<Listing>> listingsMap = MatchProductListings.createListingList();
    List<Product> productList = MatchProductListings.createProductList();
    ProcessMatching pm = new ProcessMatching();
    MatchProductListings.output(pm.process(productList, listingsMap));
  }

  private static void output(List<Result> results) throws IOException {
    BufferedWriter bw = null;
    Gson gson = new Gson();
    try {
      bw = new BufferedWriter(
          new OutputStreamWriter(new FileOutputStream("results.txt"), StandardCharsets.UTF_8));
      for (Result result : results) {
        gson.toJson(result, bw);
        bw.write("\n");
        bw.flush();
      }
    } catch (IOException e) {
      System.out.println("Cannot output file: results.json");
    } finally {
      if (bw != null) {
        bw.close();
      }
    }

  }

  private static Map<String, List<Listing>> createListingList()
      throws JsonSyntaxException, IOException {
    Map<String, List<Listing>> map = new HashMap<String, List<Listing>>();
    String line = "";
    BufferedReader input = null;
    Gson gson = new Gson();
    try {
      input = new BufferedReader(new InputStreamReader(
          MatchProductListings.class.getClassLoader().getResource("listings.txt").openStream(),
          StandardCharsets.UTF_8));
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

  private static List<Product> createProductList() throws JsonSyntaxException, IOException {
    List<Product> list = new ArrayList<Product>();
    String line = "";
    BufferedReader input = null;
    Gson gson = new Gson();
    try {
      input = new BufferedReader(new InputStreamReader(
          MatchProductListings.class.getClassLoader().getResource("products.txt").openStream(),
          StandardCharsets.UTF_8));
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
}
