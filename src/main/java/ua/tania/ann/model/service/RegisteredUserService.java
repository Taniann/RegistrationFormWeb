package ua.tania.ann.model.service;

import ua.tania.ann.model.dao.RegisteredUserDao;
import ua.tania.ann.model.entity.RegisteredUser;

/**
 * Created by Таня on 08.08.2018.
 */
public class RegisteredUserService {
    RegisteredUserDao registeredUserDao = new RegisteredUserDao();

    public boolean insert(RegisteredUser registeredUser) {
        return true;
    }
}
