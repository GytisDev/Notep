package com.training.gytis.foodep;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Gytis on 2017-10-09.
 */

class MenuAdapterNotes extends ArrayAdapter<Note> {

    MenuAdapterNotes(Context context, Note[] notes) {
        super(context, R.layout.notes_menu_element, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = convertView;
        if(customView == null)
            customView = inflater.inflate(R.layout.notes_menu_element, parent, false);

        TextView nameView = (TextView) customView.findViewById(R.id.text_note_title);
        TextView dateView = (TextView) customView.findViewById(R.id.text_date);

        nameView.setText(getItem(position).getName());
        dateView.setText("Note created: " + getItem(position).getDate());

        return customView;
    }
}
