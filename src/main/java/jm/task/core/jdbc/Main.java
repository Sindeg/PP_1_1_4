package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        List<User> userList = List.of(
                new User("Ivan", "Nikitin", (byte) 19),
                new User("Sergey", "Popov", (byte) 23),
                new User("Konstantin", "Sidorov", (byte) 54),
                new User("Oleg", "Komarov", (byte) 71)
        );

        for (User user : userList) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.printf("User с именем – %s добавлен в базу данных", user.getAge());
        }

        List<User> usersFromService = userService.getAllUsers();
        for (User user : usersFromService) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
        Util.closeSessionFactory();
    }
}
