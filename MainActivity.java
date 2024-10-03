// MainActivity.java
package com.example.project3;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button startButton;

    private Handler handler;
    private Runnable runnable;

    private long startTime;
    private long endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        findViewById(R.id.resultTextView);
        findViewById(R.id.timeTextView);

        handler = new Handler();

        startButton.setOnClickListener(v -> {
            startButton.setVisibility(View.INVISIBLE);
            handler.postDelayed(runnable, 2000);
        });

        runnable = () -> {
            Random random = new Random();
            int delay = random.nextInt(5000 - 1000) + 1000;

            startButton.setVisibility(View.VISIBLE);
            startButton.setX(random.nextInt(800));
            startButton.setY(random.nextInt(1400));

            startTime = System.currentTimeMillis();
        };
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
