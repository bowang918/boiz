package com.seven7.insurance.feed.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.seven7.insurance.feed.domain.FeedFile;
import com.seven7.insurance.feed.domain.FeedItem;
import com.seven7.insurance.feed.services.FeedService;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Controller
public class FeedController {

	@Autowired
	private FeedService feedService;

	@ExtDirectMethod(ExtDirectMethodType.FORM_POST)
	public ExtDirectFormPostResult uploadFeed(@RequestParam("feedFile") MultipartFile file) {
		boolean success = false;
		if (file != null && !file.isEmpty()) {
			success = feedService.process(file);
		}
		return new ExtDirectFormPostResult(success);
	}

	@ExtDirectMethod(ExtDirectMethodType.STORE_READ)
	public ExtDirectStoreResult<FeedFile> listFeeds() {
		return new ExtDirectStoreResult<FeedFile>(feedService.listFeeds());
	}

	@ExtDirectMethod(ExtDirectMethodType.STORE_READ)
	public ExtDirectStoreResult<FeedItem> listFeedItems() {
		return new ExtDirectStoreResult<FeedItem>(feedService.listFeedItems());
	}

	@GetMapping("/feed/{feedFileId}")
	public void uploadFeed(@PathVariable String feedFileId, HttpServletRequest request, HttpServletResponse response) {
	}
}
