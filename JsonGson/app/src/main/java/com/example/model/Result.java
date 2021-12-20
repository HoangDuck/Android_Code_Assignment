package com.example.model;

public class Result {
    private String url;
    private String tittleNoFormating;

    public Result() {
    }

    public Result(String url, String tittleNoFormating) {
        this.url = url;
        this.tittleNoFormating = tittleNoFormating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTittleNoFormating() {
        return tittleNoFormating;
    }

    public void setTittleNoFormating(String tittleNoFormating) {
        this.tittleNoFormating = tittleNoFormating;
    }

    @Override
    public String toString() {
        return "Result{" +
                "url='" + url + '\'' +
                ", tittleNoFormating='" + tittleNoFormating + '\'' +
                '}';
    }
}
