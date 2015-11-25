import koreatech.cse.controller.StringSimilarity;
import koreatech.cse.controller.dbpia.DbpiaController;
import koreatech.cse.controller.naver.NaverController;
import koreatech.cse.domain.dbpia.ItemType;
import koreatech.cse.service.UserService;
import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        {"file:src/main/resources/common/services.xml",
                "file:src/main/resources/common/security.xml",
                "file:src/main/resources/common/mybatis.xml"}
)
public class JHanNanum {
    StringSimilarity stringSimilarity = new StringSimilarity();
    DbpiaController dbpiaController = new DbpiaController();
    NaverController naverController = new NaverController();

    List<koreatech.cse.domain.naver.ItemType> naverItemTypes;
    List<ItemType> DbpiaItemTypes;

    @Before
    public void setup() {}

    @Test
    public void mvcTest() {
        DbpiaItemTypes = dbpiaController.getDbpia("한연희");
        for(ItemType itemType : DbpiaItemTypes){
            String edit = itemType.getTitle().replaceAll("<[^>]*>", "");
            System.out.println("edit : " + edit);
            Workflow workflow = WorkflowFactory.getPredefinedWorkflow(3);

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
                                naverItemTypes= naverController.getNaver(morphemes[j]);
                                for(koreatech.cse.domain.naver.ItemType itemType1 : naverItemTypes){
                                    if(itemType1.getLink() == null || itemType1.getPrice() == null){
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
    }

}
