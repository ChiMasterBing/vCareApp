package com.example.vcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SavedRecViewAdapter extends RecyclerView.Adapter<SavedRecViewAdapter.ViewHolder> {

    private ArrayList<SavedItem> items = new ArrayList<>();

    private Context context;

    public SavedRecViewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SavedRecViewAdapter.ViewHolder holder, int position) {
        holder.txtTitle.setText(items.get(position).getTitle());
        int color;
        if (position % 9 == 0 || position % 9 == 4 || position % 9 == 8){
            color = context.getResources().getColor(R.color.light_green);
        }
        else if (position % 9 == 1 || position % 9 == 5 || position % 9 == 6){
            color = context.getResources().getColor(R.color.red);
        }
        else{
            color = context.getResources().getColor(R.color.peach);
        }
        holder.relLayout.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItem(ArrayList<SavedItem> item){
        this.items = item;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtTitle;
        private CardView parent;
        private RelativeLayout relLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtArticle);
            parent = itemView.findViewById(R.id.parent);
            relLayout = itemView.findViewById(R.id.relLayout);

        }
    }
}
