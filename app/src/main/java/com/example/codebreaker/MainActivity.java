package com.example.codebreaker;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomLeft;
    int randomCenter;
    int randomRight;
    String generatedCode;

    List<String> listGuess;
    int countPositions = 0;
    int guessCounter = 0;

    ImageButton leftButton;
    ImageButton centerButton;
    ImageButton rightButton;

    TextView txtView;

    Button guessBtn;
    Button hintButton;

    private void setupGame() {
        randomLeft = new Random().nextInt(3) + 1;
        randomCenter = new Random().nextInt(3) + 1;
        randomRight = new Random().nextInt(3) + 1;
        generatedCode = String.valueOf(randomLeft+""+randomCenter+""+randomRight);

        System.out.println("Generated Code: "+ generatedCode);

        countPositions = 0;
        guessCounter = 0;

        listGuess = new ArrayList<>();

        leftButton.setImageResource(R.drawable.blank);
        centerButton.setImageResource(R.drawable.blank);
        rightButton.setImageResource(R.drawable.blank);

        leftButton.setTag("0");
        centerButton.setTag("0");
        rightButton.setTag("0");

        txtView.setVisibility(View.INVISIBLE);
        txtView.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        leftButton = (ImageButton) findViewById(R.id.leftButton);
        centerButton = (ImageButton) findViewById(R.id.centerButton);
        rightButton = (ImageButton) findViewById(R.id.rightButton);

        guessBtn = (Button) findViewById(R.id.guessButton);
        hintButton = (Button) findViewById(R.id.hintsButton);

        txtView = (TextView) findViewById(R.id.positions);

        setupGame();

    }

    public void leftButtonClicked(View view) {

        if(leftButton.getTag().equals("0") || leftButton.getTag().equals("3")) {
            leftButton.setImageResource(R.drawable.red);
            leftButton.setTag("1");
        }
        else if(leftButton.getTag().equals("1")) {
            leftButton.setImageResource(R.drawable.blue);
            leftButton.setTag("2");
        }
        else if(leftButton.getTag().equals("2")) {
            leftButton.setImageResource(R.drawable.green);
            leftButton.setTag("3");
        }

    }

    public void centerButtonClicked(View view) {
        if(centerButton.getTag().equals("0") || centerButton.getTag().equals("3")) {
            centerButton.setImageResource(R.drawable.red);
            centerButton.setTag("1");
        }
        else if(centerButton.getTag().equals("1")) {
            centerButton.setImageResource(R.drawable.blue);
            centerButton.setTag("2");
        }
        else if(centerButton.getTag().equals("2")) {
            centerButton.setImageResource(R.drawable.green);
            centerButton.setTag("3");
        }
    }

    public void rightButtonClicked(View view) {

        if(rightButton.getTag().equals("0") || rightButton.getTag().equals("3")) {
            rightButton.setImageResource(R.drawable.red);
            rightButton.setTag("1");
        }
        else if(rightButton.getTag().equals("1")) {
            rightButton.setImageResource(R.drawable.blue);
            rightButton.setTag("2");
        }
        else if(rightButton.getTag().equals("2")) {
            rightButton.setImageResource(R.drawable.green);
            rightButton.setTag("3");
        }

    }

    public void guessButtonClicked(View view) {

        String builder = leftButton.getTag()+""+centerButton.getTag()+rightButton.getTag();
        listGuess.add(builder);
        txtView.setVisibility(View.VISIBLE);

        if(builder.equals(generatedCode)) {
            System.out.println("WOW, Good Job");
            txtView.setText("Correct Positions: 3");

            Intent intent = new Intent(this, DisplayGuess.class);
            intent.putExtra("guess", (Serializable) listGuess);
            startActivity(intent);

        }
        else {
            int positions = 0;
            for(int i = 0; i < builder.length(); i++) {
                if(builder.charAt(i) == generatedCode.charAt(i)) {
                    positions++;
                }
            }
            System.out.println("matched in positions: "+positions);
            txtView.setText("Correct Positions: "+positions);
        }

    }

    public void hintButtonClicked(View view) {
        CharSequence text;
        switch (countPositions) {
            case 0:
                text = "Position 1: "+randomLeft;
                break;
            case 1:
                text = "Position 2: "+randomCenter;
                break;
            default:
                text = "Position 3: "+randomRight;
                break;
        }
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        countPositions++;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new_game) {
            setupGame();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
