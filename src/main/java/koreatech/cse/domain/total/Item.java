package koreatech.cse.domain.total;

/**
 * Created by kth on 2015. 11. 30..
 */
public class Item {
    private String ctype;
    private String title;
    private Authors authors;
    private String pages;
    private String preview;
    private String link_url;
    private String link_api;
    private Publisher publisher;
    private Publication publication;
    private Books books;

    public Item(String ctype, String title, Authors authors, String pages, String preview, String link_url, String link_api, Publisher publisher, Publication publication, Books books) {
        this.ctype = ctype;
        this.title = title;
        this.authors = authors;
        this.pages = pages;
        this.preview = preview;
        this.link_url = link_url;
        this.link_api = link_api;
        this.publisher = publisher;
        this.publication = publication;
        this.books = books;
    }

    public Item() {
        this.ctype = null;
        this.title = null;
        this.authors = null;
        this.pages = null;
        this.preview = null;
        this.link_url = null;
        this.link_api = null;
        this.publisher = null;
        this.publication = null;
        this.books = null;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ctype='" + ctype + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", pages='" + pages + '\'' +
                ", preview='" + preview + '\'' +
                ", link_url='" + link_url + '\'' +
                ", link_api='" + link_api + '\'' +
                ", publisher=" + publisher +
                ", publication=" + publication +
                ", books=" + books +
                '}';
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getLink_url() {
        return link_url;
    }

    public void setLink_url(String link_url) {
        this.link_url = link_url;
    }

    public String getLink_api() {
        return link_api;
    }

    public void setLink_api(String link_api) {
        this.link_api = link_api;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public String getCtype() {

        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }
}
