package il.co.sears.autoplayground;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonReader implements IJsonReader {
    public JSONObject read(InputStream inputStream) {
        JSONObject jsonObject = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line + "\n");
            }
            jsonObject = new JSONObject(builder.toString());
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        return jsonObject;
    }
}
