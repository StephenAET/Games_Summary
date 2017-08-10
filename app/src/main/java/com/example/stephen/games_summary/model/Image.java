
package com.example.stephen.games_summary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Image extends RealmObject {

    /*
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private int id;*/

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    @SerializedName("medium_url")
    @Expose
    private String mediumUrl;

    @SerializedName("screen_url")
    @Expose
    private String screenUrl;

    @SerializedName("small_url")
    @Expose
    private String smallUrl;

    @SerializedName("super_url")
    @Expose
    private String superUrl;

    @SerializedName("thumb_url")
    @Expose
    private String thumbUrl;

    @SerializedName("tiny_url")
    @Expose
    private String tinyUrl;

    @SerializedName("tags")
    @Expose
    private String tags;

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    public String getScreenUrl() {
        return screenUrl;
    }

    public void setScreenUrl(String screenUrl) {
        this.screenUrl = screenUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getSuperUrl() {
        return superUrl;
    }

    public void setSuperUrl(String superUrl) {
        this.superUrl = superUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
