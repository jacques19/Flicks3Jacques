package com.ingrayy.flicks.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {

    // the base url for loading images
    String imagesBaseUrl;
    // the poster size to use when fetching image, of the url
    String posterSize;
    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        // get the image base url
        imagesBaseUrl = images.getString("secure_base_url");
        // get the poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        // use the option at index 3 or w342 as a fallback
        posterSize = posterSizeOptions.optString(3,"w342");

    }

    // helper method for creating urls
    public String getImageUrl(String size ,String path){
        return String.format("%s%s%s",imagesBaseUrl,size ,path); // concatenate all three
    }
    public String getImagesBaseUrl() {
        return imagesBaseUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }
}
