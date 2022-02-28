package com.jger.groupe4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jger.groupe4.R;
import com.jger.groupe4.database.CalculDao;
import com.jger.groupe4.database.ComputeBaseHelper;
import com.jger.groupe4.model.Entities.Calcul;
import com.jger.groupe4.service.CalculService;

public class LastComputeActivity extends AppCompatActivity {
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

        /* L'intent est inutile vu que l'on récupère dorénavent les valeurs dans la BDD
        Intent intent =getIntent();
        premierElement = intent.getDoubleExtra("premierElement",0.0);
        deuxiemeElement = intent.getDoubleExtra("deuxiemeElement",0.0);
        symbol = intent.getStringExtra("operationSymbol");
        resultat = intent.getDoubleExtra("resultat",0.0);
         */
        //-----------
        Calcul lastCalcul = calculService.getLast();
        //-----------

        textViewNombreCalcul.setText("Il y a " + calculService.getCalculCount() + " calculs réalisées");
        textViewCalcul.setText(lastCalcul.getPremierElement() +" "+lastCalcul.getSymbol()+" "+lastCalcul.getDeuxiemeElement());
        textViewRESULTAT.setText(" = " + lastCalcul.getResultat());


        if(lastCalcul.getSymbol() != null){
            textViewCalcul.setText(lastCalcul.getPremierElement() +" "+lastCalcul.getSymbol()+" "+lastCalcul.getDeuxiemeElement());
            textViewRESULTAT.setText(" = " + lastCalcul.getResultat());
        }else{
            textViewCalcul.setText("");
        }
    }

    private void retourneAuPrecedent() {
        finish();
    }
}