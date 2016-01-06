package com.cmc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.entity.Blog;
import com.cmc.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);
}
