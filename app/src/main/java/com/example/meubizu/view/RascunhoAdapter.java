package com.example.meubizu.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.meubizu.R;
import com.example.meubizu.model.Rascunho;

import java.util.ArrayList;

public class RascunhoAdapter extends ArrayAdapter<Rascunho> {
    private static class ViewHolder {
        TextView name;
        TextView date;
    }
    public RascunhoAdapter(@NonNull Context context, ArrayList<Rascunho> rascunhos) {
        super(context, 0, rascunhos);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Rascunho rascunho = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_rascunho, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            // Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data from the data object via the viewHolder object
        // into the template view.
        viewHolder.name.setText(rascunho.getTitulo());
        viewHolder.date.setText(rascunho.getDataDeCriacao());

        // Return the completed view to render on screen
        return convertView;
    }
}
