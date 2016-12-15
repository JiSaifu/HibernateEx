package com.yuwxw.saifu.ji.ex.hbmst.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hiberbnate session构筑类
 *
 * Created by Ji.Saifu on 2016/11/24.
 */
public class BaseHibernateService {
    public static SessionFactory sessionFactory;

    static {
        try {
            // Configuration用来配置并启动Hibernate。
            // 采用hibernate.cfg.xml配置文件的场合，使用如下Config的配置方法，
            // 不需要显式地加载对象-关系映射文件
            Configuration config = new Configuration().configure();

            // 使用properties配置文件的场合，使用如下Config配置方法，
            // 需要加载类的对象-关系映射文件
            // Configuration config = new Configuration();
            // config.addClass(Dog.class);

            // 创建SessionFactory实例，一个实例对应一个数据存储源。
            // 创建数据库存储源需要消耗很多资源，不可随意创建。
            sessionFactory = config.buildSessionFactory();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
