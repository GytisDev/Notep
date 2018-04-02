package com.training.gytis.foodep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Gytis on 2018-01-18.
 */

public class EditNoteActivity extends Activity{

    TextView textViewTitle;
    EditText editTextTitle;
    EditText editTextNote;
    Button buttonSave;
    Button buttonDelete;
    Note note;

    DatabaseHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_note);

        Initialize();

        Intent intent = getIntent();
        note = (Note) intent.getSerializableExtra("note");

        String title = note.getName();
        String noteText = note.getNote();

        editTextTitle.setText(title);
        editTextNote.setText(noteText);

    }

    public void onClick_deleteNote(View view){
        dbHelper.deleteNote(note);

        finish();
    }

    public void onClick_saveEdit(View view){
        if(isEmpty(editTextNote) || isEmpty(editTextTitle)) return;

        Note newNote = new Note(editTextTitle.getText().toString(), editTextNote.getText().toString());

        dbHelper.updateNote(note, newNote);

        finish();
    }

    private boolean isEmpty(EditText view){
        return view.getText().toString().trim().length() <= 0;

    }

    private void Initialize(){
        editTextTitle = (EditText) findViewById(R.id.input_noteTitleEdit);
        editTextNote = (EditText) findViewById(R.id.input_noteEdit);
        buttonSave = (Button) findViewById(R.id.button_saveEdit);
        buttonDelete = (Button) findViewById(R.id.button_deleteEdit);
        textViewTitle = (TextView) findViewById(R.id.text_titleEdit);

        dbHelper = new DatabaseHelper(this);
    }
}
