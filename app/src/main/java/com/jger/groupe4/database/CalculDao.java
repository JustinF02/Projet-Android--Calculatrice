package com.jger.groupe4.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.jger.groupe4.model.Entities.Calcul;

public class CalculDao  extends BaseDao<Calcul>{
    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    static String clePremierElement="premierelement";
    static String cleDeuxiemeElement="deuxiemeelement";
    static String cleSymbol="symbol";
    static String cleResultat="resultat";

    @Override
    protected String getTableName() {
        return "historique";
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(clePremierElement,entity.getPremierElement());
        values.put(cleDeuxiemeElement,entity.getDeuxiemeElement());
        values.put(cleSymbol,entity.getSymbol());
        values.put(cleResultat,entity.getResultat());
    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        Calcul calcul = new Calcul();


        Integer indexPremierElement = cursor.getColumnIndex(clePremierElement);
        Integer indexDeuxiemeElement= cursor.getColumnIndex(cleDeuxiemeElement);
        Integer indexSymbol = cursor.getColumnIndex(cleSymbol);
        Integer indexResultat = cursor.getColumnIndex(cleResultat);

        calcul.setPremierElement(cursor.getDouble(indexPremierElement));
        calcul.setDeuxiemeElement(cursor.getDouble(indexDeuxiemeElement));
        calcul.setSymbol(cursor.getString(indexSymbol));
        calcul.setResultat(cursor.getDouble(indexResultat));

        return calcul;
    }
}
