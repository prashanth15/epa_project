package com.app.service.epa;

import com.app.dao.epa.ProjectScoresDAOImpl;
import com.app.model.epa.ProjectScores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectScoreServiceImpl {
    ProjectScoresDAOImpl projectScoresDAO;

    @Autowired
    public void setProjectScoresDAO(ProjectScoresDAOImpl projectScoresDAO) {
        this.projectScoresDAO = projectScoresDAO;
    }

    public void updateProjectScore(ProjectScores projectScores){
        projectScoresDAO.insertGroupScores(projectScores);
    }


    public Double getLatestProjectScore(int projectId){
        return projectScoresDAO.getLatestProjectScore(projectId);
    }

}
