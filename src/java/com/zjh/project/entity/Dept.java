package com.zjh.project.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 18221 on 2018/10/18.
 */
public class Dept {
    private Integer did;
    private String dname;
    private Post post;
    private Set<Post> postSet=new HashSet<>();

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Dept() {
    }

    public Dept(String dname) {
        this.dname = dname;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}
