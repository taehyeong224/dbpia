package koreatech.cse.controller.naver;


import koreatech.cse.domain.naver.ItemType;
import koreatech.cse.domain.naver.RssType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/koreatech/cse/domain/koreatech.cse.domain.naver")
public class NaverController {

    public String naverURL = "http://openapi.naver.com/search";
    public String naverKEY = "0490c1442fae0f9657ae2104e0bd3588";

    List<ItemType> itemTypes;
    public List<ItemType> getNaver(String search) {

       // System.out.println("search : " + search);
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(naverURL)
                    .queryParam("key", naverKEY)
                    .queryParam("query", search)
                    .queryParam("display", 100)
                    .queryParam("target", "book");

            System.out.println("Naver API : " + builder.build().encode().toUri());

            RssType rssType = restTemplate.getForObject(builder.build().encode().toUri(),
                    RssType.class);

            itemTypes = rssType.getChannel().getItem();

            return itemTypes;

        }catch (HttpClientErrorException e) {
            System.out.println("오류다 : " + e.getStatusCode() + ": " + e.getStatusText());
        }
        return itemTypes;
    }
}
