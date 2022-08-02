package com.example.giaphong.Controller;

import com.example.giaphong.mapper.TaskEntityMapper;
import com.example.giaphong.model.TaskEntity;
import com.example.giaphong.model.TaskEntityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    TaskEntityMapper taskMapper;

    @GetMapping("/hello")
    public String hello() {
        TaskEntityExample example = new TaskEntityExample();
        List<TaskEntity> listTask = taskMapper.selectByExample(example);

        for(TaskEntity value : listTask){
            System.out.println("Kiem tra " + value.getTitle());
        }
        return "hello";
    }

}
