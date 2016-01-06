package com.cmc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cmc.entity.Blog;
import com.cmc.entity.Item;
import com.cmc.entity.User;
import com.cmc.repository.BlogRepository;
import com.cmc.repository.ItemRepository;
import com.cmc.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findOne(int id){
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithBlogs(int id){
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findOneByBlog(blog,new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}
	
	public void save(User user) {
		userRepository.save(user);	
	}
}
