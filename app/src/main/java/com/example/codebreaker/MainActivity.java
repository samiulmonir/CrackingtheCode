package com.example.codebreaker;

import android.content.Context;
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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final int randomLeft = new Random().nextInt(3) + 1;
    final int randomCenter = new Random().nextInt(3) + 1;
    final int randomRight = new Random().nextInt(3) + 1;
    final String generatedCode = String.valueOf(randomLeft+""+randomCenter+""+randomRight);

    Queue<String> queue = new LinkedList<>();
    int countPositions = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        System.out.println("Generated Code: "+ generatedCode);

        final ImageButton leftButton = (ImageButton) findViewById(R.id.leftButton);

        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

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
        });

        final ImageButton centerButton = (ImageButton) findViewById(R.id.centerButton);

        centerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

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
        });

        final ImageButton rightButton = (ImageButton) findViewById(R.id.rightButton);

        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

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
        });

        final Button guessBtn = (Button) findViewById(R.id.guessButton);

        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String builder = leftButton.getTag()+""+centerButton.getTag()+rightButton.getTag();

                TextView txtView = (TextView) findViewById(R.id.positions);
                txtView.setVisibility(View.VISIBLE);

                if(builder.equals(generatedCode)) {
                    System.out.println("WOW, Good Job");
                    txtView.setText("Correct Positions: 3");

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
        });

        final Button hintButton = (Button) findViewById(R.id.hintsButton);

        hintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text;
                switch (countPositions) {
                    case 0:
                        text = "Position 1: "+leftButton.getTag().toString();
                        break;
                    case 1:
                        text = "Position 2: "+centerButton.getTag().toString();
                        break;
                    default:
                        text = "Position 3: "+rightButton.getTag().toString();
                        break;
                }
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                countPositions++;
            }
        });



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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
