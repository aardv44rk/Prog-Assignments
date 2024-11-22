package main;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MunicipalityLoader {
    public Map<Integer, String> loadMunicipalities() {

    Map<Integer, String> municipalities = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new InputStreamReader(
        MunicipalityLoader.class.getResourceAsStream("municipalities.csv")))) {
            
            
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length >= 4) { // Ensure there are enough columns
                    int code = Integer.parseInt(values[0].replace("\"", ""));  // Municipality code as int  
                    String name = values[3].replace("\"", "");  // Municipality name
                    municipalities.put(code, name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Print or use the municipalities map
        return municipalities;
    }
}