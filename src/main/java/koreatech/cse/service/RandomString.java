package koreatech.cse.service;

import java.util.Random;

/**
 * Created by kth on 2015. 12. 3..
 */
public class RandomString {

    public String getRandom(){
        Random rnd = new Random();
        StringBuffer buf =new StringBuffer();
        for(int i=0;i<20;i++){
            if(rnd.nextBoolean()){
                buf.append((char)((int)(rnd.nextInt(26))+97));
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }
        return buf.toString();
    }
}
