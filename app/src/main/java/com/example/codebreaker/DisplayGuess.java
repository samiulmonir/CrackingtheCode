package com.example.codebreaker;

import android.content.Intent;
import android.os.Bundle;

import com.example.codebreaker.List.ItemAdapter;
import com.example.codebreaker.List.ListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayGuess extends AppCompatActivity {

    private RecyclerView mRecycleview;
    private List<ItemAdapter> mList = new ArrayList<>();
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_guess);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        List<String> sList = (List<String>)intent.getSerializableExtra("guess");

        TextView txtView = (TextView) findViewById(R.id.title_display);
        txtView.setText("You got it in "+sList.size()+" guesses");

        mRecycleview = findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager mRecycleviewLayout = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecycleview.setLayoutManager(mRecycleviewLayout);

        convertQueueToList(sList);

        mAdapter = new ListAdapter(mList, this);
        mRecycleview.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    private void convertQueueToList(List<String> sList) {
        System.out.println("Queue Size: "+sList.size());

        for(int i = 0; i < sList.size(); i++) {
            String guess = sList.get(i);

            ItemAdapter itemAdapter = new ItemAdapter();
            itemAdapter.setImageLeft(getImageFromCharacter(guess.charAt(0)));
            itemAdapter.setImageCenter(getImageFromCharacter(guess.charAt(1)));
            itemAdapter.setImageRight(getImageFromCharacter(guess.charAt(2)));
            mList.add(itemAdapter);
        }
    }

    private int getImageFromCharacter(char c) {

        switch (c) {
            case '1':
                return R.drawable.red;
            case '2':
                return R.drawable.blue;
            case '3':
                return R.drawable.green;
            default:
                return R.drawable.blank;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_go_back) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
