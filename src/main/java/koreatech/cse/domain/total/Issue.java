package koreatech.cse.domain.total;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Issue {

    private String name;
    private String num;
    private String yymm;

    public Issue() {
        this.name =  null;
        this.num = null;
        this.yymm = null;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", yymm='" + yymm + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getYymm() {
        return yymm;
    }

    public void setYymm(String yymm) {
        this.yymm = yymm;
    }
}
