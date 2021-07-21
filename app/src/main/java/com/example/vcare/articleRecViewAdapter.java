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

public class articleRecViewAdapter extends RecyclerView.Adapter<articleRecViewAdapter.ViewHolder>{

    private ArrayList<Article> articles = new ArrayList<>(); //Currently displays Article objects

    private Context context;
    public articleRecViewAdapter(Context context) {
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
        holder.articleName.setText(articles.get(position).getTitle());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                //context.startActivity(ArticleActivity.class); => Navigate to article screen
                //finish();
            }
        });
        //Set correct color
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
        return articles.size();
    }

    public void setArticles(ArrayList<Article> articles){
        this.articles = articles;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView articleName;
        private CardView parent;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            articleName = itemView.findViewById(R.id.articleTitleTxt);
        }
    }
}
