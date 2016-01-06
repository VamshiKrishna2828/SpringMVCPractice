package com.cmc.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.entity.Blog;
import com.cmc.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public List<Item> findOneByBlog(Blog blog,Pageable pageable);

}
