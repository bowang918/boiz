package com.seven7.insurance.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seven7.insurance.feed.domain.FeedFile;
import com.seven7.insurance.feed.repository.FeedFileRepository;
import com.seven7.insurance.services.FeedService;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Service
@Transactional
public class FeedServiceImpl implements FeedService {

	@Autowired
	private FeedFileRepository feedRepository;

	@Override
	public void process(MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			FeedFile feed = FeedFile.from(file);
			feedRepository.save(feed);
		}
	}

	@Override
	public List<FeedFile> listFeeds() {
		return feedRepository.findAll();
	}
}
