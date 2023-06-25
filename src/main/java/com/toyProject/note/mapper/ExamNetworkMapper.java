package com.toyProject.note.mapper;


import com.toyProject.note.model.ExamNetwork;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamNetworkMapper {
    List<ExamNetwork> selectExamAll();
    int insertExamNetwork();
}
