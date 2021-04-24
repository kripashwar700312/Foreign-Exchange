package com.bloomberg.fx;

import lombok.extern.slf4j.Slf4j;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@ActiveProfiles("dev")
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
public abstract class AbstractTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeClass
    public static void contextLoads() {
        log.info("-------------------------------------------------------------------");
        log.info("--------------------------Unit test started------------------------");
        log.info("-------------------------------------------------------------------");
    }

    @AfterClass
    public static void contextClosed() {
        log.info("-------------------------------------------------------------------");
        log.info("------------------------Unit test performed------------------------");
        log.info("-------------------------------------------------------------------");
    }
}
