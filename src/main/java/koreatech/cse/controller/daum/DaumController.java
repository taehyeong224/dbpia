package koreatech.cse.controller.daum;


import koreatech.cse.domain.daum.Book;
import koreatech.cse.domain.daum.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Controller
@RequestMapping(value={"/koreatech/cse/domain/koreatech.cse.domain.daum"})
public class DaumController {
    public String daumURL = "https://apis.daum.net/search/book";
    public String daumKEY = "65cc04c591ba1b9efd2004bd4b1ccaac";
    List<Item> itemTypes = null;

    public List<Item> getDaum(String search) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(daumURL)
                    .queryParam("apikey", daumKEY)
                    .queryParam("q", search)
                    .queryParam("cate_id", "33");

            System.out.println("daum : " + builder.build().encode().toUri());

            Book book = restTemplate.getForObject(builder.build().encode().toUri(), Book.class);
            if(book.getChannel() == null){
                return null;
            }
            itemTypes = book.getChannel().getItem();

            return itemTypes;

        } catch (HttpClientErrorException e) {
            System.out.println("오류다 : " + e.getStatusCode() + ": " + e.getStatusText());
            return null;
        }
    }
}