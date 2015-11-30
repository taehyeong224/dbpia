package koreatech.cse.domain.total;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Total {
    private String keyword;
    private Result result;

    public Total(String keyword, Result result) {
        this.keyword = keyword;
        this.result = result;
    }

    public Total() {
        this.keyword = null;
        this.result = null;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Total{" +
                "keyword='" + keyword + '\'' +
                ", result=" + result +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
