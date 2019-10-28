package com.example.planningpoker;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends FragmentActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;
    DatabaseHelper db;
    private  TextView question,answer;
    private TextView name;
    private String uName, uQuestion, uAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_vote);
        String[] data = {"0", "1/2", "1", "2", "3", "5", "8", "13", "20", "40", "80", "100", "inf", "?", "coffe", "XL", "L", "M", "S", "XS"};

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvNumbers);
        int numberOfColumns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        db = new DatabaseHelper(this);

        name=findViewById(R.id.tv_votername);
        name.setText(getIntent().getStringExtra("Name"));
        question= findViewById(R.id.tv_question);
        question.setText("Mennyire vagytok faradtak?");
        answer= findViewById(R.id.tv_selectednumber);

        Button vote_button = findViewById(R.id.button_vote);
        vote_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uQuestion=question.getText().toString();
                uAnswer=answer.getText().toString();
                uName=name.getText().toString();
                //db.insertVoter(uName,uQuestion,uAnswer);
                setContentView(R.layout.fragment_voters_list);

            }
        });

    }

    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + adapter.getItem(position) + ", which is at cell position " + position);
        TextView selected = findViewById(R.id.tv_selectednumber);
        selected.setText(adapter.getItem(position));

    }

}
