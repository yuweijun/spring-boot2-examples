package com.example.spring.boot2.mongodb.repository;

import com.example.spring.boot2.mongodb.model.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yuweijun
 * @since 2018-12-07
 */
@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {

}