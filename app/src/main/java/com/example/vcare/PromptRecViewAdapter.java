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

public class PromptRecViewAdapter extends RecyclerView.Adapter<PromptRecViewAdapter.ViewHolder>{

    private ArrayList<Prompt> prompts = new ArrayList<>();
    private Context context;
    public PromptRecViewAdapter(Context context){
        this.context = context;
    }
    public PromptRecViewAdapter(Context context, ArrayList<Prompt> prompts){
        this.context = context;
        this.prompts = prompts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list, parent, false);
        PromptRecViewAdapter.ViewHolder holder = new PromptRecViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.promptName.setText(prompts.get(position).getName());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(context, JournalPage.class);
                context.startActivity(intent); // => Navigate to journal screen, add prompt info to intent
            }
        });
        //Set correct color
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
        else if (context.getClass().getName().equals("com.example.vcare.SavedPrompts")){
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
        return prompts.size();
    }

    public void setPrompts(ArrayList<Prompt> prompts){
        this.prompts = prompts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView promptName;
        private CardView parent;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            promptName = itemView.findViewById(R.id.articleTitleTxt);
        }
    }
}
