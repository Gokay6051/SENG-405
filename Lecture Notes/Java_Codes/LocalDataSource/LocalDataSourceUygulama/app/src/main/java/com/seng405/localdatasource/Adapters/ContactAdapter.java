package com.seng405.localdatasource.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seng405.localdatasource.Entity.Contact;
import com.seng405.localdatasource.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    private ArrayList<Contact> contactItemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Contact item);
    }


    public ContactAdapter(ArrayList<Contact> contactItemList ,OnItemClickListener listener) {
        this.contactItemList = contactItemList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        android.view.View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.contact_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Contact contact = contactItemList.get(position);

        holder.contactNameTextView.setText(contact.getName());

        holder.bind(contactItemList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return contactItemList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contactNameTextView;

        public ViewHolder(android.view.View itemView) {
            super(itemView);

            contactNameTextView = itemView.findViewById(R.id.contactNameTextView);
        }


        public void bind(final Contact item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
