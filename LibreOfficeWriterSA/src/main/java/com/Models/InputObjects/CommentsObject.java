package com.Models.InputObjects;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class CommentsObject {
    //-----------------------------------com.Models.InputObjects.Bugs.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Bugs implements Serializable
    {


        private com.Models.InputObjects.CommentsObject.BugComments bugComments;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -2477017487248744751L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Bugs() {
        }

        /**
         *
         * @param bugComments
         */
        public Bugs(com.Models.InputObjects.CommentsObject.BugComments bugComments) {
            super();
            this.bugComments = bugComments;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        public BugComments getBugComments() {
            return bugComments;
        }

        public void setBugComments(BugComments bugComments) {
            this.bugComments = bugComments;
        }
    }
    //-----------------------------------com.Models.InputObjects.Comment.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "attachment_id",
            "bug_id",
            "count",
            "creation_time",
            "creator",
            "id",
            "is_private",
            "tags",
            "text",
            "time"
    })
    public static class Comment implements Serializable
    {

        @JsonProperty("attachment_id")
        private Object attachmentId;
        @JsonProperty("bug_id")
        private Integer bugId;
        @JsonProperty("count")
        private Integer count;
        @JsonProperty("creation_time")
        private String creationTime;
        @JsonProperty("creator")
        private String creator;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("is_private")
        private Boolean isPrivate;
        @JsonProperty("tags")
        private List<String> tags = null;
        @JsonProperty("text")
        private String text;
        @JsonProperty("time")
        private String time;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -3076488330270861125L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Comment() {
        }

        /**
         *
         * @param creator
         * @param bugId
         * @param creationTime
         * @param count
         * @param attachmentId
         * @param id
         * @param isPrivate
         * @param text
         * @param time
         * @param tags
         */
        public Comment(Object attachmentId, Integer bugId, Integer count, String creationTime, String creator, Integer id, Boolean isPrivate, List<String> tags, String text, String time) {
            super();
            this.attachmentId = attachmentId;
            this.bugId = bugId;
            this.count = count;
            this.creationTime = creationTime;
            this.creator = creator;
            this.id = id;
            this.isPrivate = isPrivate;
            this.tags = tags;
            this.text = text;
            this.time = time;
        }

        @JsonProperty("attachment_id")
        public Object getAttachmentId() {
            return attachmentId;
        }

        @JsonProperty("attachment_id")
        public void setAttachmentId(Object attachmentId) {
            this.attachmentId = attachmentId;
        }

        @JsonProperty("bug_id")
        public Integer getBugId() {
            return bugId;
        }

        @JsonProperty("bug_id")
        public void setBugId(Integer bugId) {
            this.bugId = bugId;
        }

        @JsonProperty("count")
        public Integer getCount() {
            return count;
        }

        @JsonProperty("count")
        public void setCount(Integer count) {
            this.count = count;
        }

        @JsonProperty("creation_time")
        public String getCreationTime() {
            return creationTime;
        }

        @JsonProperty("creation_time")
        public void setCreationTime(String creationTime) {
            this.creationTime = creationTime;
        }

        @JsonProperty("creator")
        public String getCreator() {
            return creator;
        }

        @JsonProperty("creator")
        public void setCreator(String creator) {
            this.creator = creator;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("is_private")
        public Boolean getIsPrivate() {
            return isPrivate;
        }

        @JsonProperty("is_private")
        public void setIsPrivate(Boolean isPrivate) {
            this.isPrivate = isPrivate;
        }

        @JsonProperty("tags")
        public List<String> getTags() {
            return tags;
        }

        @JsonProperty("tags")
        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }

        @JsonProperty("time")
        public String getTime() {
            return time;
        }

        @JsonProperty("time")
        public void setTime(String time) {
            this.time = time;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
    //-----------------------------------com.Models.InputObjects.Comments.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "bugs",
            "comments"
    })
    public static class Comments implements Serializable
    {

        @JsonProperty("bugs")
        private Bugs bugs;
        @JsonProperty("comments")
        private Comments_ comments;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -1071828994380705673L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Comments() {
        }

        /**
         *
         * @param bugs
         * @param comments
         */
        public Comments(Bugs bugs, Comments_ comments) {
            super();
            this.bugs = bugs;
            this.comments = comments;
        }

        @JsonProperty("bugs")
        public Bugs getBugs() {
            return bugs;
        }

        @JsonProperty("bugs")
        public void setBugs(Bugs bugs) {
            this.bugs = bugs;
        }

        @JsonProperty("comments")
        public Comments_ getComments() {
            return comments;
        }

        @JsonProperty("comments")
        public void setComments(Comments_ comments) {
            this.comments = comments;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
    //-----------------------------------com.Models.InputObjects.Comments_.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({

    })
    public static class Comments_ implements Serializable
    {

        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 8666808135223555780L;

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
    //-----------------------------------com.Models.InputObjects.BugComments.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "comments"
    })
    public static class BugComments implements Serializable
    {

        @JsonProperty("comments")
        private List<Comment> comments = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 267611456361448937L;

        /**
         * No args constructor for use in serialization
         *
         */
        public BugComments() {
        }

        /**
         *
         * @param comments
         */
        public BugComments(List<Comment> comments) {
            super();
            this.comments = comments;
        }

        @JsonProperty("comments")
        public List<Comment> getComments() {
            return comments;
        }

        @JsonProperty("comments")
        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
