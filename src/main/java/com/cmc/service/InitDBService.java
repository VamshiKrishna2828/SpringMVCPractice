package com.cmc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cmc.entity.Blog;
import com.cmc.entity.Item;
import com.cmc.entity.Role;
import com.cmc.entity.User;
import com.cmc.repository.BlogRepository;
import com.cmc.repository.ItemRepository;
import com.cmc.repository.RoleRepository;
import com.cmc.repository.UserRepository;

@Transactional
@Service
public class InitDBService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("ADMIN");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("JAVA VIDS");
		blogJavaVids.setUrl("https://feeds.feedburner.com/javavids?format=xml");
		blogJavaVids.setUser(userAdmin);
		blogRepository.save(blogJavaVids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavaVids);
		item1.setDescription("FIRST ITEM");
		item1.setPublishedDate(new Date());
		item1.setLink("http://www.javavids.com");
		item1.setTitle("First");
		
		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setDescription("SECOND ITEM");
		item2.setPublishedDate(new Date());
		item2.setLink("http://www.javavids.com");
		item2.setTitle("SECOND");
		
		itemRepository.save(item1);
		itemRepository.save(item2);
	
	}
}
