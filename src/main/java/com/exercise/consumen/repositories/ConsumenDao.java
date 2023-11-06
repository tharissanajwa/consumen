package com.exercise.consumen.repositories;

import com.exercise.consumen.models.Consumen;

import java.util.List;

public interface ConsumenDao {

    public List<Consumen> getAll();
    public Consumen getById(Integer id);
    public void insertConsumen(Consumen consumen);

}
