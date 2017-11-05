package il.co.sears.mobileautomationplayground;

import org.json.JSONObject;

import java.io.InputStream;

public interface IJsonReader {
    JSONObject read(InputStream inputStream);
}
