package koreatech.cse.domain.google;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "resultCount",
        "pages",
        "estimatedResultCount",
        "currentPageIndex",
        "moreResultsUrl",
        "searchResultTime"
})
public class Cursor {

    @JsonProperty("resultCount")
    private String resultCount;
    @JsonProperty("pages")
    private List<Page> pages = new ArrayList<Page>();
    @JsonProperty("estimatedResultCount")
    private String estimatedResultCount;
    @JsonProperty("currentPageIndex")
    private Integer currentPageIndex;
    @JsonProperty("moreResultsUrl")
    private String moreResultsUrl;
    @JsonProperty("searchResultTime")
    private String searchResultTime;

    /**
     *
     * @return
     * The resultCount
     */
    @JsonProperty("resultCount")
    public String getResultCount() {
        return resultCount;
    }

    /**
     *
     * @param resultCount
     * The resultCount
     */
    @JsonProperty("resultCount")
    public void setResultCount(String resultCount) {
        this.resultCount = resultCount;
    }

    /**
     *
     * @return
     * The pages
     */
    @JsonProperty("pages")
    public List<Page> getPages() {
        return pages;
    }

    /**
     *
     * @param pages
     * The pages
     */
    @JsonProperty("pages")
    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     * The estimatedResultCount
     */
    @JsonProperty("estimatedResultCount")
    public String getEstimatedResultCount() {
        return estimatedResultCount;
    }

    /**
     *
     * @param estimatedResultCount
     * The estimatedResultCount
     */
    @JsonProperty("estimatedResultCount")
    public void setEstimatedResultCount(String estimatedResultCount) {
        this.estimatedResultCount = estimatedResultCount;
    }

    /**
     *
     * @return
     * The currentPageIndex
     */
    @JsonProperty("currentPageIndex")
    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    /**
     *
     * @param currentPageIndex
     * The currentPageIndex
     */
    @JsonProperty("currentPageIndex")
    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    /**
     *
     * @return
     * The moreResultsUrl
     */
    @JsonProperty("moreResultsUrl")
    public String getMoreResultsUrl() {
        return moreResultsUrl;
    }

    /**
     *
     * @param moreResultsUrl
     * The moreResultsUrl
     */
    @JsonProperty("moreResultsUrl")
    public void setMoreResultsUrl(String moreResultsUrl) {
        this.moreResultsUrl = moreResultsUrl;
    }

    /**
     *
     * @return
     * The searchResultTime
     */
    @JsonProperty("searchResultTime")
    public String getSearchResultTime() {
        return searchResultTime;
    }

    /**
     *
     * @param searchResultTime
     * The searchResultTime
     */
    @JsonProperty("searchResultTime")
    public void setSearchResultTime(String searchResultTime) {
        this.searchResultTime = searchResultTime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}