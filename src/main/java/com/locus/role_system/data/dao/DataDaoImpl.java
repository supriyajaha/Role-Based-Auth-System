package com.locus.role_system.data.dao;

import com.locus.role_system.data.entity.UserResourceRole;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataDaoImpl implements DataDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Boolean isAuthorized(String username, String resourceName, String action) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(UserResourceRole.class);
        criteria.createAlias("user","user");
        criteria.createAlias("resource","resource");
        criteria.createAlias("role","role");
        criteria.createAlias("role.actionTypes","actionTypes");
        criteria.add(Restrictions.eq("user.username",username));
        criteria.add(Restrictions.eq("resource.resourceName",resourceName).ignoreCase());
        criteria.add(Restrictions.eq("actionTypes.actionTypeName",action).ignoreCase());
        List list = criteria.list();
        return list.size() > 0;
    }
}
