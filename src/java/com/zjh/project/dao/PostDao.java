package com.zjh.project.dao;

import com.zjh.project.entity.Post;
import com.zjh.project.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Repository
public interface PostDao {
    public void addPost(Post post);
    public void updatePost(Post post);
    public void deletePost(Post post);
    public List<Post> getAll();
    public Post getPostByPid(int pid);
    public Post getPostByPname(String name);
}
