package koreatech.cse.domain.total;

public class Publication {
    private String issn;
    private String url;
    private String name;

    public String toString() {
        return "Publication{issn='" + this.issn + '\'' + ", url='" + this.url + '\'' + ", name='" + this.name + '\'' + '}';
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
        return this.issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}