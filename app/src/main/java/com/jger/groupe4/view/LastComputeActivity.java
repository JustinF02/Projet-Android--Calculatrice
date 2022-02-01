package com.jger.groupe4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jger.groupe4.R;

public class LastComputeActivity extends AppCompatActivity {
    private Long premierElement = 0L;
    private Long deuxiemeElement = 0L;
    private String symbol;
    private Long resultat = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_compute);
        Button boutonPrecedent = findViewById(R.id.bouton_precedent);
        TextView textViewCalcul = findViewById(R.id.lastCompute_textviewCalcul);
        boutonPrecedent.setOnClickListener(view -> retourneAuPrecedent());
        Intent intent =getIntent();
        premierElement = intent.getLongExtra("premierElement",0);
        deuxiemeElement = intent.getLongExtra("deuxiemeElement",0);
        symbol = intent.getStringExtra("operationSymbol");
        resultat = intent.getLongExtra("resultat",0L);
        if(symbol != null){
            textViewCalcul.setText(premierElement +" "+symbol+" "+deuxiemeElement +" = "+resultat);
        }else{
            textViewCalcul.setText("");
        }
    }

    private void retourneAuPrecedent() {
        finish();
    }
}