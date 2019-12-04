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
import com.example.meubizu.model.Materia;
import com.example.meubizu.model.Rascunho;

import java.util.ArrayList;

public class MateriaAdapter extends ArrayAdapter<Materia> {
    private static class ViewHolder {
        TextView name;
        ImageView icon;
    }
    public MateriaAdapter(@NonNull Context context, ArrayList<Materia> materias) {
        super(context, 0, materias);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Materia materia = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_materia, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.materia_name);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon_materia);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(materia.getNome());
        long idMateria = Rascunho.getIdDeUmaMateria(materia.getNome());
        switch ((int) idMateria){
            case 1:
                viewHolder.icon.setImageResource(R.drawable.biologia_icon);
                break;
            case 2:
                viewHolder.icon.setImageResource(R.drawable.espanhol_icon);
                break;
            case 3:
                viewHolder.icon.setImageResource(R.drawable.filosofia_icon);
                break;
            case 4:
                viewHolder.icon.setImageResource(R.drawable.fisica_icon);
                break;
            case 5:
                viewHolder.icon.setImageResource(R.drawable.geografia_icon);
                break;
            case 6:
                viewHolder.icon.setImageResource(R.drawable.historia_icon);
                break;
            case 7:
                viewHolder.icon.setImageResource(R.drawable.ingles_icon);
                break;
            case 8:
                viewHolder.icon.setImageResource(R.drawable.matematica_icon);
                break;
            case 9:
                viewHolder.icon.setImageResource(R.drawable.portugues_icon);
                break;
            case 10:
                viewHolder.icon.setImageResource(R.drawable.redacao_icon);
                break;
            case 11:
                viewHolder.icon.setImageResource(R.drawable.quimica_icon);
                break;
            case 12:
                viewHolder.icon.setImageResource(R.drawable.socio_icon);
                break;
        }


        return convertView;
    }
}