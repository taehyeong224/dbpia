
package koreatech.cse.domain.naver;

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
 *         &lt;element name="title">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="G*Power와 &lt;b>Sample&lt;/b> Size (스포츠 의.과학 연구를 위한)"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 꼼짝도 하기 싫은 사람들을 위한 요가"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 모바일 트렌드 2015"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 개를 훔치는 완벽한 방법"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 푸른 수염"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 소년은 눈물 위를 달린다"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 플로팅 시티"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 셈을 할 줄 아는 까막눈이 여자"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 관계가 결과를 바꾼다"/>
 *               &lt;enumeration value="[&lt;b>samPle&lt;/b>] 공짜로 놀아주마"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="link">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="http://openapi.naver.com/l?AAABWLSwrCMBQAT/OyLM2naVxkkf5AwY14gSR9oVD7MUahnt44zGpgnm+Mh4a+BcWgaaE30FRgun8xNaiSpGNH7bZtJjMe2lMnSuk4G10GEavALJfj6GnudSBTxKCnlHbgBtiQfaGNfipW+8FY+G0hSVMhlOCypqeT5GTRy10NKP1VSn453+w3uWrA9ZHn4BTw7gcZL2dJpgAAAA=="/>
 *               &lt;enumeration value="http://openapi.naver.com/l?AAABXIuw6CMBSA4ac5HUlvFBg6lIuJDgYnZ9oeIAEEoUp4e/HPP33vD66HhqqAlENeQGUgj8GUfzEJpJSEY0Ft53kgAx7aMSupsoJ7e4aIccsbobx37PSkJf2Kre5DWEAY4JfzDZvV9dGr+eIauXkiQTMpUylUwrJMSTLpHSVF/7xTrItr19fjzpdbVz/GbANR/gDjRlExpAAAAA=="/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="image">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/089/547/08954739.jpg?type=m1&amp;udate=20150718"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501977.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501976.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501972.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501974.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501973.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501970.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501968.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501969.jpg?type=m1&amp;udate=20141129"/>
 *               &lt;enumeration value="http://bookthumb.phinf.naver.net/cover/085/019/08501978.jpg?type=m1&amp;udate=20141129"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="author">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="남상석"/>
 *               &lt;enumeration value="제프 다이어"/>
 *               &lt;enumeration value="커넥팅랩"/>
 *               &lt;enumeration value="바바라 오코너"/>
 *               &lt;enumeration value="아멜리 노통브"/>
 *               &lt;enumeration value="팀 보울러"/>
 *               &lt;enumeration value="수디르 벤카테시"/>
 *               &lt;enumeration value="요나스 요나손"/>
 *               &lt;enumeration value="앤드루 소벨"/>
 *               &lt;enumeration value="고정욱"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="price">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="15000"/>
 *               &lt;enumeration value="1000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="discount">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="13500"/>
 *               &lt;enumeration value=""/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="publisher">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="한나래"/>
 *               &lt;enumeration value="웅진지식하우스"/>
 *               &lt;enumeration value="미래의창"/>
 *               &lt;enumeration value="다산북스"/>
 *               &lt;enumeration value="열린책들"/>
 *               &lt;enumeration value="어크로스"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="pubdate">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="20150420"/>
 *               &lt;enumeration value="20141110"/>
 *               &lt;enumeration value="20141030"/>
 *               &lt;enumeration value="20140915"/>
 *               &lt;enumeration value="20140812"/>
 *               &lt;enumeration value="20140718"/>
 *               &lt;enumeration value="20140710"/>
 *               &lt;enumeration value="20141031"/>
 *               &lt;enumeration value="20141028"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="isbn">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="8955661819 9788955661811"/>
 *               &lt;enumeration value="480D141103950 480D141103950"/>
 *               &lt;enumeration value="480D141103040 480D141103040"/>
 *               &lt;enumeration value="480D141103030 480D141103030"/>
 *               &lt;enumeration value="480D141103010 480D141103010"/>
 *               &lt;enumeration value="480D141103020 480D141103020"/>
 *               &lt;enumeration value="480D141102980 480D141102980"/>
 *               &lt;enumeration value="480D141103000 480D141103000"/>
 *               &lt;enumeration value="480D141102990 480D141102990"/>
 *               &lt;enumeration value="480D141103940 480D141103940"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="description">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="『G POWER와 &lt;b>SAMPLE&lt;/b> SIZE』는  연구자들이나 대학원생들이 G*POWER를 이용하여 쉽게 최적의 표본크기를 산출할 수 있도록 안내한다."/>
 *               &lt;enumeration value="현대문명의 폐허를 보며, 자신의 내면을 들여다보다! 《파리 리뷰》가 반했으며, 알랭 드 보통, 무라카미 하루키가 극찬한 논픽션 글쓰기의 대가 제프 다이어의의 에세이『꼼짝도 하기 싫은 사람들을 위한 요가』. 꿈도 방향도 없고, 심지어 그것에 대해 아무렇지도 않게 생각했던 저자는 어느날 자신의 상태가... "/>
 *               &lt;enumeration value="2015년 모바일 핵심 키워드를 잡아라! 스마트폰의 확산으로 모바일 시장이 성장하면서 IT 산업과 비즈니스 세계를 뒤흔들고 있다. 온ㆍ오프라인 경계가 무너지고 새로운 융합이 일어나고 있다. 이러한 변화의 연장선상에서 2015년 모바일 트렌드의 화두는 옴니채널과 O2O이다. 즉, 옴니채널(Omni... "/>
 *               &lt;enumeration value="패런츠 초이스 어워드, ALA 노터블 어워드 등 열네 개에 해당하는 문학상, 협회 선정작 등 각종 부문에 노미네이트 되는 쾌거를 이룬 바바라 오코너의 첫 국내출간 소설 『개를 훔치는 완벽한 방법』. 아빠는 도망가고, 집은 사라지고, 한순간에 길거리로 나앉게 된 주인공 소녀와 엄마, 동생의 고군분투기를 그린... "/>
 *               &lt;enumeration value="아멜리 노통브의 손끝에서 다시 태어난 《푸른 수염》! 아멜리 노통브의 소설 『푸른 수염』. 샤를 페로의 잔혹동화 《푸른 수염》을 재해석한 작품으로 저자의 특유의 빈틈없는 문체가 빛을 발한다. 저자는 자신이 가장 좋아하는 동화《푸른 수염》의 주인공을 황금과 중세 사상에 사로잡힌 한 에스파냐 귀족... "/>
 *               &lt;enumeration value="가족의 운명을 짊어진 채 위험천만한 밤거리를 달리는 한 소년의 이야기! 가족의 운명을 짊어진 채 위험천만한 밤거리를 달리는 한 소년의 이야기! 가족의 운명을 짊어진 채 위험천만한 밤거리를 달리는 한 소년의 이야기! 《리버보이》의 저자 팀 보울러의 소설 『소년은 눈물 위를 달린다』. 가족에 대한 애증을... "/>
 *               &lt;enumeration value="세계자본주의의 중심 뉴욕 지하경제에서 새로운 사회학을 목격하다! 경계를 넘나드는 사람들의 모습과 새로운 사회학『플로팅 시티』. 이 책은 《괴짜 사회학》의 저자 수디르 벤카테시가 뉴욕의 지하경제 종사자들을 동행하며 그들의 생활상을 기록하고 새로운 양상을 그려낸 것이다. 저자는 뉴욕에서 새롭게... "/>
 *               &lt;enumeration value="비천한 태생이었지만 두뇌만은 비범했던 여인 놈베코가 세상을 구한다! 비천한 태생이었지만 두뇌만은 비범했던 여인 놈베코가 세상을 구한다! 《창문 넘어 도망친 100세 노인》의 저자 요나스 요나손의 신작 『셈을 할 줄 아는 까막눈이 여자』. 스웨덴과 남아공을 배경으로 100세 노인의 삶보다 더... "/>
 *               &lt;enumeration value="『관계가 결과를 바꾼다』는 저자들이 30년간의 현장 경험에서 체득한 생생한 경험담과 수백 명의 명사들의 인터뷰를 통해 확인한 인간관계 불변의 법칙 26가지를 소개한다. 고객 관계에서 최고의 우정까지, 사람을 남기고 결과를 바꾸는 관계의 비밀을 탐사한 이 책은 인간관계의 기쁨과 어려움을 다루는 가슴... "/>
 *               &lt;enumeration value="고정욱 장편소설 『공짜로 놀아주마』. 한길로 우직하게 살아온 원길은 어머니의 죽음이라는 엄청난 단절과 절망 앞에서 희망을 되찾으려 노력한다. 그 희망을 찾는 과정에서 발견한 것이 바로 ‘공짜로 놀아준다’는 것. 그러나 고요한 놀이터를 아이들의 함성으로 채우려는 원길의 구상은 의외로 쉽게... "/>
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
@XmlType(name = "itemType", propOrder = {
    "title",
    "link",
    "image",
    "author",
    "price",
    "discount",
    "publisher",
    "pubdate",
    "isbn",
    "description"
})
public class ItemType {

    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String link;
    @XmlElement(required = true)
    protected String image;
    @XmlElement(required = true)
    protected String author;
    @XmlElement(required = true)
    protected String price;
    @XmlElement(required = true)
    protected String discount;
    @XmlElement(required = true)
    protected String publisher;
    @XmlElement(required = true)
    protected String pubdate;
    @XmlElement(required = true)
    protected String isbn;
    @XmlElement(required = true)
    protected String description;

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
     * link 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * link 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * image 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * image 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * author 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * author 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * price 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrice() {
        return price;
    }

    /**
     * price 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * discount 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * discount 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscount(String value) {
        this.discount = value;
    }

    /**
     * publisher 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * publisher 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisher(String value) {
        this.publisher = value;
    }

    /**
     * pubdate 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPubdate() {
        return pubdate;
    }

    /**
     * pubdate 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPubdate(String value) {
        this.pubdate = value;
    }

    /**
     * isbn 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * isbn 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn(String value) {
        this.isbn = value;
    }

    /**
     * description 속성의 값을 가져옵니다.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * description 속성의 값을 설정합니다.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
