package com.example.giaphong.Controller;

import com.example.giaphong.Entities.TaskEntityJPA;
import com.example.giaphong.Service.impl.TaskService;
import com.example.giaphong.mapper.TaskEntityMapper;
import com.example.giaphong.model.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ListTaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    TaskEntityMapper taskMapper;

    @GetMapping("/admin/index")
    public String ListTask(
            Model model,HttpServletRequest request,
            @RequestParam(name="keywork",required = false )String keywork,
            @RequestParam(name="status",required = false )String status,

            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        //Giá trị ngầm định là 1 khi không nhập
        int currentPage = page.orElse(0);
        //5 giá trị trên 1 trnag
        int pageSize = size.orElse(10   );
        //Thực hiện sắp xếp theo status

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("id"));
        Page<TaskEntityJPA> resultPage = null;
        if(StringUtils.hasText(keywork)) {
            resultPage =taskService.findByKeywork(keywork, pageable);
        }else {
            resultPage = taskService.findAll(pageable);
        }

        if(StringUtils.hasText(status)) {
            resultPage =taskService.findByStatus(status, pageable);
        }

        // Trả về tổng số trang hiển thị
        int totalPages = resultPage.getTotalPages();
        if (totalPages > 0) {
            //Tính toán không làm giá trị âm hoặc vượt quá
            int start = Math.max(1, currentPage - 2);
            int end = Math.min(currentPage + 2, totalPages);

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
        }
        List<TaskEntityJPA> alltask = taskService.findAll();
        //Đẩy xuống tầng view
        model.addAttribute("taskPage", resultPage);
        model.addAttribute("alltask",alltask);
        return "ListTask";
    }

    @GetMapping("/admin/index2")
    public String ListTask2(
            Model model,HttpServletRequest request) {
        List<Map<String,Object>> alltask = taskMapper.findAll();
        model.addAttribute("alltask",alltask);
        return "AllListTask";
    }

    @PostMapping(value = "/admin/addLisk")
    public String create(HttpServletRequest request) {
        TaskEntity task = new TaskEntity();
        task.setTitle(request.getParameter("title").trim());
        task.setContent(request.getParameter("content").trim());
        task.setStatus("Open");
        taskMapper.insert(task);
        return "redirect:/admin/index";
    }

    @PostMapping(value = "/admin/delete")
    public String delete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        taskMapper.deleteByPrimaryKey(id);
        return "redirect:/admin/index";
    }

    @PostMapping(value = "/admin/update")
    public String update(Model model,HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        TaskEntity task = taskMapper.selectByPrimaryKey(id);
        model.addAttribute("task", task);
        task.setTitle(request.getParameter("title").trim());
        task.setContent(request.getParameter("content").trim());
        task.setStatus(request.getParameter("percentage").trim());
        taskMapper.updateByPrimaryKey(task);
        return "redirect:/admin/index";
    }




}
