package com.example.demo.service;

import com.example.demo.domain.MyRecord;
import com.example.demo.repository.SpringDataMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    SpringDataMongoRepository springDataMongoRepository;

    public MongoService(SpringDataMongoRepository springDataMongoRepository){
        this.springDataMongoRepository = springDataMongoRepository;
    }

    public MyRecord saveRecord(MyRecord myRecord) {
        return springDataMongoRepository.save(myRecord);
    }

    public MyRecord saveRecord(List<MyRecord> myRecords) {
        return springDataMongoRepository.save(myRecords);
    }


}
