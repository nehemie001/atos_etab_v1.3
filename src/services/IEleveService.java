package services;

import models.Eleve;

import java.sql.SQLException;

public interface  IEleveService {

    Eleve save(Eleve eleve) throws SQLException;
    Eleve update(Eleve eleve);
    void delete(int identifiant);
    Eleve getOne(int identifiant);
}
