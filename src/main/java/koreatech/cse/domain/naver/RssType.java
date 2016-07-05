package koreatech.cse.domain.naver;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import koreatech.cse.domain.naver.ChannelType;

@XmlAccessorType(value=XmlAccessType.FIELD)
@XmlType(name="rssType", propOrder={"channel"})
public class RssType {
    @XmlElement(required=true)
    protected ChannelType channel;
    @XmlAttribute(name="version")
    protected String version;

    public ChannelType getChannel() {
        return this.channel;
    }

    public void setChannel(ChannelType value) {
        this.channel = value;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String value) {
        this.version = value;
    }
}