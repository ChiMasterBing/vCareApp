package com.example.vcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuoteRecViewAdapter extends RecyclerView.Adapter<QuoteRecViewAdapter.ViewHolder> {
    private ArrayList<Quote> quotes = new ArrayList<>();

    private Context context;
    public QuoteRecViewAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.quoteName.setText(quotes.get(position).getQuoteTxt());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //context.startActivity(QuoteActivity.class); => Navigate to quote screen
                //finish();
            }
        });
        int color;
        if (position % 4 == 0){
            color = context.getResources().getColor(R.color.colorPrimaryDark);
        }
        else if (position % 4 == 1){
            color = context.getResources().getColor(R.color.colorPrimary);
        }
        else if (position % 4 == 2){
            color = context.getResources().getColor(R.color.colorAccent);
        }
        else{
            color = context.getResources().getColor(R.color.color4);
        }
        holder.parent.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public void setQuotes(ArrayList<Quote> quotes){
        this.quotes = quotes;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView quoteName;
        private CardView parent;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            quoteName = itemView.findViewById(R.id.articleTitleTxt);
        }
    }

}