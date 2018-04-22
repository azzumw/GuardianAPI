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

//    private static final String JSON_RESPONSE = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":2026011,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":202602,\"orderBy\":\"newest\",\"results\":[{\"id\":\"football/live/2018/apr/14/liverpool-v-bournemouth-premier-league-live\",\"type\":\"liveblog\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2018-04-14T17:49:50Z\",\"webTitle\":\"Liverpool v Bournemouth: Premier League – live!\",\"webUrl\":\"https://www.theguardian.com/football/live/2018/apr/14/liverpool-v-bournemouth-premier-league-live\",\"apiUrl\":\"https://content.guardianapis.com/football/live/2018/apr/14/liverpool-v-bournemouth-premier-league-live\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"football/live/2018/apr/14/tottenham-hotspur-v-manchester-city-premier-league-live\",\"type\":\"liveblog\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2018-04-14T17:48:37Z\",\"webTitle\":\"Tottenham Hotspur v Manchester City: Premier League – live!\",\"webUrl\":\"https://www.theguardian.com/football/live/2018/apr/14/tottenham-hotspur-v-manchester-city-premier-league-live\",\"apiUrl\":\"https://content.guardianapis.com/football/live/2018/apr/14/tottenham-hotspur-v-manchester-city-premier-league-live\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"sport/2018/apr/14/warrington-hull-kr-super-league-match-report\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2018-04-14T17:33:00Z\",\"webTitle\":\"Warrington remain in winning form as Kevin Brown ends Hull KR revival\",\"webUrl\":\"https://www.theguardian.com/sport/2018/apr/14/warrington-hull-kr-super-league-match-report\",\"apiUrl\":\"https://content.guardianapis.com/sport/2018/apr/14/warrington-hull-kr-super-league-match-report\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"football/2018/apr/14/mark-hughes-southampton-chelsea-mike-dean-marcus-alonso-tackle\",\"type\":\"article\",\"sectionId\":\"football\",\"sectionName\":\"Football\",\"webPublicationDate\":\"2018-04-14T17:24:13Z\",\"webTitle\":\"Chelsea’s Marcos Alonso should have been sent off, claims Mark Hughes\",\"webUrl\":\"https://www.theguardian.com/football/2018/apr/14/mark-hughes-southampton-chelsea-mike-dean-marcus-alonso-tackle\",\"apiUrl\":\"https://content.guardianapis.com/football/2018/apr/14/mark-hughes-southampton-chelsea-mike-dean-marcus-alonso-tackle\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"},{\"id\":\"commentisfree/2018/apr/14/rome-extreme-weather-events-italy\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2018-04-14T17:15:27Z\",\"webTitle\":\"Rome wasn’t built in a day but these days it feels as if it may collapse in one | Tobias Jones\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2018/apr/14/rome-extreme-weather-events-italy\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2018/apr/14/rome-extreme-weather-events-italy\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"world/live/2018/apr/14/syria-donald-trump-announcement-chemical-attack-live\",\"type\":\"liveblog\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-14T17:05:39Z\",\"webTitle\":\"Syria latest: US 'locked and loaded' if chemical weapons used again – live\",\"webUrl\":\"https://www.theguardian.com/world/live/2018/apr/14/syria-donald-trump-announcement-chemical-attack-live\",\"apiUrl\":\"https://content.guardianapis.com/world/live/2018/apr/14/syria-donald-trump-announcement-chemical-attack-live\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"music/2018/apr/14/one-to-watch-sasha-sloan-sad-girl\",\"type\":\"article\",\"sectionId\":\"music\",\"sectionName\":\"Music\",\"webPublicationDate\":\"2018-04-14T17:00:27Z\",\"webTitle\":\"One to watch: Sasha Sloan\",\"webUrl\":\"https://www.theguardian.com/music/2018/apr/14/one-to-watch-sasha-sloan-sad-girl\",\"apiUrl\":\"https://content.guardianapis.com/music/2018/apr/14/one-to-watch-sasha-sloan-sad-girl\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"science/2018/apr/14/ellen-hendriksen-we-are-each-our-own-worst-critic-social-anxiety-disorder-interview\",\"type\":\"article\",\"sectionId\":\"science\",\"sectionName\":\"Science\",\"webPublicationDate\":\"2018-04-14T17:00:27Z\",\"webTitle\":\"Psychologist Ellen Hendriksen: ‘We are each our own worst critic’\",\"webUrl\":\"https://www.theguardian.com/science/2018/apr/14/ellen-hendriksen-we-are-each-our-own-worst-critic-social-anxiety-disorder-interview\",\"apiUrl\":\"https://content.guardianapis.com/science/2018/apr/14/ellen-hendriksen-we-are-each-our-own-worst-critic-social-anxiety-disorder-interview\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"artanddesign/2018/apr/14/big-picture-new-york-racial-divide-1960s\",\"type\":\"article\",\"sectionId\":\"artanddesign\",\"sectionName\":\"Art and design\",\"webPublicationDate\":\"2018-04-14T17:00:27Z\",\"webTitle\":\"The big picture: Window Nurses, NYC, 1966\",\"webUrl\":\"https://www.theguardian.com/artanddesign/2018/apr/14/big-picture-new-york-racial-divide-1960s\",\"apiUrl\":\"https://content.guardianapis.com/artanddesign/2018/apr/14/big-picture-new-york-racial-divide-1960s\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"sport/2018/apr/14/tiger-roll-holds-on-to-win-dramatic-grand-national-photo-finish-davy-russell-horse-racing\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2018-04-14T16:48:35Z\",\"webTitle\":\"Tiger Roll holds on to win dramatic Grand National in photo-finish\",\"webUrl\":\"https://www.theguardian.com/sport/2018/apr/14/tiger-roll-holds-on-to-win-dramatic-grand-national-photo-finish-davy-russell-horse-racing\",\"apiUrl\":\"https://content.guardianapis.com/sport/2018/apr/14/tiger-roll-holds-on-to-win-dramatic-grand-national-photo-finish-davy-russell-horse-racing\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"}]}}";

