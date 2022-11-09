package com.david.backend.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.backend.dao.RoleDao;
import com.david.backend.dao.UserDao;
import com.david.backend.entity.Role;
import com.david.backend.entity.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user) {
        return userDao.save(user);
    }

    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("David");
        user.setUserLastName("Mateus");
        user.setUserName("davidmateus");
        user.setUserPassword("123456");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }
}
