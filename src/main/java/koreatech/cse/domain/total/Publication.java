package koreatech.cse.domain.total;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Publication {
    private String issn;
    private String url;
    private String name;

    @Override
    public String toString() {
        return "Publication{" +
                "issn='" + issn + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Publication(String issn, String url, String name) {
        this.issn = issn;
        this.url = url;
        this.name = name;
    }

    public Publication() {
        this.issn = null;
        this.url = null;
        this.name = null;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
