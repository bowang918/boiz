package com.seven7.insurance.feed.services.impl;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.seven7.insurance.feed.domain.FeedFile;
import com.seven7.insurance.feed.domain.FeedItem;
import com.seven7.insurance.feed.repository.FeedFileRepository;
import com.seven7.insurance.feed.repository.FeedItemRepository;
import com.seven7.insurance.feed.services.FeedService;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Service
@Transactional
@Slf4j
public class FeedServiceImpl implements FeedService {

	@Autowired
	private FeedFileRepository feedRepository;
	
	@Autowired
	private FeedItemRepository itemRepository;

	@Override
	public boolean process(MultipartFile file) {
		if (file != null && !file.isEmpty()) {
			FeedFile feed = feedRepository.save(FeedFile.from(file));
			HSSFWorkbook wb = null;
			try {
				wb = new HSSFWorkbook(file.getInputStream());
				for (int k = 0; k < wb.getNumberOfSheets(); k++) {
					HSSFSheet sheet = wb.getSheetAt(k);
					int rows = sheet.getPhysicalNumberOfRows();
					for (int r = 1; r < rows; r++) {
						HSSFRow row = sheet.getRow(r);
						if (row == null) {
							continue;
						}
						processFeedRow(feed, row);
					}
				}
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (wb != null) {
						wb.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Transactional(TxType.REQUIRES_NEW)
	private void processFeedRow(FeedFile feed, Row row) {
		FeedItem item = FeedItem.from(row);

		item.setFeed(feed);
		
		itemRepository.save(item);
	}

	@Override
	public List<FeedFile> listFeeds() {
		return feedRepository.findAll();
	}

	@Override
	public List<FeedItem> listFeedItems() {
		return itemRepository.findAll();
	}
}
