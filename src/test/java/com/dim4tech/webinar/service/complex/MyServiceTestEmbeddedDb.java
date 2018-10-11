package com.dim4tech.webinar.service.complex;

import com.dim4tech.webinar.service.MyService;
import com.dim4tech.webinar.service.remote.RemoteServer;
import com.dim4tech.webinar.service.remote.RemoteServerDbImpl;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.SingleInstancePostgresRule;
import org.junit.Before;
import org.junit.Rule;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyServiceTestEmbeddedDb extends AbstractMyServiceTest {
    private JdbcTemplate jdbcTemplate;
    private RemoteServer remoteServerDb;
    private MyService myService;

    @Rule
    public SingleInstancePostgresRule postgres = EmbeddedPostgresRules.singleInstance();

    @Before
    public void setUp() throws Exception {
        jdbcTemplate = new JdbcTemplate(postgres.getEmbeddedPostgres().getTemplateDatabase());
        remoteServerDb = new RemoteServerDbImpl(jdbcTemplate);
        myService = new MyService(remoteServerDb);
        jdbcTemplate.execute("create table employee (id int, name varchar)");
        jdbcTemplate.execute("insert into employee (id, name) values (1, 'A')");
        jdbcTemplate.execute("insert into employee (id, name) values (2, 'B')");
    };

    @Override
    MyService getMyService() {
        return myService;
    }

    @Override
    RemoteServer getRemoteServer() {
        return remoteServerDb;
    }
}