package com.example.list_task.api;


import com.example.list_task.entity.TaskEntityJPA;
import com.example.list_task.service.impl.TaskServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskAPI {

    private final TaskServiceImpl taskService;

    public TaskAPI(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "api/task/{id}")
    public ResponseEntity<TaskEntityJPA> taskId(@PathVariable("id") int id){
        try{
            return new ResponseEntity<TaskEntityJPA>(taskService.findById(id), HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<TaskEntityJPA>(HttpStatus.BAD_REQUEST);
        }
    }


}

