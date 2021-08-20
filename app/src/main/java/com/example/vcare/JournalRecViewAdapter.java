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

public class JournalRecViewAdapter extends RecyclerView.Adapter<JournalRecViewAdapter.ViewHolder>{
    private ArrayList<String> journalPrompts = new ArrayList<>();

    private Context context;
    public JournalRecViewAdapter(Context context){
        this.context = context;
    }
    public void setJournalPrompts(ArrayList<String> journalPrompts){
        this.journalPrompts = journalPrompts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JournalRecViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.prompt_list, parent, false);
        JournalRecViewAdapter.ViewHolder holder = new JournalRecViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull JournalRecViewAdapter.ViewHolder holder, int position) {
        holder.prompt.setText(journalPrompts.get(position));
        String promptString = (String) holder.prompt.getText();
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, JournalPage.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return journalPrompts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView prompt;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            prompt = itemView.findViewById(R.id.promptTxt);

        }
    }
}
