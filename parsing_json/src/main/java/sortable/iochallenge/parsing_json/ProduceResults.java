
package sortable.iochallenge.parsing_json;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.google.gson.Gson;

/**
 * This produces the results of matching listings and write them on a file named results.txt
 *
 * @author bhling
 *
 */
public class ProduceResults {

  /**
   * Given list of results write them into a text file with JSON format
   *
   * @param results the list of results
   * @throws IOException if cannot process file
   */
  protected void output(List<Result> results) throws IOException {
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

}
