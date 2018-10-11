package com.dim4tech.webinar.service.remote;

import com.dim4tech.webinar.dto.RemoteServerDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@AllArgsConstructor
@Service
public class RemoteServerDbImpl implements RemoteServer {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public String getA() {
        Map<String, Object> results = jdbcTemplate.queryForMap("select * from employee where id=?", 1);
        return results.get("NAME").toString();
    }

    @Override
    public String getB() {
        Map<String, Object> results = jdbcTemplate.queryForMap("select * from employee where id=?", 2);
        return results.get("NAME").toString();
    }

    @Override
    public RemoteServerDto getDto() {
        RemoteServerDto remoteServerDto = new RemoteServerDto();
        for (Map<String, Object> stringObjectMap : jdbcTemplate.queryForList("select * from employee")) {
            if (stringObjectMap.get("NAME").equals("A")) {
                remoteServerDto.setA(stringObjectMap.get("NAME").toString());
            } else if (stringObjectMap.get("NAME").equals("B")) {
                remoteServerDto.setB(stringObjectMap.get("NAME").toString());
            }
        }
        return remoteServerDto;
    }
}
