package com.example.guessit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public void guessIt(View view) {
        int max = 20;
        int min = 1; 
        int randomNumber = (int)(Math.random()*((max-min)+1))+min;
        EditText yourEditText = (EditText) findViewById(R.id.editText);
        if(!(yourEditText.getText().toString()).equalsIgnoreCase("")) {
            int yourNumber = Integer.parseInt(yourEditText.getText().toString());
            ImageView image = (ImageView) findViewById(R.id.imageView);
            if(yourNumber == randomNumber) {
                Toast.makeText(getBaseContext(),"Bingo !!You guessed it right!",Toast.LENGTH_SHORT).show();
                image.setImageResource(R.drawable.bingo);
            } else {
                Toast.makeText(getBaseContext(),"Hard Luck!!Try guessing again!",Toast.LENGTH_SHORT).show();
                image.setImageResource(R.drawable.hardluck);
            }
            TextView myGuess = (TextView) findViewById(R.id.myGuess);
            TextView yourGuess = (TextView) findViewById(R.id.yourGuess);
            myGuess.setText(Integer.toString(randomNumber));
            yourGuess.setText(Integer.toString(yourNumber));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
