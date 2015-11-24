package koreatech.cse.domain.google;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "start",
        "label"
})
public class Page {

    @JsonProperty("start")
    private String start;
    @JsonProperty("label")
    private Integer label;

    /**
     *
     * @return
     * The start
     */
    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    /**
     *
     * @param start
     * The start
     */
    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    /**
     *
     * @return
     * The label
     */
    @JsonProperty("label")
    public Integer getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    @JsonProperty("label")
    public void setLabel(Integer label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}