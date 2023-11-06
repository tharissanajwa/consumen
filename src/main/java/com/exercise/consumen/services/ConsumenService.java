package com.exercise.consumen.services;

import com.exercise.consumen.models.Consumen;

import java.util.List;

public interface ConsumenService {
    List<Consumen> getAll();
    Consumen getConsumenById(int id);
    void addConsumen(Consumen consumen);
}
