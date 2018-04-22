package com.example.azzumwaqar.guardianapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //adapter
    private NewsAdapter adapter;

    private static final String GUARDIAN_API_URL = "http://content.guardianapis.com/search?api-key=bd204a3a-e27d-4f11-93c3-3e392bb3214b";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView newsFeedListView = findViewById(R.id.list);

        adapter = new NewsAdapter(this,new ArrayList<NewsFeed>());

        newsFeedListView.setAdapter(adapter);

        NewsFeedAsyncTask task = new NewsFeedAsyncTask();
        task.execute(GUARDIAN_API_URL);

    }

    private class NewsFeedAsyncTask extends AsyncTask<String,Void,List<NewsFeed>>{

        @Override
        protected List<NewsFeed> doInBackground(String... urls) {
            if(urls.length<1 || urls[0]==null){
                return null;
            }

            List<NewsFeed> newsFeedList = Utils.fetchNewsFeedData(urls[0]);
            return  newsFeedList;
        }

        @Override
        protected void onPostExecute(List<NewsFeed> newsFeeds) {
            adapter.clear();
            if(newsFeeds!=null && !newsFeeds.isEmpty()){
                adapter.addAll(newsFeeds);
            }
        }
    }
}
