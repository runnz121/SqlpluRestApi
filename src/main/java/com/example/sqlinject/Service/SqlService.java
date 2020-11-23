package com.example.sqlinject.Service;


import com.example.sqlinject.Mapper.SqlMapper;
import com.example.sqlinject.domain.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SqlService {

    @Autowired
    private SqlMapper sqlMapper;


    public void InsertList(Domain domain)  {
        sqlMapper.InsertList(domain);
    }





}
