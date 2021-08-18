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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FriendRecViewAdapter extends RecyclerView.Adapter<FriendRecViewAdapter.ViewHolder> {

    private ArrayList<Friend> friends;
    private Context context;

    public FriendRecViewAdapter(Context context) { this.context = context; }

    public FriendRecViewAdapter(Context context, ArrayList<Friend> friends) {
        this.context = context;
        this.friends = friends;
    }
    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list, parent, false);
        FriendRecViewAdapter.ViewHolder holder = new FriendRecViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FriendRecViewAdapter.ViewHolder holder, int position) {
        holder.friendTxt.setText(friends.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public void setFriends(ArrayList<Friend> friends) {
        this.friends = friends;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView friendTxt;
        private RelativeLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            friendTxt = itemView.findViewById(R.id.friendTxt);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
