package com.nhnacademy.servlet.User;

import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserRepository;
import com.nhnacademy.servlet.Command;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserModifyServlet implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        UserRepository userRepository =
            (UserRepository) servletContext.getAttribute("userRepository");
        String id = req.getParameter("id");
        User user = new User(
            req.getParameter("newid"),
            req.getParameter("newpwd"),
            req.getParameter("newname")
        );

        if (Objects.isNull(user)) {
            return "/404.jsp";
        } else {
            userRepository.remove(id);
            userRepository.addUser(user);
            List<User> userlist = userRepository.getUsers();
            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).getId().equals(id)) {
                    userlist.remove(i);
                }
            }
            servletContext.setAttribute("userlist", userlist);
            req.setAttribute("user", user);
            return "/usermodifyView.jsp";

        }
    }
}
