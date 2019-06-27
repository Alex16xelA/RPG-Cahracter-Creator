package pl.wroc.pwr.a236139.rpgcharactercreator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    // Init ui elements
    RecyclerView historyRecyclerView;

    // Variables
    HistoryORM h = new HistoryORM();
    List<History> historyList ;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;


    private void getData() {
        historyList = h.getAll(getActivity().getApplicationContext());
        adapter = new HistoryAdapter(historyList);
        historyRecyclerView.setAdapter(adapter);
    }


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        ButterKnife.bind(this,view);

        historyRecyclerView=(RecyclerView) view.findViewById(R.id.historyRecyclerView);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        historyRecyclerView.setLayoutManager(layoutManager);
        getData();

        Button garbage = view.findViewById(R.id.clear_button);
        garbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h.clearAll(getActivity().getApplicationContext());
                Toast.makeText(getActivity().getApplicationContext(), "The history is cleared, please refresh this page!", Toast.LENGTH_LONG).show();
            }
        });
        Button refresh = view.findViewById(R.id.refresh_button);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().recreate();
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

}
