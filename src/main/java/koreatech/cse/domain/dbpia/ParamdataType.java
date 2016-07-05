
package koreatech.cse.domain.dbpia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>paramdataType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="paramdataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keyword" type="{}keywordType"/>
 *         &lt;element name="totalcount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pagecount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pagenumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paramdataType", propOrder = {
    "keyword",
    "totalcount",
    "pagecount",
    "pagenumber",
    "category",
    "sort",
    "order"
})
public class ParamdataType {

    @XmlElement(required = true)
    protected KeywordType keyword;
    @XmlElement(required = true)
    protected String totalcount;
    @XmlElement(required = true)
    protected String pagecount;
    @XmlElement(required = true)
    protected String pagenumber;
    @XmlElement(required = true)
    protected String category;

    @Override
    public String toString() {
        return "ParamdataType{" +
                "keyword=" + keyword +
                ", totalcount='" + totalcount + '\'' +
                ", pagecount='" + pagecount + '\'' +
                ", pagenumber='" + pagenumber + '\'' +
                ", category='" + category + '\'' +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    @XmlElement(required = true)
    protected String sort;
    @XmlElement(required = true)
    protected String order;

    /**
     * keyword 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link KeywordType }
     *     
     */
    public KeywordType getKeyword() {
        return keyword;
    }

    /**
     * keyword 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link KeywordType }
     *     
     */
    public void setKeyword(KeywordType value) {
        this.keyword = value;
    }

    /**
     * totalcount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalcount() {
        return totalcount;
    }

    /**
     * totalcount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalcount(String value) {
        this.totalcount = value;
    }

    /**
     * pagecount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagecount() {
        return pagecount;
    }

    /**
     * pagecount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagecount(String value) {
        this.pagecount = value;
    }

    /**
     * pagenumber 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagenumber() {
        return pagenumber;
    }

    /**
     * pagenumber 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagenumber(String value) {
        this.pagenumber = value;
    }

    /**
     * category 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * category 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * sort 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSort() {
        return sort;
    }

    /**
     * sort 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSort(String value) {
        this.sort = value;
    }

    /**
     * order 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * order 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

}
