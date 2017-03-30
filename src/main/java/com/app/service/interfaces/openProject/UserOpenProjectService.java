package com.app.service.interfaces.openProject;

import com.app.model.openProject.UsersOpenProject;

import java.util.List;


public interface UserOpenProjectService {
    public List<UsersOpenProject> listUsers();
    public String getLoginByUserId(int id);
}
