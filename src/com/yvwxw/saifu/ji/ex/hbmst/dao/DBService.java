package com.yvwxw.saifu.ji.ex.hbmst.dao;

import com.yvwxw.saifu.ji.ex.hbmst.bean.Entity;
import com.yvwxw.saifu.ji.ex.hbmst.util.BaseHibernateService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Ji.Saifu on 2016/11/26.
 */
public abstract class DBService<T extends Entity> {

    public void save(T entity) {
        Session session = BaseHibernateService.sessionFactory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public abstract void delete(T entity);

    public abstract void delete(Long id);

    public abstract Object search(Long id);

    public List<T> search(String hql) {
        Session session = BaseHibernateService.sessionFactory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            return query.list();
        } catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
