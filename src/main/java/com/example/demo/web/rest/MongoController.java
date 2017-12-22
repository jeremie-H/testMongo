package com.example.demo.web.rest;

import com.example.demo.domain.MyRecord;
import com.example.demo.service.MongoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MongoController {

    private final MongoService mongoService;

    public MongoController(MongoService mongoService) {
        this.mongoService = mongoService;
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    @ResponseBody
    public MyRecord record(@RequestBody MyRecord myRecord) {
        MyRecord resultRecord = mongoService.saveRecord(myRecord);
        return resultRecord;
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    @ResponseBody
    public MyRecord log(@RequestBody List<MyRecord> myRecords) {
        MyRecord resultRecord = mongoService.saveRecord(myRecords);
        return resultRecord;
    }


}
