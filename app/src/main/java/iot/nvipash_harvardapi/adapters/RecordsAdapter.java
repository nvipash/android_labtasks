package iot.nvipash_harvardapi.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import iot.nvipash_harvardapi.entities.Records;
import iot.nvipash_harvardapi.R;
import iot.nvipash_harvardapi.views.RecordsViewHolder;

public class RecordsAdapter extends RecyclerView.Adapter<RecordsViewHolder> {

    private ArrayList<Records> recordsList;

    public RecordsAdapter(ArrayList<Records> recordsList) {
        this.recordsList = recordsList;
    }

    @NonNull
    @Override
    public RecordsViewHolder onCreateViewHolder(@NonNull ViewGroup parentView, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parentView.getContext());
        View view = layoutInflater.inflate(R.layout.single_record_view, parentView, false);
        return new RecordsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordsViewHolder viewHolder, int position) {
        viewHolder.recordsTitle.setText(recordsList.get(position).getTitle());
        viewHolder.recordsCreditLine
                .setText(recordsList.get(position).getCreditLine());
        viewHolder.recordsDimensions
                .setText(recordsList.get(position).getDimensions());
        Picasso.with(viewHolder.itemView.getContext())
                .load(recordsList.get(position).getPrimaryImageUrl())
                .fit().centerCrop().into(viewHolder.recordsPrimaryImage);
    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }
}