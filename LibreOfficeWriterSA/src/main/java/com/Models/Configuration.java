package com.Models;

public class Configuration {
    private boolean loaded;
    private boolean fetchProducts;
    private boolean autoActivate;
    private boolean fetchBugs;
    private boolean fetchComments;
    private boolean analyzeWithVader;
    private boolean analyzeWithMC;
    private boolean exportFromVader;
    private boolean exportFromMC;
    private boolean exportByBugs;
    private boolean exportOnlyComments;

    public Configuration(){
        this.loaded=false;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isFetchProducts() {
        return fetchProducts;
    }

    public void setFetchProducts(boolean fetchProducts) {
        this.fetchProducts = fetchProducts;
    }

    public boolean isFetchBugs() {
        return fetchBugs;
    }

    public void setFetchBugs(boolean fetchBugs) {
        this.fetchBugs = fetchBugs;
    }

    public boolean isFetchComments() {
        return fetchComments;
    }

    public void setFetchComments(boolean fetchComments) {
        this.fetchComments = fetchComments;
    }

    public boolean isAnalyzeWithVader() {
        return analyzeWithVader;
    }

    public void setAnalyzeWithVader(boolean analyzeWithVader) {
        this.analyzeWithVader = analyzeWithVader;
    }

    public boolean isAnalyzeWithMC() {
        return analyzeWithMC;
    }

    public void setAnalyzeWithMC(boolean analyzeWithMC) {
        this.analyzeWithMC = analyzeWithMC;
    }

    public boolean isExportFromVader() {
        return exportFromVader;
    }

    public void setExportFromVader(boolean exportFromVader) {
        this.exportFromVader = exportFromVader;
    }

    public boolean isExportFromMC() {
        return exportFromMC;
    }

    public void setExportFromMC(boolean exportFromMC) {
        this.exportFromMC = exportFromMC;
    }

    public boolean isAutoActivate() {
        return autoActivate;
    }

    public void setAutoActivate(boolean autoActivate) {
        this.autoActivate = autoActivate;
    }

    public boolean isExportByBugs() {
        return exportByBugs;
    }

    public void setExportByBugs(boolean exportByBugs) {
        this.exportByBugs = exportByBugs;
    }

    public boolean isExportOnlyComments() {
        return exportOnlyComments;
    }

    public void setExportOnlyComments(boolean exportOnlyComments) {
        this.exportOnlyComments = exportOnlyComments;
    }
}
