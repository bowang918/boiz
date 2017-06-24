package com.seven7.insurance.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult;
import ch.ralscha.extdirectspring.bean.ExtDirectResponse;
import com.seven7.insurance.services.FeedService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by FANFAN on 2017/6/10.
 */
@Controller
public class FeedController {

    @Autowired
    private FeedService feedService;

    @ExtDirectMethod(ExtDirectMethodType.FORM_POST)
    public ExtDirectFormPostResult uploadFeed(@RequestParam("feedFile") MultipartFile feedFile){
        feedService.process(feedFile);
        return new ExtDirectFormPostResult(true);
    }

    @GetMapping("/feed/{feedFileId}")
    public void uploadFeed(@PathVariable String feedFileId,
                           HttpServletRequest request,
                           HttpServletResponse response){
    }
}
