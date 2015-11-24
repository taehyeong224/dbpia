
package koreatech.cse.domain.dbpia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>publisherType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="publisherType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="url">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publisher/IPRD00010028"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publisher/IPRD00010898"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publisher/IPRD00010947"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publisher/IPRD00013925"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publisher/IPRD00010241"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publisher/IPRD00010074"/>
 *               &lt;enumeration value="http://www.dbpia.co.kr/Publisher/IPRD00010353"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="한국통신학회"/>
 *               &lt;enumeration value="한국니트디자인학회"/>
 *               &lt;enumeration value="한국의상디자인학회"/>
 *               &lt;enumeration value="한국정보통신학회"/>
 *               &lt;enumeration value="한국정보과학회"/>
 *               &lt;enumeration value="대한전자공학회"/>
 *               &lt;enumeration value="한국정보기술학회"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "publisherType", propOrder = {
    "url",
    "name"
})
public class PublisherType {

    @XmlElement(required = true)
    protected String url;
    @XmlElement(required = true)
    protected String name;

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

    @Override
    public String toString() {
        return "PublisherType{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
