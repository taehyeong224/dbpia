import koreatech.cse.controller.StringSimilarity;
import koreatech.cse.controller.dbpia.DbpiaController;
import koreatech.cse.controller.naver.NaverController;
import koreatech.cse.domain.dbpia.ItemType;
import koreatech.cse.service.UserService;
import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.MorphAnalyzer.ChartMorphAnalyzer.ChartMorphAnalyzer;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.PosTagger.HmmPosTagger.HMMTagger;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.MorphemeProcessor.UnknownMorphProcessor.UnknownProcessor;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PlainTextProcessor.InformalSentenceFilter.InformalSentenceFilter;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PlainTextProcessor.SentenceSegmentor.SentenceSegmentor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    public void test(){
        Workflow workflow = new Workflow();

        try {
			/* Setting up the work flow */
			/* Phase1. Supplement Plug-in for analyzing the plain text */
            workflow.appendPlainTextProcessor(new SentenceSegmentor(), null);
            workflow.appendPlainTextProcessor(new InformalSentenceFilter(), null);

			/* Phase2. Morphological Analyzer Plug-in and Supplement Plug-in for post processing */
            workflow.setMorphAnalyzer(new ChartMorphAnalyzer(), "conf/plugin/MajorPlugin/MorphAnalyzer/ChartMorphAnalyzer.json");
            workflow.appendMorphemeProcessor(new UnknownProcessor(), null);

			/*
			 * For simpler morphological analysis result with 22 tags, decomment the following line.
			 * Notice: If you use SimpleMAResult22 plug-in, POSTagger will not work correctly.
			 *         So don't add phase3 plug-ins after SimpleMAResult22.
			 */
//			workflow.appendMorphemeProcessor(new SimpleMAResult22(), null);

			/*
			 * For simpler morphological analysis result with 9 tags, decomment the following line.
			 * Notice: If you use SimpleMAResult09 plug-in, POSTagger will not work correctly.
			 *         So don't add phase3 plug-ins after SimpleMAResult09.
			 */
//			workflow.appendMorphemeProcessor(new SimpleMAResult09(), null);

			/* Phase3. Part Of Speech Tagger Plug-in and Supplement Plug-in for post processing */
            workflow.setPosTagger(new HMMTagger(), "conf/plugin/MajorPlugin/PosTagger/HmmPosTagger.json");

			/* For extracting nouns only, decomment the following line. */
//			workflow.appendPosProcessor(new NounExtractor(), null);

			/* For simpler POS tagging result with 22 tags, decomment the following line. */
//			workflow.appendPosProcessor(new SimplePOSResult22(), null);

			/* For simpler POS tagging result with 9 tags, decomment the following line. */
//			workflow.appendPosProcessor(new SimplePOSResult09(), null);

			/* Activate the work flow in the thread mode */
            workflow.activateWorkflow(true);

			/* Analysis using the work flow */
            String document = "한나눔 형태소 분석기는 KLDP에서 제공하는 공개 소프트웨어 프로젝트 사이트에 등록되어 있다.";

            workflow.analyze(document);
            System.out.println("document : " + workflow.getResultOfDocument());

			/* Once a work flow is activated, it can be used repeatedly. */
            document = "日時: 2010년 7월 30일 오후 1시\n"
                    + "場所: Coex Conference Room\n";

            workflow.analyze(document);
            System.out.println(workflow.getResultOfDocument());

			/* Close the work flow */
            workflow.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

		/* Shutdown the workflow */
        workflow.close();
    }

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
