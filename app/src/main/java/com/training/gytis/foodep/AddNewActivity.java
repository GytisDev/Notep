package com.training.gytis.foodep;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

;

/**
 * Created by Gytis on 2018-01-18.
 */

public class AddNewActivity extends Activity {

    TextView textViewTitle;
    EditText editTextTitle;
    EditText editTextNote;
    Button buttonSave;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new);

        Initialize();
    }

    public void onClick_buttonSave(View view){
        if(isEmpty(editTextNote) || isEmpty(editTextTitle)) return;

        Note note = new Note(editTextTitle.getText().toString(), editTextNote.getText().toString());

        dbHelper.addNote(note);

        finish();
    }

    public boolean isEmpty(EditText view){
        return view.getText().toString().trim().length() <= 0;

    }

    private void Initialize(){
        editTextTitle = (EditText) findViewById(R.id.input_title);
        editTextNote = (EditText) findViewById(R.id.input_note);
        buttonSave = (Button) findViewById(R.id.button_save);
        textViewTitle = (TextView) findViewById(R.id.text_title);

        dbHelper = new DatabaseHelper(this);
    }
}
