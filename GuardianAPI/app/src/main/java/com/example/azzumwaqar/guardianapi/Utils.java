package com.example.azzumwaqar.guardianapi;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static final String LOG_TAG = Utils.class.getSimpleName();

    private Utils(){}

    /**
     * Query the USGS dataset and return an {@link NewsFeed} object to represent a single newsfeed.
     */
    public static List<NewsFeed> fetchNewsFeedData(String requestUrl) {

        Log.e("Utils","fetchenewsdata executing...");

        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        // Extract relevant fields from the JSON response and create an {@link Event} object
        List<NewsFeed> newsFeedList = extractJSONNewsFeeds(jsonResponse);

        // Return the {@link Event}
        return newsFeedList;
    }


    public static List<NewsFeed> extractJSONNewsFeeds(String newsJSON){

        if(TextUtils.isEmpty(newsJSON)){
            return null;
        }

        try{
            //this is to force the thread to wait 2 seconds
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        List<NewsFeed> newsFeeds = new ArrayList<>();

        try{

            JSONObject rootObject = new JSONObject(newsJSON);
            JSONObject response = rootObject.getJSONObject("response");
            JSONArray resultArray = response.getJSONArray("results");

            for(int i=0;i<resultArray.length();i++){
                JSONObject jsonObject = resultArray.getJSONObject(i);

                String title = jsonObject.getString("webTitle");
                String section = jsonObject.getString("sectionName");
                String date = jsonObject.getString("webPublicationDate");
                String webUrl = jsonObject.getString("webUrl");
                int indexOfT = date.indexOf('T');
                String sub_date = date.substring(0,indexOfT);
                newsFeeds.add(new NewsFeed(title,section,sub_date,webUrl));
            }
        }catch(JSONException e){
            Log.e("Utils", "Problem parsing the newsfeed JSON results", e);
        }
        return newsFeeds;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        Log.e("HttpResponse","makeHttpResponse executing...");
        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            Log.e("MakeHttpResponse","connecting...");

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the newsFeed JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            Log.e("readFromStream","readFromStream executing...");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        Log.e("createURL","createUrl executing...");
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }
}
