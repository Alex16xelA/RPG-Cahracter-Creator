package pl.wroc.pwr.a236139.rpgcharactercreator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    // Variables
    private List<History> historyList;


    public HistoryAdapter(List<History> mhistoryList) {
        historyList = mhistoryList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.history_message.setText(historyList.get(position).getContext());
        holder.data.setText(historyList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView history_message, data;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            history_message = (TextView) itemView.findViewById(R.id.character_name);
            data = (TextView) itemView.findViewById(R.id.data);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}

