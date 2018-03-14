package com.db.base;

import com.db.entitys.ClientsUpsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateDataBase {

    private static SessionFactory sessionFactory;
    private static Session session;

    public HibernateDataBase(){
        //1. 创建配置对象
        Configuration config = new Configuration().configure();
        config.addClass(ClientsUpsEntity.class);
        //2. 创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        //3. 创建会话工厂对象
        sessionFactory = config.buildSessionFactory(serviceRegistry);
    }

    //4. 会话对象
    protected Session getSession(){
        return session = sessionFactory.openSession();
    }

    //9. 关闭会话
    protected void closeSession(){
        if(null != session){
            session.close();
        }
    }

    //10. 关闭会话工厂
    protected void closeSessionFactory(){
        if(null != sessionFactory){
            sessionFactory.close();
        }
    }
}
