package com.example.odaiodeh.messenger;

/**
 * Created by odai.odeh on 4/22/18.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private MyAdapter adapter;
    EditText dataMessage;
    Button sent ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.list);

        ArrayList<dataText> input = new ArrayList<>();
        adapter = new MyAdapter(input);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);




        sent = (Button) findViewById(R.id.button);
        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataText insertedMessage = new dataText(dataMessage.getText().toString());
                adapter.addData(insertedMessage);
                dataMessage.setText("");
            }
        });



        dataMessage = (EditText) findViewById(R.id.dataMessage);
        dataMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // nothing
            }

            @Override
            public void afterTextChanged(Editable s) {

                sent.setEnabled(!TextUtils.isEmpty(s) );

            }
        });

    }


}


