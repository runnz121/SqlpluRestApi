package com.example.sqlinject.Mapper;

import com.example.sqlinject.domain.Domain;
import org.apache.ibatis.session.SqlSession;

public class SqlMapperImpl implements SqlMapper { //interface 상속받아서 mapper 구현(xml 과 매칭)

    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public int InsertList(Domain domain) {
        return sqlSession.insert("SqlMapper.InsertList");
    }
}
