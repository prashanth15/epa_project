package com.app.service.interfaces.openProject;

import com.app.model.openProject.UsersOpenProject;

import java.util.List;

/**
 * Created by K.Kokulan on 2/28/2017.
 */
public interface UserOpenProjectService {
    public void addUser(UsersOpenProject p);
    public void updateUser(UsersOpenProject p);
    public List<UsersOpenProject> listUsers();
    public UsersOpenProject getUserById(int id);
    public void removeUSer(int id);
}
