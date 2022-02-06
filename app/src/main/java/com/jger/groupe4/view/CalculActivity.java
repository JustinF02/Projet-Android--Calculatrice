package com.jger.groupe4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jger.groupe4.exception.DivisionException;
import com.jger.groupe4.R;
import com.jger.groupe4.model.TypeOperationEnum;

public class CalculActivity extends AppCompatActivity {
    private Double premierElement = 0.0;
    private Double deuxiemeElement=0.0;
    private Double decimalePremierElement = 0.0;
    private Double decimaleDeuxiemeElement = 0.0;
    private Boolean virgulePremierElement = false;
    private Boolean VirguleDeuxiemeElement = false;
    private int CoeffChiffreApresVirgulePREMIER = 10;
    private int CoeffChiffreApresVirguleDEUXIEME = 10;
    private boolean suisJeNegatifPremier = false;
    private boolean suisJeNegatifDeuxieme = false;
    private TypeOperationEnum typeOperationEnum = null;

    private TextView textViewCalcul;
    private int BORNE = 9999;
    private int BorneVirgule = 99;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        textViewCalcul = findViewById(R.id.textview_calcul);
        Button bouton1 = findViewById(R.id.button_1);
        bouton1.setOnClickListener(view -> ajouterNombre(1));
        Button bouton2 = findViewById(R.id.button_2);
        bouton2.setOnClickListener(view -> ajouterNombre(2));
        Button bouton3 = findViewById(R.id.button_3);
        bouton3.setOnClickListener(view -> ajouterNombre(3));
        Button bouton4 = findViewById(R.id.button_4);
        bouton4.setOnClickListener(view -> ajouterNombre(4));
        Button bouton5 = findViewById(R.id.button_5);
        bouton5.setOnClickListener(view -> ajouterNombre(5));
        Button bouton6 = findViewById(R.id.button_6);
        bouton6.setOnClickListener(view -> ajouterNombre(6));
        Button bouton7 = findViewById(R.id.button_7);
        bouton7.setOnClickListener(view -> ajouterNombre(7));
        Button bouton8 = findViewById(R.id.button_8);
        bouton8.setOnClickListener(view -> ajouterNombre(8));
        Button bouton9 = findViewById(R.id.button_9);
        bouton9.setOnClickListener(view -> ajouterNombre(9));
        Button bouton0 = findViewById(R.id.button_0);
        bouton0.setOnClickListener(view -> ajouterNombre(0));
        Button boutonAdd = findViewById(R.id.button_add);
        boutonAdd.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.ADD));
        Button boutonSubstract = findViewById(R.id.button_substract);
        boutonSubstract.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.SUBSTRACT));
        Button boutonDivide = findViewById(R.id.button_divide);
        boutonDivide.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.DIVIDE));
        Button boutonMultiply = findViewById(R.id.button_multiply);
        boutonMultiply.setOnClickListener(view -> ajouteTypeOperation(TypeOperationEnum.MULTIPLY));
        Button boutonNegatif = findViewById(R.id.buttonNegative);
        boutonNegatif.setOnClickListener(view-> InverseMoi());

        //Button supprimer = findViewById(R.id.buttonDEL);
        //supprimer.setOnClickListener(view-> supprimer());
        Button virgule = findViewById(R.id.buttonDot);
        virgule.setOnClickListener(view->passeMoiEnVirgule());

        Button boutonCalculer = findViewById(R.id.buttonCalc);
        boutonCalculer.setOnClickListener(menuItem -> calcul());

    }


    /*
    private void supprimer(int element) {
        if(element !=0){
            deuxiemeElement /=10;
            if(deuxiemeElement == 0){
                typeOperationEnum = null;
            }
        }else{
            premierElement /= 10;
        }
    }*/
    private void passeMoiEnVirgule() {
        if(typeOperationEnum == null){
            virgulePremierElement = true;
        }
        else{VirguleDeuxiemeElement = true;}
    }
    private void InverseMoi() {
        if(typeOperationEnum == null) {premierElement *= -1;suisJeNegatifPremier = !suisJeNegatifPremier;}
        else {deuxiemeElement *= -1;suisJeNegatifDeuxieme = !suisJeNegatifDeuxieme;}

        majTextView();
    }

    private void ajouteTypeOperation(TypeOperationEnum typeOperation) {
        switch (typeOperation){
            case ADD:
                this.typeOperationEnum = TypeOperationEnum.ADD;
                break;
            case DIVIDE:
                this.typeOperationEnum = TypeOperationEnum.DIVIDE;
                break;
            case MULTIPLY:
                this.typeOperationEnum=TypeOperationEnum.MULTIPLY;
                break;
            case SUBSTRACT:
                this.typeOperationEnum=TypeOperationEnum.SUBSTRACT;
                break;
        }
        majTextView();
    }

    private void ajouterNombre(Integer valeur){
        if(typeOperationEnum == null){
            //On traite le premier nombre.
            if(virgulePremierElement != true){
                //On traite la partie unitaire
                if(10*premierElement+valeur > BORNE || 10*premierElement+valeur < BORNE * -1){
                    //Dans le cas où le nombre avec l'ajout d'une valeur dépasse la borne.
                    Toast.makeText(this,getString(R.string.message_valeur_trop_grande),Toast.LENGTH_LONG).show();
                }else{
                    if(suisJeNegatifPremier != false){
                        //Dans le cas ou le nombre est négatif, on va soustraire la valeur pour l'ajouter
                        premierElement = 10 * premierElement-valeur;
                    }else{
                        //et inversement.
                        premierElement = 10 * premierElement+valeur;
                    }
                }
            }else{
                //On traite la partie decimale.
                if(10*decimalePremierElement + valeur > BorneVirgule){
                    Toast.makeText(this, getString(R.string.message_valeur_trop_grande), Toast.LENGTH_LONG).show();
                }
                else{
                    decimalePremierElement = 10*decimalePremierElement+valeur;
                    Integer truc1 = (int)((double)premierElement);
                    premierElement = (double)truc1;
                    if(suisJeNegatifPremier == true){
                        premierElement -= decimalePremierElement/CoeffChiffreApresVirgulePREMIER;
                    }else{
                        premierElement += decimalePremierElement/CoeffChiffreApresVirgulePREMIER;
                    }
                    CoeffChiffreApresVirgulePREMIER *=10;
                }
            }
        }else{
            //On traite le second nombre.
            if(VirguleDeuxiemeElement != true){
                if(10*deuxiemeElement+valeur > BORNE){
                    Toast.makeText(this,getString(R.string.message_valeur_trop_grande),Toast.LENGTH_LONG).show();
                }else{
                    if(suisJeNegatifDeuxieme != false){
                        deuxiemeElement = 10 * deuxiemeElement-valeur;
                    }else{
                        deuxiemeElement = 10 * deuxiemeElement+valeur;
                    }
                }
            }else{
                if(10*decimaleDeuxiemeElement + valeur > BorneVirgule){
                    Toast.makeText(this, getString(R.string.message_valeur_trop_grande), Toast.LENGTH_LONG).show();
                }
                else{
                    decimaleDeuxiemeElement = 10*decimaleDeuxiemeElement+valeur;
                    Integer truc2 = (int)((double)deuxiemeElement);
                    deuxiemeElement = (double)truc2;
                    if(suisJeNegatifDeuxieme == true){
                        deuxiemeElement -= decimaleDeuxiemeElement/CoeffChiffreApresVirguleDEUXIEME;
                    }else{
                        deuxiemeElement += decimaleDeuxiemeElement/CoeffChiffreApresVirguleDEUXIEME;
                    }
                    CoeffChiffreApresVirguleDEUXIEME *= 10;
                }
            }
        }
        majTextView();
    }

    private void majTextView() {
        String valeurAAfficher = "";
        if(typeOperationEnum == null){
            valeurAAfficher = premierElement.toString();
        }else{
            valeurAAfficher = premierElement + " "+ typeOperationEnum.getSymbol()+" "+ deuxiemeElement;
        }
        textViewCalcul.setText(valeurAAfficher);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar,menu);

        MenuItem itemVider = menu.findItem(R.id.toolbarVider);
        itemVider.setOnMenuItemClickListener(menuItem -> videTextViewCalcul());
        return super.onCreateOptionsMenu(menu);
    }

    private boolean calcul()  {
        try {
            if (typeOperationEnum == null) throw new DivisionException();
            try {
                Double resultat = 0.0;
                switch (typeOperationEnum) {
                    case MULTIPLY:
                        resultat = premierElement * deuxiemeElement;
                        break;
                    case ADD:
                        resultat = premierElement + deuxiemeElement;
                        break;
                    case DIVIDE:
                        if (deuxiemeElement == 0) {
                            throw new DivisionException();
                        } else {
                            resultat = premierElement / deuxiemeElement;
                        }
                        break;
                    case SUBSTRACT:
                        resultat = premierElement - deuxiemeElement;
                        break;
                }
                ouvreLastComputeActivity(resultat);
            } catch (DivisionException exception) {
                Toast.makeText(this, getString(R.string.message_division_par_zero), Toast.LENGTH_LONG).show();
            }
        }catch (DivisionException exception2){
            Toast.makeText(this, getString(R.string.messagePasDoperation), Toast.LENGTH_LONG).show();
        }
        return true;
    }

    private void ouvreLastComputeActivity(Double resultat) {
        Intent intent = new Intent(this, LastComputeActivity.class);
        intent.putExtra("premierElement",premierElement);
        intent.putExtra("deuxiemeElement",deuxiemeElement);
        intent.putExtra("operationSymbol",typeOperationEnum.getSymbol());
        intent.putExtra("resultat",resultat);
        startActivity(intent);
    }

    private boolean videTextViewCalcul() {
        suisJeNegatifPremier = false;
        suisJeNegatifDeuxieme = false;
        textViewCalcul.setText("");
        premierElement = 0.0;
        deuxiemeElement = 0.0;
        typeOperationEnum = null;
        virgulePremierElement = false;
        VirguleDeuxiemeElement = false;
        CoeffChiffreApresVirgulePREMIER = 10;
        CoeffChiffreApresVirguleDEUXIEME = 10;
        decimalePremierElement = 0.0;
        decimaleDeuxiemeElement =0.0;

        return true;
    }
}