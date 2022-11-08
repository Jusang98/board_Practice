package com.nhnacademy.servlet.Post;

import com.nhnacademy.domain.Counter;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.PostRepository;
import com.nhnacademy.servlet.Command;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostModifyServlet implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        Counter counter = (Counter) servletContext.getAttribute("counter");
            PostRepository postRepository =
            (PostRepository) servletContext.getAttribute("postRepository");
        String id = req.getParameter("id");
        Post post = new Post(
            req.getParameter("newtitle"),
            req.getParameter("newcontent"),
            req.getParameter("id"),
            LocalDateTime.now(),counter.getCount()
        );

        if (Objects.isNull(post)) {
            return "/404.jsp";
        } else {
            postRepository.remove(id);
            postRepository.register(post);
            List<Post> postlist = postRepository.getPosts();
            for (int i = 0; i < postlist.size(); i++) {
                if (postlist.get(i).getId().equals(id)) {
                    postlist.remove(i);
                }
            }
            servletContext.setAttribute("postlist",postlist);
            req.setAttribute("post", post);
            return "/postindex.jsp";

        }
    }
}
