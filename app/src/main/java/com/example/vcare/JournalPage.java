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

import java.util.ArrayList;
import java.util.Random;

public class JournalPage extends AppCompatActivity {
    private String[] prompts;
    private String[] quotes;
    private String[] prompts2;
    private String[] quotes2;
    private String[] prompts3;
    private String[] quotes3;
    private TypedArray images;
    private TypedArray images2;
    private TypedArray images3;
    private Prompt prompt1, prompt2, prompt3, quote1, quote2, quote3;
    private Drawable img1, img2, img3;


    private Button txtPrompt1;
    private Button txtQuote1;
    private ImageButton imgBtn1;
    private Button txtPrompt2;
    private Button txtQuote2;
    private ImageButton imgBtn2;
    private Button txtPrompt3;
    private Button txtQuote3;
    private ImageButton imgBtn3;

    private ImageView big;

    private RecyclerView JournalRecView;
/*TODO:
Color scheme has been finalized by CD team we are using color codes BEE3DB, 89B0AE, EC9192, and FFD6BA.
Text should be Roboto Mono for now. Please make sure to update your screen(s) accordingly.
TODO:
Saving prompts/responses in 2 ways: 1. connect it to the account, and 2. have it saved in the "Saved" activity/screen
TODO:
back button
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_page);

        initialize();

        ImageButton back = findViewById(R.id.backJournal); //back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Return to HomeScreen
                finish();
            }
        });

        JournalRecView = findViewById(R.id.journalRecView);

        JournalAdapter journalAdapter = new JournalAdapter(this, dummyStrings());

        JournalRecView.setAdapter(journalAdapter);
        JournalRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(JournalRecView);
    }

    private ArrayList<String> dummyStrings(){
        ArrayList<String> temp = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            temp.add("prompt " + i);
        }
        return temp;
    }

    public void onImg1Clicked(View view) {
        big = findViewById(R.id.imageBig);
        //big.setBackground(img1.getBackground());

    }

    public void onTxtQuote1Clicked(View view) {

    }

    public void onTxtPrompt1Clicked(View view) {

    }

    public void onEditTextClicked(View view) {
        Toast.makeText(this, "Like the prompt? Tap it to save.", Toast.LENGTH_SHORT).show();
    }
    public void onSaveBtnClicked(View view) {

    }

    private void initialize() {

        prompts = getResources().getStringArray(R.array.prompts);
        prompt1 = new Prompt("prompt1",prompts[new Random().nextInt(prompts.length)]); //I made a class for prompts, I believe it's needed to save, but I'm not 100% sure
        quotes = getResources().getStringArray(R.array.quotes);
        images = getResources().obtainTypedArray(R.array.imgPrompts);
        prompts2 = getResources().getStringArray(R.array.prompts2); //if not, this is how you would declare without class
        quotes2 = getResources().getStringArray(R.array.quotes2);
        images2 = getResources().obtainTypedArray(R.array.imgPrompts2);
        prompts3 = getResources().getStringArray(R.array.prompts3);
        quotes3 = getResources().getStringArray(R.array.quotes3);
        images3 = getResources().obtainTypedArray(R.array.imgPrompts3);

        imgBtn1 = findViewById(R.id.img1);
        imgBtn1.setBackground(images.getDrawable(new Random().nextInt(images.length())));
        txtPrompt1 = findViewById(R.id.txtPrompt1);
        txtPrompt1.setText(prompts[new Random().nextInt(prompts.length)]); //selects a random prompt from strings.xml in the res folder
        txtQuote1 = findViewById(R.id.txtQuote1);
        txtQuote1.setText(quotes[new Random().nextInt(quotes.length)]);

        imgBtn2 = findViewById(R.id.img2); //pull from different arrays to avoid duplicates (however many prompts we get, divide by 3 and store evenly)
        imgBtn2.setBackground(images2.getDrawable(new Random().nextInt(images2.length())));
        txtPrompt2 = findViewById(R.id.txtPrompt2);
        txtPrompt2.setText(prompts2[new Random().nextInt(prompts2.length)]);
        txtQuote2 = findViewById(R.id.txtQuote2);
        txtQuote2.setText(quotes2[new Random().nextInt(quotes2.length)]);

        imgBtn3 = findViewById(R.id.img3);
        imgBtn3.setBackground(images3.getDrawable(new Random().nextInt(images3.length())));
        txtPrompt3 = findViewById(R.id.txtPrompt3);
        txtPrompt3.setText(prompts3[new Random().nextInt(prompts3.length)]);
        txtQuote3 = findViewById(R.id.txtQuote3);
        txtQuote3.setText(quotes2[new Random().nextInt(quotes3.length)]);
    }
}