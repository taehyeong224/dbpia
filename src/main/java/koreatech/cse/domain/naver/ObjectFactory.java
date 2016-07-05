package koreatech.cse.domain.naver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import koreatech.cse.domain.naver.ChannelType;
import koreatech.cse.domain.naver.ItemType;
import koreatech.cse.domain.naver.RssType;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@XmlRegistry
public class ObjectFactory {
    private static final QName _Rss_QNAME = new QName("", "rss");

    public RssType createRssType() {
        return new RssType();
    }

    public ItemType createItemType() {
        return new ItemType();
    }

    public ChannelType createChannelType() {
        return new ChannelType();
    }

    @XmlElementDecl(namespace="", name="rss")
    public JAXBElement<RssType> createRss(RssType value) {
        return new JAXBElement<RssType>(_Rss_QNAME, RssType.class, null, value);
    }
}