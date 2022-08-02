package com.example.giaphong.API;


import com.example.giaphong.Entities.TaskEntityJPA;
import com.example.giaphong.Service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiskTaskRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "api/find/{id}")
    public ResponseEntity<TaskEntityJPA> find(@PathVariable("id") int id){
        try{
            return new ResponseEntity<TaskEntityJPA>(taskService.findById(id), HttpStatus.OK);
        }catch (Exception e ){
            return new ResponseEntity<TaskEntityJPA>(HttpStatus.BAD_REQUEST);
        }
    }


}

