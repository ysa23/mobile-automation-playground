package il.co.sears.autoplayground;

import org.json.JSONObject;

import java.io.InputStream;

public interface IJsonReader {
    JSONObject read(InputStream inputStream);
}
