package ua.tania.ann.model.service;

import ua.tania.ann.model.dao.RegisteredUserDao;
import ua.tania.ann.model.entity.RegisteredUser;
import ua.tania.ann.model.service.validation.RegexConstants;

/**
 * Created by Таня on 08.08.2018.
 */
public class RegisteredUserService {
    RegisteredUserDao registeredUserDao = new RegisteredUserDao();

    public boolean insert(RegisteredUser registeredUser) {
        if (checkEmail(registeredUser.getEmail()) || checkPhoneNumber(registeredUser.getPhoneNumber())) {
            return registeredUserDao.insertRegisteredUser(registeredUser);
        }
        else return false;
    }

    public boolean checkEmail(String email) {
        return email.matches(RegexConstants.EMAIL);
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(RegexConstants.TELEPHONE);
    }
}
