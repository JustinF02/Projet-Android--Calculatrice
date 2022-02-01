package com.jger.groupe4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.jger.groupe4.R;
import com.jger.groupe4.view.CalculActivity;
import com.jger.groupe4.view.LastComputeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boutonCalculer = findViewById(R.id.bouton_calculer);
        boutonCalculer.setOnClickListener(view -> ouvreActiviteCalculer());
        Button boutonDernierCalcul = findViewById(R.id.bouton_dernier_calcul);
        boutonDernierCalcul.setOnClickListener(view -> ouvreActiviteDernierCalcul());

    }

    private void ouvreActiviteDernierCalcul() {
        Intent intent = new Intent(this, LastComputeActivity.class);
        startActivity(intent);
    }

    private void ouvreActiviteCalculer() {
        Intent intent = new Intent(this, CalculActivity.class);
        startActivity(intent);
    }
}