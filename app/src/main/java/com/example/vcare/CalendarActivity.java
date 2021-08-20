package com.example.vcare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;

public class CalendarActivity extends AppCompatActivity {

    private ImageButton back;
    private DatePicker calendar;
    int selectedDay, selectedMonth, selectedYear;
    int[] selectedDate;
    public static final String EXTRA_MESSAGE = "com.example.vcare.MESSAGE";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        back = findViewById(R.id.backBtn);
        calendar = findViewById(R.id.calendar);
        selectedDay = calendar.getDayOfMonth();
        selectedMonth = calendar.getMonth();
        selectedYear = calendar.getYear();
        selectedDate = new int[]{selectedYear, selectedMonth, selectedDay};

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CalendarActivity.this, Menu.class));
                finish();
            }
        });

        calendar.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
                selectedDate = new int[] {year, month, dayOfMonth};
                Intent intent = new Intent(CalendarActivity.this, CalendarNoteActivity.class);
                intent.putExtra(EXTRA_MESSAGE, selectedDate);
                startActivity(intent);
                finish();

            }
        });
    }
}
