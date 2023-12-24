package com.example.projetmobile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class Myadapter extends ArrayAdapter<Contact> {

    private Context context;

    public Myadapter(Context context, List<Contact> data) {
        super(context, 0, data);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Contact cont = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.my_row, parent, false);
        }

        TextView textViewPersonName = convertView.findViewById(R.id.person_name);
        TextView textViewPersonPhone = convertView.findViewById(R.id.person_phone);

        textViewPersonName.setText(cont.getName());
        textViewPersonPhone.setText(cont.getPhone());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleItemClick(cont);
            }
        });

        return convertView;
    }

    private void handleItemClick(Contact cont) {
        Intent intent = new Intent(context, CallActivity.class);
        intent.putExtra("personName", cont.getName());
        intent.putExtra("personPhone", cont.getPhone());
        context.startActivity(intent);
    }}