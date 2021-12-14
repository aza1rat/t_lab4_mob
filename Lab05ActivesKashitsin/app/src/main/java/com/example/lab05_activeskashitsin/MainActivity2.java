package com.example.lab05_activeskashitsin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText ValueTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ValueTxt = findViewById(R.id.input_value2);
        Intent intent = getIntent();
        ValueTxt.setText(intent.getStringExtra("check"));
    }

    public void Cancel(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    public  void Save(View v)
    {
        Intent intent = new Intent();
        intent.putExtra("check2", ValueTxt.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}