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

import java.util.Map;

public class BugsObject {

    //-----------------------------------com.Models.InputObjects.AssignedToDetail.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "email",
            "id",
            "name",
            "real_name"
    })
    public static class AssignedToDetail implements Serializable
    {

        @JsonProperty("email")
        private String email;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("real_name")
        private String realName;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -4002743144721933324L;

        /**
         * No args constructor for use in serialization
         *
         */
        public AssignedToDetail() {
        }

        /**
         *
         * @param realName
         * @param name
         * @param id
         * @param email
         */
        public AssignedToDetail(String email, Integer id, String name, String realName) {
            super();
            this.email = email;
            this.id = id;
            this.name = name;
            this.realName = realName;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("real_name")
        public String getRealName() {
            return realName;
        }

        @JsonProperty("real_name")
        public void setRealName(String realName) {
            this.realName = realName;
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
    //-----------------------------------com.Models.InputObjects.Bug.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "alias",
            "assigned_to",
            "assigned_to_detail",
            "blocks",
            "cc",
            "cc_detail",
            "cf_crashreport",
            "classification",
            "component",
            "creation_time",
            "creator",
            "creator_detail",
            "deadline",
            "depends_on",
            "dupe_of",
            "flags",
            "groups",
            "id",
            "is_cc_accessible",
            "is_confirmed",
            "is_creator_accessible",
            "is_open",
            "keywords",
            "last_change_time",
            "op_sys",
            "platform",
            "priority",
            "product",
            "qa_contact",
            "resolution",
            "see_also",
            "severity",
            "status",
            "summary",
            "target_milestone",
            "url",
            "version",
            "whiteboard"
    })
    public static class Bug implements Serializable
    {
//        @JsonProperty("alias")
//        private List<Object> alias = null;
        @JsonProperty("assigned_to")
        private String assignedTo;
        @JsonProperty("assigned_to_detail")
        private AssignedToDetail assignedToDetail;
        @JsonProperty("blocks")
        private List<Integer> blocks = null;
        @JsonProperty("cc")
        private List<String> cc = null;
        @JsonProperty("cc_detail")
        private List<CcDetail> ccDetail = null;
        @JsonProperty("cf_crashreport")
        private String cfCrashreport;
        @JsonProperty("classification")
        private String classification;
        @JsonProperty("component")
        private String component;
        @JsonProperty("creation_time")
        private String creationTime;
        @JsonProperty("creator")
        private String creator;
        @JsonProperty("creator_detail")
        private CreatorDetail creatorDetail;
        @JsonProperty("deadline")
        private Object deadline;
        @JsonProperty("depends_on")
        private List<Object> dependsOn = null;
        @JsonProperty("dupe_of")
        private Object dupeOf;
        @JsonProperty("flags")
        private List<Object> flags = null;
        @JsonProperty("groups")
        private List<Object> groups = null;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("is_cc_accessible")
        private Boolean isCcAccessible;
        @JsonProperty("is_confirmed")
        private Boolean isConfirmed;
        @JsonProperty("is_creator_accessible")
        private Boolean isCreatorAccessible;
        @JsonProperty("is_open")
        private Boolean isOpen;
        @JsonProperty("keywords")
        private List<String> keywords = null;
        @JsonProperty("last_change_time")
        private String lastChangeTime;
        @JsonProperty("op_sys")
        private String opSys;
        @JsonProperty("platform")
        private String platform;
        @JsonProperty("priority")
        private String priority;
        @JsonProperty("product")
        private String product;
        @JsonProperty("qa_contact")
        private String qaContact;
        @JsonProperty("resolution")
        private String resolution;
        @JsonProperty("see_also")
        private List<String> seeAlso = null;
        @JsonProperty("severity")
        private String severity;
        @JsonProperty("status")
        private String status;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("target_milestone")
        private String targetMilestone;
        @JsonProperty("url")
        private String url;
        @JsonProperty("version")
        private String version;
        @JsonProperty("whiteboard")
        private String whiteboard;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 4661202139259048637L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Bug() {
        }

        /**
         *
         * @param creationTime
         * @param keywords
         * @param qaContact
         * @param flags
         * @param isCcAccessible
         * @param whiteboard
         * @param isCreatorAccessible
         * @param resolution
         * @param assignedTo
         * @param platform
         * @param seeAlso
         * @param creatorDetail
         * @param cfCrashreport
         * @param alias
         * @param isConfirmed
         * @param id
         * @param deadline
         * @param cc
         * @param severity
         * @param summary
         * @param targetMilestone
         * @param creator
         * @param product
         * @param dependsOn
         * @param blocks
         * @param groups
         * @param classification
         * @param priority
         * @param version
         * @param url
         * @param component
         * @param isOpen
         * @param dupeOf
         * @param assignedToDetail
         * @param lastChangeTime
         * @param opSys
         * @param ccDetail
         * @param status
         */
        public Bug(List<Object> alias, String assignedTo, AssignedToDetail assignedToDetail, List<Integer> blocks, List<String> cc, List<CcDetail> ccDetail, String cfCrashreport, String classification, String component, String creationTime, String creator, CreatorDetail creatorDetail, Object deadline, List<Object> dependsOn, Object dupeOf, List<Object> flags, List<Object> groups, Integer id, Boolean isCcAccessible, Boolean isConfirmed, Boolean isCreatorAccessible, Boolean isOpen, List<String> keywords, String lastChangeTime, String opSys, String platform, String priority, String product, String qaContact, String resolution, List<String> seeAlso, String severity, String status, String summary, String targetMilestone, String url, String version, String whiteboard) {
            super();
            //this.alias = alias;
            this.assignedTo = assignedTo;
            this.assignedToDetail = assignedToDetail;
            this.blocks = blocks;
            this.cc = cc;
            this.ccDetail = ccDetail;
            this.cfCrashreport = cfCrashreport;
            this.classification = classification;
            this.component = component;
            this.creationTime = creationTime;
            this.creator = creator;
            this.creatorDetail = creatorDetail;
            this.deadline = deadline;
            this.dependsOn = dependsOn;
            this.dupeOf = dupeOf;
            this.flags = flags;
            this.groups = groups;
            this.id = id;
            this.isCcAccessible = isCcAccessible;
            this.isConfirmed = isConfirmed;
            this.isCreatorAccessible = isCreatorAccessible;
            this.isOpen = isOpen;
            this.keywords = keywords;
            this.lastChangeTime = lastChangeTime;
            this.opSys = opSys;
            this.platform = platform;
            this.priority = priority;
            this.product = product;
            this.qaContact = qaContact;
            this.resolution = resolution;
            this.seeAlso = seeAlso;
            this.severity = severity;
            this.status = status;
            this.summary = summary;
            this.targetMilestone = targetMilestone;
            this.url = url;
            this.version = version;
            this.whiteboard = whiteboard;
        }

//        @JsonProperty("alias")
//        public List<Object> getAlias() {
//            return alias;
//        }
//
//        @JsonProperty("alias")
//        public void setAlias(List<Object> alias) {
//            this.alias = alias;
//        }

        @JsonProperty("assigned_to")
        public String getAssignedTo() {
            return assignedTo;
        }

        @JsonProperty("assigned_to")
        public void setAssignedTo(String assignedTo) {
            this.assignedTo = assignedTo;
        }

        @JsonProperty("assigned_to_detail")
        public AssignedToDetail getAssignedToDetail() {
            return assignedToDetail;
        }

        @JsonProperty("assigned_to_detail")
        public void setAssignedToDetail(AssignedToDetail assignedToDetail) {
            this.assignedToDetail = assignedToDetail;
        }

        @JsonProperty("blocks")
        public List<Integer> getBlocks() {
            return blocks;
        }

        @JsonProperty("blocks")
        public void setBlocks(List<Integer> blocks) {
            this.blocks = blocks;
        }

        @JsonProperty("cc")
        public List<String> getCc() {
            return cc;
        }

        @JsonProperty("cc")
        public void setCc(List<String> cc) {
            this.cc = cc;
        }

        @JsonProperty("cc_detail")
        public List<CcDetail> getCcDetail() {
            return ccDetail;
        }

        @JsonProperty("cc_detail")
        public void setCcDetail(List<CcDetail> ccDetail) {
            this.ccDetail = ccDetail;
        }

        @JsonProperty("cf_crashreport")
        public String getCfCrashreport() {
            return cfCrashreport;
        }

        @JsonProperty("cf_crashreport")
        public void setCfCrashreport(String cfCrashreport) {
            this.cfCrashreport = cfCrashreport;
        }

        @JsonProperty("classification")
        public String getClassification() {
            return classification;
        }

        @JsonProperty("classification")
        public void setClassification(String classification) {
            this.classification = classification;
        }

        @JsonProperty("component")
        public String getComponent() {
            return component;
        }

        @JsonProperty("component")
        public void setComponent(String component) {
            this.component = component;
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

        @JsonProperty("creator_detail")
        public CreatorDetail getCreatorDetail() {
            return creatorDetail;
        }

        @JsonProperty("creator_detail")
        public void setCreatorDetail(CreatorDetail creatorDetail) {
            this.creatorDetail = creatorDetail;
        }

        @JsonProperty("deadline")
        public Object getDeadline() {
            return deadline;
        }

        @JsonProperty("deadline")
        public void setDeadline(Object deadline) {
            this.deadline = deadline;
        }

        @JsonProperty("depends_on")
        public List<Object> getDependsOn() {
            return dependsOn;
        }

        @JsonProperty("depends_on")
        public void setDependsOn(List<Object> dependsOn) {
            this.dependsOn = dependsOn;
        }

        @JsonProperty("dupe_of")
        public Object getDupeOf() {
            return dupeOf;
        }

        @JsonProperty("dupe_of")
        public void setDupeOf(Object dupeOf) {
            this.dupeOf = dupeOf;
        }

        @JsonProperty("flags")
        public List<Object> getFlags() {
            return flags;
        }

        @JsonProperty("flags")
        public void setFlags(List<Object> flags) {
            this.flags = flags;
        }

        @JsonProperty("groups")
        public List<Object> getGroups() {
            return groups;
        }

        @JsonProperty("groups")
        public void setGroups(List<Object> groups) {
            this.groups = groups;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("is_cc_accessible")
        public Boolean getIsCcAccessible() {
            return isCcAccessible;
        }

        @JsonProperty("is_cc_accessible")
        public void setIsCcAccessible(Boolean isCcAccessible) {
            this.isCcAccessible = isCcAccessible;
        }

        @JsonProperty("is_confirmed")
        public Boolean getIsConfirmed() {
            return isConfirmed;
        }

        @JsonProperty("is_confirmed")
        public void setIsConfirmed(Boolean isConfirmed) {
            this.isConfirmed = isConfirmed;
        }

        @JsonProperty("is_creator_accessible")
        public Boolean getIsCreatorAccessible() {
            return isCreatorAccessible;
        }

        @JsonProperty("is_creator_accessible")
        public void setIsCreatorAccessible(Boolean isCreatorAccessible) {
            this.isCreatorAccessible = isCreatorAccessible;
        }

        @JsonProperty("is_open")
        public Boolean getIsOpen() {
            return isOpen;
        }

        @JsonProperty("is_open")
        public void setIsOpen(Boolean isOpen) {
            this.isOpen = isOpen;
        }

        @JsonProperty("keywords")
        public List<String> getKeywords() {
            return keywords;
        }

        @JsonProperty("keywords")
        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }

        @JsonProperty("last_change_time")
        public String getLastChangeTime() {
            return lastChangeTime;
        }

        @JsonProperty("last_change_time")
        public void setLastChangeTime(String lastChangeTime) {
            this.lastChangeTime = lastChangeTime;
        }

        @JsonProperty("op_sys")
        public String getOpSys() {
            return opSys;
        }

        @JsonProperty("op_sys")
        public void setOpSys(String opSys) {
            this.opSys = opSys;
        }

        @JsonProperty("platform")
        public String getPlatform() {
            return platform;
        }

        @JsonProperty("platform")
        public void setPlatform(String platform) {
            this.platform = platform;
        }

        @JsonProperty("priority")
        public String getPriority() {
            return priority;
        }

        @JsonProperty("priority")
        public void setPriority(String priority) {
            this.priority = priority;
        }

        @JsonProperty("product")
        public String getProduct() {
            return product;
        }

        @JsonProperty("product")
        public void setProduct(String product) {
            this.product = product;
        }

        @JsonProperty("qa_contact")
        public String getQaContact() {
            return qaContact;
        }

        @JsonProperty("qa_contact")
        public void setQaContact(String qaContact) {
            this.qaContact = qaContact;
        }

        @JsonProperty("resolution")
        public String getResolution() {
            return resolution;
        }

        @JsonProperty("resolution")
        public void setResolution(String resolution) {
            this.resolution = resolution;
        }

        @JsonProperty("see_also")
        public List<String> getSeeAlso() {
            return seeAlso;
        }

        @JsonProperty("see_also")
        public void setSeeAlso(List<String> seeAlso) {
            this.seeAlso = seeAlso;
        }

        @JsonProperty("severity")
        public String getSeverity() {
            return severity;
        }

        @JsonProperty("severity")
        public void setSeverity(String severity) {
            this.severity = severity;
        }

        @JsonProperty("status")
        public String getStatus() {
            return status;
        }

        @JsonProperty("status")
        public void setStatus(String status) {
            this.status = status;
        }

        @JsonProperty("summary")
        public String getSummary() {
            return summary;
        }

        @JsonProperty("summary")
        public void setSummary(String summary) {
            this.summary = summary;
        }

        @JsonProperty("target_milestone")
        public String getTargetMilestone() {
            return targetMilestone;
        }

        @JsonProperty("target_milestone")
        public void setTargetMilestone(String targetMilestone) {
            this.targetMilestone = targetMilestone;
        }

        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        @JsonProperty("url")
        public void setUrl(String url) {
            this.url = url;
        }

        @JsonProperty("version")
        public String getVersion() {
            return version;
        }

        @JsonProperty("version")
        public void setVersion(String version) {
            this.version = version;
        }

        @JsonProperty("whiteboard")
        public String getWhiteboard() {
            return whiteboard;
        }

        @JsonProperty("whiteboard")
        public void setWhiteboard(String whiteboard) {
            this.whiteboard = whiteboard;
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
    //-----------------------------------com.Models.InputObjects.Bugs.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "bugs",
            "faults"
    })
    public static class Bugs implements Serializable
    {

        @JsonProperty("bugs")
        private List<Bug> bugs = null;
        @JsonProperty("faults")
        private List<Object> faults = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = -4148724772947835964L;

        /**
         * No args constructor for use in serialization
         *
         */
        public Bugs() {
        }

        /**
         *
         * @param bugs
         * @param faults
         */
        public Bugs(List<Bug> bugs, List<Object> faults) {
            super();
            this.bugs = bugs;
            this.faults = faults;
        }

        @JsonProperty("bugs")
        public List<Bug> getBugs() {
            return bugs;
        }

        @JsonProperty("bugs")
        public void setBugs(List<Bug> bugs) {
            this.bugs = bugs;
        }

        @JsonProperty("faults")
        public List<Object> getFaults() {
            return faults;
        }

        @JsonProperty("faults")
        public void setFaults(List<Object> faults) {
            this.faults = faults;
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
    //-----------------------------------com.Models.InputObjects.CcDetail.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "email",
            "id",
            "name",
            "real_name"
    })
    public static class CcDetail implements Serializable
    {

        @JsonProperty("email")
        private String email;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("real_name")
        private String realName;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 6855910729657775148L;

        /**
         * No args constructor for use in serialization
         *
         */
        public CcDetail() {
        }

        /**
         *
         * @param realName
         * @param name
         * @param id
         * @param email
         */
        public CcDetail(String email, Integer id, String name, String realName) {
            super();
            this.email = email;
            this.id = id;
            this.name = name;
            this.realName = realName;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("real_name")
        public String getRealName() {
            return realName;
        }

        @JsonProperty("real_name")
        public void setRealName(String realName) {
            this.realName = realName;
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
    //-----------------------------------com.Models.InputObjects.CreatorDetail.java-----------------------------------
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "email",
            "id",
            "name",
            "real_name"
    })
    public static class CreatorDetail implements Serializable
    {

        @JsonProperty("email")
        private String email;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("real_name")
        private String realName;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();
        private final static long serialVersionUID = 8739076360895249086L;

        /**
         * No args constructor for use in serialization
         *
         */
        public CreatorDetail() {
        }

        /**
         *
         * @param realName
         * @param name
         * @param id
         * @param email
         */
        public CreatorDetail(String email, Integer id, String name, String realName) {
            super();
            this.email = email;
            this.id = id;
            this.name = name;
            this.realName = realName;
        }

        @JsonProperty("email")
        public String getEmail() {
            return email;
        }

        @JsonProperty("email")
        public void setEmail(String email) {
            this.email = email;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("real_name")
        public String getRealName() {
            return realName;
        }

        @JsonProperty("real_name")
        public void setRealName(String realName) {
            this.realName = realName;
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
