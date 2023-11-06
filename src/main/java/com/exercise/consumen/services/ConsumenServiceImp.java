package com.exercise.consumen.services;

import com.exercise.consumen.models.Consumen;
import com.exercise.consumen.repositories.ConsumenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumenServiceImp implements ConsumenService{

    @Autowired
    private ConsumenDao consumenDao;

    @Override
    public List<Consumen> getAll() {
        return consumenDao.getAll();
    }

    @Override
    public Consumen getConsumenById(int id) {
        return consumenDao.getById(id);
    }

    @Override
    public void addConsumen(Consumen consumen) {
        consumenDao.insertConsumen(consumen);
    }
}
