package koreatech.cse.controller.google;

import koreatech.cse.domain.google.Google;
import koreatech.cse.domain.google.Result;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kth on 2015. 11. 21..
 */
@Controller
@RequestMapping("/test/google")
public class GoogleController {

    Google google;

    public String url = "https://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
    public String url2 = "https://ajax.googleapis.com/ajax/services/search/web";
    @RequestMapping("/")
    public String search(){
        return "google/index";
    }

    @RequestMapping("/getJson")
    public String getSpringerResponse(Model model,String search) {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> msgConverters = new ArrayList<>();
        msgConverters.add(new MappingAnyJsonHttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url2)
                    .queryParam("v", "1.0")
                    .queryParam("q", search + " filetype:pdf");

            ResponseEntity<Google> googleResponseEntity
                    =
                    restTemplate.getForEntity(builder.build().encode().toUri(),
                            Google.class);
            google = googleResponseEntity.getBody();
            model.addAttribute("google" , google.getResponseData().getResults());
            for(Result result : google.getResponseData().getResults()){
                System.out.println("getTitle :" + result.getTitle());
                System.out.println("getCacheUrl : " + result.getCacheUrl());
                System.out.println("getContent : " + result.getContent());
                System.out.println("getGsearchResultClass : " + result.getGsearchResultClass());
                System.out.println("getTitleNoFormatting : " + result.getTitleNoFormatting());
                System.out.println("getUnescapedUrl : " + result.getUnescapedUrl());
                System.out.println("getUrl : " + result.getUrl());
                System.out.println("getVisibleUrl : " + result.getVisibleUrl());
                System.out.println();
            }
        }catch (HttpClientErrorException e) {
            System.out.println("오류다 : " + e.getStatusCode() + ": " + e.getStatusText());
        }
        return "google/getJson";
    }


    public Google getGoogle(String search) {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> msgConverters =new ArrayList<>();
        msgConverters.add(new MappingAnyJsonHttpMessageConverter());
        restTemplate.setMessageConverters(msgConverters);

        try {

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url2)
                    .queryParam("v", "1.0")
                    .queryParam("q", search + " filetype:pdf");

            System.out.println("google : " + builder.build().encode().toUri());
            ResponseEntity<Google> googleResponseEntity
                    =
                    restTemplate.getForEntity(builder.build().encode().toUri(),
                            Google.class);
            google = googleResponseEntity.getBody();

           return google;
        }catch (HttpClientErrorException e) {
            System.out.println("오류다 : " + e.getStatusCode() + ": " + e.getStatusText());
        }
        return google;
    }
}

class MappingAnyJsonHttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public MappingAnyJsonHttpMessageConverter() {
        List list = new ArrayList(1);
        list.add(MediaType.ALL);
        this.setSupportedMediaTypes(list);
    }
}