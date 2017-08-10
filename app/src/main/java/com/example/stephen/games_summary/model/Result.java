
package com.example.stephen.games_summary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Result extends RealmObject  {

    @SerializedName("aliases")
    @Expose
    private String aliases;
    @SerializedName("api_detail_url")
    @Expose
    private String apiDetailUrl;
    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("date_last_updated")
    @Expose
    private String dateLastUpdated;
    @SerializedName("deck")
    @Expose
    private String deck;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("expected_release_day")
    @Expose
    private int expectedReleaseDay;
    @SerializedName("expected_release_month")
    @Expose
    private int expectedReleaseMonth;
    @SerializedName("expected_release_quarter")
    @Expose
    private int expectedReleaseQuarter;
    @SerializedName("expected_release_year")
    @Expose
    private int expectedReleaseYear;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number_of_user_reviews")
    @Expose
    private int numberOfUserReviews;
    @SerializedName("original_game_rating")
    @Expose
    private RealmList<Document> originalGameRating = null;
    @SerializedName("original_release_date")
    @Expose
    private String originalReleaseDate;
    @SerializedName("platforms")
    @Expose
    private RealmList<Platform> platforms = null;
    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;
    @SerializedName("score")
    @Expose
    private int score;
    @SerializedName("reviewer")
    @Expose
    private String reviewer;
    @SerializedName("reviews")
    @Expose
    private RealmList<Document> reviews;

    public RealmList<Document> getReviews() {
        return reviews;
    }

    public void setReviews(RealmList<Document> reviews) {
        this.reviews = reviews;
    }

    public int getScore() {
        return score;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    public String getApiDetailUrl() {
        return apiDetailUrl;
    }

    public void setApiDetailUrl(String apiDetailUrl) {
        this.apiDetailUrl = apiDetailUrl;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExpectedReleaseDay() {
        return expectedReleaseDay;
    }

    public void setExpectedReleaseDay(int expectedReleaseDay) {
        this.expectedReleaseDay = expectedReleaseDay;
    }

    public int getExpectedReleaseMonth() {
        return expectedReleaseMonth;
    }

    public void setExpectedReleaseMonth(int expectedReleaseMonth) {
        this.expectedReleaseMonth = expectedReleaseMonth;
    }

    public int getExpectedReleaseQuarter() {
        return expectedReleaseQuarter;
    }

    public void setExpectedReleaseQuarter(int expectedReleaseQuarter) {
        this.expectedReleaseQuarter = expectedReleaseQuarter;
    }

    public int getExpectedReleaseYear() {
        return expectedReleaseYear;
    }

    public void setExpectedReleaseYear(int expectedReleaseYear) {
        this.expectedReleaseYear = expectedReleaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfUserReviews() {
        return numberOfUserReviews;
    }

    public void setNumberOfUserReviews(int numberOfUserReviews) {
        this.numberOfUserReviews = numberOfUserReviews;
    }

    public RealmList<Document> getOriginalGameRating() {
        return originalGameRating;
    }

    public void setOriginalGameRating(RealmList<Document> originalGameRating) {
        this.originalGameRating = originalGameRating;
    }

    public String getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    public void setOriginalReleaseDate(String originalReleaseDate) {
        this.originalReleaseDate = originalReleaseDate;
    }

    public RealmList<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(RealmList<Platform> platforms) {
        this.platforms = platforms;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }
}
