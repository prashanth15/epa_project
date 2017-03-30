package com.app.dao.openProject;

import com.app.dao.interfaces.openProject.WorkPackagesDAO;
import com.app.model.openProject.PlanningDataModel;
import com.app.model.openProject.WorkPackages;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;

import java.util.ArrayList;
import java.util.List;

@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, value = "transactionManager_openproject")
public class WorkPackagesDAOImpl implements WorkPackagesDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(@Qualifier("hibernate4_openproject") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<WorkPackages> getStatusOfTasks(int userId, String startDate, String endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "FROM com.app.model.openProject.WorkPackages as wp WHERE wp.assigned_to_id = " + userId + " AND wp.type_id = 1 AND wp.updated_at between '" + startDate + "' and '" + endDate + "'";
        List<WorkPackages> data = session.createQuery(query).list();

        return data;
    }

    @SuppressWarnings("unchecked")
    public PlanningDataModel getPlaningTheProject(int userId, String startDate, String endDate) {
        Session session = this.sessionFactory.getCurrentSession();

        /*
        Query : return estimated hour, and actual hour from work_packages and time estimate
         */
        String query = "SELECT wpack.estimated_hours, te.hours FROM " +
                "com.app.model.openProject.WorkPackages AS wpack, com.app.model.openProject.TimeEntries as te WHERE " +
                "wpack.assigned_to_id = te.user_id AND wpack.id = te.work_package_id AND wpack.project_id = te.project_id " +
                "AND te.hours IS NOT NULL AND wpack.assigned_to_id = " + userId + " AND wpack.assigned_to_id = te.user_id " +
                "AND wpack.type_id = 1 AND wpack.estimated_hours IS NOT NULL AND wpack.updated_at between '" + startDate +
                "' and '" + endDate + "'";

        final List<Object []> data = session.createQuery(query).list();

        Float actualSum = 0.0f;
        Float estimate = 0.0f;
        for(Object [] obj : data){
            estimate = (Float) obj[0];
            actualSum += (Float) obj[1];
        }
        PlanningDataModel planningDataModel = new PlanningDataModel();
        planningDataModel.setEstimated_hours(estimate);
        planningDataModel.setHours(actualSum);

        return planningDataModel;
    }


    @SuppressWarnings("unchecked")
    public long getDefectCount(int userId, String startDate, String endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "SELECT count(wp.id) FROM com.app.model.openProject.WorkPackages as wp WHERE wp.author_id = " +
                userId + " AND wp.updated_at between '" + startDate + "' and '" + endDate + "' AND wp.type_id = 7 AND " +
                "wp.status_id = 15";

        Long count = (Long)session.createQuery(query).uniqueResult();

        return count;
    }

    @SuppressWarnings("unchecked")
    public long getFixedDefectCount(int userId, String startDate, String endDate) {
        Session session = this.sessionFactory.getCurrentSession();
        String query = "SELECT count(wp.id) FROM com.app.model.openProject.WorkPackages as wp WHERE wp.assigned_to_id = " +
                userId + " AND wp.updated_at between '" + startDate + "' and '" + endDate + "' AND wp.type_id = 7 AND " +
                "wp.status_id = 13";

        Long count = (Long)session.createQuery(query).uniqueResult();

        return count;
    }


}
