package com.dim4tech.webinar.service.complex;

import com.dim4tech.webinar.service.MyService;
import com.dim4tech.webinar.service.remote.RemoteServer;
import com.dim4tech.webinar.dto.RemoteServerDto;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTestMockSerialization extends AbstractMyServiceTest {
    @Mock
    private RemoteServer remoteServer;

    @InjectMocks
    private MyService myService;

    @Before
    public void setUp() {
        when(remoteServer.getA()).thenReturn("A");
        when(remoteServer.getB()).thenReturn("B");
        when(remoteServer.getDto()).thenReturn(
                new Gson()
                .fromJson("{\"a\":\"A\",\"b\":\"B\"}", RemoteServerDto.class)
        );
    }

    @Override
    MyService getMyService() {
        return myService;
    }

    @Override
    RemoteServer getRemoteServer() {
        return remoteServer;
    }
}
