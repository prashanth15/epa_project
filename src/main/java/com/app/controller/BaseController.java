package com.app.controller;

import com.app.model.epa.Sprint;
import com.app.requestBody.SprintDuration;
import com.app.service.epa.SprintServiceImpl;
import com.app.service.openProject.UserOpenProjectServiceImpl;
import com.sun.deploy.nativesandbox.comm.Response;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
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


//    @Autowired
//    SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    CronTrigger cronTrigger;



    @RequestMapping(value = "/configuration", method = RequestMethod.GET)
    public String goToLoginPage(ModelMap model) {
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

        String cronExpression = "0/" + duration +" * * * * ?";

//        try {
//            cronTrigger.clearAllTriggerListeners();
//            cronTrigger.setCronExpression(cronExpression);
//            Trigger[] triggers = {cronTrigger};
//
//            schedulerFactory.stop();
//            schedulerFactory.setTriggers(triggers);
//            schedulerFactory.start();
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        sprintService.updateSprint(sprint);
        return sprintDuration;
    }

}
