package services.impl;

import dao.IProfesseurDao;
import models.Professeur;
import services.IProfesseurService;

import java.sql.SQLException;
import java.util.List;

public class ProfesseurServiceImpl implements IProfesseurService {

    private IProfesseurDao professeurDao;

    public ProfesseurServiceImpl(IProfesseurDao professeurDao) {
        this.professeurDao = professeurDao;
    }

    @Override
    public Professeur save(Professeur professeur) throws SQLException {
        professeurDao.save(professeur);
        return professeur;
    }

    @Override
    public Professeur update(Professeur professeur) {
        return null;
    }

    @Override
    public void delete(int identifiant) {

    }

    @Override
    public List<Professeur> getAll() {
        return List.of();
    }

    @Override
    public void getOne(int identifiant) {

    }
}
