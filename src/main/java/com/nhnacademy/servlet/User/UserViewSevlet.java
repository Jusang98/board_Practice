package com.nhnacademy.servlet.User;




import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserRepository;
import com.nhnacademy.servlet.Command;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import javax.servlet.http.HttpSession;

public class UserViewSevlet implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        UserRepository userRepository = (UserRepository) servletContext.getAttribute("userRepository");

        String id = req.getParameter("id");
        User user =userRepository.getUser(id);
        List<User> userlist = (List<User>) servletContext.getAttribute("userlist");
        HttpSession session = req.getSession();
        if(Objects.isNull(user)){
            return "/404.jsp";
        }
        else{
            req.setAttribute("user", user);
            req.setAttribute("userlist",userlist);
            session.removeAttribute("userlist");
            return "/userView.jsp";
        }

    }
}


