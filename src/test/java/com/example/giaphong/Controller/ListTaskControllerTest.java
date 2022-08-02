package com.example.giaphong.Controller;

/*
@ExtendWith(MockitoExtension.class)
class ListTaskControllerTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService = new TaskService();

    private final List<TaskEntity> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        TaskEntity task = TaskEntity.builder()
                .id(1L)
                .title("Task1")
                .content("Hello Xin chào")
                .status("Open")
                .build();
        tasks.add(task);
    }



    @Test
    void index() {
        int currentPage = 0;
        int pageSize = 5;
        int startItem = 0;
        List<TaskEntity> taskEntities = new ArrayList<>();
        taskEntities.add(TaskEntity.builder()
                .title("Task1")
                .content("Hello Xin chào")
                .status("Open")
                .build());
        List<TaskEntity> list;
        int toIndex = Math.min(startItem + pageSize, taskEntities.size());
        list = taskEntities.subList(startItem, toIndex);
        Page<TaskEntity> taskPage
                = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), tasks.size());
        assertEquals(taskPage, taskService.getByFlag(pageSize));
    }



}
*/
