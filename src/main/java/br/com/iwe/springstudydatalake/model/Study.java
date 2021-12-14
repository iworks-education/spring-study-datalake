package br.com.iwe.springstudydatalake.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime dateTimeCreation;
    private String topic;
    private String tag;
    private String url;
    private String description;
    private Boolean consumed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        private Long id;
        private String topic;
        private String tag;
        private String url;
        private String description;
        private Boolean consumed;
        private LocalDateTime dateTimeCreation;

        public Builder topic(Long id) {
            this.id = id;
            return this;
        }

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

        public Study build() {
            final Study study = new Study();
            study.id = id;
            study.dateTimeCreation = dateTimeCreation;
            study.consumed = this.consumed;
            study.description = this.description;
            study.tag = this.tag;
            study.topic = this.topic;
            study.url = this.url;
            return study;
        }
    }
}

