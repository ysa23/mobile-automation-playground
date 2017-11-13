package il.co.sears.autoplayground;
import android.support.test.runner.AndroidJUnit4;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ProductJsonParserTests {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private ProductJsonParser target;

    @Before
    public void Setup() {
        target = new ProductJsonParser();
    }

    @Test
    public void parse_WhenJsonIsNull_ThrowException() throws Exception {
        exception.expect(IllegalArgumentException.class);
        target.parse(null);
    }

    @Test
    public void parse_WhenJsonDoesNotIncludeProducts_ReturnEmpty() throws Exception {
        JSONObject json = new JSONObject("{ \"name\" : \"test\" }");

        List<Product> result = target.parse(json);

        assertThat(result, hasSize(0));
    }

    @Test
    public void parse_WhenJsonIncludeProducts_ReturnListWithProducts() throws Exception {
        JSONObject json = new JSONObject("{\"products\": [{\"id\": 1, \"name\": \"Product 1\", \"imageUrl\": \"image.url.com\"},{\"id\": 2, \"name\": \"Product 2\", \"imageUrl\": \"image.url2.com\"}]}");

        List<Product> result = target.parse(json);

        assertThat(result, hasSize(2));
        assertThat(result, hasItems(new Product(1, "Product 1", "image.url.com"), new Product(2, "Product 2", "image.url2.com")));
    }
}