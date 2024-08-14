package dao.Impl;

import dao.IEleveDao;
import dao.SingletonDataBase;
import models.Eleve;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class EleveDaoImpl implements IEleveDao {

    @Override
    public Eleve Ajouter(Eleve eleve) {
        String query = "INSERT INTO Personne () values(? , ? , ? , ? , ? , ?)";
        try{
            PreparedStatement Pstmt = SingletonDataBase.getInstance().prepareStatement(query , PreparedStatement.RETURN_GENERATED_KEYS);

            Pstmt.setString(1 , null);
            Pstmt.setString(2 , eleve.getNom());
            Pstmt.setString(3 , eleve.getPrenom());
            Pstmt.setString(4 , eleve.getVille());
            Pstmt.setString(5 , eleve.getTelephone());
            Pstmt.setString(6 , eleve.getDateNaissance());

            Pstmt.executeUpdate();

            // Récupération du dernier ID inséré
            ResultSet rs = Pstmt.getGeneratedKeys();
            int lastInsertedId = 0;
            if (rs.next()) {
                lastInsertedId = rs.getInt(1);
            }
            eleve.setId(lastInsertedId);


            String query1 = "INSERT INTO Eleve values(? , ? , ? , ? )";
            PreparedStatement Pstmt1 = SingletonDataBase.getInstance().prepareStatement(query1);

            Pstmt1.setString(1 , null);
            Pstmt1.setString(2 , eleve.getMatricule());
            Pstmt1.setString(3 , eleve.getClasse());
            Pstmt1.setInt(4 , lastInsertedId);

            Pstmt1.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return eleve;
    }

    @Override
    public Eleve modifier(Eleve eleve) throws SQLException {
        PreparedStatement Pstmt = null;
        PreparedStatement pstmtEleve = null;
        try {

            // Étape 1 :Update the table Person
            String sqlPersonne = "UPDATE Personne SET nom = ?, prenom = ?, dateNaissance = ?, telephone = ?, ville = ? WHERE id = ?";
            Pstmt = SingletonDataBase.getInstance().prepareStatement(sqlPersonne, PreparedStatement.RETURN_GENERATED_KEYS);
            Pstmt.setString(1, null);
            Pstmt.setString(1, eleve.getNom());
            Pstmt.setString(2, eleve.getPrenom());
            Pstmt.setString(3, eleve.getDateNaissance());
            Pstmt.setInt(4, eleve.getId());

            Pstmt.executeUpdate();

            // Étape 2 : Modifier la table Eleve
            String sqlEleve = "UPDATE Eleve SET classe = ?, numero_inscription = ? WHERE personne_id = ?";
            pstmtEleve = SingletonDataBase.getInstance().prepareStatement(sqlEleve);
            pstmtEleve.setString(1, null);
            pstmtEleve.setString(1, eleve.getMatricule());
            pstmtEleve.setString(1, eleve.getClasse());
//            pstmtEleve.setInt(3, eleve.getId());

            pstmtEleve.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
//            throw new SQLException("Erreur lors de la modification de l'élève");
        } finally {
            // Fermeture des ressources
            if (Pstmt != null) Pstmt.close();
            if (pstmtEleve != null) pstmtEleve.close();
        }
        return eleve;
    }

    @Override
    public void supprimer(int identifiant) {

    }

    @Override
    public Eleve Obtenir(int identifiant) {
        return null;
    }

    @Override
    public List<Eleve> obtenirProfesseur() {
        return List.of();
    }
}
