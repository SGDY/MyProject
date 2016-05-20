package com.example.myapplication.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.NewsAdapter;
import com.example.myapplication.entity.News;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * A simple {@link Fragment} subclass.
 */
public class NewsTitleFragment extends Fragment {

    private ListView newsTitleListView;

    private List<News> newsList;

    private NewsAdapter adapter;

    public NewsTitleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        adapter = new NewsAdapter(getActivity(), R.layout.news_item, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        newsTitleListView = (ListView)view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener((parent, view1, position, id) -> {
            News news = newsList.get(position);

            NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        });
        return view;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList();
        News news1 = new News();
        news1.setTitle("title1");
        news1.setContent("content1");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("title2");
        news2.setContent("content2");
        newsList.add(news2);
        return newsList;
    }
}
