package com.jger.groupe4.database;

import android.content.Context;

public class ComputeBaseHelper extends DataBaseHelper {


    public ComputeBaseHelper(Context context) {
        super(context, "Calcul", 1);
    }

    @Override
    protected String getCreationSql() {

        return "CREATE TABLE IF NOT EXISTS historique (" +
                "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                CalculDao.clePremierElement + " DOUBLE NOT NULL, " +
                CalculDao.cleDeuxiemeElement + " DOUBLE NOT NULL," +
                CalculDao.cleSymbol + " VARCHAR(255) NOT NULL," +
                CalculDao.cleResultat + " DOUBLE NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
