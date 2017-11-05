package il.co.sears.mobileautomationplayground;

import org.json.JSONObject;

import java.net.URL;

interface IApiProxy {
    JSONObject get(URL url) throws Exception;
}
