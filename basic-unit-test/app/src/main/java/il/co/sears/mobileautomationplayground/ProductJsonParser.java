package il.co.sears.mobileautomationplayground;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductJsonParser implements IProductJsonParser {
    @Override
    public List<Product> parse(JSONObject json) throws Exception {
        if (json == null) throw new IllegalArgumentException("json");
        if (json.isNull("products")) return new ArrayList<>();

        List<Product> items = new ArrayList<>();

        JSONArray array = json.getJSONArray("products");
        for(int i =0; i < array.length();i++)
        {
            JSONObject current = array.getJSONObject(i);
            Product product = new Product(current.getInt("id"), current.getString("name"), current.getString("imageUrl"));

            items.add(product);
        }

        return  items;
    }
}
