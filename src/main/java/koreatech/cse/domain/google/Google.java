package koreatech.cse.domain.google;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "responseData",
        "responseDetails",
        "responseStatus"
})
public class Google {

    @JsonProperty("responseData")
    private ResponseData responseData;
    @JsonProperty("responseDetails")
    private Object responseDetails;
    @JsonProperty("responseStatus")
    private Integer responseStatus;

    /**
     *
     * @return
     * The responseData
     */
    @JsonProperty("responseData")
    public ResponseData getResponseData() {
        return responseData;
    }

    /**
     *
     * @param responseData
     * The responseData
     */
    @JsonProperty("responseData")
    public void setResponseData(ResponseData responseData) {
        this.responseData = responseData;
    }

    /**
     *
     * @return
     * The responseDetails
     */
    @JsonProperty("responseDetails")
    public Object getResponseDetails() {
        return responseDetails;
    }

    /**
     *
     * @param responseDetails
     * The responseDetails
     */
    @JsonProperty("responseDetails")
    public void setResponseDetails(Object responseDetails) {
        this.responseDetails = responseDetails;
    }

    /**
     *
     * @return
     * The responseStatus
     */
    @JsonProperty("responseStatus")
    public Integer getResponseStatus() {
        return responseStatus;
    }

    /**
     *
     * @param responseStatus
     * The responseStatus
     */
    @JsonProperty("responseStatus")
    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}