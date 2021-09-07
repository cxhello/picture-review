package com.cxhello.picture.controller;

import com.cxhello.picture.util.ImageReviewUtils;
import com.cxhello.picture.util.OssClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author cxhello
 * @date 2021/9/7
 */
@RestController
public class TestController {

    @Autowired
    private OssClientUtils ossClientUtils;

    @Autowired
    private ImageReviewUtils imageReviewUtils;

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        return ossClientUtils.upload(file);
    }

    @PostMapping("/review")
    public void review(@RequestBody List<String> urlList) {
        imageReviewUtils.review(urlList);
    }

}
