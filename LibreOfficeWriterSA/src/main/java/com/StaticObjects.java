package com;

public class StaticObjects {
    public static String baseUrl="https://bugs.documentfoundation.org/";
    public static String productsUrl="rest/product/";
    public static String product="LibreOffice";
    //usage : bug?product={name}&component={name}&version={name}
    public static String bugsUrl="rest/bug";
    public static String bugSearchUrl="?product=%s&component=%s&version=%s";
    //usage : bugsUrl/(bug id or bug name)/commentsUrl
    public static String commentsUrl="/%d/comment";
    public static String MCSubscriptionKey="d7d3b4751e27d48d4cd67bf92b207761";

    public static String CONFIG_FETCH_PRODUCTS="FETCH_PRODUCTS";
    public static String CONFIG_AUTO_ACTIVATE="AUTO_ACTIVATE";
    public static String CONFIG_FETCH_BUGS="FETCH_BUGS";
    public static String CONFIG_FETCH_COMMENTS="FETCH_COMMENTS";
    public static String CONFIG_ANALYZE_WITH_VADER="USE_VADER";
    public static String CONFIG_ANALYZE_WITH_MC="USE_MEANINGCLOUD";
    public static String CONFIG_EXPORT_FROM_VADER="EXPORT_VADER";
    public static String CONFIG_EXPORT_FROM_MC="EXPORT_MC";
    public static String CONFIG_EXPORT_BY_BUGS="EXPORT_BUGS_ONLY";
    public static String CONFIG_EXPORT_BY_COMMENTS="EXPORT_COMMENTS_ONLY";
    public static String CONFIG_OVERRIDE_BASEURL="OVERRIDE_API";
    public static String CONFIG_OVERRIDE_PRODUCT="OVERRIDE_PRODUCT";
    public static String CONFIG_OVERRIDE_MC_SUB_KEY="MC_SUB_KEY";

}
