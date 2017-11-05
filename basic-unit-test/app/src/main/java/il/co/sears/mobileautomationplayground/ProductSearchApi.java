package il.co.sears.mobileautomationplayground;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ProductSearchApi {
    private final String SEARCH_URL_FORMAT = "https://platform.shopyourway.com/products/search?" +
            "q=%s&" +
            "&token=0_20975_253402300799_1_39c0fd9abf524b96985688e78892212c05f34203a46ac36a4117f211b41c7f5d&hash=16eba7802b35f6cb1b03dbf6262d4db0808f437a14f070019a6fa98da45b3d90";

    private final IProductJsonParser productJsonParser;
    private IApiProxy apiProxy;

    public ProductSearchApi(IApiProxy apiProxy, IProductJsonParser productJsonParser) {
        this.apiProxy = apiProxy;
        this.productJsonParser = productJsonParser;
    }

    public List<Product> search(String term) throws Exception {
        if (term == null || term.isEmpty()) throw new IllegalArgumentException("term");

        URL url = GetUrl(term);

        return productJsonParser.parse(apiProxy.get(url));
    }

    private URL GetUrl(String term) throws Exception {
        return new URL(String.format(SEARCH_URL_FORMAT, term));
    }
}
