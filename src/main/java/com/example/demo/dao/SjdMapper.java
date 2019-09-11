package com.example.demo.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SjdMapper {
    public Map<String, String> getSjdByYwh(String ywh);
}
