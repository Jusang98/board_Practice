package com.nhnacademy.servlet;


import com.nhnacademy.servlet.Post.WriterViewServlet;
import com.nhnacademy.servlet.Post.PostDeleteServlet;
import com.nhnacademy.servlet.Post.PostModifyServlet;
import com.nhnacademy.servlet.Post.PostRegisterServlet;
import com.nhnacademy.servlet.User.UserDeleteServlet;
import com.nhnacademy.servlet.User.UserFormController;
import com.nhnacademy.servlet.User.UserLoginServlet;
import com.nhnacademy.servlet.User.UserModifyServlet;
import com.nhnacademy.servlet.User.UserRegisterServlet;
import com.nhnacademy.servlet.User.UserViewSevlet;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            // 실제 요청 처리할 Servlet 결정.
            Command command = resolveServlet(req.getServletPath());

            // 실제 요청을 처리할 Servlet으로 요청을 전달하여 처리 결과를 include시킴.
            // ex.) /student/register, /student/view
//            RequestDispatcher rd = req.getRequestDispatcher(processingServletPath);
//            rd.include(req, resp);
            String view = command.execute(req, resp);

            // 실제 요청을 처리한 Servlet이 `view`라는 request 속성 값으로 view를 전달해 줌.
//            String view = (String) req.getAttribute("view");
            if (view.startsWith(REDIRECT_PREFIX)) {
                // `redirect:`로 시작하면 redirect 처리.
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            }
            else {
                // redirect 아니면 JSP에게 view 처리를 위임하여 그 결과를 include시킴.
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        }
        catch (Exception ex) {
            // 에러가 발생한 경우는 error page로 지정된 `/error.jsp`에게 view 처리를 위임.
            log.error("", ex);
            req.setAttribute("exception", ex);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveServlet(String servletPath) {
//        String processingServletPath = null;
        Command command = null;
        if ("/user/form.do".equals(servletPath)) {
            command = new UserFormController();
        } else if ("/user/register.do".equals(servletPath)) {
            command = new UserRegisterServlet();
        } else if ("/user/view.do".equals(servletPath)) {
            command = new UserViewSevlet();
        } else if ("/user/delete.do".equals(servletPath)) {
            command = new UserDeleteServlet();
        } else if ("/user/modify.do".equals(servletPath)) {
            command = new UserModifyServlet();
        } else if ("/user/login.do".equals(servletPath)) {
            command = new UserLoginServlet();
        }else if("/post/register.do".equals(servletPath)){
            command = new PostRegisterServlet();
        } else if ("/post/writerView.do".equals(servletPath)) {
            command = new WriterViewServlet();
        } else if ("/post/modify.do".equals(servletPath)) {
            command = new PostModifyServlet();
        }else if("/delete.do".equals(servletPath)){
            command = new PostDeleteServlet();
        }

        return command;
    }
}

