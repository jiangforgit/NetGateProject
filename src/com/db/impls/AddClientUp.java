package com.db.impls;

import com.db.base.HibernateDataBase;
import com.db.entitys.ClientsUpsEntity;
import com.db.interfaces.IAddClientUp;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddClientUp extends HibernateDataBase implements IAddClientUp {

    @Override
    public boolean addClientUp(ClientsUpsEntity entity) {
        boolean result = false;
        Session session = getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
