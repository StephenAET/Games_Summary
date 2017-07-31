package com.example.stephen.games_summary.giantBomb;

/**
 * Created by Stephen on 31/07/2017.
 */

public class GiantBombConstants {

    /**
     * Base URL for all Giant Bomb Request
     */
    public static final String BASE_URL = "http://www.giantbomb.com/api/";

    /**
     * API Key is required to make Giant Bomb Requests
     */
    public static final String Q_API_KEY = "api_key";
    public static final String V_API_KEY = "1ea38da7024e688b72884542c417a0dcdab6b80e";

    /**
     * Unless specified, the request will return html
     */
    public static final String Q_FORMAT = "format";
    public static final String V_FORMAT = "json";

    public static final String P_ID = "id";

    /**
     * Used for filtering Results
     */
    public static final String Q_FILTER = "filter";

    /**
     * Limit number of results
     */
    public static final String Q_LIMIT = "limit";

    /**
     * Get Data
     */
    public static final String B_GAME = "game/";
    public static final String B_GAMES = "games/";
    public static final String B_GENRES = "genres/";
}