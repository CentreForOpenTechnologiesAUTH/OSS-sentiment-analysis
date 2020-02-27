package com.Models.InputObjects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class SentimentObject {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "neg",
            "neu",
            "pos",
            "compound"
    })
    public static class Sentiment{

        public Sentiment() {
        }

        public Sentiment(float negative, float neutral, float positive, float compound) {
            this.negative = negative;
            this.neutral = neutral;
            this.positive = positive;
            this.compound = compound;
        }

        @JsonProperty("neg")
        private float negative;
        @JsonProperty("neu")
        private float neutral;
        @JsonProperty("pos")
        private float positive;
        @JsonProperty("compound")
        private float compound;

        public float getNegative() {
            return negative;
        }

        public void setNegative(float negative) {
            this.negative = negative;
        }

        public float getNeutral() {
            return neutral;
        }

        public void setNeutral(float neutral) {
            this.neutral = neutral;
        }

        public float getPositive() {
            return positive;
        }

        public void setPositive(float positive) {
            this.positive = positive;
        }

        public float getCompound() {
            return compound;
        }

        public void setCompound(float compound) {
            this.compound = compound;
        }
    }
}
