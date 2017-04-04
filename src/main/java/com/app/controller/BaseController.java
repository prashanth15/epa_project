package com.app.controller;

import com.app.Criteria.handler.ScoreHandler;
import com.app.Criteria.individual.*;
import com.app.Criteria.projects.ProjectTeamCodeQuality;
import com.app.Criteria.projects.ProjectTeamDefectCount;
import com.app.Criteria.projects.ProjectTeamEfficiency;
import com.app.Criteria.projects.ProjectTeamWorkCompletion;
import com.app.model.epa.IndividualScores;
import com.app.model.epa.PersonalTraits;
import com.app.model.epa.Sprint;
import com.app.model.openProject.WorkPackages;
import com.app.requestBody.IndiScoreWeight;
import com.app.requestBody.PersonalTraitsRB;
import com.app.requestBody.SprintDuration;
import com.app.service.epa.IndiScoreWeightService;
import com.app.service.epa.IndividualScoreServiceImpl;
import com.app.service.epa.PersonalTraitsServiceImpl;
import com.app.service.epa.SprintServiceImpl;
import com.app.service.openProject.UserOpenProjectServiceImpl;
import com.app.service.openProject.WorkPackagesServiceImpl;
import com.sun.deploy.nativesandbox.comm.Response;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.CronTriggerBean;
import org.springframework.scheduling.quartz.JobDetailBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.support.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class BaseController {

    @Autowired(required=true)
    @Qualifier(value="userOpenProjectService")
    UserOpenProjectServiceImpl userOpenProjectService;

    @Autowired
    @Qualifier(value = "sprintServiceImpl")
    SprintServiceImpl sprintService;

    @Autowired
    @Qualifier(value = "personalTraitsServiceImpl")
    PersonalTraitsServiceImpl personalTraitsServiceImpl;

    @Autowired
    @Qualifier(value = "indiScoreWeightService")
    IndiScoreWeightService indiScoreWeightService;

    @Autowired
    JobDetailBean queryScheduler;

    @Autowired
    CronTriggerBean cronTriggerBean;

    @Autowired
    ScoreHandler scoreHandler;


    @RequestMapping(value = "/configuration", method = RequestMethod.GET)
    public String goToLoginPage(ModelMap model) {
        model.addAttribute("users", userOpenProjectService.listUsers());
//        scoreHandler.scheduleScoreHandlers();
        return "adminConfiguration";
    }

    @RequestMapping(value = "/update_duration", method = RequestMethod.POST, consumes="application/json",headers = "content-type=application/json")
    public @ResponseBody SprintDuration updateDuration(@RequestBody SprintDuration sprintDuration) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        Sprint sprint = new Sprint();
        sprint.setId(1);
        sprint.setLast_update(simpleDateFormat.format(date));

        int duration = Integer.parseInt(sprintDuration.getDuration());
        sprint.setNo_of_days(duration);
        sprintService.updateSprint(sprint);
        return sprintDuration;
    }

    @RequestMapping(value = "/update_personal_traits", method = RequestMethod.POST, consumes="application/json",headers = "content-type=application/json")
    public @ResponseBody PersonalTraitsRB updatePerTraits(@RequestBody PersonalTraitsRB personalTraitsRB) {
        personalTraitsServiceImpl.updatePersonalTrait(personalTraitsRB.getEmpId(), personalTraitsRB.getScore());
        return personalTraitsRB;
    }


    @RequestMapping(value = "/update_isw", method = RequestMethod.POST, consumes="application/json",headers = "content-type=application/json")
    public @ResponseBody IndiScoreWeight updateIndiScoreWeights(@RequestBody IndiScoreWeight indiScoreWeight) {
        indiScoreWeightService.updateScore(indiScoreWeight);
        return indiScoreWeight;
    }

}
