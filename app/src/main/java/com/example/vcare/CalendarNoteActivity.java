package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarNoteActivity extends AppCompatActivity {

    private TextView addReminderTxt, reminderInfo, surveyText, surveyResult;
    private ImageView emoji;
    private Button surveyButton;
    private ImageButton back;
    private EditText reminders;
    String savedReminders, savedResult;
    boolean surveyTaken;
    int[] givenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_note);

        addReminderTxt = findViewById(R.id.addReminderText);
        reminderInfo = findViewById(R.id.reminderInfo);
        surveyText = findViewById(R.id.surveyText);
        surveyResult = findViewById(R.id.surveyResult);
        emoji = findViewById(R.id.emotionImage);
        surveyButton = findViewById(R.id.surveyButton);
        reminders = findViewById(R.id.reminderEdit);
        back = findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CalendarNoteActivity.this, CalendarActivity.class));
                finish();
            }
        });
        Intent intent = getIntent();
        givenDate = intent.getIntArrayExtra(CalendarActivity.EXTRA_MESSAGE);


        Calendar currDate = Calendar.getInstance();
        currDate.set(Calendar.HOUR, 0);
        currDate.set(Calendar.HOUR_OF_DAY, 0);
        currDate.set(Calendar.MINUTE, 0);
        currDate.set(Calendar.SECOND, 0);
        currDate.set(Calendar.MILLISECOND, 0);
        Calendar selectedDate = new GregorianCalendar(givenDate[0], givenDate[1], givenDate[2]);
        String month = selectedDate.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
        addReminderTxt.setText("Add reminder for " + month + " " + selectedDate.get(Calendar.DAY_OF_MONTH));
        if (selectedDate.before(currDate)){
            reminderInfo.setText("This date has already passed.");
            reminders.setText(savedReminders);
            reminders.setEnabled(false);
        }
        else{
            //Set reminder works
            reminderInfo.setText("Insert reminder here...");
            reminders.setText(savedReminders);
            emoji.setVisibility(View.GONE);
        }

        if (surveyTaken){
            surveyText.setText("You have already taken a survey for this date. On this day, you were feeling: ");
            surveyResult.setVisibility(View.VISIBLE);
            emoji.setVisibility(View.VISIBLE);
            surveyButton.setVisibility(View.GONE);
        }
        else if (selectedDate.before(currDate)){
            surveyText.setText("You did not take a survey for this date.");
            surveyResult.setVisibility(View.GONE);
            emoji.setVisibility(View.GONE);
            surveyButton.setVisibility(View.GONE);
        }
        else{
            surveyText.setText("How are you feeling today? Take this survey to keep track of your mood!");
            surveyResult.setVisibility(View.GONE);
            emoji.setVisibility(View.GONE);
            surveyButton.setVisibility(View.VISIBLE);
            surveyButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    //startActivity(new Intent(CalendarNoteActivity.this, SurveyActivity.class));
                    //finish();
                }
            });
        }
    }
}