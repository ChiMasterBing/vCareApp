package com.example.vcare;

import android.content.Context;
import android.content.Intent;
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
    public static final String EXTRA_MESSAGE = "com.example.vcare.MESSAGE";
    String[] quoteInfo;

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
                quoteInfo = new String[]{quotes.get(position).getQuoteTxt(), quotes.get(position).getAuthor()};
                Intent intent = new Intent(context, DailyQuote.class);
                intent.putExtra(EXTRA_MESSAGE, quoteInfo);
                context.startActivity(intent);
            }
        });
        int color;
        if (context.getClass().getName().equals("com.example.vcare.Mindfulness")){
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
        }
        else if (context.getClass().getName().equals("com.example.vcare.SavedQuotes")){
            if (position % 9 == 0 || position % 9 == 4 || position % 9 == 8){
                color = context.getResources().getColor(R.color.colorPrimary);
            }
            else if (position % 9 == 1 || position % 9 == 5 || position % 9 == 6){
                color = context.getResources().getColor(R.color.colorAccent);
            }
            else{
                color = context.getResources().getColor(R.color.color4);
            }
        }
        else{
            color = context.getResources().getColor(R.color.colorPrimary);
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
