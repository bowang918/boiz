package com.seven7.insurance.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by FANFAN on 2017/6/10.
 */
public interface FeedService {
    void process(MultipartFile feedFile);
}
