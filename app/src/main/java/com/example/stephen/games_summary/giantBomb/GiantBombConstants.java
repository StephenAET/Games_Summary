package com.example.stephen.games_summary.giantBomb;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GiantBombConstants {

    /**
     * Base URL for all Giant Bomb RequestArray
     */
    public static final String BASE_URL = "http://www.giantbomb.com/api/";

    /**
     * API Key is required to make Giant Bomb Requests
     */
    public static final String API_KEY_QUERY = "api_key";
    public static final String API_KEY_VALUE = "1ea38da7024e688b72884542c417a0dcdab6b80e";

    /**
     * Unless specified, the request will return html
     */
    public static final String FORMAT_QUERY = "format";
    public static final String JSON = "json";

    public static final String ID_PATH = "id";

    /**
     * Used for filtering Results
     */
    public static final String FILTER_QUERY = "filter";

    /**
     * Limit number of results
     */
    public static final String LIMIT_QUERY = "limit";

    /**
     * Get Data
     */
    public static final String GAME_PATH = "game/";
    public static final String GAMES_PATH = "games/";
    public static final String GENRES_PATH = "genres/";
    public static final String REVIEWS_PATH = "review/";

    public static final String NAME_FILTER = "name=";
    public static final String GENRE_FILTER = "genre=";

    public static final String SORT_QUERY = "sort";
    public static final String DATE_DESC = "original_release_date:desc";
}