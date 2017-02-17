package com.etereration.sc.eureka.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SCEurekaServerApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
public class EurekaServerApplicationTest {
	@Test
	public void contextLoads() {
	}

}