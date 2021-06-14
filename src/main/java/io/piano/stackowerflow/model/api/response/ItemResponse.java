package io.piano.stackowerflow.model.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import javax.annotation.Generated;
import java.util.List;

@Builder
@Generated("jsonschema2pojo")
public class ItemResponse {

    @JsonProperty("items")
    private List<Item> items = null;
    @JsonProperty("has_more")
    private Boolean hasMore;
    @JsonProperty("quota_max")
    private Integer quotaMax;
    @JsonProperty("quota_remaining")
    private Integer quotaRemaining;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Integer getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Integer quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Integer getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Integer quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

}
