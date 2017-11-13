package il.co.sears.autoplayground;
import android.support.test.runner.AndroidJUnit4;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(AndroidJUnit4.class)
public class ProductSearchApiTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private IApiProxy apiProxy;
    private IProductJsonParser productJsonParser;
    private ProductSearchApi target;

    @Before
    public void setup() {
        apiProxy = mock(IApiProxy.class);
        productJsonParser = mock(IProductJsonParser.class);

        target = new ProductSearchApi(apiProxy, productJsonParser);
    }

    @Test
    public void search_WhenTermIsNull_ThrowException() throws Exception {
        exception.expect(IllegalArgumentException.class);
        target.search(null);
    }
    @Test
    public void search_WhenTermIsNotNull_ReturnSearchResults() throws Exception {
        SetApiResult("{\"products\": [{\"id\": 1}]}");
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "sock1", "image.url"));
        Parse(products);

        List<Product> result = target.search("socks");

        assertThat(result, not(empty()));
        assertThat(result, is(products));
    }

    private void Parse(List<Product> products) throws Exception {
        when(productJsonParser.parse(org.mockito.Mockito.any(JSONObject.class))).thenReturn(products);
    }

    private void SetApiResult(String json) throws Exception {
        when(apiProxy.get(org.mockito.Mockito.any(URL.class))).thenReturn(new JSONObject(json));
    }
}