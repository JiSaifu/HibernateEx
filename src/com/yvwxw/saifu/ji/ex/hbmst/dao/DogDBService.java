package com.yvwxw.saifu.ji.ex.hbmst.dao;

import com.yvwxw.saifu.ji.ex.hbmst.bean.Dog;
import com.yvwxw.saifu.ji.ex.hbmst.util.BaseHibernateService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Created by Ji.Saifu on 2016/11/26.
 */
public class DogDBService extends DBService<Dog> {

    @Override
    public void delete(Dog dog) {

    }

    /**
     * 通过指定OID删除对象Dog
     *
     * @param id 删除对象Dog的OID
     */
    @Override
    public void delete(Long id) {
        Session session = BaseHibernateService.sessionFactory.openSession();

        Transaction tx = null;

        try {
            Dog dog = search(id);

            tx = session.beginTransaction();
            session.delete(dog);
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

    /**
     * 通过指定OID查询特定的Dog
     *
     * @param id 查询对象Dog的OID
     * @return 查询对象Dog的实例
     */
    @Override
    public Dog search(Long id) {
        Session session = BaseHibernateService.sessionFactory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Dog dog = (Dog)session.get(Dog.class, id);
            return dog;
        } catch (RuntimeException e) {
            if (null != tx) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }


    /**
     * 通过指定OID更新Dog的name值
     *
     * @param id 更新对象OID
     * @param name  更新后的name值
     */
    public void updateName(Long id, String name) {
        Session session = BaseHibernateService.sessionFactory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Dog dog = (Dog)session.get(Dog.class, id);
            dog.setName(name);
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
}
