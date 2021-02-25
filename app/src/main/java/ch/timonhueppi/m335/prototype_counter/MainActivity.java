package ch.timonhueppi.m335.prototype_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        this.counter = preferences.getInt("counter", this.counter);

        setCounter();

        setButtonHandlers();
    }

    private void setButtonHandlers(){
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> updateCounter(true));

        Button btnSubtract = findViewById(R.id.btnSubtract);
        btnSubtract.setOnClickListener(v -> updateCounter(false));

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(v -> resetCounter());

        Button btn2ndActivity = findViewById(R.id.btn2ndActivity);
        btn2ndActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        });
    }

    private void updateCounter(Boolean add){
        if (add)
            this.counter++;
        else
            this.counter--;

        setCounter();
    }

    private void resetCounter(){
        this.counter = 0;
        setCounter();
    }

    private void setCounter(){
        TextView counterNumber = findViewById(R.id.counterNumber);
        counterNumber.setText(Integer.toString(this.counter));

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("counter", this.counter);
        editor.apply();
    }
}