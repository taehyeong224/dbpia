package koreatech.cse.domain.total;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Publisher {
    private String url;
    private String name;

    @Override
    public String toString() {
        return "Publisher{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}