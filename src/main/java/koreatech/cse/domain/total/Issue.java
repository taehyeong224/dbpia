package koreatech.cse.domain.total;

public class Issue {
    private String name;
    private String num;
    private String yymm;

    public Issue(String name, String num, String yymm) {
        this.name = name;
        this.num = num;
        this.yymm = yymm;
    }

    public Issue() {
        this.name = null;
        this.num = null;
        this.yymm = null;
    }

    public String toString() {
        return "Issue{name='" + this.name + '\'' + ", num='" + this.num + '\'' + ", yymm='" + this.yymm + '\'' + '}';
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getYymm() {
        return this.yymm;
    }

    public void setYymm(String yymm) {
        this.yymm = yymm;
    }
}