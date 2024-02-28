package com.example.notes.notes;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.notes.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    LinearLayout llNoteContainer;
    TextView tvNoteTitle, tvNoteBody;
    public NoteViewHolder(@NonNull View v) {
        super(v);

        llNoteContainer = v.findViewById(R.id.llNoteContainer);
        tvNoteTitle = v.findViewById(R.id.tvNoteTitle);
        tvNoteBody = v.findViewById(R.id.tvNoteBody);
    }
}
