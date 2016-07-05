package koreatech.cse.domain.total;

public class Author {
    private String order;
    private String name;
    private String url;

    public Author(String order, String name, String url) {
        this.order = order;
        this.name = name;
        this.url = url;
    }

    public Author(String order) {
        this.order = order;
    }

    public Author() {
        this.order = null;
        this.name = null;
        this.url = null;
    }

    public String toString() {
        return "Author{order='" + this.order + '\'' + ", name='" + this.name + '\'' + ", url='" + this.url + '\'' + '}';
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}