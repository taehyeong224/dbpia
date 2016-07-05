
package koreatech.cse.domain.dbpia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>publicationType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="publicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00000243"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00001707"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00001768"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00000242"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00002408"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00000749"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00000489"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00000552"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publication/PLCT00000958"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="한국통신학회논문지"/>
 *               &lt;enumeration value="패션과 니트"/>
 *               &lt;enumeration value="한국의상디자인학회지"/>
 *               &lt;enumeration value="한국통신학회지(정보와통신)"/>
 *               &lt;enumeration value="한국정보통신학회논문지"/>
 *               &lt;enumeration value="정보과학회지"/>
 *               &lt;enumeration value="한국통신학회 학술대회논문집"/>
 *               &lt;enumeration value="대한전자공학회 학술대회"/>
 *               &lt;enumeration value="한국정보기술학회논문지"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="issn">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="1226-4717"/>
 *               &lt;enumeration value="1738-1177"/>
 *               &lt;enumeration value="1229-7240"/>
 *               &lt;enumeration value="1226-4725"/>
 *               &lt;enumeration value="2234-4772"/>
 *               &lt;enumeration value="1229-6821"/>
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="1598-8619"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="isbn10" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isbn13" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publicationType", propOrder = {
    "url",
    "name",
    "issn",
    "isbn10",
    "isbn13"
})
public class PublicationType {

    @XmlElement(required = true)
    protected String url;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String issn;
    @XmlElement(required = true)
    protected String isbn10;
    @XmlElement(required = true)
    protected String isbn13;

    /**
     * url 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * url 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * name 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * name 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * issn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssn() {
        return issn;
    }

    /**
     * issn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssn(String value) {
        this.issn = value;
    }

    /**
     * isbn10 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn10() {
        return isbn10;
    }

    /**
     * isbn10 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn10(String value) {
        this.isbn10 = value;
    }

    /**
     * isbn13 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * isbn13 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn13(String value) {
        this.isbn13 = value;
    }

    @Override
    public String toString() {
        return "PublicationType{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", issn='" + issn + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                '}';
    }
}
