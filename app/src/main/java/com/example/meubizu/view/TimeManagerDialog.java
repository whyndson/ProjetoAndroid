package com.example.meubizu.view;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import com.example.meubizu.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeManagerDialog extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }


    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        TextView tv = (TextView) getActivity().findViewById(R.id.edittext_hora);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
        calendar.set(Calendar.MINUTE,minute);
        tv.setText("");
        tv.setText(sdf.format(calendar.getTime()));

    }
}