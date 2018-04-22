package com.example.azzumwaqar.guardianapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class NewsAdapter extends ArrayAdapter<NewsFeed> {

    public NewsAdapter(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        if(listView ==null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        NewsFeed currentNewsFeed = getItem(position);

        TextView titleTextView = listView.findViewById(R.id.titleTextView);
        TextView sectionTextView = listView.findViewById(R.id.sectionTextView);
        TextView dateTextView = listView.findViewById(R.id.dateTextView);

        titleTextView.setText(currentNewsFeed.getTitle());
        sectionTextView.setText(currentNewsFeed.getSection());
        dateTextView.setText(String.valueOf(currentNewsFeed.getDate()));


        return listView;
    }
}
