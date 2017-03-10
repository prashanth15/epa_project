package com.app.service.openProject;

import com.app.dao.interfaces.openProject.WorkPackagesDAO;
import com.app.model.openProject.WorkPackages;
import com.app.service.interfaces.openProject.WorkPackagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K.Kokulan on 3/10/2017.
 */

@Service
public class WorkPackagesServiceImpl implements WorkPackagesService{

    WorkPackagesDAO workPackagesDAO;

    @Autowired
    public void setWorkPackagesDAO(@Qualifier("WorkPackagesDAO") WorkPackagesDAO workPackagesDAO) {
        this.workPackagesDAO = workPackagesDAO;
    }

    @Override
    public List<WorkPackages> getStatusOfTasks(int userId, String startDate, String endDate){
        return workPackagesDAO.getStatusOfTasks(userId, startDate, endDate);
    }
}
