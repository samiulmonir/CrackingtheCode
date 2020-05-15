package com.example.codebreaker;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageButton leftButton = (ImageButton) findViewById(R.id.leftButton);

        leftButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(leftButton.getTag().equals("blank") || leftButton.getTag().equals("green")) {
                    leftButton.setImageResource(R.drawable.red);
                    leftButton.setTag("red");
                }
                else if(leftButton.getTag().equals("red")) {
                    leftButton.setImageResource(R.drawable.blue);
                    leftButton.setTag("blue");
                }
                else if(leftButton.getTag().equals("blue")) {
                    leftButton.setImageResource(R.drawable.green);
                    leftButton.setTag("green");
                }
            }
        });

        final ImageButton centerButton = (ImageButton) findViewById(R.id.centerButton);

        centerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(centerButton.getTag().equals("blank") || centerButton.getTag().equals("green")) {
                    centerButton.setImageResource(R.drawable.red);
                    centerButton.setTag("red");
                }
                else if(centerButton.getTag().equals("red")) {
                    centerButton.setImageResource(R.drawable.blue);
                    centerButton.setTag("blue");
                }
                else if(centerButton.getTag().equals("blue")) {
                    centerButton.setImageResource(R.drawable.green);
                    centerButton.setTag("green");
                }
            }
        });

        final ImageButton rightButton = (ImageButton) findViewById(R.id.rightButton);

        rightButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(rightButton.getTag().equals("blank") || rightButton.getTag().equals("green")) {
                    rightButton.setImageResource(R.drawable.red);
                    rightButton.setTag("red");
                }
                else if(rightButton.getTag().equals("red")) {
                    rightButton.setImageResource(R.drawable.blue);
                    rightButton.setTag("blue");
                }
                else if(rightButton.getTag().equals("blue")) {
                    rightButton.setImageResource(R.drawable.green);
                    rightButton.setTag("green");
                }
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
