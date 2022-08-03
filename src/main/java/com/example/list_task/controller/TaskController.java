
package com.example.list_task.controller;

import com.example.list_task.entity.TaskEntityJPA;
import com.example.list_task.service.impl.TaskServiceImpl;
import com.example.list_task.model.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TaskController extends BaseController {

    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/admin/pageTask")
    public String showPage(Model model,HttpServletRequest request,
            @RequestParam(name="keyword", required = false) String keyword,
            @RequestParam(name="status", required = false) String status,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        //Giá trị ngầm định là 1 khi không nhập
        int currentPage = page.orElse(0);
        //5 giá trị trên 1 trang
        int pageSize = size.orElse(10);
        //Thực hiện sắp xếp theo id
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("id"));
        Page<TaskEntityJPA> resultPage;
        if(StringUtils.hasText(keyword)) {
            resultPage =taskService.findByKeyword(keyword, pageable);
        }else {
            resultPage = taskService.findAll(pageable);
        }

        if(StringUtils.hasText(status)) {
            resultPage =taskService.findByStatus(status, pageable);
        }
        // Trả về tổng số trang hiển thị
        int totalPages = resultPage.getTotalPages();

            if (totalPages > 0) {
                List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                        .boxed()
                        .collect(Collectors.toList());
                model.addAttribute("pageNumbers", pageNumbers);
            }

            //Tính số trang hiển thị trên view
            model.addAttribute("pages", resultPage.getContent());
            model.addAttribute("number", resultPage.getNumber());
            model.addAttribute("totalElements", resultPage.getTotalElements());
        //Đẩy xuống tầng view
        model.addAttribute("taskPage", resultPage);
        return "PageTask";
    }

    @GetMapping("/admin/pageTask2")
    public String showPage2(
            Model model,
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> title,
            @RequestParam Optional<String> status){
        Page<TaskEntity> tasks = taskService.findTasks(page, title, status);
        model.addAttribute("tasks", tasks);
        return "PageTask2";
    }

    @GetMapping("/admin/listTask")
    public String showAll(
            Model model,HttpServletRequest request) {
        List<TaskEntity> all_task = taskService.findAll();
        model.addAttribute("listTask",all_task);
        return "AllTask";
    }

    @PostMapping(value = "/admin/create-task")
    public String createTask(HttpServletRequest request) {

        TaskEntity task = new TaskEntity();
        task.setTitle(request.getParameter("title").trim());
        task.setContent(request.getParameter("content").trim());
        task.setStatus("Open");

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

}

