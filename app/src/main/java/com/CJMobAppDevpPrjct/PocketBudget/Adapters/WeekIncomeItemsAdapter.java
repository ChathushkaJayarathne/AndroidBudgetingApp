package com.CJMobAppDevpPrjct.PocketBudget.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.CJMobAppDevpPrjct.PocketBudget.Model.Data;
import com.CJMobAppDevpPrjct.PocketBudget.R;

import java.util.List;

public class WeekIncomeItemsAdapter extends RecyclerView.Adapter<WeekIncomeItemsAdapter.ViewHolder> {

    private Context mContext;
    private List<Data> myDataList;


    public WeekIncomeItemsAdapter(Context mContext, List<Data> myDataList) {
        this.mContext = mContext;
        this.myDataList = myDataList;
    }

    @NonNull
    @Override
    public WeekIncomeItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.retrieve_layout,parent,false);
        return new WeekIncomeItemsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeekIncomeItemsAdapter.ViewHolder holder, int position) {

        final Data data = myDataList.get(position);

        holder.item.setText("Category: "+data.getItem());
        holder.amount.setText("Received: "+data.getAmount());
        holder.date.setText("On "+data.getDate());
        holder.note.setText("Note: "+data.getNotes());


        switch (data.getItem()) {
            case "Salary":
                holder.imageView.setImageResource(R.drawable.salary);
                break;
            case "Investment":
                holder.imageView.setImageResource(R.drawable.investment);
                break;
            case "Gifts":
                holder.imageView.setImageResource(R.drawable.gifts);
                break;
            case "Other":
                holder.imageView.setImageResource(R.drawable.ic_other);
                break;

        }

    }

    @Override
    public int getItemCount() {
        return myDataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView item,amount,date,note;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item);
            note = itemView.findViewById(R.id.notes);
            amount = itemView.findViewById(R.id.amount);
            date = itemView.findViewById(R.id.date);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
