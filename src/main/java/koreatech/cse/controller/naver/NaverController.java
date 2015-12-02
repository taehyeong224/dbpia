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

    List<ItemType> itemTypes = null;
    public List<ItemType> getNaver(String search,int display) {

       // System.out.println("search : " + search);
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(naverURL)
                    .queryParam("key", naverKEY)
                    .queryParam("query", search)
                    .queryParam("display", display)
                    .queryParam("target", "book")
                    .queryParam("d_catg",280);

            RssType rssType = restTemplate.getForObject(builder.build().encode().toUri(),
                    RssType.class);
            //System.out.println("rss : " +  rssType);
            if (rssType.getChannel() == null)
                return null;
            itemTypes = rssType.getChannel().getItem();
            return itemTypes;

        }catch (HttpClientErrorException e) {
            System.out.println("오류다 : " + e.getStatusCode() + ": " + e.getStatusText());
        }
        return null;
    }
}
