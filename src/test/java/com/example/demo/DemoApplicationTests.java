package com.example.demo;

import com.example.demo.domain.MyRecord;
import com.example.demo.repository.CustomRepository;
import com.example.demo.repository.SpringDataMongoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@DataMongoTest(includeFilters = @ComponentScan.Filter(Repository.class))
public class DemoApplicationTests {

    private Clock clockFixed = Clock.fixed(Instant.parse("2017-12-21T10:15:30.000Z"), ZoneId.of("Europe/Paris"));
    private static int loop = 100_000;
    private static final Logger LOG = LoggerFactory.getLogger(DemoApplicationTests.class.getName());

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SpringDataMongoRepository springDataMongoRepository;

    @Autowired
    private CustomRepository customRepository;

	@Before
	public void loadMassRecords(){
        mongoTemplate.indexOps(MyRecord.class)
                .ensureIndex(new Index().on("ipp", Sort.Direction.ASC));

        LOG.info("load mass records ..");
		List<MyRecord> records = new ArrayList<>();

		for(int i = 0; i < loop; i++){
			Instant dateMesure = clockFixed.instant().plusSeconds(i*60);
			Instant dateReception = clockFixed.instant().plusSeconds(i*60+5);
			Double value = Math.random()*5+37;

			MyRecord record = new MyRecord(null,"origine", "appareil", "chambre", "lit",
			"uf", "ipp", "domaineIpp", "iep", "domaineIep",
			"ej", dateReception, "codeMesure", "uniteMesure", value, dateMesure );

			records.add(record);
		}
		springDataMongoRepository.save(records);
        LOG.info("mass records loaded !");
	}



	@Test
    public void performanceSpringData(){
	    Instant from = clockFixed.instant().minusSeconds(5);
	    Instant to = clockFixed.instant().plusSeconds(loop*60+5);
        List<MyRecord> result1=null, result2=null;

	    for(int i = 0; i<5; i++) {
            long t1 = System.currentTimeMillis();
            result1 = springDataMongoRepository.findByIppAndCodeMesureInAndDateMesureBetween("ipp", Arrays.asList("codeMesure"), from, to);
            long t2 = System.currentTimeMillis();
            LOG.info("[springDataMongoRepository] timed passed : {} ms",(t2 - t1));
        }

        for(int i = 0; i<5; i++) {
            long t1 = System.currentTimeMillis();
            result2 = customRepository.findByIppAndCodeMesureInAndDateMesureBetween("ipp", Arrays.asList("codeMesure"), from, to);
            long t2 = System.currentTimeMillis();
            LOG.info("[customRepository] timed passed : {} ms",(t2 - t1));
        }

        Assert.assertNotNull(result1);
        Assert.assertNotNull(result2);
        Assert.assertArrayEquals(result1.toArray(), result2.toArray());
    }
}
