package com.example.vcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JournalPage extends AppCompatActivity {
    private String[] prompts;
    private String[] quotes;
    private ImageView big;

    private RecyclerView JournalRecView;
    private int numPrompts = 3;
/*TODO:
Color scheme has been finalized by CD team we are using color codes BEE3DB, 89B0AE, EC9192, and FFD6BA.
Text should be Roboto Mono for now. Please make sure to update your screen(s) accordingly.
TODO:
Saving prompts/responses in 2 ways: 1. connect it to the account, and 2. have it saved in the "Saved" activity/screen
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_page);

        init();

        ImageButton back = findViewById(R.id.backJournal); //back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return to HomeScreen
                finish();
            }
        });

        //TODO Implement quotes and images into RecView
        //Could try multi-view recView or alternatively allowing the user to select what type of journaling they want
        JournalRecView = findViewById(R.id.journalRecView);

        JournalAdapter journalAdapter = new JournalAdapter(this, getRandomEntries(numPrompts));

        JournalRecView.setAdapter(journalAdapter);
        JournalRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(JournalRecView);
    }

    private ArrayList<JournalEntry> getRandomEntries(int num){
        //Eventually need a way to not reuse prompts

        //Randomly select prompts from prompts String[] by using a shuffled list
        ArrayList<JournalEntry> selectedEntries = new ArrayList<JournalEntry>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < prompts.length; i++){
            list.add(i);
        }
        Collections.shuffle(list);

        for(int i = 0; i < num; i++){
            selectedEntries.add(new JournalEntry("prompt", prompts[list.get(i)]));
        }

        //Randomly select quotes the same way
        list = new ArrayList<Integer>();
        for(int i = 0; i < quotes.length; i++){
            list.add(i);
        }
        Collections.shuffle(list);

        for(int i = 0; i < num; i++){
            selectedEntries.add(new JournalEntry("quote", quotes[list.get(i)]));
        }

        return selectedEntries;
    }

    public void onImg1Clicked(View view) {
        big = findViewById(R.id.imageBig);
        //big.setBackground(img1.getBackground());

    }

    public void onEditTextClicked(View view) {
        Toast.makeText(this, "Like the prompt? Tap it to save.", Toast.LENGTH_SHORT).show();
    }
    public void onSaveBtnClicked(View view) {

    }

    private void init() {

        //TODO Refine and implement prompt class to allow for prompts and answers to be saved
        prompts = getResources().getStringArray(R.array.prompts);
        quotes = getResources().getStringArray(R.array.quotes);
    }
}