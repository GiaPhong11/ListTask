package com.example.giaphong.Controller;

import com.example.giaphong.Entities.TaskEntity;
import com.example.giaphong.Service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ListTaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/index")
    public String ListTask(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {

        //Giá trị ngầm định là 1 khi không nhập
        int currentPage = page.orElse(0);
        //5 giá trị trên 1 trnag
        int pageSize = size.orElse(5);


        //Thực hiện sắp xếp theo status
        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("status"));

        Page<TaskEntity> resultPage = null;
        resultPage = taskService.findAll(pageable);

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

        //Đẩy xuống tầng view
        model.addAttribute("taskPage", resultPage);
        return "ListTask";
    }

    @PostMapping( value= "/addLisk")
    public String create(HttpServletRequest request){
        TaskEntity task = new TaskEntity();
        task.setTitle(request.getParameter("title").trim());
        task.setContent(request.getParameter("content").trim());
        task.setStatus(request.getParameter("status").trim());
        return "redirect:/ListTask";
    }
}
