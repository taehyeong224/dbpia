
package koreatech.cse.domain.dbpia;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>rootType complex type에 대한 Java 클래스입니다.
 * 
 * <p>다음 스키마 단편이 이 클래스에 포함되는 필요한 콘텐츠를 지정합니다.
 * 
 * <pre>
 * &lt;complexType name="rootType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paramdata" type="{}paramdataType"/>
 *         &lt;element name="result" type="{}resultType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rootType", propOrder = {
    "paramdata",
    "result"
})
public class RootType {

    @XmlElement(required = true)
    protected ParamdataType paramdata;
    @XmlElement(required = true)
    protected ResultType result;

    /**
     * paramdata 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ParamdataType }
     *     
     */
    public ParamdataType getParamdata() {
        return paramdata;
    }

    /**
     * paramdata 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ParamdataType }
     *     
     */
    public void setParamdata(ParamdataType value) {
        this.paramdata = value;
    }

    /**
     * result 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link ResultType }
     *     
     */
    public ResultType getResult() {
        return result;
    }

    /**
     * result 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *     
     */
    public void setResult(ResultType value) {
        this.result = value;
    }

    @Override
    public String toString() {
        return "RootType{" +
                "paramdata=" + paramdata +
                ", result=" + result +
                '}';
    }
}
