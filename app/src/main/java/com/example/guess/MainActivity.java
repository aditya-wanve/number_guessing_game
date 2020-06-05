package com.example.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randnum;
    public void generateNumber(){
        Random rand = new Random();
        randnum = rand.nextInt(20) + 1;
    }
    public void guess(View view){
        EditText editText=(EditText) findViewById(R.id.editText);
        int guessValue = Integer.parseInt(editText.getText().toString());
        String message;
        if (guessValue<randnum){
            message =  "Higher";
        }
        else if (guessValue>randnum){
            message = "Lower";
        }else{
            message = "You got it right,Try Again";
            generateNumber();
        }
        Log.i("Info",Integer.toHexString(randnum));
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNumber();

    }
}
