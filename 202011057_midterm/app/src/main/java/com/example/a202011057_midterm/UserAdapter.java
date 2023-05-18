package com.example.a202011057_midterm;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private ArrayList<User> userItemList;

    public UserAdapter(ArrayList<User> userItemList) {this.userItemList = userItemList;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        android.view.View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        User user = userItemList.get(position);
        if(user.getUserId() != null) {
            holder.id.setText(user.getUserId());
        }

        if(user.getTitle() != null) {
            holder.title.setText(user.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return userItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView id;
        private TextView title;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textViewId);
            title = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
