package com.jger.groupe4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jger.groupe4.R;
import com.jger.groupe4.database.CalculDao;
import com.jger.groupe4.database.ComputeBaseHelper;
import com.jger.groupe4.service.CalculService;

public class LastComputeActivity extends AppCompatActivity {
    private Double premierElement = 0.0;
    private Double deuxiemeElement = 0.0;
    private String symbol;
    private Double resultat = 0.0;
    private CalculService calculService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_compute);
        calculService = new CalculService(new CalculDao(new ComputeBaseHelper(this)));
        Button boutonPrecedent = findViewById(R.id.bouton_precedent);
        TextView textViewCalcul = findViewById(R.id.derniereOperation);
        TextView textViewRESULTAT = findViewById(R.id.derniereOperationRESULTAT);
        TextView textViewNombreCalcul = findViewById(R.id.nbOperations);
        boutonPrecedent.setOnClickListener(view -> retourneAuPrecedent());
        Intent intent =getIntent();
        premierElement = intent.getDoubleExtra("premierElement",0.0);
        deuxiemeElement = intent.getDoubleExtra("deuxiemeElement",0.0);
        symbol = intent.getStringExtra("operationSymbol");
        resultat = intent.getDoubleExtra("resultat",0.0);

        textViewNombreCalcul.setText("Il y a " + calculService.getCalculCount() + " calculs réalisées");
        textViewCalcul.setText(premierElement + " " + symbol + " " + deuxiemeElement);
        textViewRESULTAT.setText(" = " + resultat);

        if(symbol != null){
            textViewCalcul.setText(premierElement +" "+symbol+" "+deuxiemeElement);
            textViewRESULTAT.setText(" = " + resultat);
        }else{
            textViewCalcul.setText("");
        }
    }

    private void retourneAuPrecedent() {
        finish();
    }
}