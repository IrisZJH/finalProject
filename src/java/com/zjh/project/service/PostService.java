package com.zjh.project.service;

import com.zjh.project.entity.Dept;
import com.zjh.project.entity.Post;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
public interface PostService {
    public void addPost(Post post);
    public void updatePost(Post post);
    public void deletePost(Post post);
    public List<Post> getAll();
    public Post getPostByPid(int pid);
    public Post getPostByPname(String name);
    public List<Post> getPostByDid(int did);
}
