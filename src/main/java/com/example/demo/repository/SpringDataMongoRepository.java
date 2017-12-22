package com.example.demo.repository;

import com.example.demo.domain.MyRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface SpringDataMongoRepository extends MongoRepository<MyRecord, Integer> {

    public List<MyRecord> findByIppAndCodeMesureInAndDateMesureBetween(final String ipp, final List<String> codesMesure,
                                                                       final Instant from, final Instant to);

}
