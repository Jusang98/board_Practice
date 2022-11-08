package com.nhnacademy.servlet.Post;

import com.nhnacademy.domain.Counter;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.PostRepository;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.UserRepository;
import com.nhnacademy.servlet.Command;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriterViewServlet implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        PostRepository postRepository =
            (PostRepository) req.getServletContext().getAttribute("postRepository");
        UserRepository userRepository =
            (UserRepository) req.getServletContext().getAttribute("userRepository");
        String id = req.getParameter("id");
        User user = userRepository.getUser(id);
        Post post = postRepository.getPost(id);
        Counter counter = (Counter) req.getServletContext().getAttribute("counter");

        if(Objects.isNull(user)){
            return"/404.jsp";
        }
        else{
            counter.setCount();
            req.setAttribute("counter",counter);
            req.setAttribute("user",user);
            req.setAttribute("post",post);
            return "/writerView.jsp";
        }

    }
}
