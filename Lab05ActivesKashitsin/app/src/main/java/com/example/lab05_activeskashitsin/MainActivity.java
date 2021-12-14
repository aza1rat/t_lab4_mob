package com.example.lab05_activeskashitsin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ValueTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ValueTxt = findViewById(R.id.input_value);
    }
    @Override
    protected void onActivityResult(int requestC, int resultC, @Nullable Intent data) {
        if (requestC == 555)
        {
            if (data != null)
            {
                String s = data.getStringExtra("check2");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestC, resultC, data);
    }

    public void Exit(View v)
    {
        makeDialog("Вы действительно хотите выйти?");
    }

    public void Ex(View v)
    {
        finish();
    }

    public void ToNextWindow (View v)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("check", ValueTxt.getText().toString());
        startActivityForResult(intent, 555);
    }

    void makeDialog(String str)//Кашицын,393
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dlg = builder.create();
        dlg.setIcon(R.drawable.exiticon);
        dlg.setTitle(str);
        dlg.setButton(AlertDialog.BUTTON_NEGATIVE, "ОК", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dlg.setButton(AlertDialog.BUTTON_POSITIVE, "Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dlg.show();
    }

}