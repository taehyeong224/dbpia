
package koreatech.cse.domain.dbpia;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the koreatech.cse.domain.dbpia package.
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Root_QNAME = new QName("", "root");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: koreatech.cse.domain.dbpia
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RootType }
     * 
     */
    public RootType createRootType() {
        return new RootType();
    }

    /**
     * Create an instance of {@link IssueType }
     * 
     */
    public IssueType createIssueType() {
        return new IssueType();
    }

    /**
     * Create an instance of {@link PublisherType }
     * 
     */
    public PublisherType createPublisherType() {
        return new PublisherType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link ParamdataType }
     * 
     */
    public ParamdataType createParamdataType() {
        return new ParamdataType();
    }

    /**
     * Create an instance of {@link AuthorType }
     * 
     */
    public AuthorType createAuthorType() {
        return new AuthorType();
    }

    /**
     * Create an instance of {@link ItemsType }
     * 
     */
    public ItemsType createItemsType() {
        return new ItemsType();
    }

    /**
     * Create an instance of {@link PublicationType }
     * 
     */
    public PublicationType createPublicationType() {
        return new PublicationType();
    }

    /**
     * Create an instance of {@link KeywordType }
     * 
     */
    public KeywordType createKeywordType() {
        return new KeywordType();
    }

    /**
     * Create an instance of {@link ResultType }
     * 
     */
    public ResultType createResultType() {
        return new ResultType();
    }

    /**
     * Create an instance of {@link AuthorsType }
     * 
     */
    public AuthorsType createAuthorsType() {
        return new AuthorsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RootType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "root")
    public JAXBElement<RootType> createRoot(RootType value) {
        return new JAXBElement<RootType>(_Root_QNAME, RootType.class, null, value);
    }

}
