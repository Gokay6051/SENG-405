package com.example.keepinnotes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keepinnotes.R;
import com.example.keepinnotes.entity.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
    private ArrayList<Note> noteItemList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Note item);
    }

    public NoteAdapter(ArrayList<Note> noteItemList ,OnItemClickListener listener) {
        this.noteItemList = noteItemList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        android.view.View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.note_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Note note = noteItemList.get(position);

        holder.noteTitleTextView.setText(" "+note.getTitle());
        holder.itemDescriptionTextView.setText("   "+note.getDescription());


        holder.bind(noteItemList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return noteItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView noteTitleTextView, itemDescriptionTextView;

        public ViewHolder(android.view.View itemView) {
            super(itemView);

            noteTitleTextView = itemView.findViewById(R.id.noteTitleTextView);
            itemDescriptionTextView = itemView.findViewById(R.id.itemDescriptionTextView);
        }

        public void bind(final Note item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

}
