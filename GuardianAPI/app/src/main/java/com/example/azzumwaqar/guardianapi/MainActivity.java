package com.example.azzumwaqar.guardianapi;

import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsFeed>>{

    private TextView emptyStateTextView;
    private ProgressBar progressBar;
    private ListView newsFeedListView;
    private NewsAdapter adapter;

    private static final int NEWSFEED_LOADER_ID =1;

    private static final String GUARDIAN_API_URL = "http://content.guardianapis.com/search?&show-tags=contributor&q=debates&api-key=bd204a3a-e27d-4f11-93c3-3e392bb3214b";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsFeedListView = findViewById(R.id.list);
        emptyStateTextView = findViewById(R.id.emptyStateTextView);
        progressBar = findViewById(R.id.progressBar);

        adapter = new NewsAdapter(this,new ArrayList<NewsFeed>());

        newsFeedListView.setAdapter(adapter);

        newsFeedListView.setEmptyView(emptyStateTextView);

        newsFeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsFeed currentNewsFeed = adapter.getItem(position);

                Uri webpage = Uri.parse(currentNewsFeed.getUrl());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW,webpage);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

        ConnectivityManager cm = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if(activeNetwork != null && activeNetwork.isConnectedOrConnecting()){
            getLoaderManager().initLoader(NEWSFEED_LOADER_ID,null,this);
        }else{
            progressBar.setVisibility(View.GONE);

            emptyStateTextView.setText(R.string.NoInternetInfo);
        }
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        Log.i("MainActivity: ","OnCreateLoader executing...");
        return new NewsFeedLoader(this,GUARDIAN_API_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsFeed>> loader, List<NewsFeed> data) {
        adapter.clear();

        progressBar.setVisibility(View.GONE);

        emptyStateTextView.setText(R.string.NoNewsInfo);

        if(data!=null && !data.isEmpty()) {
            adapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader loader) {
        //loader reset so that we can clear out our existing data
        adapter.clear();
    }

    public static class NewsFeedLoader extends AsyncTaskLoader<List<NewsFeed>> {
        /**
         * can access static data members or outer clss including private
         * cannot access non-static data members or methods
         * */

        private String mUrl;

        private static final String LOG_TAG = NewsFeedLoader.class.getName();


        //construct
        public NewsFeedLoader(Context context, String url) {
            super(context);
            Log.e("NEWSFEEDLOAD CONSTRUCT","NewsFeedLoader executing...");
            mUrl = url;
        }

        @Override
        protected void onStartLoading() {
            Log.e("MainActivity","OnStartLoading executing...");
            forceLoad();
        }

        @Override
        public List<NewsFeed> loadInBackground() {
            Log.e("MainActivity","LoadinBackground executing...");

            if(mUrl ==null){
                return null;
            }
            List<NewsFeed> result = Utils.fetchNewsFeedData(mUrl);

            return result;
        }
    }
}
