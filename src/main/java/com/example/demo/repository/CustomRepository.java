package com.example.demo.repository;

import com.example.demo.domain.MyRecord;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.query.Query.*;

@Repository
public class CustomRepository {

    private MongoTemplate template;

    public CustomRepository(MongoTemplate mongoTemplate){
        this.template = mongoTemplate;
    }

    private static final Logger LOG = LoggerFactory.getLogger(CustomRepository.class.getName());


    public List<MyRecord> findByIppAndCodeMesureInAndDateMesureBetween(final String ipp,
                                                                       final List<String> codes, final Instant dateDebut, final Instant dateFin) {

        LOG.debug("Chargement des mesures du patient ipp={},dateDebut={},dateDebut={}, codes={} ", ipp, dateDebut, dateFin, codes);

        Query myquery = query(where("ipp").is(ipp).and("codeMesure").in(codes)
        .and("dateMesure").gte(new Date(dateDebut.toEpochMilli())).lte(new Date(dateFin.toEpochMilli())));

        final DBCollection collection = template.getCollection("myrecords");
        final DBCursor cursor = collection.find(myquery.getQueryObject());
        final List<MyRecord> tab = new ArrayList<>();

        while (cursor.hasNext()) {
            final DBObject d = cursor.next();

            tab.add(new MyRecord(((ObjectId)d.get("_id")).toString(), (String) d.get("origine"), (String) d.get("appareil"),
                    (String) d.get("chambre"), (String) d.get("lit"), (String) d.get("uf"), (String) d.get("ipp"),
                    (String) d.get("domaineIpp"), (String) d.get("iep"), (String) d.get("domaineIep"), (String) d.get("ej"),
                    ((Date) d.get("dateReception")).toInstant(), (String) d.get("codeMesure"),
                    (String) d.get("uniteMesure"), (Double) d.get("valeurMesure"), ((Date) d.get("dateMesure")).toInstant()));

        }
        LOG.debug("fin de parcours");
        return tab;

    }
}
