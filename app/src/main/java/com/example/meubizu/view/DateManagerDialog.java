package com.example.meubizu.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.meubizu.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateManagerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_LIGHT,this,2000,0,1);

        return datepickerdialog;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        EditText birthDate = (EditText) getActivity().findViewById(R.id.edittext_data);
        Calendar dateSelected = Calendar.getInstance();
        dateSelected.set(i,i1,i2);
        birthDate.setText("");
        birthDate.setText(sdf.format(dateSelected.getTime()));
    }
}