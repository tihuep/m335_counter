package ch.timonhueppi.m335.prototype_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn1stActivity = findViewById(R.id.btn1stActivity);
        btn1stActivity.setOnClickListener(v -> {
            finish();
        });
    }
}