package com.training.gytis.foodep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/*public class MainActivity extends Activity {

    List<String> names;
    DatabaseHelper dbHandler;

    EditText input;
    Button addButton;
    Button deleteButton;
    ListView databaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_tester);

        Initialize();
    }

    public void onClick_add(View v){
        if(isEmpty(input)) return;

        dbHandler.addFood(new Food(input.getText().toString()));

        displayDatabase();
    }

    public void onClick_delete(View v){
        if(isEmpty(input)) return;

        dbHandler.deleteFood(input.getText().toString());

        displayDatabase();
    }

    public void displayDatabase(){
        String dbString = dbHandler.databaseToString();

        String[] contents = dbString.split(",");

        for(int i = 0; i < contents.length; i++){
            names.add(contents[i]);
        }

        ListAdapter adapter = new MenuAdapter(this, names.toArray(new String[0]));
        ListView list = (ListView) findViewById(R.id.list);
        databaseList.setAdapter(adapter);
    }

    public boolean isEmpty(EditText view){
        return view.getText().toString().trim().length() <= 0;

    }

    public void Initialize(){
        names = new ArrayList<>();
        dbHandler = new DatabaseHelper(this);

        input = (EditText) findViewById(R.id.inputView);
        addButton = (Button) findViewById(R.id.button_add);
        deleteButton  = (Button) findViewById(R.id.button_delete);
        databaseList = (ListView) findViewById(R.id.databaseContents);
    }
}*/


//LEISTI EDITINTI, ISTRINTI!!!!!

public class MainActivity extends Activity {

    List<Note> notes;
    DatabaseHelper dbHandler;

    Button addButton;
    ListView databaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notes);

        Initialize();

        displayDatabase();

        databaseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent nextActivity = new Intent(MainActivity.this, EditNoteActivity.class);
                nextActivity.putExtra("note", notes.get(position));

                startActivity(nextActivity);
            }
        });
    }

    public void onClick_addNote(View v) {
        Intent intent = new Intent(this, AddNewActivity.class);

        startActivity(intent);
    }

    public void displayDatabase(){
        notes = dbHandler.databaseToList();

        ListAdapter adapter = new MenuAdapterNotes(this, notes.toArray(new Note[0]));
        databaseList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        displayDatabase();
    }

    public boolean isEmpty(EditText view){
        return view.getText().toString().trim().length() <= 0;

    }

    public void Initialize(){
        notes = new ArrayList<>();
        dbHandler = new DatabaseHelper(this);

        addButton = (Button) findViewById(R.id.button_addNewNoteActivity);
        databaseList = (ListView) findViewById(R.id.list_notes);
    }
}
