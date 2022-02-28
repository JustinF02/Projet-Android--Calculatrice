package com.jger.groupe4.service;

import com.jger.groupe4.database.CalculDao;
import com.jger.groupe4.model.Entities.Calcul;

public class CalculService {
    private CalculDao calculDao;

    public CalculService(CalculDao calculDao) {
        this.calculDao = calculDao;
    }

    public Long getCalculCount(){
        return calculDao.count();
    }

    public void storeInDb(Calcul calcul){
        calculDao.create(calcul);
    }

    public Calcul getLast(){
        return  calculDao.lastOrNull();
    }
}
