package com.jger.groupe4.model.Entities;

public class Calcul extends BaseEntity{
    Double premierElement;
    Double deuxiemeElement;
    Double resultat;
    String symbol;

    public Double getPremierElement() {
        return premierElement;
    }

    public void setPremierElement(Double premierElement) {
        this.premierElement = premierElement;
    }

    public Double getDeuxiemeElement() {
        return deuxiemeElement;
    }

    public void setDeuxiemeElement(Double deuxiemeElement) {
        this.deuxiemeElement = deuxiemeElement;
    }

    public Double getResultat() {
        return resultat;
    }

    public void setResultat(Double resultat) {
        this.resultat = resultat;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
