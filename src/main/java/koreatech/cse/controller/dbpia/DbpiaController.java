package koreatech.cse.controller.dbpia;


import koreatech.cse.domain.dbpia.*;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dbpia")
public class DbpiaController {

    List<ItemType> itemTypes;

    public String dbpia_key = "50929d84fe30e41a00d02a66fddfffff";
    public String dbpia_url = "http://api.dbpia.co.kr/v1/search/search.xml";
    public String dbpia_url2 = "&target=se&searchall=";
    public String dbpia_url3 = "&category=4";

    @RequestMapping("/")
    public String dbpia(){
        return "dbpia/index";
    }


    @RequestMapping("/getDbpia")
    public String getSpringerResponse(Model model,String search) {

        System.out.println("search : " + search);
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(dbpia_url)
                    .queryParam("key", dbpia_key)
                    .queryParam("target", "se_adv")
                    .queryParam("searchall", search)
                    .queryParam("category", "4");

            System.out.println(builder.build().encode().toUri());

            RootType dbpiaType = restTemplate.getForObject(builder.build().encode().toUri(),
                    RootType.class);
            System.out.println(dbpiaType);

            model.addAttribute("dbpia",dbpiaType.getResult().getItems().getItem());

            itemTypes = dbpiaType.getResult().getItems().getItem();

            for(ItemType item : itemTypes){

                System.out.println("Title : " + item.getTitle());
                System.out.println("Ctype : " + item.getCtype());
                for(AuthorType authorType :item.getAuthors().getAuthor()){
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


        }catch (HttpClientErrorException e) {
            System.out.println("오류다 : " + e.getStatusCode() + ": " + e.getStatusText());
        }


        return "dbpia/index";
    }

    public List<ItemType> getDbpia(String search) {

        System.out.println("search : " + search);
        RestTemplate restTemplate = new RestTemplate();
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(dbpia_url)
                    .queryParam("key", dbpia_key)
                    .queryParam("target", "se")
                    .queryParam("searchall", search)
                    .queryParam("category", "4");

            //System.out.println("dbpia : " + builder.build().encode().toUri());

            RootType dbpiaType = restTemplate.getForObject(builder.build().encode().toUri(),
                    RootType.class);

            itemTypes = dbpiaType.getResult().getItems().getItem();

            return itemTypes;

        }catch (HttpClientErrorException e) {
            System.out.println("오류다 : " + e.getStatusCode() + ": " + e.getStatusText());
        }
        return itemTypes;
    }
}
