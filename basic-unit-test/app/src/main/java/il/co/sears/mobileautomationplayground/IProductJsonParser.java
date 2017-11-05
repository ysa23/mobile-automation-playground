package il.co.sears.mobileautomationplayground;

import org.json.JSONObject;

import java.util.List;

public interface IProductJsonParser {
    List<Product> parse(JSONObject json) throws Exception;
}
