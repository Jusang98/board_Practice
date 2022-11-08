package com.nhnacademy.servlet.User;

import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserRepository;
import com.nhnacademy.servlet.Command;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDeleteServlet implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        UserRepository userRepository =
            (UserRepository) servletContext.getAttribute("userRepository");
        ArrayList<User> userlist = (ArrayList<User>) servletContext.getAttribute("userlist");
        String id = req.getParameter("id");
        User user = userRepository.getUser(id);
        if(Objects.isNull(user)){
            return "/404.jsp";
        }
        else{
            userRepository.remove(id);
            for(int i = 0; i<userlist.size();i++){
                if(userlist.get(i).getId().equals(id)){
                    userlist.remove(i);
                }
            }
            servletContext.setAttribute("userlist",userlist);
            req.setAttribute("user", user);
            return "/userdeleteView.jsp";

        }

    }
}
