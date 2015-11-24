package koreatech.cse.domain.google;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "GsearchResultClass",
        "unescapedUrl",
        "url",
        "visibleUrl",
        "cacheUrl",
        "title",
        "titleNoFormatting",
        "content"
})
public class Result {

    @JsonProperty("GsearchResultClass")
    private String GsearchResultClass;
    @JsonProperty("unescapedUrl")
    private String unescapedUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("visibleUrl")
    private String visibleUrl;
    @JsonProperty("cacheUrl")
    private String cacheUrl;
    @JsonProperty("title")
    private String title;
    @JsonProperty("titleNoFormatting")
    private String titleNoFormatting;
    @JsonProperty("content")
    private String content;

    /**
     *
     * @return
     * The GsearchResultClass
     */
    @JsonProperty("GsearchResultClass")
    public String getGsearchResultClass() {
        return GsearchResultClass;
    }

    /**
     *
     * @param GsearchResultClass
     * The GsearchResultClass
     */
    @JsonProperty("GsearchResultClass")
    public void setGsearchResultClass(String GsearchResultClass) {
        this.GsearchResultClass = GsearchResultClass;
    }

    /**
     *
     * @return
     * The unescapedUrl
     */
    @JsonProperty("unescapedUrl")
    public String getUnescapedUrl() {
        return unescapedUrl;
    }

    /**
     *
     * @param unescapedUrl
     * The unescapedUrl
     */
    @JsonProperty("unescapedUrl")
    public void setUnescapedUrl(String unescapedUrl) {
        this.unescapedUrl = unescapedUrl;
    }

    /**
     *
     * @return
     * The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The visibleUrl
     */
    @JsonProperty("visibleUrl")
    public String getVisibleUrl() {
        return visibleUrl;
    }

    /**
     *
     * @param visibleUrl
     * The visibleUrl
     */
    @JsonProperty("visibleUrl")
    public void setVisibleUrl(String visibleUrl) {
        this.visibleUrl = visibleUrl;
    }

    /**
     *
     * @return
     * The cacheUrl
     */
    @JsonProperty("cacheUrl")
    public String getCacheUrl() {
        return cacheUrl;
    }

    /**
     *
     * @param cacheUrl
     * The cacheUrl
     */
    @JsonProperty("cacheUrl")
    public void setCacheUrl(String cacheUrl) {
        this.cacheUrl = cacheUrl;
    }

    /**
     *
     * @return
     * The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The titleNoFormatting
     */
    @JsonProperty("titleNoFormatting")
    public String getTitleNoFormatting() {
        return titleNoFormatting;
    }

    /**
     *
     * @param titleNoFormatting
     * The titleNoFormatting
     */
    @JsonProperty("titleNoFormatting")
    public void setTitleNoFormatting(String titleNoFormatting) {
        this.titleNoFormatting = titleNoFormatting;
    }

    /**
     *
     * @return
     * The content
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}