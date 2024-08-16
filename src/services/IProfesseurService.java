package services;

import models.Professeur;

import java.sql.SQLException;
import java.util.List;

public interface IProfesseurService {
    Professeur save(Professeur professeur) throws SQLException;
    public  Professeur update(Professeur professeur);
    public void delete(int identifiant);
    public List<Professeur> getAll();
    public void getOne(int identifiant);
}
