package koreatech.cse.domain.naver;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@XmlAccessorType(value=XmlAccessType.FIELD)
@XmlType(name="channelType", propOrder={"title", "link", "description", "lastBuildDate", "total", "start", "display", "item"})
public class ChannelType {
    @XmlElement(required=true)
    protected String title;
    @XmlElement(required=true)
    protected String link;
    @XmlElement(required=true)
    protected String description;
    @XmlElement(required=true)
    protected String lastBuildDate;
    @XmlElement(required=true)
    protected String total;
    @XmlElement(required=true)
    protected String start;
    @XmlElement(required=true)
    protected String display;
    @JacksonXmlElementWrapper(useWrapping=false)
    protected List<ItemType> item;

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getLastBuildDate() {
        return this.lastBuildDate;
    }

    public void setLastBuildDate(String value) {
        this.lastBuildDate = value;
    }

    public String getTotal() {
        return this.total;
    }

    public void setTotal(String value) {
        this.total = value;
    }

    public String getStart() {
        return this.start;
    }

    public void setStart(String value) {
        this.start = value;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String value) {
        this.display = value;
    }

    @Override
    public String toString() {
        return "ChannelType{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", total='" + total + '\'' +
                ", start='" + start + '\'' +
                ", display='" + display + '\'' +
                ", item=" + item +
                '}';
    }

    public void setItem(List<ItemType> item) {
        this.item = item;
    }

    public List<ItemType> getItem() {
        if (this.item == null) {
            this.item = new ArrayList<>();
        }
        return this.item;
    }
}