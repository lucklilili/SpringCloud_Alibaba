import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/9/1 3:14 下午
 */
public class HttpRequest {


    public static String AccountCenter(String url) throws Exception {
        HttpClient httpClient;
        HttpGet postMethod;
        HttpResponse response;
        String reponseContent;
        httpClient = HttpClients.createDefault();
        postMethod = new HttpGet(url);
        postMethod.addHeader("Content-type", "text/plain;charset=utf-8");
        postMethod.addHeader("accept", "*/*");
        postMethod.addHeader("connection", "Keep-Alive");
        response = httpClient.execute(postMethod);
        HttpEntity httpEntity = response.getEntity();
        reponseContent = EntityUtils.toString(httpEntity);
        EntityUtils.consume(httpEntity);
        return reponseContent;
    }
}
