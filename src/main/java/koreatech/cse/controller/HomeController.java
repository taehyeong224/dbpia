package koreatech.cse.controller;

import koreatech.cse.controller.dbpia.DbpiaController;
import koreatech.cse.controller.google.GoogleController;
import koreatech.cse.domain.dbpia.ItemType;
import koreatech.cse.domain.google.Google;
import koreatech.cse.domain.google.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    DbpiaController dbpiaController = new DbpiaController();
    GoogleController googleController = new GoogleController();
    List<ItemType> itemTypes;
    Google google;

    @RequestMapping("/")
    public String home()
    {
        return "hello";
    }
//


    @Value("${env.text}")
    private String env;

    @RequestMapping("/total")
    public String search(){
        return "total";
    }



    @RequestMapping("total/show")
    public String total(String search){

        itemTypes = dbpiaController.getDbpia(search);
        int i = 0,j = 0;

       for(ItemType itemType : itemTypes){
           String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
           //edit = edit.replaceAll("[?][$]\\(\\)\\{\\}[*][+]\\^[|]\\[\\]", "");
           //edit = edit.replaceAll("([).([^<]*).(])", "");
           System.out.println("edit : " + edit);
           google = googleController.getGoogle(edit);
           for(Result result : google.getResponseData().getResults()){
//               if (result.getUrl().isEmpty() || result.getVisibleUrl().isEmpty() || result.getUnescapedUrl().isEmpty()){
//                   break;
//               }
                 System.out.println("url : " +  result.getUrl());
//               System.out.println("url2 : " + result.getVisibleUrl());
//               System.out.println("url3 : " + result.getUnescapedUrl());

               System.out.println();
                j++;
           }
           System.out.println();
           i++;
       }
       return "total";
   }
}
