package koreatech.cse.controller.dbpia;

import java.io.PrintStream;
import java.net.URI;
import java.util.List;
import koreatech.cse.domain.dbpia.AuthorType;
import koreatech.cse.domain.dbpia.AuthorsType;
import koreatech.cse.domain.dbpia.IssueType;
import koreatech.cse.domain.dbpia.ItemType;
import koreatech.cse.domain.dbpia.ItemsType;
import koreatech.cse.domain.dbpia.PublicationType;
import koreatech.cse.domain.dbpia.PublisherType;
import koreatech.cse.domain.dbpia.ResultType;
import koreatech.cse.domain.dbpia.RootType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@Controller
@RequestMapping(value={"/dbpia"})
public class DbpiaController {
    List<ItemType> itemTypes;
    public String dbpia_key = "50929d84fe30e41a00d02a66fddfffff";
    public String dbpia_url = "http://api.dbpia.co.kr/v1/search/search.xml";
    public String dbpia_url2 = "&target=se&searchall=";
    public String dbpia_url3 = "&category=4";

    @RequestMapping(value={"/"})
    public String dbpia() {
        return "dbpia/index";
    }

    @RequestMapping(value={"/getDbpia"})
    public String getSpringerResponse(Model model, String search) {
        System.out.println("search : " + search);
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl((String)this.dbpia_url).queryParam("key", new Object[]{this.dbpia_key}).queryParam("target", new Object[]{"se_adv"}).queryParam("searchall", new Object[]{search}).queryParam("category", new Object[]{"4"});
            System.out.println(builder.build().encode().toUri());
            RootType dbpiaType = (RootType)restTemplate.getForObject(builder.build().encode().toUri(), (Class)RootType.class);
            System.out.println((Object)dbpiaType);
            model.addAttribute("dbpia", (Object)dbpiaType.getResult().getItems().getItem());
            this.itemTypes = dbpiaType.getResult().getItems().getItem();
            for (ItemType item : this.itemTypes) {
                System.out.println("Title : " + item.getTitle());
                System.out.println("Ctype : " + item.getCtype());
                for (AuthorType authorType : item.getAuthors().getAuthor()) {
                    System.out.println("AuthorName : " + authorType.getName());
                    System.out.println("AuthorOrder : " + authorType.getOrder());
                    System.out.println("AuthorUrl : " + authorType.getUrl());
                }
                System.out.println("PublisherName : " + item.getPublisher().getName());
                System.out.println("PublisherUrl : " + item.getPublisher().getUrl());
                System.out.println("PublicationName : " + item.getPublication().getName());
                System.out.println("PublicationUrl : " + item.getPublication().getUrl());
                System.out.println("PublicationIssn : " + item.getPublication().getIssn());
                System.out.println("IssueName : " + item.getIssue().getName());
                System.out.println("IssueNum : " + item.getIssue().getNum());
                System.out.println("IssueYymm : " + item.getIssue().getYymm());
                System.out.println("Pages : " + item.getPages());
                System.out.println("Preview : " + item.getPreview());
                System.out.println();
            }
        }
        catch (HttpClientErrorException e) {
            System.out.println("\uc624\ub958\ub2e4 : " + (Object)e.getStatusCode() + ": " + e.getStatusText());
        }
        return "dbpia/index";
    }

    public List<ItemType> getDbpia(String search) {
        System.out.println("search : " + search);
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl((String)this.dbpia_url).queryParam("key", new Object[]{this.dbpia_key}).queryParam("target", new Object[]{"se"}).queryParam("searchall", new Object[]{search}).queryParam("category", new Object[]{"4"});
            RootType dbpiaType = (RootType)restTemplate.getForObject(builder.build().encode().toUri(), (Class)RootType.class);
            this.itemTypes = dbpiaType.getResult().getItems().getItem();
            return this.itemTypes;
        }
        catch (HttpClientErrorException e) {
            System.out.println("\uc624\ub958\ub2e4 : " + (Object)e.getStatusCode() + ": " + e.getStatusText());
            return this.itemTypes;
        }
    }
}