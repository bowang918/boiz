package com.seven7.insurance.services.impl;

import com.seven7.insurance.services.FeedService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Service
@Transactional
public class FeedServiceImpl implements FeedService {

    @Override
    public void process(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
//            resp.addResultProperty("fileContents", new String(file.getBytes(), StandardCharsets.ISO_8859_1));
        }
    }
}
