package com.example.Forum.repositories;

import com.example.Forum.models.Topic;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAll(Sort sort);
}