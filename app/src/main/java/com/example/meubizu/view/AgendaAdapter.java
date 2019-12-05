package com.example.meubizu.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.meubizu.R;
import com.example.meubizu.model.Agenda;


import java.util.ArrayList;

public class AgendaAdapter  extends ArrayAdapter<Agenda> {

    private static class ViewHolder {
        TextView name;
    }
    public AgendaAdapter(@NonNull Context context, ArrayList<Agenda> agendas) {
        super(context, 0, agendas);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Agenda agenda = getItem(position);
        AgendaAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new AgendaAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_agenda, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.agenda_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AgendaAdapter.ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(agenda.getDescricao());
        return convertView;
    }
}