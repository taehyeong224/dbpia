package koreatech.cse.controller.naver;

import java.io.PrintStream;
import java.net.URI;
import java.util.List;
import koreatech.cse.domain.naver.ChannelType;
import koreatech.cse.domain.naver.ItemType;
import koreatech.cse.domain.naver.RssType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Controller
@RequestMapping(value={"/koreatech/cse/domain/koreatech.cse.domain.naver"})
public class NaverController {
    public String naverURL = "http://openapi.naver.com/search";
    public String naverKEY = "0490c1442fae0f9657ae2104e0bd3588";
    List<ItemType> itemTypes = null;

    public List<ItemType> getNaver(String search, int display) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl((String)this.naverURL).queryParam("key", new Object[]{this.naverKEY}).queryParam("query", new Object[]{search}).queryParam("display", new Object[]{display}).queryParam("target", new Object[]{"book"}).queryParam("d_catg", new Object[]{280});
            RssType rssType = (RssType)restTemplate.getForObject(builder.build().encode().toUri(), (Class)RssType.class);
            if (rssType.getChannel() == null) {
                return null;
            }
            this.itemTypes = rssType.getChannel().getItem();
            return this.itemTypes;
        }
        catch (HttpClientErrorException e) {
            System.out.println("\uc624\ub958\ub2e4 : " + (Object)e.getStatusCode() + ": " + e.getStatusText());
            return null;
        }
    }
}