package com.kjbank.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kjbank.blog.model.Board;
import com.kjbank.blog.model.User;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>{


}
