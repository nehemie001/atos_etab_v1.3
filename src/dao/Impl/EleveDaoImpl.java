package dao.Impl;

import dao.IEleveDao;
import dao.SingletonDataBase;
import models.Eleve;

import java.sql.*;

import java.util.List;

public class EleveDaoImpl implements IEleveDao {

    /**
     * Ajoute un élève.
     *
     * @param eleve Élève à ajouter.
     * @return Élève ajouté.
     */
    @Override
    public void save(Eleve eleve) throws SQLException {
        ResultSet rs = null;
        PreparedStatement Pstmt = null;
        PreparedStatement PstmtE = null;
        String query = "INSERT INTO Personne () VALUES (?, ?, ?, ?, ?)";
        try {
            Pstmt = SingletonDataBase.getInstance().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

//             Étape 1 : Insérer dans la table Personne

            Pstmt.setString(1, null);
            Pstmt.setString(2, eleve.getNom());
            Pstmt.setString(3, eleve.getPrenom());
            Pstmt.setString(4, eleve.getVille());
            Pstmt.setString(5, eleve.getTelephone());

            Pstmt.executeUpdate();

//             Récupérer l'ID généré pour la personne

            rs = Pstmt.getGeneratedKeys();
            int personneId = 0;
            if (rs.next()) {
                personneId = rs.getInt(1);
            }

//             Étape 2 : Insérer les informations de l'eleve dans la table Eleve

            String query1 = "INSERT INTO Eleve () VALUES (?, ?, ?, ?)";
            PstmtE = SingletonDataBase.getInstance().prepareStatement(query1, PreparedStatement.RETURN_GENERATED_KEYS);
            PstmtE.setString(1, null);
            PstmtE.setString(2, eleve.getClasse());
            PstmtE.setString(3, eleve.getMatricule());
            PstmtE.setInt(4, personneId);
            PstmtE.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // Fermeture des ressources
            if (rs != null) rs.close();
            if (Pstmt != null) Pstmt.close();
            if (PstmtE != null) PstmtE.close();
        }

    }

    /**
     * Modifie un élève.
     *
     * @param eleve Élève à modifier.
     * @return Élève modifié.
     */
    @Override
    public Eleve modifier(Eleve eleve) throws SQLException {
        return null;
    }

    /**
     * Supprime un élève par son identifiant.
     *
     * @param id Identifiant de l'élève à supprimer.
     */
    @Override
    public void delete(int id) {

    }

    /**
     * Obtient un élève par son identifiant.
     *
     * @param identifiant Identifiant de l'élève.
     * @return Élève trouvé.
     */
    @Override
    public Eleve Obtenir(int identifiant) {
        return null;
    }

    /**
     * Obtient la liste de tous les élèves.
     *
     * @return Liste d'élèves.
     */
    @Override
    public List<Eleve> obtenirProfesseur() {
        return List.of();
    }
}
