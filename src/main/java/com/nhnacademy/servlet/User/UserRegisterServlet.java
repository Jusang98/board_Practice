package com.nhnacademy.servlet.User;




import com.nhnacademy.domain.MapUserRepository;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserRepository;
import com.nhnacademy.servlet.Command;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterServlet implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp){
        User user = new User(
            req.getParameter("id"),
            req.getParameter("pwd"),
            req.getParameter("name"));

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");
        ServletContext servletContext = req.getServletContext();
        userRepository.addUser(user);
        List<User> userlist = userRepository.getUsers();
        servletContext.setAttribute("userlist",userlist);
        return "redirect:/user/view.do?id="+user.getId();
    }
}

