package com.jger.groupe4.database;

import android.content.Context;

public class ComputeBaseHelper extends DataBaseHelper {


    public ComputeBaseHelper(Context context) {
        super(context, "Calcul", 1);
    }

    @Override
    protected String getCreationSql() {
        return null;
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
