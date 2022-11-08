package com.nhnacademy.servlet.User;

import com.nhnacademy.servlet.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFormController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
            return "/userRegister.jsp";
    }
}
