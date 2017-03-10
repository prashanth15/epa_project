package com.app.dao.openProject;

import com.app.dao.interfaces.openProject.WorkPackagesDAO;
import com.app.model.openProject.WorkPackages;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

/**
 * Created by K.Kokulan on 3/10/2017.
 */

@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, value = "transactionManager_openproject")
public class WorkPackagesDAOImpl implements WorkPackagesDAO{

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(@Qualifier("hibernate4_openproject")SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<WorkPackages> getStatusOfTasks(int userId, String startDate, String endDate){
        Session session = this.sessionFactory.getCurrentSession();
        String query = "FROM com.app.model.openProject.WorkPackages as wp WHERE wp.assigned_to_id = "+ userId +" AND wp.type_id = 1 AND wp.updated_at between '" + startDate + "' and '" + endDate+ "'";
        List<WorkPackages> data = session.createQuery(query).list();

        return data;
    }
}
