package koreatech.cse.controller;

import koreatech.cse.controller.dbpia.DbpiaController;
import koreatech.cse.controller.naver.NaverController;
import koreatech.cse.domain.dbpia.ItemType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

@Controller
@RequestMapping("/")
public class HomeController extends Thread {
    StringSimilarity stringSimilarity = new StringSimilarity();
    DbpiaController dbpiaController = new DbpiaController();
    NaverController naverController = new NaverController();
    HashSet<String> set = new HashSet<String>();

    List<koreatech.cse.domain.naver.ItemType> naverItemTypes = null;
    List<ItemType> DbpiaItemTypes;

    @RequestMapping("/")
    public String home()
    {
        return "hello";
    }



    @Value("${env.text}")
    private String env;

    @RequestMapping("/total")
    public String search(){
        return "total";
    }



    @RequestMapping("total/show")
    public String total(String search,Model model) throws InterruptedException {
        DbpiaItemTypes = dbpiaController.getDbpia(search);
        for(ItemType itemType : DbpiaItemTypes){
            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            StringTokenizer st = new StringTokenizer(edit," ");
            while(st.hasMoreTokens()) {
                set.add(st.nextToken());
            }
        }

        System.out.println("집합 : " + set);
        for(String str : set) {
            if (str.length() > 2) {
                System.out.println("검색어 : " + str);
                naverItemTypes = naverController.getNaver(str);
                System.out.println("naverItemTypes : " + naverItemTypes);
                if (naverItemTypes != null) {
                    for (koreatech.cse.domain.naver.ItemType itemType1 : naverItemTypes) {
                        if (itemType1.getLink() == null || itemType1.getPrice() == null || itemType1 == null) {
                            break;
                        }
                        System.out.println("link : " + itemType1.getLink());
                        System.out.println("description : " + itemType1.getDescription());
                        System.out.println("Title : " + itemType1.getTitle());
                        System.out.println("Author : " + itemType1.getAuthor());
                        System.out.println("discout : " + itemType1.getDiscount());
                        System.out.println("Image : " + itemType1.getImage());
                        System.out.println("Isbn : " + itemType1.getIsbn());
                        System.out.println("Price : " + itemType1.getPrice());
                        System.out.println("Pubdate : " + itemType1.getPubdate());
                        System.out.println("Publisher : " + itemType1.getPublisher());
                    }
                }
                System.out.println();
            }
        }



        return "total";
    }
}
