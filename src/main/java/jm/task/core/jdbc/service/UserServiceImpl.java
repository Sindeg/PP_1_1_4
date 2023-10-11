package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDaoJDBC = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
