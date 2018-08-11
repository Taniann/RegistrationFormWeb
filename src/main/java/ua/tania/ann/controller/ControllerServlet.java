package ua.tania.ann.controller;

import ua.tania.ann.controller.command.Command;
import ua.tania.ann.controller.command.LoginCommand;
import ua.tania.ann.controller.command.LogoutCommand;
import ua.tania.ann.controller.command.RegisterCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Таня on 08.08.2018.
 */
public class ControllerServlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(){
        commands.put("/logout", new LogoutCommand());
        commands.put("/login", new LoginCommand());
        commands.put("/register", new RegisterCommand());
        //commands.put("exception" , new Exception());
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = null;
            String nameCommand = request.getServletPath();
            Command command = commands.get(nameCommand);
        try {
            path = command.execute(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
       // requestDispatcher.forward(request, response);
        response.sendRedirect(path);
    }
}
