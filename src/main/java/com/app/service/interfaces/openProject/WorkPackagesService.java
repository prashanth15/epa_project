package com.app.service.interfaces.openProject;

import com.app.model.openProject.PlanningDataModel;
import com.app.model.openProject.WorkPackages;

import java.util.List;


public interface WorkPackagesService {
    public List<WorkPackages> getStatusOfTasks(int userId, String startDate, String endDate);
    public PlanningDataModel getPlaningTheProject(int userId, String startDate, String endDate);
    public long getDefectCount(int userId, String startDate, String endDate);
    public long getFixedDefectCount(int userId, String startDate, String endDate);
}
