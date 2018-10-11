package com.dim4tech.webinar.service.single;

import com.dim4tech.webinar.service.MyService;
import com.dim4tech.webinar.service.remote.RemoteServer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTestMock {
    @Mock
    private RemoteServer remoteServer;

    @InjectMocks
    private MyService myService;

    @Before
    public void setUp() {
        when(remoteServer.getA()).thenReturn("A");
        when(remoteServer.getB()).thenReturn("B");
    }

    @Test
    public void Test() {
        assertEquals("AB", myService.concatenateRemodeData());
    }
}
