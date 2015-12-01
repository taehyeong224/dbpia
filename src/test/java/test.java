
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        {"file:src/main/resources/common/services.xml",
                "file:src/main/resources/common/security.xml",
                "file:src/main/resources/common/mybatis.xml"}
)
public class test {

    @Value("${datapath}")
    String datapath;

    @Test
    public void mvcTest() throws Exception {
        System.out.println(datapath);
        Komoran komoran = new Komoran(datapath);
        List<List<Pair<String,String>>> result = komoran.analyze("안녕하세요? 좋은 아침입니다.");
        for (List<Pair<String, String>> eojeolResult : result) {
            for (Pair<String, String> wordMorph : eojeolResult) {
                System.out.println(wordMorph.getFirst());
            }
            System.out.println();
        }

    }

}