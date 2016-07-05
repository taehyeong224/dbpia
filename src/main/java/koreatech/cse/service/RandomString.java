package koreatech.cse.service;

import java.util.Random;

public class RandomString {
    public String getRandom() {
        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 20; ++i) {
            if (rnd.nextBoolean()) {
                buf.append((char)(rnd.nextInt(26) + 97));
                continue;
            }
            buf.append(rnd.nextInt(10));
        }
        return buf.toString();
    }
}