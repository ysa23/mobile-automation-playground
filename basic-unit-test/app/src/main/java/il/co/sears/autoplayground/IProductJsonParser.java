package il.co.sears.autoplayground;

import org.json.JSONObject;

import java.util.List;

public interface IProductJsonParser {
    List<Product> parse(JSONObject json) throws Exception;
}
