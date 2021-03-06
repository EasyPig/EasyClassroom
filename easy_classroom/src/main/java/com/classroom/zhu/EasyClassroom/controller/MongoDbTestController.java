package com.classroom.zhu.EasyClassroom.controller;

import com.classroom.zhu.EasyClassroom.dao.MongoTestDao;
import com.classroom.zhu.EasyClassroom.dto.MongoTestBean;
import com.classroom.zhu.EasyClassroom.service.MongoTestService;
import com.classroom.zhu.common.dto.OnlyResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by 12801 on 2017/8/13.
 */

@Controller
@RequestMapping("api")
public class MongoDbTestController {
    @Autowired
    MongoTestService mongoTestService;
    @Autowired
    MongoTestDao mongoTestDao;

    private static final Logger LOG= LoggerFactory.getLogger(MongoDbTestController.class);

    @RequestMapping(value = "/mongo/test",method = RequestMethod.POST)
    public
    @ResponseBody
    Object testMongo(@RequestBody MongoTestBean test) throws IOException {
        mongoTestService.testAddToMongoDb(test);

        return new OnlyResultDTO(mongoTestService.getTestBeanByName(test.getName()));
    }

}
