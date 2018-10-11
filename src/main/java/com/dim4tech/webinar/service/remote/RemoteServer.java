package com.dim4tech.webinar.service.remote;

import com.dim4tech.webinar.dto.RemoteServerDto;

public interface RemoteServer {
    String getA();
    String getB();

    RemoteServerDto getDto();
}
