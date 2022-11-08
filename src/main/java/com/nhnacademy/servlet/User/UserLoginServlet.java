package com.nhnacademy.servlet.User;

import com.nhnacademy.domain.User;
import com.nhnacademy.servlet.Command;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLoginServlet implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
                ServletContext servletContext = req.getServletContext();
        ArrayList<User> userlist = (ArrayList<User>) servletContext.getAttribute("userlist");
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        for(int i =0;i<userlist.size(); i++){
          if(userlist.get(i).getId().equals(id)&&userlist.get(i).getPwd().equals(pwd)){
              return "/postindex.jsp";
          }else {
              return "/userlogin.jsp";
          }
        }
        return null;
    }
}
