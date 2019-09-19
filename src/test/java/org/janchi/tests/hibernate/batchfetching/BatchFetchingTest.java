package org.janchi.tests.hibernate.batchfetching;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.janchi.tests.hibernate.batchfetching.entity.enhanced.EnhancedBar;
import org.janchi.tests.hibernate.batchfetching.entity.unenhanced.UnenhancedFoo;
import org.janchi.tests.hibernate.batchfetching.repository.BarRepository;
import org.janchi.tests.hibernate.batchfetching.repository.FooRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchFetchingTest {

	private static final Logger logger = LoggerFactory.getLogger(BatchFetchingTestApplication.class);

	@Autowired
	private FooRepository fooRepository;
	@Autowired
	private BarRepository barRepository;
	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	public void whenFetchingNonEnhancedEntities_thenUseTwoQueries() {

		Session session = entityManager.unwrap(Session.class);
		StatementCounter statementCounter = new StatementCounter();
		session.addEventListeners(statementCounter);

		List<UnenhancedFoo> foos = fooRepository.findAllById(List.of(1L, 2L, 3L, 4L));
		logger.info("Fetched {} unenhanced foos", foos.size());
		foos.get(0).getBar().getProperty();
		logger.info("Should have fetched {} enhanced bars", foos.size());

		// here we expect 2 queries. for the lack of faster solution they can be counted in log output
		assertEquals("Executed JDBC statement count", 2, statementCounter.getCounter());
	}

	@Test
	@Transactional
	public void whenFetchingEnhancedEntities_thenUseTwoQueries() {
		Session session = entityManager.unwrap(Session.class);
		StatementCounter statementCounter = new StatementCounter();
		session.addEventListeners(statementCounter);

		List<EnhancedBar> bars = barRepository.findAllById(List.of(9L, 8L, 7L, 6L));
		logger.info("Fetched {} enhanced bars", bars.size());
		bars.get(0).getFoo().getProperty();
		logger.info("Should have fetched {} unenhanced foos", bars.size());

		assertEquals("Executed JDBC statement count", 2, statementCounter.getCounter());
	}

}
