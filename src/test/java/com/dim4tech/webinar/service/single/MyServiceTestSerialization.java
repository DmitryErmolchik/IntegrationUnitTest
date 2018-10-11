package com.dim4tech.webinar.service.single;

import com.dim4tech.webinar.dto.RemoteServerDto;
import com.dim4tech.webinar.service.MyService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MyServiceTestSerialization {
    private RemoteServerDto remoteServerDto;

    @InjectMocks
    private MyService myService;

    @Before
    public void setUp() {
        remoteServerDto = new Gson()
                .fromJson("{\"a\":\"A\",\"b\":\"B\"}", RemoteServerDto.class);
    }

    @Test
    public void Test() {
        assertEquals("AB", myService.concatenateRemoteServerDto(remoteServerDto));
    }
}
