package com.example.vcare;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JournalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private static int TYPE_PROMPT = 1;
    private static int TYPE_QUOTE = 2;
    private ArrayList<JournalEntry> entries;
    private Context context;

    public JournalAdapter(Context ct, ArrayList<JournalEntry> items){
        context = ct;
        entries = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_PROMPT){
            //Display prompt layout
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_prompt, parent, false);
            return new PromptViewHolder(view);
        }
        else{
            //Display quote layout
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_quote, parent, false);
            return new QuoteViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(entries.get(position).isPrompt()){
            return TYPE_PROMPT;
        }
        else{
            return TYPE_QUOTE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_PROMPT){
            ((PromptViewHolder) holder).promptTxt.setText(entries.get(position).getTxt());

            if(position % 2 == 0){
                ((PromptViewHolder) holder).cardView.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                R.color.white
                        )
                );
            } else{
                ((PromptViewHolder) holder).cardView.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                R.color.light_green
                        )
                );
            }
        }
        else{
            ((QuoteViewHolder) holder).quoteTxt.setText(entries.get(position).getTxt());

            if(position % 2 == 0){
                ((QuoteViewHolder) holder).cardView.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                R.color.white
                        )
                );
            } else{
                ((QuoteViewHolder) holder).cardView.setBackgroundColor(
                        ContextCompat.getColor(
                                context,
                                R.color.light_green
                        )
                );
            }
        }

    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public class PromptViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView promptTxt;

        public PromptViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.promptCardView);
            promptTxt = itemView.findViewById(R.id.promptTxt);
        }
    }

    public class QuoteViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView quoteTxt;

        public QuoteViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.quoteCardView);
            quoteTxt = itemView.findViewById(R.id.quoteTxt);
        }
    }
}