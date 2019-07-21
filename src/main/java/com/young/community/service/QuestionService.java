package com.young.community.service;

import com.young.community.dao.QuestionDao;
import com.young.community.dao.UserDao;
import com.young.community.dto.QuestionDTO;
import com.young.community.model.Question;
import com.young.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private UserDao userDao;

    public List<QuestionDTO> list() {
        List<Question> questions = questionDao.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question:questions){
            User user = userDao.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            questionDTO.setId(question.getId());  //比较古老的方法
            //快速将question中的所有属性拷贝到questionDTO中
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
