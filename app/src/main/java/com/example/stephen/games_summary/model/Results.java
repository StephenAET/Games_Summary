
package com.example.stephen.games_summary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

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
    private java.lang.Object expectedReleaseDay;
    @SerializedName("expected_release_month")
    @Expose
    private java.lang.Object expectedReleaseMonth;
    @SerializedName("expected_release_quarter")
    @Expose
    private java.lang.Object expectedReleaseQuarter;
    @SerializedName("expected_release_year")
    @Expose
    private java.lang.Object expectedReleaseYear;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("number_of_user_reviews")
    @Expose
    private Integer numberOfUserReviews;
    @SerializedName("original_game_rating")
    @Expose
    private List<OriginalGameRating> originalGameRating = null;
    @SerializedName("original_release_date")
    @Expose
    private String originalReleaseDate;
    @SerializedName("platforms")
    @Expose
    private List<Platform> platforms = null;
    @SerializedName("site_detail_url")
    @Expose
    private String siteDetailUrl;
    @SerializedName("images")
    @Expose
    private List<Image_> images = null;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;
    @SerializedName("characters")
    @Expose
    private List<Character> characters = null;
    @SerializedName("concepts")
    @Expose
    private List<Concept> concepts = null;
    @SerializedName("developers")
    @Expose
    private List<Developer> developers = null;
    @SerializedName("first_appearance_characters")
    @Expose
    private List<FirstAppearanceCharacter> firstAppearanceCharacters = null;
    @SerializedName("first_appearance_concepts")
    @Expose
    private List<FirstAppearanceConcept> firstAppearanceConcepts = null;
    @SerializedName("first_appearance_locations")
    @Expose
    private List<FirstAppearanceLocation> firstAppearanceLocations = null;
    @SerializedName("first_appearance_objects")
    @Expose
    private List<FirstAppearanceObject> firstAppearanceObjects = null;
    @SerializedName("first_appearance_people")
    @Expose
    private List<FirstAppearancePerson> firstAppearancePeople = null;
    @SerializedName("franchises")
    @Expose
    private List<Franchise> franchises = null;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = null;
    @SerializedName("killed_characters")
    @Expose
    private java.lang.Object killedCharacters;
    @SerializedName("locations")
    @Expose
    private List<Location> locations = null;
    @SerializedName("objects")
    @Expose
    private List<Object> objects = null;
    @SerializedName("people")
    @Expose
    private List<Person> people = null;
    @SerializedName("publishers")
    @Expose
    private List<Publisher> publishers = null;
    @SerializedName("releases")
    @Expose
    private List<Release> releases = null;
    @SerializedName("dlcs")
    @Expose
    private List<Dlc> dlcs = null;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;
    @SerializedName("similar_games")
    @Expose
    private List<SimilarGame> similarGames = null;
    @SerializedName("themes")
    @Expose
    private List<Theme> themes = null;

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

    public java.lang.Object getExpectedReleaseDay() {
        return expectedReleaseDay;
    }

    public void setExpectedReleaseDay(java.lang.Object expectedReleaseDay) {
        this.expectedReleaseDay = expectedReleaseDay;
    }

    public java.lang.Object getExpectedReleaseMonth() {
        return expectedReleaseMonth;
    }

    public void setExpectedReleaseMonth(java.lang.Object expectedReleaseMonth) {
        this.expectedReleaseMonth = expectedReleaseMonth;
    }

    public java.lang.Object getExpectedReleaseQuarter() {
        return expectedReleaseQuarter;
    }

    public void setExpectedReleaseQuarter(java.lang.Object expectedReleaseQuarter) {
        this.expectedReleaseQuarter = expectedReleaseQuarter;
    }

    public java.lang.Object getExpectedReleaseYear() {
        return expectedReleaseYear;
    }

    public void setExpectedReleaseYear(java.lang.Object expectedReleaseYear) {
        this.expectedReleaseYear = expectedReleaseYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getNumberOfUserReviews() {
        return numberOfUserReviews;
    }

    public void setNumberOfUserReviews(Integer numberOfUserReviews) {
        this.numberOfUserReviews = numberOfUserReviews;
    }

    public List<OriginalGameRating> getOriginalGameRating() {
        return originalGameRating;
    }

    public void setOriginalGameRating(List<OriginalGameRating> originalGameRating) {
        this.originalGameRating = originalGameRating;
    }

    public String getOriginalReleaseDate() {
        return originalReleaseDate;
    }

    public void setOriginalReleaseDate(String originalReleaseDate) {
        this.originalReleaseDate = originalReleaseDate;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public String getSiteDetailUrl() {
        return siteDetailUrl;
    }

    public void setSiteDetailUrl(String siteDetailUrl) {
        this.siteDetailUrl = siteDetailUrl;
    }

    public List<Image_> getImages() {
        return images;
    }

    public void setImages(List<Image_> images) {
        this.images = images;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public List<Concept> getConcepts() {
        return concepts;
    }

    public void setConcepts(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<FirstAppearanceCharacter> getFirstAppearanceCharacters() {
        return firstAppearanceCharacters;
    }

    public void setFirstAppearanceCharacters(List<FirstAppearanceCharacter> firstAppearanceCharacters) {
        this.firstAppearanceCharacters = firstAppearanceCharacters;
    }

    public List<FirstAppearanceConcept> getFirstAppearanceConcepts() {
        return firstAppearanceConcepts;
    }

    public void setFirstAppearanceConcepts(List<FirstAppearanceConcept> firstAppearanceConcepts) {
        this.firstAppearanceConcepts = firstAppearanceConcepts;
    }

    public List<FirstAppearanceLocation> getFirstAppearanceLocations() {
        return firstAppearanceLocations;
    }

    public void setFirstAppearanceLocations(List<FirstAppearanceLocation> firstAppearanceLocations) {
        this.firstAppearanceLocations = firstAppearanceLocations;
    }

    public List<FirstAppearanceObject> getFirstAppearanceObjects() {
        return firstAppearanceObjects;
    }

    public void setFirstAppearanceObjects(List<FirstAppearanceObject> firstAppearanceObjects) {
        this.firstAppearanceObjects = firstAppearanceObjects;
    }

    public List<FirstAppearancePerson> getFirstAppearancePeople() {
        return firstAppearancePeople;
    }

    public void setFirstAppearancePeople(List<FirstAppearancePerson> firstAppearancePeople) {
        this.firstAppearancePeople = firstAppearancePeople;
    }

    public List<Franchise> getFranchises() {
        return franchises;
    }

    public void setFranchises(List<Franchise> franchises) {
        this.franchises = franchises;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public java.lang.Object getKilledCharacters() {
        return killedCharacters;
    }

    public void setKilledCharacters(java.lang.Object killedCharacters) {
        this.killedCharacters = killedCharacters;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    public List<Release> getReleases() {
        return releases;
    }

    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

    public List<Dlc> getDlcs() {
        return dlcs;
    }

    public void setDlcs(List<Dlc> dlcs) {
        this.dlcs = dlcs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<SimilarGame> getSimilarGames() {
        return similarGames;
    }

    public void setSimilarGames(List<SimilarGame> similarGames) {
        this.similarGames = similarGames;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

}
