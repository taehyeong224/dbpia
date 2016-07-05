package koreatech.cse.domain.naver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(value=XmlAccessType.FIELD)
@XmlType(name="itemType", propOrder={"title", "link", "image", "author", "price", "discount", "publisher", "pubdate", "isbn", "description"})
public class ItemType {
    @XmlElement(required=true)
    protected String title;
    @XmlElement(required=true)
    protected String link;
    @XmlElement(required=true)
    protected String image;
    @XmlElement(required=true)
    protected String author;
    @XmlElement(required=true)
    protected String price;
    @XmlElement(required=true)
    protected String discount;
    @XmlElement(required=true)
    protected String publisher;
    @XmlElement(required=true)
    protected String pubdate;
    @XmlElement(required=true)
    protected String isbn;
    @XmlElement(required=true)
    protected String description;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String value) {
        this.link = value;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String value) {
        this.image = value;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String value) {
        this.author = value;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String value) {
        this.price = value;
    }

    public String getDiscount() {
        return this.discount;
    }

    public void setDiscount(String value) {
        this.discount = value;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String value) {
        this.publisher = value;
    }

    public String getPubdate() {
        return this.pubdate;
    }

    public void setPubdate(String value) {
        this.pubdate = value;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String value) {
        this.isbn = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }
}