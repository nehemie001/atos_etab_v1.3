package services.impl;

import dao.IUtilisateurDao;
import dao.Impl.UtilisateurDaoImpl;
import models.Utilisateur;
import services.IUtilisateurService;

import java.sql.SQLException;
import java.util.List;

public class UtilisateurServiceImpl implements IUtilisateurService {
    private IUtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl() {
        this.utilisateurDao = new UtilisateurDaoImpl();
    }

    @Override
    public boolean authentification(String identifiant, String motDePasse) throws SQLException {
        Utilisateur user = utilisateurDao.getUser(identifiant,motDePasse);
        return user!=null;
    }

    @Override
    public boolean ajouterCompte(String identifiant, String motDePasse) {
        return false;
    }

    @Override
    public boolean modifierMotDepass(String identifiant, String motDePasse) {
        return false;
    }

    @Override
    public boolean supprimerCompte(String identifiant, String motDePasse) {
        return false;
    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return List.of();
    }
}
