package com.dim4tech.webinar.service;

import com.dim4tech.webinar.service.remote.RemoteServer;
import com.dim4tech.webinar.dto.RemoteServerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyService {
    private final RemoteServer remoteServer;

    public String concatenateRemodeData() {
        return remoteServer.getA() + remoteServer.getB();
    }

    public String concatenateRemoteServerDto(RemoteServerDto remoteServerDto) {
        return remoteServerDto.getA() + remoteServerDto.getB();
    }
}
