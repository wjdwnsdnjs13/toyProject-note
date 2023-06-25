package com.toyProject.note.Service;

import com.toyProject.note.mapper.ExamNetworkMapper;
import com.toyProject.note.model.ExamNetwork;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ExamNetworkService {

    @Autowired
    private ExamNetworkMapper examNetworkMapper;

    @Transactional
    public List<ExamNetwork> selectExamAll(){

        return examNetworkMapper.selectExamAll();
    };

    @Transactional
    public int insertExamNetwork(ExamNetwork examNetwork){
        return examNetworkMapper.insertExamNetwork();
    }

}
