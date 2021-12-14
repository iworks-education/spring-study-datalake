package br.com.iwe.springstudydatalake.resource;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudyResource {

    private LocalDateTime dateTimeCreation;
    private String topic;
    private String tag;
    private String url;
    private String description;
    private Boolean consumed;

    public StudyResource(@JsonProperty("dateTimeCreation") LocalDateTime dateTimeCreation,
                         @JsonProperty("topic") String topic,
                         @JsonProperty("tag") String tag,
                         @JsonProperty("url") String url,
                         @JsonProperty("description") String description,
                         @JsonProperty("consumed") Boolean consumed) {

        this.dateTimeCreation = dateTimeCreation;
        this.topic = topic;
        this.tag = tag;
        this.url = url;
        this.description = description;
        this.consumed = consumed;
    }

    public StudyResource() {

    }

    public LocalDateTime getDateTimeCreation() {
        return dateTimeCreation;
    }

    public void setDateTimeCreation(LocalDateTime dateTimeCreation) {
        this.dateTimeCreation = dateTimeCreation;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getConsumed() {
        return consumed;
    }

    public void setConsumed(Boolean consumed) {
        this.consumed = consumed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {

        private String topic;
        private String tag;
        private String url;
        private String description;
        private Boolean consumed;
        private LocalDateTime dateTimeCreation;

        public Builder topic(String topic) {
            this.topic = topic;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder consumed(Boolean consumed) {
            this.consumed = consumed;
            return this;
        }

        public Builder dateTimeCreation(LocalDateTime dateTimeCreation) {
            this.dateTimeCreation = dateTimeCreation;
            return this;
        }

        public StudyResource build() {
            return new StudyResource(dateTimeCreation, topic, tag, url, description, consumed);
        }
    }
}