//    private static final String JSON_SYRIA = "{\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":25174,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":2518,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"world/2018/apr/12/thursday-briefing-syria-decision-time-for-may\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-12T05:26:18Z\",\"webTitle\":\"Thursday briefing: Syria decision time for May\",\"webUrl\":\"https://www.theguardian.com/world/2018/apr/12/thursday-briefing-syria-decision-time-for-may\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/apr/12/thursday-briefing-syria-decision-time-for-may\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/apr/10/signs-of-tory-division-over-uk-support-for-us-assault-on-syria\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-04-10T10:45:53Z\",\"webTitle\":\"Retaliation in Syria: what are May's options?\",\"webUrl\":\"https://www.theguardian.com/politics/2018/apr/10/signs-of-tory-division-over-uk-support-for-us-assault-on-syria\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/apr/10/signs-of-tory-division-over-uk-support-for-us-assault-on-syria\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/apr/11/syria-the-wests-response-and-international-law\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-11T16:59:34Z\",\"webTitle\":\"Syria, the west’s response and international law | Letters\",\"webUrl\":\"https://www.theguardian.com/world/2018/apr/11/syria-the-wests-response-and-international-law\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/apr/11/syria-the-wests-response-and-international-law\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/apr/14/jeremy-corbyn-calls-syria-airstrikes-legally-questionable\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-04-14T14:56:58Z\",\"webTitle\":\"Jeremy Corbyn calls Syria airstrikes legally questionable\",\"webUrl\":\"https://www.theguardian.com/politics/2018/apr/14/jeremy-corbyn-calls-syria-airstrikes-legally-questionable\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/apr/14/jeremy-corbyn-calls-syria-airstrikes-legally-questionable\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/mar/30/british-soldier-killed-explosion-syria\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-03-30T20:41:53Z\",\"webTitle\":\"British soldier killed by explosion in Syria\",\"webUrl\":\"https://www.theguardian.com/world/2018/mar/30/british-soldier-killed-explosion-syria\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/mar/30/british-soldier-killed-explosion-syria\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"commentisfree/2018/feb/27/syria-europe-moral-eu-helplessness\",\"type\":\"article\",\"sectionId\":\"commentisfree\",\"sectionName\":\"Opinion\",\"webPublicationDate\":\"2018-02-27T18:34:40Z\",\"webTitle\":\"Syria is a moral defeat for Europeans | Natalie Nougayrède\",\"webUrl\":\"https://www.theguardian.com/commentisfree/2018/feb/27/syria-europe-moral-eu-helplessness\",\"apiUrl\":\"https://content.guardianapis.com/commentisfree/2018/feb/27/syria-europe-moral-eu-helplessness\",\"isHosted\":false,\"pillarId\":\"pillar/opinion\",\"pillarName\":\"Opinion\"},{\"id\":\"world/2018/feb/22/new-russian-stealth-fighter-spotted-in-syria\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-02-22T16:14:34Z\",\"webTitle\":\"New Russian stealth fighter spotted in Syria\",\"webUrl\":\"https://www.theguardian.com/world/2018/feb/22/new-russian-stealth-fighter-spotted-in-syria\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/feb/22/new-russian-stealth-fighter-spotted-in-syria\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/apr/11/wednesday-briefing-allies-edge-closer-to-military-action-in-syria\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-11T05:25:43Z\",\"webTitle\":\"Wednesday briefing: Allies edge closer to military action in Syria\",\"webUrl\":\"https://www.theguardian.com/world/2018/apr/11/wednesday-briefing-allies-edge-closer-to-military-action-in-syria\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/apr/11/wednesday-briefing-allies-edge-closer-to-military-action-in-syria\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/apr/10/tuesday-briefing-russia-and-us-face-off-over-syria\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-10T05:27:17Z\",\"webTitle\":\"Tuesday briefing: Russia and US face off over Syria\",\"webUrl\":\"https://www.theguardian.com/world/2018/apr/10/tuesday-briefing-russia-and-us-face-off-over-syria\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/apr/10/tuesday-briefing-russia-and-us-face-off-over-syria\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/apr/12/iran-reiterates-support-for-syria-in-face-of-foreign-aggression\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-04-12T13:53:12Z\",\"webTitle\":\"Iran reiterates support for Syria in face of 'foreign aggression'\",\"webUrl\":\"https://www.theguardian.com/world/2018/apr/12/iran-reiterates-support-for-syria-in-face-of-foreign-aggression\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/apr/12/iran-reiterates-support-for-syria-in-face-of-foreign-aggression\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}]}}";
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
                int indexOfT = date.indexOf('T');
                String sub_date = date.substring(0,indexOfT);
                newsFeeds.add(new NewsFeed(title,section,sub_date));
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
