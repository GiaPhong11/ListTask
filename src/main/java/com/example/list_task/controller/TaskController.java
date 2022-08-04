
package com.example.list_task.controller;

import com.example.list_task.model.enums.TaskStatus;
import com.example.list_task.service.TaskService;
import com.example.list_task.service.UserService;
import com.example.list_task.service.impl.TaskServiceImpl;
import com.example.list_task.model.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class TaskController extends BaseController {


    private final TaskService taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }


    @GetMapping("/admin/pageTask")
    public String showPage2(
            Model model,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> title,
            @RequestParam Optional<String> status){
        Page<TaskEntity> tasks = taskService.findTasks(page, title, status);
        model.addAttribute("tasks", tasks);
        return "PageTask";
    }

    @PostMapping(value = "/admin/create-task")
    public String createTask(HttpServletRequest request) throws Exception {
        int userId = Integer.parseInt(request.getParameter("userId"));
        TaskEntity task = new TaskEntity();
        task.setUserId(userId);
        task.setTitle(request.getParameter("title").trim());
        task.setContent(request.getParameter("content").trim());
        task.setStatus(TaskStatus.OPEN.getCode());
        taskService.insert(task);
        return "redirect:/admin/pageTask";
    }

    @PostMapping(value = "/admin/delete-task")
    public String deleteTask(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        taskService.deleteByPrimaryKey(id);
        return "redirect:/admin/pageTask";
    }

    @PostMapping(value = "/admin/update-task")
    public String updateTask(Model model,HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        TaskEntity task = taskService.selectByPrimaryKey(id);
        model.addAttribute("task", task);
        task.setTitle(request.getParameter("title").trim());
        task.setContent(request.getParameter("content").trim());
        task.setStatus(request.getParameter("percentage").trim());
        taskService.updateByPrimaryKey(task);
        return "redirect:/admin/pageTask";
    }

    @GetMapping(value = "/list/export")
    public void export(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName = "tasks.csv";

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;

        response.setHeader(headerKey,headerValue);

        List<TaskEntity> list = taskService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"ID", "Title","Status","Id_User"};
        String[] nameMapping = {"id", "title","status","userId"};

        csvWriter.writeHeader(csvHeader);
        for(TaskEntity task : list){
            csvWriter.write(task,nameMapping);
        }
        csvWriter.close();
    }


}

