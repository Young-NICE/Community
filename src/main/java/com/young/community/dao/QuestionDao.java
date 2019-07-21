package com.young.community.dao;

import com.young.community.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionDao {

    void create(Question question);

    List<Question> list();
}
