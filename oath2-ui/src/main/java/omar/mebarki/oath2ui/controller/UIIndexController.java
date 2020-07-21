package omar.mebarki.oath2ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class UIIndexController {
    @Value("#{ @environment['spring.security.oauth2.resource.server1'] }")
    private String resourceServerUrl1;

    @Value("#{ @environment['spring.security.oauth2.resource.server2'] }")
    private String resourceServerUrl2;

    @Autowired
    @Qualifier("api1")
    private WebClient webClient1;

    @Autowired
    @Qualifier("api2")
    private WebClient webClient2;

    @ResponseBody
    @GetMapping("/ui")
    public String ui() {
        String hello1 = invokeApi(webClient1, this.resourceServerUrl1, "/hello");
        String hello2 = invokeApi(webClient2, this.resourceServerUrl2, "/hello2");
        return "UI api1:" + hello1 + ", api2:" + hello2;
    }

    private String invokeApi(WebClient webclient, String url, String api) {
        return webclient
                .get()
                .uri(url + api)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    @ResponseBody
    @GetMapping("/")
    public String index() {
        return "Index";
    }
}
