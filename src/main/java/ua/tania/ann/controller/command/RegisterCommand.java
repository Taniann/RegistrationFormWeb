package ua.tania.ann.controller.command;
import ua.tania.ann.model.entity.RegisteredUser;
import ua.tania.ann.model.service.RegisteredUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Таня on 08.08.2018.
 */
public class RegisterCommand implements Command {
    RegisteredUserService registeredUserService = new RegisteredUserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        RegisteredUser newRegisteredUser = new RegisteredUser(email, phoneNumber, login, password);
        registeredUserService.insert(newRegisteredUser);
        return "register";
    }
}
