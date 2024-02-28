package com.example.notes.notes;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.notes.BaseActivity;
import com.example.notes.LoginActivity;
import com.example.notes.R;
import com.example.notes.notes.models.Note;
import com.example.notes.utils.Constants;

import java.util.ArrayList;

public class NotesActivity extends BaseActivity {
    RecyclerView rvNotes;
    ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        setRecycleViewData();

        setLogoutEvent();
    }

    private void populateNoteList(){
        noteList = new ArrayList<>();

        noteList.add(new Note("Paser perro", "hace mucho que no sale"));
        noteList.add(new Note("Paser gato", "nunca sale"));
        noteList.add(new Note("Alimentar perro", "hace mucho que no come"));
        noteList.add(new Note("Alimentar loro", "hace mucho que no habla"));
    }

    private void setRecycleViewData() {
        rvNotes = findViewById(R.id.rvNotes);

        populateNoteList();

        NotesAdapter adapter = new NotesAdapter(noteList, NotesActivity.this);
        rvNotes.setAdapter(adapter);
        rvNotes.setHasFixedSize(true); //mejora el manejo de memoria
        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);//como se maneja la vista, linearlayout
        rvNotes.setLayoutManager(manager);


    }

    private void setLogoutEvent() {
        Button btLogout = findViewById(R.id.btLogout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.setPref(Constants.PREFS_USER, false);
                Intent intent = new Intent(NotesActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}