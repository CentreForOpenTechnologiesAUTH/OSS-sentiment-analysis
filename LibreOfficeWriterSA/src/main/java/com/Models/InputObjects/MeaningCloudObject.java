package com.Models.InputObjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
import java.io.Serializable;

public class MeaningCloudObject {
    //-----------------------------------com.Models.InputObjects.PolarityTermList.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "text",
            "inip",
            "endp",
            "confidence",
            "score_tag",
            "sentimented_concept_list"
    })
    public static class PolarityTermList implements Serializable
    {

        @JsonProperty("text")
        private String text;
        @JsonProperty("inip")
        private String inip;
        @JsonProperty("endp")
        private String endp;
        @JsonProperty("confidence")
        private String confidence;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonProperty("sentimented_concept_list")
        private List<SentimentedConceptList> sentimentedConceptList = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 6895582979298666361L;

        /**
         * No args constructor for use in serialization
         *
         */
        public PolarityTermList() {
        }

        /**
         *
         * @param confidence
         * @param scoreTag
         * @param endp
         * @param text
         * @param inip
         * @param sentimentedConceptList
         */
        public PolarityTermList(String text, String inip, String endp, String confidence, String scoreTag, List<SentimentedConceptList> sentimentedConceptList) {
            super();
            this.text = text;
            this.inip = inip;
            this.endp = endp;
            this.confidence = confidence;
            this.scoreTag = scoreTag;
            this.sentimentedConceptList = sentimentedConceptList;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }

        @JsonProperty("inip")
        public String getInip() {
            return inip;
        }

        @JsonProperty("inip")
        public void setInip(String inip) {
            this.inip = inip;
        }

        @JsonProperty("endp")
        public String getEndp() {
            return endp;
        }

        @JsonProperty("endp")
        public void setEndp(String endp) {
            this.endp = endp;
        }

        @JsonProperty("confidence")
        public String getConfidence() {
            return confidence;
        }

        @JsonProperty("confidence")
        public void setConfidence(String confidence) {
            this.confidence = confidence;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
        }

        @JsonProperty("sentimented_concept_list")
        public List<SentimentedConceptList> getSentimentedConceptList() {
            return sentimentedConceptList;
        }

        @JsonProperty("sentimented_concept_list")
        public void setSentimentedConceptList(List<SentimentedConceptList> sentimentedConceptList) {
            this.sentimentedConceptList = sentimentedConceptList;
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
    //-----------------------------------com.Models.InputObjects.SegmentList.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "text",
            "segment_type",
            "inip",
            "endp",
            "confidence",
            "score_tag",
            "agreement",
            "polarity_term_list",
            "sentimented_entity_list"
    })
    public static class SegmentList implements Serializable
    {

        @JsonProperty("text")
        private String text;
        @JsonProperty("segment_type")
        private String segmentType;
        @JsonProperty("inip")
        private String inip;
        @JsonProperty("endp")
        private String endp;
        @JsonProperty("confidence")
        private String confidence;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonProperty("agreement")
        private String agreement;
        @JsonProperty("polarity_term_list")
        private List<PolarityTermList> polarityTermList = null;
        @JsonProperty("sentimented_entity_list")
        private List<SentimentedEntityList> sentimentedEntityList = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 4074871362293636921L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SegmentList() {
        }

        /**
         *
         * @param polarityTermList
         * @param agreement
         * @param sentimentedEntityList
         * @param confidence
         * @param scoreTag
         * @param endp
         * @param text
         * @param inip
         * @param segmentType
         */
        public SegmentList(String text, String segmentType, String inip, String endp, String confidence, String scoreTag, String agreement, List<PolarityTermList> polarityTermList, List<SentimentedEntityList> sentimentedEntityList) {
            super();
            this.text = text;
            this.segmentType = segmentType;
            this.inip = inip;
            this.endp = endp;
            this.confidence = confidence;
            this.scoreTag = scoreTag;
            this.agreement = agreement;
            this.polarityTermList = polarityTermList;
            this.sentimentedEntityList = sentimentedEntityList;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }

        @JsonProperty("segment_type")
        public String getSegmentType() {
            return segmentType;
        }

        @JsonProperty("segment_type")
        public void setSegmentType(String segmentType) {
            this.segmentType = segmentType;
        }

        @JsonProperty("inip")
        public String getInip() {
            return inip;
        }

        @JsonProperty("inip")
        public void setInip(String inip) {
            this.inip = inip;
        }

        @JsonProperty("endp")
        public String getEndp() {
            return endp;
        }

        @JsonProperty("endp")
        public void setEndp(String endp) {
            this.endp = endp;
        }

        @JsonProperty("confidence")
        public String getConfidence() {
            return confidence;
        }

        @JsonProperty("confidence")
        public void setConfidence(String confidence) {
            this.confidence = confidence;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
        }

        @JsonProperty("agreement")
        public String getAgreement() {
            return agreement;
        }

        @JsonProperty("agreement")
        public void setAgreement(String agreement) {
            this.agreement = agreement;
        }

        @JsonProperty("polarity_term_list")
        public List<PolarityTermList> getPolarityTermList() {
            return polarityTermList;
        }

        @JsonProperty("polarity_term_list")
        public void setPolarityTermList(List<PolarityTermList> polarityTermList) {
            this.polarityTermList = polarityTermList;
        }

        @JsonProperty("sentimented_entity_list")
        public List<SentimentedEntityList> getSentimentedEntityList() {
            return sentimentedEntityList;
        }

        @JsonProperty("sentimented_entity_list")
        public void setSentimentedEntityList(List<SentimentedEntityList> sentimentedEntityList) {
            this.sentimentedEntityList = sentimentedEntityList;
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
    //-----------------------------------com.Models.InputObjects.SentenceList.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "text",
            "inip",
            "endp",
            "bop",
            "confidence",
            "score_tag",
            "agreement",
            "segment_list",
            "sentimented_entity_list",
            "sentimented_concept_list"
    })
    public static class SentenceList implements Serializable
    {

        @JsonProperty("text")
        private String text;
        @JsonProperty("inip")
        private String inip;
        @JsonProperty("endp")
        private String endp;
        @JsonProperty("bop")
        private String bop;
        @JsonProperty("confidence")
        private String confidence;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonProperty("agreement")
        private String agreement;
        @JsonProperty("segment_list")
        private List<SegmentList> segmentList = null;
        @JsonProperty("sentimented_entity_list")
        private List<SentimentedEntityList_> sentimentedEntityList = null;
        @JsonProperty("sentimented_concept_list")
        private List<SentimentedConceptList_> sentimentedConceptList = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -6521749174065227112L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SentenceList() {
        }

        /**
         *
         * @param bop
         * @param agreement
         * @param sentimentedEntityList
         * @param confidence
         * @param scoreTag
         * @param endp
         * @param text
         * @param inip
         * @param segmentList
         * @param sentimentedConceptList
         */
        public SentenceList(String text, String inip, String endp, String bop, String confidence, String scoreTag, String agreement, List<SegmentList> segmentList, List<SentimentedEntityList_> sentimentedEntityList, List<SentimentedConceptList_> sentimentedConceptList) {
            super();
            this.text = text;
            this.inip = inip;
            this.endp = endp;
            this.bop = bop;
            this.confidence = confidence;
            this.scoreTag = scoreTag;
            this.agreement = agreement;
            this.segmentList = segmentList;
            this.sentimentedEntityList = sentimentedEntityList;
            this.sentimentedConceptList = sentimentedConceptList;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }

        @JsonProperty("inip")
        public String getInip() {
            return inip;
        }

        @JsonProperty("inip")
        public void setInip(String inip) {
            this.inip = inip;
        }

        @JsonProperty("endp")
        public String getEndp() {
            return endp;
        }

        @JsonProperty("endp")
        public void setEndp(String endp) {
            this.endp = endp;
        }

        @JsonProperty("bop")
        public String getBop() {
            return bop;
        }

        @JsonProperty("bop")
        public void setBop(String bop) {
            this.bop = bop;
        }

        @JsonProperty("confidence")
        public String getConfidence() {
            return confidence;
        }

        @JsonProperty("confidence")
        public void setConfidence(String confidence) {
            this.confidence = confidence;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
        }

        @JsonProperty("agreement")
        public String getAgreement() {
            return agreement;
        }

        @JsonProperty("agreement")
        public void setAgreement(String agreement) {
            this.agreement = agreement;
        }

        @JsonProperty("segment_list")
        public List<SegmentList> getSegmentList() {
            return segmentList;
        }

        @JsonProperty("segment_list")
        public void setSegmentList(List<SegmentList> segmentList) {
            this.segmentList = segmentList;
        }

        @JsonProperty("sentimented_entity_list")
        public List<SentimentedEntityList_> getSentimentedEntityList() {
            return sentimentedEntityList;
        }

        @JsonProperty("sentimented_entity_list")
        public void setSentimentedEntityList(List<SentimentedEntityList_> sentimentedEntityList) {
            this.sentimentedEntityList = sentimentedEntityList;
        }

        @JsonProperty("sentimented_concept_list")
        public List<SentimentedConceptList_> getSentimentedConceptList() {
            return sentimentedConceptList;
        }

        @JsonProperty("sentimented_concept_list")
        public void setSentimentedConceptList(List<SentimentedConceptList_> sentimentedConceptList) {
            this.sentimentedConceptList = sentimentedConceptList;
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
    //-----------------------------------com.Models.InputObjects.SentimentedConceptList.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "form",
            "id",
            "variant",
            "inip",
            "endp",
            "type",
            "score_tag"
    })
    public static class SentimentedConceptList implements Serializable
    {

        @JsonProperty("form")
        private String form;
        @JsonProperty("id")
        private String id;
        @JsonProperty("variant")
        private String variant;
        @JsonProperty("inip")
        private String inip;
        @JsonProperty("endp")
        private String endp;
        @JsonProperty("type")
        private String type;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -1529245749599986431L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SentimentedConceptList() {
        }

        /**
         *
         * @param form
         * @param scoreTag
         * @param variant
         * @param endp
         * @param id
         * @param type
         * @param inip
         */
        public SentimentedConceptList(String form, String id, String variant, String inip, String endp, String type, String scoreTag) {
            super();
            this.form = form;
            this.id = id;
            this.variant = variant;
            this.inip = inip;
            this.endp = endp;
            this.type = type;
            this.scoreTag = scoreTag;
        }

        @JsonProperty("form")
        public String getForm() {
            return form;
        }

        @JsonProperty("form")
        public void setForm(String form) {
            this.form = form;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("variant")
        public String getVariant() {
            return variant;
        }

        @JsonProperty("variant")
        public void setVariant(String variant) {
            this.variant = variant;
        }

        @JsonProperty("inip")
        public String getInip() {
            return inip;
        }

        @JsonProperty("inip")
        public void setInip(String inip) {
            this.inip = inip;
        }

        @JsonProperty("endp")
        public String getEndp() {
            return endp;
        }

        @JsonProperty("endp")
        public void setEndp(String endp) {
            this.endp = endp;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
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
    //-----------------------------------com.Models.InputObjects.SentimentedConceptList_.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "form",
            "id",
            "type",
            "score_tag"
    })
    public static class SentimentedConceptList_ implements Serializable
    {

        @JsonProperty("form")
        private String form;
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 2917492188676463507L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SentimentedConceptList_() {
        }

        /**
         *
         * @param form
         * @param scoreTag
         * @param id
         * @param type
         */
        public SentimentedConceptList_(String form, String id, String type, String scoreTag) {
            super();
            this.form = form;
            this.id = id;
            this.type = type;
            this.scoreTag = scoreTag;
        }

        @JsonProperty("form")
        public String getForm() {
            return form;
        }

        @JsonProperty("form")
        public void setForm(String form) {
            this.form = form;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
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
    //-----------------------------------com.Models.InputObjects.SentimentedConceptList__.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "form",
            "id",
            "type",
            "score_tag"
    })
    public static class SentimentedConceptList__ implements Serializable
    {

        @JsonProperty("form")
        private String form;
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -7260945678154879053L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SentimentedConceptList__() {
        }

        /**
         *
         * @param form
         * @param scoreTag
         * @param id
         * @param type
         */
        public SentimentedConceptList__(String form, String id, String type, String scoreTag) {
            super();
            this.form = form;
            this.id = id;
            this.type = type;
            this.scoreTag = scoreTag;
        }

        @JsonProperty("form")
        public String getForm() {
            return form;
        }

        @JsonProperty("form")
        public void setForm(String form) {
            this.form = form;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
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
    //-----------------------------------com.Models.InputObjects.SentimentedEntityList.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "form",
            "id",
            "variant",
            "inip",
            "endp",
            "type",
            "score_tag"
    })
    public static class SentimentedEntityList implements Serializable
    {

        @JsonProperty("form")
        private String form;
        @JsonProperty("id")
        private String id;
        @JsonProperty("variant")
        private String variant;
        @JsonProperty("inip")
        private String inip;
        @JsonProperty("endp")
        private String endp;
        @JsonProperty("type")
        private String type;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -6307826701166641334L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SentimentedEntityList() {
        }

        /**
         *
         * @param form
         * @param scoreTag
         * @param variant
         * @param endp
         * @param id
         * @param type
         * @param inip
         */
        public SentimentedEntityList(String form, String id, String variant, String inip, String endp, String type, String scoreTag) {
            super();
            this.form = form;
            this.id = id;
            this.variant = variant;
            this.inip = inip;
            this.endp = endp;
            this.type = type;
            this.scoreTag = scoreTag;
        }

        @JsonProperty("form")
        public String getForm() {
            return form;
        }

        @JsonProperty("form")
        public void setForm(String form) {
            this.form = form;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("variant")
        public String getVariant() {
            return variant;
        }

        @JsonProperty("variant")
        public void setVariant(String variant) {
            this.variant = variant;
        }

        @JsonProperty("inip")
        public String getInip() {
            return inip;
        }

        @JsonProperty("inip")
        public void setInip(String inip) {
            this.inip = inip;
        }

        @JsonProperty("endp")
        public String getEndp() {
            return endp;
        }

        @JsonProperty("endp")
        public void setEndp(String endp) {
            this.endp = endp;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
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
    //-----------------------------------com.Models.InputObjects.SentimentedEntityList_.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "form",
            "id",
            "type",
            "score_tag"
    })
    public static class SentimentedEntityList_ implements Serializable
    {

        @JsonProperty("form")
        private String form;
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -7675893352369898904L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SentimentedEntityList_() {
        }

        /**
         *
         * @param form
         * @param scoreTag
         * @param id
         * @param type
         */
        public SentimentedEntityList_(String form, String id, String type, String scoreTag) {
            super();
            this.form = form;
            this.id = id;
            this.type = type;
            this.scoreTag = scoreTag;
        }

        @JsonProperty("form")
        public String getForm() {
            return form;
        }

        @JsonProperty("form")
        public void setForm(String form) {
            this.form = form;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
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
    //-----------------------------------com.Models.InputObjects.SentimentedEntityList__.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "form",
            "id",
            "type",
            "score_tag"
    })
    public static class SentimentedEntityList__ implements Serializable
    {

        @JsonProperty("form")
        private String form;
        @JsonProperty("id")
        private String id;
        @JsonProperty("type")
        private String type;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -7332928123219664133L;

        /**
         * No args constructor for use in serialization
         *
         */
        public SentimentedEntityList__() {
        }

        /**
         *
         * @param form
         * @param scoreTag
         * @param id
         * @param type
         */
        public SentimentedEntityList__(String form, String id, String type, String scoreTag) {
            super();
            this.form = form;
            this.id = id;
            this.type = type;
            this.scoreTag = scoreTag;
        }

        @JsonProperty("form")
        public String getForm() {
            return form;
        }

        @JsonProperty("form")
        public void setForm(String form) {
            this.form = form;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(String id) {
            this.id = id;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
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
    //-----------------------------------com.Models.InputObjects.Sentiments.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "status",
            "model",
            "score_tag",
            "agreement",
            "subjectivity",
            "confidence",
            "irony",
            "sentence_list",
            "sentimented_entity_list",
            "sentimented_concept_list"
    })
    public static class Sentiments implements Serializable
    {

        @JsonProperty("status")
        private Status status;
        @JsonProperty("model")
        private String model;
        @JsonProperty("score_tag")
        private String scoreTag;
        @JsonProperty("agreement")
        private String agreement;
        @JsonProperty("subjectivity")
        private String subjectivity;
        @JsonProperty("confidence")
        private String confidence;
        @JsonProperty("irony")
        private String irony;
        @JsonProperty("sentence_list")
        private List<SentenceList> sentenceList = null;
        @JsonProperty("sentimented_entity_list")
        private List<SentimentedEntityList__> sentimentedEntityList = null;
        @JsonProperty("sentimented_concept_list")
        private List<SentimentedConceptList__> sentimentedConceptList = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -1638310119028551694L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Sentiments() {
        }

        /**
         *
         * @param sentenceList
         * @param agreement
         * @param subjectivity
         * @param sentimentedEntityList
         * @param scoreTag
         * @param confidence
         * @param model
         * @param irony
         * @param sentimentedConceptList
         * @param status
         */
        public Sentiments(Status status, String model, String scoreTag, String agreement, String subjectivity, String confidence, String irony, List<SentenceList> sentenceList, List<SentimentedEntityList__> sentimentedEntityList, List<SentimentedConceptList__> sentimentedConceptList) {
            super();
            this.status = status;
            this.model = model;
            this.scoreTag = scoreTag;
            this.agreement = agreement;
            this.subjectivity = subjectivity;
            this.confidence = confidence;
            this.irony = irony;
            this.sentenceList = sentenceList;
            this.sentimentedEntityList = sentimentedEntityList;
            this.sentimentedConceptList = sentimentedConceptList;
        }

        @JsonProperty("status")
        public Status getStatus() {
            return status;
        }

        @JsonProperty("status")
        public void setStatus(Status status) {
            this.status = status;
        }

        @JsonProperty("model")
        public String getModel() {
            return model;
        }

        @JsonProperty("model")
        public void setModel(String model) {
            this.model = model;
        }

        @JsonProperty("score_tag")
        public String getScoreTag() {
            return scoreTag;
        }

        @JsonProperty("score_tag")
        public void setScoreTag(String scoreTag) {
            this.scoreTag = scoreTag;
        }

        @JsonProperty("agreement")
        public String getAgreement() {
            return agreement;
        }

        @JsonProperty("agreement")
        public void setAgreement(String agreement) {
            this.agreement = agreement;
        }

        @JsonProperty("subjectivity")
        public String getSubjectivity() {
            return subjectivity;
        }

        @JsonProperty("subjectivity")
        public void setSubjectivity(String subjectivity) {
            this.subjectivity = subjectivity;
        }

        @JsonProperty("confidence")
        public String getConfidence() {
            return confidence;
        }

        @JsonProperty("confidence")
        public void setConfidence(String confidence) {
            this.confidence = confidence;
        }

        @JsonProperty("irony")
        public String getIrony() {
            return irony;
        }

        @JsonProperty("irony")
        public void setIrony(String irony) {
            this.irony = irony;
        }

        @JsonProperty("sentence_list")
        public List<SentenceList> getSentenceList() {
            return sentenceList;
        }

        @JsonProperty("sentence_list")
        public void setSentenceList(List<SentenceList> sentenceList) {
            this.sentenceList = sentenceList;
        }

        @JsonProperty("sentimented_entity_list")
        public List<SentimentedEntityList__> getSentimentedEntityList() {
            return sentimentedEntityList;
        }

        @JsonProperty("sentimented_entity_list")
        public void setSentimentedEntityList(List<SentimentedEntityList__> sentimentedEntityList) {
            this.sentimentedEntityList = sentimentedEntityList;
        }

        @JsonProperty("sentimented_concept_list")
        public List<SentimentedConceptList__> getSentimentedConceptList() {
            return sentimentedConceptList;
        }

        @JsonProperty("sentimented_concept_list")
        public void setSentimentedConceptList(List<SentimentedConceptList__> sentimentedConceptList) {
            this.sentimentedConceptList = sentimentedConceptList;
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
    //-----------------------------------com.Models.InputObjects.Status.java-----------------------------------

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "code",
            "msg",
            "credits"
    })
    public static class Status implements Serializable
    {

        @JsonProperty("code")
        private String code;
        @JsonProperty("msg")
        private String msg;
        @JsonProperty("credits")
        private String credits;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 5814587267393493671L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Status() {
        }

        /**
         *
         * @param msg
         * @param code
         * @param credits
         */
        public Status(String code, String msg, String credits) {
            super();
            this.code = code;
            this.msg = msg;
            this.credits = credits;
        }

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(String code) {
            this.code = code;
        }

        @JsonProperty("msg")
        public String getMsg() {
            return msg;
        }

        @JsonProperty("msg")
        public void setMsg(String msg) {
            this.msg = msg;
        }

        @JsonProperty("credits")
        public String getCredits() {
            return credits;
        }

        @JsonProperty("credits")
        public void setCredits(String credits) {
            this.credits = credits;
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
