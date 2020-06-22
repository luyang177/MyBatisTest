package Mappers;

import DAO.Blog;

import java.util.ArrayList;

public interface BlogMapper {
    Blog selectBlog(int id);
    void insertBlog(Blog blog);
    void updateBlog(Blog blog);
    void deleteBlog(Blog blog);
    void insertBlogProc(Blog blog);
    ArrayList<Blog> getBlogProc();
}
