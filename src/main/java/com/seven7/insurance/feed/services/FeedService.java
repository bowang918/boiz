package com.seven7.insurance.feed.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.seven7.insurance.feed.domain.FeedFile;
import com.seven7.insurance.feed.domain.FeedItem;

/**
 * Created by FANFAN on 2017/6/10.
 */
public interface FeedService {
	/**
	 * 
	 * @param feedFile
	 * @return 
	 */
    boolean process(MultipartFile feedFile);

    /**
     * 
     * @return
     */
	List<FeedFile> listFeeds();

	/**
	 * 
	 * @return
	 */
	List<FeedItem> listFeedItems();
}
