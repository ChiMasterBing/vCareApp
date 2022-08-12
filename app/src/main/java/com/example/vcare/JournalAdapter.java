package com.example.vcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder>{

    ArrayList<String> prompts;
    Context context;

    public JournalAdapter(Context ct, ArrayList<String> items){
        context = ct;
        prompts = items;
    }

    @NonNull
    @Override
    public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.prompt_list, parent, false);
        return new JournalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalViewHolder holder, int position) {
        holder.promptTxt.setText(prompts.get(position));

        if(position % 2 == 0){
            holder.cardView.setBackgroundColor(
                    ContextCompat.getColor(
                            context,
                            R.color.white
                    )
            );
        } else{
            holder.cardView.setBackgroundColor(
                    ContextCompat.getColor(
                            context,
                            R.color.light_green
                    )
            );
        }
    }

    @Override
    public int getItemCount() {
        return prompts.size();
    }

    public class JournalViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView promptTxt;

        public JournalViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.promptCardView);
            promptTxt = itemView.findViewById(R.id.promptTxt);
        }
    }
}