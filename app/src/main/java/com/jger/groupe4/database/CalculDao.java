package com.jger.groupe4.database;

import android.content.ContentValues;
import android.database.Cursor;

import com.jger.groupe4.model.Entities.Calcul;

public class CalculDao  extends BaseDao<Calcul>{
    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {

    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        return null;
    }
}
