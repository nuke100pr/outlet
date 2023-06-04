package com.example.outlet_3.bottom_fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.outlet_3.R;


public class browse_f extends Fragment {

    RecyclerView rvBrowse;
    public browse_f() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_browse_f, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String [] h = {"Shop Mate","Lost and Found","Travel Buddy","Twitro","Treasure Trove","Quizmania","Donate to AWC","Donate to Outlet","Study Materials","Twitro","Movie Corner","Photo of the week","Confession Corner","Challenge Others","Meme Corner","CGPA Guesser","Bus Timetable","News","FILLER","FILLER","FILLER","FILLER"};
        rvBrowse = view.findViewById(R.id.rv_browse);
        rvBrowse.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_browse_adapter rvadapter = new rv_browse_adapter(h);
        rvBrowse.setAdapter(rvadapter);
    }
}