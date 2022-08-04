package com.example.list_task.api;


/*import com.example.list_task.entity.TaskEntityJPA;*/
import com.example.list_task.model.TaskEntity;
import com.example.list_task.service.TaskService;
import com.example.list_task.service.impl.TaskServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskAPI {

    private final TaskService taskService;

    public TaskAPI(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "api/task2/{id}")
    public ResponseEntity<TaskEntity> taskId2(@PathVariable("id") int id){
        try{
            return new ResponseEntity<TaskEntity>(taskService.findById2(id), HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<TaskEntity>(HttpStatus.BAD_REQUEST);
        }
    }


}

