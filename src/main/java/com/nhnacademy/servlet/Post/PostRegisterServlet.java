package com.nhnacademy.servlet.Post;

import com.nhnacademy.domain.Counter;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.PostRepository;
import com.nhnacademy.servlet.Command;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostRegisterServlet implements Command {
    LocalDateTime now = LocalDateTime.now();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        Counter counter = (Counter) req.getServletContext().getAttribute("counter");
            Post post = new Post(
            req.getParameter("title"),
            req.getParameter("content"),
            req.getParameter("id"),
            LocalDateTime.now(),counter.getCount()
        );
        PostRepository postRepository =
            (PostRepository) req.getServletContext().getAttribute("postRepository");
        ServletContext servletContext = req.getServletContext();
        postRepository.register(post);
        servletContext.setAttribute("post",post);
        servletContext.setAttribute("counter",counter);
        List<Post> postlist = postRepository.getPosts();
        servletContext.setAttribute("postlist",postlist);
        return "/postindex.jsp";
    }
}
