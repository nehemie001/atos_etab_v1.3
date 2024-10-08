package dao;

import models.Eleve;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface définissant les opérations CRUD pour la gestion des élèves.
 */
public interface IEleveDao {

    /**
     * Ajoute un élève.
     *
     * @param eleve Élève à ajouter.
     * @return Élève ajouté.
     */
    void save(Eleve eleve) throws SQLException;

    /**
     * Modifie un élève.
     *
     * @param eleve Élève à modifier.
     * @return Élève modifié.
     */
    Eleve modifier(Eleve eleve) throws SQLException;

    /**
     * Supprime un élève par son identifiant.
     *
     * @param id Identifiant de l'élève à supprimer.
     */
    void delete(int ic);

    /**
     * Obtient un élève par son identifiant.
     *
     * @param identifiant Identifiant de l'élève.
     * @return Élève trouvé.
     */
    Eleve Obtenir(int identifiant);

    /**
     * Obtient la liste de tous les élèves.
     *
     * @return Liste d'élèves.
     */
    List<Eleve> obtenirProfesseur();
}
