
package koreatech.cse.domain.dbpia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>itemType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="itemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ctype" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="authors" type="{}authorsType"/>
 *         &lt;element name="publisher" type="{}publisherType"/>
 *         &lt;element name="publication" type="{}publicationType"/>
 *         &lt;element name="issue" type="{}issueType"/>
 *         &lt;element name="pages" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="free_yn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="preview_yn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="preview" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coverimg" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="link_url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="link_api" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemType", propOrder = {
    "ctype",
    "title",
    "authors",
    "publisher",
    "publication",
    "issue",
    "pages",
    "freeYn",
    "previewYn",
    "preview",
    "coverimg",
    "linkUrl",
    "linkApi"
})
public class ItemType {

    @XmlElement(required = true)
    protected String ctype;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected AuthorsType authors;
    @XmlElement(required = true)
    protected PublisherType publisher;
    @XmlElement(required = true)
    protected PublicationType publication;
    @XmlElement(required = true)
    protected IssueType issue;
    @XmlElement(required = true)
    protected String pages;
    @XmlElement(name = "free_yn", required = true)
    protected String freeYn;
    @XmlElement(name = "preview_yn", required = true)
    protected String previewYn;
    @XmlElement(required = true)
    protected String preview;
    @XmlElement(required = true)
    protected String coverimg;
    @XmlElement(name = "link_url", required = true)
    protected String linkUrl;
    @XmlElement(name = "link_api", required = true)
    protected String linkApi;

    /**
     * ctype 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtype() {
        return ctype;
    }

    /**
     * ctype 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtype(String value) {
        this.ctype = value;
    }

    /**
     * title 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * title 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * authors 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link AuthorsType }
     *     
     */
    public AuthorsType getAuthors() {
        return authors;
    }

    /**
     * authors 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorsType }
     *     
     */
    public void setAuthors(AuthorsType value) {
        this.authors = value;
    }

    /**
     * publisher 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PublisherType }
     *     
     */
    public PublisherType getPublisher() {
        return publisher;
    }

    /**
     * publisher 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PublisherType }
     *     
     */
    public void setPublisher(PublisherType value) {
        this.publisher = value;
    }

    /**
     * publication 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link PublicationType }
     *     
     */
    public PublicationType getPublication() {
        return publication;
    }

    /**
     * publication 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationType }
     *     
     */
    public void setPublication(PublicationType value) {
        this.publication = value;
    }

    /**
     * issue 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link IssueType }
     *     
     */
    public IssueType getIssue() {
        return issue;
    }

    /**
     * issue 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueType }
     *     
     */
    public void setIssue(IssueType value) {
        this.issue = value;
    }

    /**
     * pages 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPages() {
        return pages;
    }

    /**
     * pages 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPages(String value) {
        this.pages = value;
    }

    /**
     * freeYn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeYn() {
        return freeYn;
    }

    /**
     * freeYn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeYn(String value) {
        this.freeYn = value;
    }

    /**
     * previewYn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreviewYn() {
        return previewYn;
    }

    /**
     * previewYn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreviewYn(String value) {
        this.previewYn = value;
    }

    /**
     * preview 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreview() {
        return preview;
    }

    /**
     * preview 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreview(String value) {
        this.preview = value;
    }

    /**
     * coverimg 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverimg() {
        return coverimg;
    }

    /**
     * coverimg 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverimg(String value) {
        this.coverimg = value;
    }

    /**
     * linkUrl 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkUrl() {
        return linkUrl;
    }

    /**
     * linkUrl 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkUrl(String value) {
        this.linkUrl = value;
    }

    /**
     * linkApi 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkApi() {
        return linkApi;
    }

    /**
     * linkApi 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkApi(String value) {
        this.linkApi = value;
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "ctype='" + ctype + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", publisher=" + publisher +
                ", publication=" + publication +
                ", issue=" + issue +
                ", pages='" + pages + '\'' +
                ", freeYn='" + freeYn + '\'' +
                ", previewYn='" + previewYn + '\'' +
                ", preview='" + preview + '\'' +
                ", coverimg='" + coverimg + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", linkApi='" + linkApi + '\'' +
                '}';
    }
}
