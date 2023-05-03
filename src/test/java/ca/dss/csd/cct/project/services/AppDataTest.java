package ca.dss.csd.cct.project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest
public class AppDataTest {

    @Autowired private AppDataService appDataService;

    @Test
    public void testFindById() {
        Assertions.assertEquals(null, appDataService.findById("0"));
    }
}
