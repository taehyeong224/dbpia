package koreatech.cse.repository;



/**
 * Created by kth on 2015-12-03.
 */
public class Random {

    public String getRandomString()
    {
        StringBuffer buffer = new StringBuffer();
        java.util.Random rnd = new java.util.Random();
        StringBuffer buf =new StringBuffer();

        for(int i=0;i<20;i++){
            if(rnd.nextBoolean()){
                buf.append((char)((int)(rnd.nextInt(26))+97));
            }else{
                buf.append((rnd.nextInt(10)));
            }
        }
        return String.valueOf(buf);
    }
}
