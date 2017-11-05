package il.co.sears.mobileautomationplayground;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

public class ApiProxy implements IApiProxy {
    private IJsonReader jsonReader;

    public ApiProxy(IJsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    @Override
    public JSONObject get(URL url) throws Exception {
        HttpURLConnection connection = openConnection(url);

        try {
            return jsonReader.read(connection.getInputStream());
        }
        finally {
            connection.disconnect();
        }
    }

    private HttpURLConnection openConnection(URL url) throws Exception {
        java.net.HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setReadTimeout(5000);
        connection.connect();
        return  connection;
    }
}
