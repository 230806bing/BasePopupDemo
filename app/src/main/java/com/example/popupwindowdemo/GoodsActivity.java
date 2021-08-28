package com.example.popupwindowdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GoodsActivity extends AppCompatActivity {
    private Button mTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        mTestButton = findViewById(R.id.testButtton);
        mTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DetailDialog(GoodsActivity.this).showPopupWindow();
            }
        });


    }

}