package koreatech.cse.domain.google;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "results",
        "cursor"
})
public class ResponseData {

    @JsonProperty("results")
    private List<Result> results = new ArrayList<Result>();
    @JsonProperty("cursor")
    private Cursor cursor;

    /**
     *
     * @return
     * The results
     */
    @JsonProperty("results")
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    @JsonProperty("results")
    public void setResults(List<Result> results) {
        this.results = results;
    }

    /**
     *
     * @return
     * The cursor
     */
    @JsonProperty("cursor")
    public Cursor getCursor() {
        return cursor;
    }

    /**
     *
     * @param cursor
     * The cursor
     */
    @JsonProperty("cursor")
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }


    @Override
    public String toString() {
        return "ResponseData{" +
                "results=" + results +
                ", cursor=" + cursor +
                '}';
    }
}