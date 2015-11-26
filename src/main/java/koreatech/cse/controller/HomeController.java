package koreatech.cse.controller;

import koreatech.cse.controller.dbpia.DbpiaController;
import koreatech.cse.controller.naver.NaverController;
import koreatech.cse.domain.dbpia.ItemType;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.MorphAnalyzer.ChartMorphAnalyzer.ChartMorphAnalyzer;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.PosTagger.HmmPosTagger.HMMTagger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController extends Thread {
    StringSimilarity stringSimilarity = new StringSimilarity();
    DbpiaController dbpiaController = new DbpiaController();
    NaverController naverController = new NaverController();

    List<koreatech.cse.domain.naver.ItemType> naverItemTypes;
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
        String path = this.getClass().getResource("").getPath();
        System.out.println("path : " + path);
        int index = path.indexOf("/target");
        path = path.substring(0, index);
        System.out.println("path : " + path);
        for(ItemType itemType : DbpiaItemTypes){
            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            //Workflow workflow = WorkflowFactory.getPredefinedWorkflow(3);
            // 이 라인부터는  문자열의 형태소 분리를 통해 명사를 추출하고 명사에 대해서만 책검색을 하는 기능.
            Workflow workflow = new Workflow(path + "/");
            workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
            workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");
            try {
                workflow.activateWorkflow(true);
                String e = edit;
                workflow.analyze(e);
                LinkedList resultList = workflow.getResultOfDocument(new Sentence(0, 0, false));
                Iterator var5 = resultList.iterator();

                Sentence s;
                Eojeol[] eojeolArray;
                int i;
                String[] morphemes;
                int j;
                while(var5.hasNext()) {
                    s = (Sentence)var5.next();
                    eojeolArray = s.getEojeols();

                    for(i = 0; i < eojeolArray.length; ++i) {
                        if(eojeolArray[i].length > 0) {
                            morphemes = eojeolArray[i].getMorphemes();
                            for(j = 0; j < morphemes.length; ++j) {
                                System.out.print("검색어 : " + morphemes[j]);
                                System.out.println();
                                //2글자 이상 검색
                                if(morphemes[j].length() > 2) {
                                    naverItemTypes = naverController.getNaver(morphemes[j]);
                                    for (koreatech.cse.domain.naver.ItemType itemType1 : naverItemTypes) {
                                        if (itemType1.getLink() == null || itemType1.getPrice() == null) {
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
                                    System.out.println();

                                }
                            }
                        }
                    }
                }

                System.out.println();
                workflow.close();
            } catch (Exception var10) {
                var10.printStackTrace();
                System.exit(0);
            }

            workflow.close();

		/* Shutdown the work flow */
            workflow.close();
        }
       return "total";
   }
}
