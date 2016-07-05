package koreatech.cse.domain.total;

import koreatech.cse.domain.total.Result;

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
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String toString() {
        return "Total{keyword='" + this.keyword + '\'' + ", result=" + this.result + '}';
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}