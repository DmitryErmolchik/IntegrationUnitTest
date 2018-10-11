package com.dim4tech.webinar.service.complex;

import com.dim4tech.webinar.service.MyService;
import com.dim4tech.webinar.service.remote.RemoteServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractMyServiceTest {
    abstract MyService getMyService();
    abstract RemoteServer getRemoteServer();

    @Test
    public void Test() {
        assertEquals("AB", getMyService().concatenateRemodeData());
        assertEquals("AB", getMyService().concatenateRemoteServerDto(getRemoteServer().getDto()));
    }
}
