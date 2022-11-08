package com.nhnacademy.servlet;

import com.nhnacademy.domain.Counter;
import com.nhnacademy.domain.ListPostRepository;
import com.nhnacademy.domain.MapUserRepository;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class WepAppListener implements  ServletContextListener {

        @Override
        public void contextInitialized(ServletContextEvent sce) {
            ServletContext servletContext = sce.getServletContext();
            servletContext.setAttribute("userRepository", new MapUserRepository());
            servletContext.setAttribute("postRepository",new ListPostRepository());
            servletContext.setAttribute("counter",new Counter());
        }
    }

