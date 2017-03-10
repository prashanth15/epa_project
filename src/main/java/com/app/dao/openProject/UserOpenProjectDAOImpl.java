package com.app.dao.openProject;

import com.app.dao.interfaces.openProject.UsersOpenProjectDAO;
import com.app.model.openProject.UsersOpenProject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

/**
 * Created by K.Kokulan on 2/28/2017.
 */
@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, value = "transactionManager_openproject")
public class UserOpenProjectDAOImpl implements UsersOpenProjectDAO {

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(@Qualifier("hibernate4_openproject")SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(UsersOpenProject p) {

    }

    @Override
    public void updateUser(UsersOpenProject p) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UsersOpenProject> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UsersOpenProject> users = session.createQuery("select u.firstname from com.app.model.openProject.UsersOpenProject as u").list();
        return users;
    }

    @Override
    public UsersOpenProject getUserById(int id) {
        return null;
    }

    @Override
    public void removeUSer(int id) {

    }
}
