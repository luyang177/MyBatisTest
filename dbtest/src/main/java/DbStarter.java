import DAO.Blog;
import Mappers.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DbStarter {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession session = sqlSessionFactory.openSession()) {

            //Select(session);
            //Insert(session);
            //Update(session);
            //Delete(session);
            //insertBlogProc(session);
            SelectProc(session);
        }

    }

    private static void Select(SqlSession session) {
        //Blog blog = (Blog) session.selectOne("Mappers.BlogMapper.selectBlog", 2);
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(3);
    }

    private static void Insert(SqlSession session) {
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog newBlog = new Blog();
        newBlog.setName("new2");
        //session.insert("Mappers.BlogMapper.insertBlog", newBlog);

        mapper.insertBlog(newBlog);
        session.commit();
    }

    private static void Update(SqlSession session) {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(14);
        blog.setName("other");

        mapper.updateBlog(blog);
        session.commit();
    }

    private static void Delete(SqlSession session) {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(14);

        mapper.deleteBlog(blog);
        session.commit();
    }

    private static void insertBlogProc(SqlSession session) {
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog newBlog = new Blog();
        newBlog.setName("new_proc");
        //session.insert("Mappers.BlogMapper.insertBlog", newBlog);

        mapper.insertBlogProc(newBlog);
        session.commit();
    }

    private static void SelectProc(SqlSession session) {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        ArrayList<Blog> blogs = mapper.getBlogProc();
    }
}
