package com.app.service.interfaces.openProject;

import com.app.model.openProject.WorkPackages;

import java.util.List;

/**
 * Created by K.Kokulan on 3/10/2017.
 */
public interface WorkPackagesService {
    public List<WorkPackages> getStatusOfTasks(int userId, String startDate, String endDate);
}
