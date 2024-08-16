package dao;

import models.Professeur;

import java.sql.SQLException;
import java.util.List;

public interface IProfesseurDao {

    void save(Professeur professeur) throws SQLException;
    public Professeur modifier(Professeur professeur);
    public void supprimer(int identifiant);
    public List obtenirProfesseur();
    public void Obtenir(int identifiant);
}
