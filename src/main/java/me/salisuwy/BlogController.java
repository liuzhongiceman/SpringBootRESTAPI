package me.salisuwy;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BlogController {

  BlogMockedData blogMockedData = BlogMockedData.getInstance();

  @GetMapping("/blog")
  public List<com.salisuwy.Blog> index(){
    return blogMockedData.fetchBlogs();
  }

  @GetMapping("/blog/{id}")
  public com.salisuwy.Blog show(@PathVariable String id){
    int blogId = Integer.parseInt(id);
    return blogMockedData.getBlogById(blogId);
  }

  @PostMapping("/blog/search")
  public List<com.salisuwy.Blog> search(@RequestBody Map<String, String> body){
    String searchTerm = body.get("text");
    return blogMockedData.searchBlogs(searchTerm);
  }

  @PostMapping("/blog")
  public com.salisuwy.Blog create(@RequestBody Map<String, String> body){
    int id = Integer.parseInt(body.get("id"));
    String title = body.get("title");
    String content = body.get("content");
    return blogMockedData.createBlog(id, title, content);
  }

  @PutMapping("/blog/{id}")
  public com.salisuwy.Blog update(@PathVariable String id, @RequestBody Map<String, String> body){
    int blogId = Integer.parseInt(id);
    String title = body.get("title");
    String content = body.get("content");
    return blogMockedData.updateBlog(blogId, title, content);
  }

  @DeleteMapping("blog/{id}")
  public boolean delete(@PathVariable String id){
    int blogId = Integer.parseInt(id);
    return blogMockedData.delete(blogId);
  }

}
