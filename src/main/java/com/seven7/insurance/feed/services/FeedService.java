package com.seven7.insurance.feed.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.seven7.insurance.feed.domain.FeedFile;

/**
 * Created by FANFAN on 2017/6/10.
 */
public interface FeedService {
	/**
	 * 
	 * @param feedFile
	 */
    void process(MultipartFile feedFile);

    /**
     * 
     * @return
     */
	List<FeedFile> listFeeds();
}
