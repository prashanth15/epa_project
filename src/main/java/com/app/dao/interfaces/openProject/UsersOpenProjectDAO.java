package com.app.dao.interfaces.openProject;

import com.app.model.openProject.UsersOpenProject;

import java.util.List;

/**
 * Created by K.Kokulan on 2/28/2017.
 */
public interface UsersOpenProjectDAO {
    public List<UsersOpenProject> listUsers();
    public String getUserLoginById(int id);

}
