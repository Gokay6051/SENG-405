package com.example.a202011057_seng405_midterm;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{
    private ArrayList<Person> personItemList;
    public PersonAdapter(ArrayList<Person> personItemList) {this.personItemList = personItemList;}

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        String n1, n2;// 9999

        android.view.View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.person_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Person person = personItemList.get(position);
        if(person.getFirstName() != null) {
            holder.name.setText(person.getFirstName().toString());
        }
        if(person.getEmail() != null) {
            holder.mail.setText(person.getEmail().toString());
        }
        if(person.getAvatar() != null) {
            Glide.with(holder.imageView.getContext())
                    .load(person.getAvatar())
                    .override(200, 200)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return personItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView mail;
        private ImageView imageView;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.NameTextView);
            mail = itemView.findViewById((R.id.mailTextView));
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
