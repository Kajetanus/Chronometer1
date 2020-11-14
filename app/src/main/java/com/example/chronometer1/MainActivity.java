package com.example.chronometer1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    // boolean running - aby wskazać kiedy chronometer odlicza, a kiedy nie

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
    }


    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
            // metoda startChronometer za zadanie ma rozpocząć proces odliczania po użyciu przycisku
            // if !running - sprawdza czy metoda aktualnie działa czy nie. Wywołanie metody tylko w przypadku odpowiedzi nie
            //- pauseOffset dodane aby prawidłowo (od momentu zatrzymania) wznowiæ odliczanie
        }
    }

    public void pauseChronometer(View v) {
        if (running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
            //metoda pauseChronometer za zadanie ma zatrzymać działanie programu, zachowując aktualny stan
            // if running - sprawdza czy metoda aktualnie działa czy nie. Wywołanie metody tylko w przypadku odpowiedzi tak
        }
    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
        // metoda resetChronometer ma za zadanie zresetować licznik i ustawić go na wartość równą 0
    }
}

