package koreatech.cse.domain.total;

public class Publisher {
    private String url;
    private String name;

    public String toString() {
        return "Publisher{url='" + this.url + '\'' + ", name='" + this.name + '\'' + '}';
    }

    public String getUrl() {
        return this.url;
    }

    public Publisher(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Publisher() {
        this.url = null;
        this.name = null;
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