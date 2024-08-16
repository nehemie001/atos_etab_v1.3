package services.impl;

import dao.IEleveDao;
import dao.Impl.EleveDaoImpl;
import models.Eleve;
import services.IEleveService;

import java.sql.SQLException;

public class EleveServiceImpl implements IEleveService {

    private IEleveDao eleveDao;

    public EleveServiceImpl() {
        this.eleveDao = new EleveDaoImpl();
    }

    @Override
    public Eleve save(Eleve eleve) throws SQLException {
        eleveDao.save(eleve);
        return eleve;
    }

    @Override
    public Eleve update(Eleve eleve) {
        return null;
    }

    @Override
    public void delete(int id) {
        eleveDao.delete(id);

    }

    @Override
    public Eleve getOne(int id) {
        return null;
    }
}
