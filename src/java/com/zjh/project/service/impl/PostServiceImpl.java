package com.zjh.project.service.impl;

import com.zjh.project.dao.DeptDao;
import com.zjh.project.dao.PostDao;
import com.zjh.project.entity.Dept;
import com.zjh.project.entity.Post;
import com.zjh.project.service.DeptService;
import com.zjh.project.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 18221 on 2018/10/18.
 */
@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Override
    public void addPost(Post post) {
        postDao.addPost(post);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public void deletePost(Post post) {
        postDao.deletePost(post);

    }

    @Override
    public List<Post> getAll() {
        List<Post> post=postDao.getAll();
        return post;
    }

    @Override
    public Post getPostByPid(int pid) {
        return postDao.getPostByPid(pid);
    }



    @Override
    public Post getPostByPname(String name) {
        return postDao.getPostByPname(name);
    }

    @Override
    public List<Post> getPostByDid(int did) {
        return postDao.getPostByDid(did);
    }
}
