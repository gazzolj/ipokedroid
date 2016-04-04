package com.example.gazzol_j.ipokedroid.TeamPackage;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gazzol_j.ipokedroid.R;
import com.example.gazzol_j.ipokedroid.TeamPackage.sql.TeamDb;

import java.util.List;


public class TeamFragment extends Fragment {
    TextView helper;
    ListView teamList;
    FloatingActionButton buttonAdd;
    TeamListAdapter adapter;
    TeamDb teamDb;
    List<Team> teams;

    public static TeamFragment newInstance(){
        TeamFragment teamFragment = new TeamFragment();
        return teamFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        teamDb = new TeamDb(getContext());
        teams = teamDb.getTeams();
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.team_list, container, false);

        helper = (TextView) view.findViewById(R.id.helper);
        teamList = (ListView) view.findViewById(R.id.team_listview);
        adapter = new TeamListAdapter(getContext(), view.getId(), teams);
        teamList.setAdapter(adapter);

        buttonAdd = (FloatingActionButton) view.findViewById(R.id.floatting_button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TeamBuilderActivity.class);
                getContext().startActivity(i);
            }
        });
        return view;
    }

    public void refresh() {
        teams = teamDb.getTeams();
        adapter.clear();
        adapter.addAll(teams);
        adapter.notifyDataSetChanged();
        if (teams.size() == 0) {
            helper.setVisibility(View.VISIBLE);
            teamList.setVisibility(View.GONE);
        } else {
            helper.setVisibility(View.GONE);
            teamList.setVisibility(View.VISIBLE);
        }
    }
}