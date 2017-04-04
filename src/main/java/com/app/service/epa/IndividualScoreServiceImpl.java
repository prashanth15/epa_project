package com.app.service.epa;

import com.app.dao.epa.IndividualScoreDAOImpl;
import com.app.model.epa.IndividualScores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualScoreServiceImpl {
    IndividualScoreDAOImpl individualScoreDAO;

    @Autowired
    public void setIndividualScoreDAO(IndividualScoreDAOImpl individualScoreDAO) {
        this.individualScoreDAO = individualScoreDAO;
    }

    public void insertIndividualScore(IndividualScores individualScores){
        individualScoreDAO.insertIndividualScore(individualScores);
    }
}

