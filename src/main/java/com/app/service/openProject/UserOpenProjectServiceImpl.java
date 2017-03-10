package com.app.service.openProject;

import com.app.dao.interfaces.openProject.UsersOpenProjectDAO;
import com.app.model.openProject.UsersOpenProject;
import com.app.service.interfaces.openProject.UserOpenProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by K.Kokulan on 2/28/2017.
 */
@Service
public class UserOpenProjectServiceImpl implements UserOpenProjectService {

    UsersOpenProjectDAO usersOpenProjectDAO;


    @Autowired
    public void setUsersOpenProjectDAO(@Qualifier("UserOpenProjectDAO")UsersOpenProjectDAO usersOpenProjectDAO){
        this.usersOpenProjectDAO = usersOpenProjectDAO;
    }

    @Override
    public void addUser(UsersOpenProject p) {

    }

    @Override
    public void updateUser(UsersOpenProject p) {

    }

    @Override
    public List<UsersOpenProject> listUsers() {
        return usersOpenProjectDAO.listUsers();
    }

    @Override
    public UsersOpenProject getUserById(int id) {
        return null;
    }

    @Override
    public void removeUSer(int id) {

    }
}
