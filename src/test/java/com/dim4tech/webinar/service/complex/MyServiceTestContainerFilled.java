package com.dim4tech.webinar.service.complex;

import com.dim4tech.webinar.service.MyService;
import com.dim4tech.webinar.service.remote.RemoteServer;
import com.dim4tech.webinar.service.remote.RemoteServerDbImpl;
import com.zaxxer.hikari.util.DriverDataSource;
import org.junit.Before;
import org.junit.Rule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class MyServiceTestContainerFilled extends AbstractMyServiceTest {
    private JdbcTemplate jdbcTemplate;
    private RemoteServer remoteServerDb;
    private MyService myService;

    @Rule public PostgreSQLContainer postgres = new PostgreSQLContainer("mypg:latest")
            .withDatabaseName("postgres")
            .withUsername("postgres")
            .withPassword("password");

    @Before
    public void setUp() throws Exception {
        jdbcTemplate = new JdbcTemplate(new DriverDataSource(
                postgres.getJdbcUrl(),
                postgres.getDriverClassName(),
                new Properties(),
                postgres.getUsername(),
                postgres.getPassword()));
        remoteServerDb = new RemoteServerDbImpl(jdbcTemplate);
        myService = new MyService(remoteServerDb);
    }

    @Override
    MyService getMyService() {
        return myService;
    }

    @Override
    RemoteServer getRemoteServer() {
        return remoteServerDb;
    }
}