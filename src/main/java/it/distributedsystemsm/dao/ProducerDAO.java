package it.distributedsystemsm.dao;

import it.distributedsystemsm.model.Producer;

import java.util.List;

public interface ProducerDAO {

    public void save(Producer customer);

    public void delete(Producer customer);

    public void delete(String name);

    public void delete(int id);

    public Producer find(String name);

    public Producer find(int id);

    public List<Producer> list();
}
