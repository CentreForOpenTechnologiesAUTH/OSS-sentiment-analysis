package com.Models.InputObjects;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class ProductObject {
        //-----------------------------------com.Models.InputObjects.Component.java-----------------------------------

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "default_qa_contact",
                "default_assigned_to",
                "sort_key",
                "is_active",
                "id",
                "name",
                "flag_types",
                "description"
        })
        public static class Component implements Serializable
        {

            @JsonProperty("default_qa_contact")
            private String defaultQaContact;
            @JsonProperty("default_assigned_to")
            private String defaultAssignedTo;
            @JsonProperty("sort_key")
            private Integer sortKey;
            @JsonProperty("is_active")
            private Boolean isActive;
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("name")
            private String name;
            @JsonProperty("flag_types")
            private FlagTypes flagTypes;
            @JsonProperty("description")
            private String description;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();
            private final static long serialVersionUID = 5494366430318571572L;

            /**
             * No args constructor for use in serialization
             *
             */
            public Component() {
            }

            /**
             *
             * @param defaultAssignedTo
             * @param sortKey
             * @param defaultQaContact
             * @param flagTypes
             * @param name
             * @param description
             * @param id
             * @param isActive
             */
            public Component(String defaultQaContact, String defaultAssignedTo, Integer sortKey, Boolean isActive, Integer id, String name, FlagTypes flagTypes, String description) {
                super();
                this.defaultQaContact = defaultQaContact;
                this.defaultAssignedTo = defaultAssignedTo;
                this.sortKey = sortKey;
                this.isActive = isActive;
                this.id = id;
                this.name = name;
                this.flagTypes = flagTypes;
                this.description = description;
            }

            @JsonProperty("default_qa_contact")
            public String getDefaultQaContact() {
                return defaultQaContact;
            }

            @JsonProperty("default_qa_contact")
            public void setDefaultQaContact(String defaultQaContact) {
                this.defaultQaContact = defaultQaContact;
            }

            @JsonProperty("default_assigned_to")
            public String getDefaultAssignedTo() {
                return defaultAssignedTo;
            }

            @JsonProperty("default_assigned_to")
            public void setDefaultAssignedTo(String defaultAssignedTo) {
                this.defaultAssignedTo = defaultAssignedTo;
            }

            @JsonProperty("sort_key")
            public Integer getSortKey() {
                return sortKey;
            }

            @JsonProperty("sort_key")
            public void setSortKey(Integer sortKey) {
                this.sortKey = sortKey;
            }

            @JsonProperty("is_active")
            public Boolean getIsActive() {
                return isActive;
            }

            @JsonProperty("is_active")
            public void setIsActive(Boolean isActive) {
                this.isActive = isActive;
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

            @JsonProperty("flag_types")
            public FlagTypes getFlagTypes() {
                return flagTypes;
            }

            @JsonProperty("flag_types")
            public void setFlagTypes(FlagTypes flagTypes) {
                this.flagTypes = flagTypes;
            }

            @JsonProperty("description")
            public String getDescription() {
                return description;
            }

            @JsonProperty("description")
            public void setDescription(String description) {
                this.description = description;
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
        //-----------------------------------com.Models.InputObjects.FlagTypes.java-----------------------------------

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "bug",
                "attachment"
        })
        public static class FlagTypes implements Serializable
        {

            @JsonProperty("bug")
            private List<Object> bug = null;
            @JsonProperty("attachment")
            private List<Object> attachment = null;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();
            private final static long serialVersionUID = -8062420264798007060L;

            /**
             * No args constructor for use in serialization
             *
             */
            public FlagTypes() {
            }

            /**
             *
             * @param attachment
             * @param bug
             */
            public FlagTypes(List<Object> bug, List<Object> attachment) {
                super();
                this.bug = bug;
                this.attachment = attachment;
            }

            @JsonProperty("bug")
            public List<Object> getBug() {
                return bug;
            }

            @JsonProperty("bug")
            public void setBug(List<Object> bug) {
                this.bug = bug;
            }

            @JsonProperty("attachment")
            public List<Object> getAttachment() {
                return attachment;
            }

            @JsonProperty("attachment")
            public void setAttachment(List<Object> attachment) {
                this.attachment = attachment;
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
        //-----------------------------------com.Models.InputObjects.Milestone.java-----------------------------------

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "id",
                "is_active",
                "name",
                "sort_key"
        })
        public static class Milestone implements Serializable
        {

            @JsonProperty("id")
            private Integer id;
            @JsonProperty("is_active")
            private Boolean isActive;
            @JsonProperty("name")
            private String name;
            @JsonProperty("sort_key")
            private Integer sortKey;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();
            private final static long serialVersionUID = -1823227076139679645L;

            /**
             * No args constructor for use in serialization
             *
             */
            public Milestone() {
            }

            /**
             *
             * @param sortKey
             * @param name
             * @param id
             * @param isActive
             */
            public Milestone(Integer id, Boolean isActive, String name, Integer sortKey) {
                super();
                this.id = id;
                this.isActive = isActive;
                this.name = name;
                this.sortKey = sortKey;
            }

            @JsonProperty("id")
            public Integer getId() {
                return id;
            }

            @JsonProperty("id")
            public void setId(Integer id) {
                this.id = id;
            }

            @JsonProperty("is_active")
            public Boolean getIsActive() {
                return isActive;
            }

            @JsonProperty("is_active")
            public void setIsActive(Boolean isActive) {
                this.isActive = isActive;
            }

            @JsonProperty("name")
            public String getName() {
                return name;
            }

            @JsonProperty("name")
            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty("sort_key")
            public Integer getSortKey() {
                return sortKey;
            }

            @JsonProperty("sort_key")
            public void setSortKey(Integer sortKey) {
                this.sortKey = sortKey;
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
        //-----------------------------------com.Models.InputObjects.Product.java-----------------------------------

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "milestones",
                "description",
                "classification",
                "name",
                "default_milestone",
                "components",
                "has_unconfirmed",
                "is_active",
                "id",
                "versions"
        })
        public static class Product implements Serializable
        {

            @JsonProperty("milestones")
            private List<Milestone> milestones = null;
            @JsonProperty("description")
            private String description;
            @JsonProperty("classification")
            private String classification;
            @JsonProperty("name")
            private String name;
            @JsonProperty("default_milestone")
            private String defaultMilestone;
            @JsonProperty("components")
            private List<Component> components = null;
            @JsonProperty("has_unconfirmed")
            private Boolean hasUnconfirmed;
            @JsonProperty("is_active")
            private Boolean isActive;
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("versions")
            private List<Version> versions = null;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();
            private final static long serialVersionUID = -6473466058302760448L;

            /**
             * No args constructor for use in serialization
             *
             */
            public Product() {
            }

            /**
             *
             * @param hasUnconfirmed
             * @param components
             * @param versions
             * @param defaultMilestone
             * @param name
             * @param description
             * @param id
             * @param milestones
             * @param classification
             * @param isActive
             */
            public Product(List<Milestone> milestones, String description, String classification, String name, String defaultMilestone, List<Component> components, Boolean hasUnconfirmed, Boolean isActive, Integer id, List<Version> versions) {
                super();
                this.milestones = milestones;
                this.description = description;
                this.classification = classification;
                this.name = name;
                this.defaultMilestone = defaultMilestone;
                this.components = components;
                this.hasUnconfirmed = hasUnconfirmed;
                this.isActive = isActive;
                this.id = id;
                this.versions = versions;
            }

            @JsonProperty("milestones")
            public List<Milestone> getMilestones() {
                return milestones;
            }

            @JsonProperty("milestones")
            public void setMilestones(List<Milestone> milestones) {
                this.milestones = milestones;
            }

            @JsonProperty("description")
            public String getDescription() {
                return description;
            }

            @JsonProperty("description")
            public void setDescription(String description) {
                this.description = description;
            }

            @JsonProperty("classification")
            public String getClassification() {
                return classification;
            }

            @JsonProperty("classification")
            public void setClassification(String classification) {
                this.classification = classification;
            }

            @JsonProperty("name")
            public String getName() {
                return name;
            }

            @JsonProperty("name")
            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty("default_milestone")
            public String getDefaultMilestone() {
                return defaultMilestone;
            }

            @JsonProperty("default_milestone")
            public void setDefaultMilestone(String defaultMilestone) {
                this.defaultMilestone = defaultMilestone;
            }

            @JsonProperty("components")
            public List<Component> getComponents() {
                return components;
            }

            @JsonProperty("components")
            public void setComponents(List<Component> components) {
                this.components = components;
            }

            @JsonProperty("has_unconfirmed")
            public Boolean getHasUnconfirmed() {
                return hasUnconfirmed;
            }

            @JsonProperty("has_unconfirmed")
            public void setHasUnconfirmed(Boolean hasUnconfirmed) {
                this.hasUnconfirmed = hasUnconfirmed;
            }

            @JsonProperty("is_active")
            public Boolean getIsActive() {
                return isActive;
            }

            @JsonProperty("is_active")
            public void setIsActive(Boolean isActive) {
                this.isActive = isActive;
            }

            @JsonProperty("id")
            public Integer getId() {
                return id;
            }

            @JsonProperty("id")
            public void setId(Integer id) {
                this.id = id;
            }

            @JsonProperty("versions")
            public List<Version> getVersions() {
                return versions;
            }

            @JsonProperty("versions")
            public void setVersions(List<Version> versions) {
                this.versions = versions;
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
        //-----------------------------------com.Models.InputObjects.Products.java-----------------------------------

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "products"
        })
        public static class Products implements Serializable
        {

            @JsonProperty("products")
            private List<Product> products = null;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();
            private final static long serialVersionUID = 8983361892784407777L;

            /**
             * No args constructor for use in serialization
             *
             */
            public Products() {
            }

            /**
             *
             * @param products
             */
            public Products(List<Product> products) {
                super();
                this.products = products;
            }

            @JsonProperty("products")
            public List<Product> getProducts() {
                return products;
            }

            @JsonProperty("products")
            public void setProducts(List<Product> products) {
                this.products = products;
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
        //-----------------------------------com.Models.InputObjects.Version.java-----------------------------------

        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonPropertyOrder({
                "sort_key",
                "is_active",
                "id",
                "name"
        })
        public static class Version implements Serializable
        {

            @JsonProperty("sort_key")
            private Integer sortKey;
            @JsonProperty("is_active")
            private Boolean isActive;
            @JsonProperty("id")
            private Integer id;
            @JsonProperty("name")
            private String name;
            @JsonIgnore
            private Map<String, Object> additionalProperties = new HashMap<String, Object>();
            private final static long serialVersionUID = 3186565916225581245L;

            /**
             * No args constructor for use in serialization
             *
             */
            public Version() {
            }

            /**
             *
             * @param sortKey
             * @param name
             * @param id
             * @param isActive
             */
            public Version(Integer sortKey, Boolean isActive, Integer id, String name) {
                super();
                this.sortKey = sortKey;
                this.isActive = isActive;
                this.id = id;
                this.name = name;
            }

            @JsonProperty("sort_key")
            public Integer getSortKey() {
                return sortKey;
            }

            @JsonProperty("sort_key")
            public void setSortKey(Integer sortKey) {
                this.sortKey = sortKey;
            }

            @JsonProperty("is_active")
            public Boolean getIsActive() {
                return isActive;
            }

            @JsonProperty("is_active")
            public void setIsActive(Boolean isActive) {
                this.isActive = isActive;
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
