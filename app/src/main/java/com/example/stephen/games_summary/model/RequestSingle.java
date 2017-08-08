package com.example.stephen.games_summary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestSingle {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("limit")
    @Expose
    private int limit;
    @SerializedName("offset")
    @Expose
    private int offset;
    @SerializedName("number_of_page_results")
    @Expose
    private int numberOfPageResults;
    @SerializedName("number_of_total_results")
    @Expose
    private int numberOfTotalResults;
    @SerializedName("status_code")
    @Expose
    private int statusCode;
    @SerializedName("results")
    @Expose
    private Result results = null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNumberOfPageResults() {
        return numberOfPageResults;
    }

    public void setNumberOfPageResults(int numberOfPageResults) {
        this.numberOfPageResults = numberOfPageResults;
    }

    public int getNumberOfTotalResults() {
        return numberOfTotalResults;
    }

    public void setNumberOfTotalResults(int numberOfTotalResults) {
        this.numberOfTotalResults = numberOfTotalResults;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Result getResult() {
        return results;
    }

    public void setResult(Result result) {
        this.results = result;
    }

}
