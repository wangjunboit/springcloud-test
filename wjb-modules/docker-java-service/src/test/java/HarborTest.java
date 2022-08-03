import cn.hutool.core.codec.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author wjb
 * @create 2022/8/3
 * @since 1.0.0
 */

public class HarborTest {
    private String username = "admin";
    private String password = "2970485aA";

    @Test
    public void deleteImages() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://42.194.173.207:5000/api/v2.0/projects/wjb/repositories/nginx/artifacts/1.9";


        HttpEntity httpEntity = new HttpEntity(getHeaders());
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, String.class);

        System.out.println(response.getStatusCode() + " " + response.getBody() + " " + response.getHeaders());
    }

    private HttpHeaders getHeaders() {
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Basic " + Base64.encode(username + ":" + password));
        return header;
    }
}
