package com.nhnacademy.servlet.Post;

import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.PostRepository;
import com.nhnacademy.servlet.Command;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostDeleteServlet implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext();
        PostRepository postRepository =
            (PostRepository) servletContext.getAttribute("postRepository");
        Post post = (Post) servletContext.getAttribute("post");
        ArrayList<Post> postlist = (ArrayList<Post>) servletContext.getAttribute("postlist");
        String id = req.getParameter("id");
        postRepository.getPost(id);
        if(Objects.isNull(post)){
            return "/404.jsp";
        }
        else{

            req.setAttribute("postRepository",postRepository);
            for(int i = 0; i<postlist.size();i++){
                if(postlist.get(i).equals(post)){
                    postRepository.remove(id);
                    postlist.remove(i);
                }
            }
            servletContext.setAttribute("postlist",postlist);
            req.setAttribute("post", post);
            return "/postDeleteView.jsp";
        }
    }
}
