package com.app.service.epa;

import com.app.dao.interfaces.epa.SprintDAO;
import com.app.model.epa.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by K.Kokulan on 3/1/2017.
 */
@Service
public class SprintServiceImpl {
    SprintDAO sprintDAO;

    @Autowired
    public void setSprintDAO(SprintDAO sprintDAO) {
        this.sprintDAO = sprintDAO;
    }

    public void addSprint(Sprint sprint){
        sprintDAO.addSprint(sprint);
    }

    public void updateSprint(Sprint sprint){
        sprintDAO.updateSprint(sprint);
    }
}
