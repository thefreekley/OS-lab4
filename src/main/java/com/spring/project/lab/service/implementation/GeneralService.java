package com.spring.project.lab.service.implementation;

import com.spring.project.lab.service.GeneralServiceInterface;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

public abstract class GeneralService<T> implements GeneralServiceInterface<T> {
    @Override
    public List<T> findAll() {
        List<T> ts = new LinkedList<>(getRepository().findAll());
        if (ts.isEmpty()) {
            return null;
        }
        return ts;
    }

    @Override
    public T find(Integer id) {
        if (getRepository().findById(id).isPresent()) {
            return getRepository().findById(id).get();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void create(T t) {
        if (t != null) {
            getRepository().save(t);
        }
    }

    @Override
    @Transactional
    public void update(T t) {
        getRepository().save(t);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if (getRepository().findById(id).isPresent()) {
            getRepository().deleteById(id);
        }
    }

}
