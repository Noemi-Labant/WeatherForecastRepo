import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private String line = "";
    private String cvsSplitBy = ";";

    public List<String[]> read(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            List<String[]> rows = new ArrayList<String[]>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] columnValues = line.split(cvsSplitBy);
                rows.add(columnValues);
            }
            return rows;
        } catch (IOException e) {
            System.out.println("An exception occured: " + e.getMessage());
            return null;
        }
    }
}

