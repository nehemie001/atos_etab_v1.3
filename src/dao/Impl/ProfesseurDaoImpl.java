package dao.Impl;

import dao.IProfesseurDao;
import dao.SingletonDataBase;
import models.Professeur;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProfesseurDaoImpl implements IProfesseurDao {
    @Override
    public void save(Professeur professeur) throws SQLException {
        PreparedStatement Pstmt = null;
        String query = "INSERT INTO Personne () VALUE (?, ?, ?, ?, ?)";
        try {
            Pstmt = SingletonDataBase.getInstance().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            Pstmt.setString(1, null);
            Pstmt.setString(2, professeur.getNom());
            Pstmt.setString(3, professeur.getPrenom());
            Pstmt.setString(3, professeur.getVille());
            Pstmt.setString(5, professeur.getTelephone());

            Pstmt.executeUpdate();

//            Recuperer l'Id pour
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Professeur modifier(Professeur professeur) {
        return null;
    }

    @Override
    public void supprimer(int identifiant) {

    }

    @Override
    public List obtenirProfesseur() {
        return List.of();
    }

    @Override
    public void Obtenir(int identifiant) {

    }
}
