package io.piano.stackowerflow.model.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import javax.annotation.Generated;
import java.util.List;

@Builder
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("is_answered")
    private Boolean isAnswered;
    @JsonProperty("view_count")
    private Integer viewCount;
    @JsonProperty("answer_count")
    private Integer answerCount;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("last_activity_date")
    private Integer lastActivityDate;
    @JsonProperty("creation_date")
    private Integer creationDate;
    @JsonProperty("last_edit_date")
    private Integer lastEditDate;
    @JsonProperty("question_id")
    private Integer questionId;
    @JsonProperty("content_license")
    private String contentLicense;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;
    @JsonProperty("accepted_answer_id")
    private Integer acceptedAnswerId;
    @JsonProperty("closed_date")
    private Integer closedDate;
    @JsonProperty("closed_reason")
    private String closedReason;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAnswered() {
        return isAnswered;
    }

    public void setIsAnswered(Boolean isAnswered) {
        this.isAnswered = isAnswered;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getContentLicense() {
        return contentLicense;
    }

    public void setContentLicense(String contentLicense) {
        this.contentLicense = contentLicense;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Integer getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Integer closedDate) {
        this.closedDate = closedDate;
    }

    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
    }

}
