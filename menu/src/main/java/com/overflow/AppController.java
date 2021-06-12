package com.overflow;

import com.minilabs.gautam.APMiniLab.main;
import com.minilabs.gautam.Inheritance.Editor;
import com.minilabs.gautam.Inheritance.Staffer;
import com.minilabs.gautam.LinkedLists.GArrayList;
import com.minilabs.gautam.LinkedLists.GLinkedList;
import com.minilabs.gautam.Recursion.GautamRecursion;
import com.minilabs.gautam.SortsInt.Bubble;
import com.minilabs.gautam.SortsInt.Insertion;
import com.minilabs.gautam.SortsInt.Selection;
import com.minilabs.gautam.SortsPOJO.NameG;
import com.myconnect.Login;
import com.myconnect.MyConnect;
import com.minilabs.Minilabs;
import com.overflow.todo.data.TodoItem;
import com.overflow.todo.service.TodoService;
import com.overflow.todo.tests.ServiceTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@ComponentScan()
public class AppController {

    Login test1;
    final String defaultID = "6936~rffaXRfNKIkE5QgIKa6lsNuIaOh7vxtJSvIRerholiBgbswdHTDpXfX1pNVB5Mf1";

    @GetMapping("/")
    String index() {
        return "index";
    }

    @GetMapping("/MyConnectLogin")
    String MyConnectLogin(@RequestParam(name = "id4", required = true, defaultValue = defaultID) String id1, Model model) {
        test1 = new Login(id1);
        if (test1.id2.equals(defaultID)) {
            model.addAttribute("idTest", "The default ID");
        } else {
            model.addAttribute("idTest", id1);
        }
        return "MyConnectLogin";
    }

    @GetMapping("/ToDoActivity")
    String ToDoActivity(@RequestParam(name = "id4", required = true, defaultValue = defaultID) String id1, Model model) {

        // get items from a test
        ArrayList<TodoItem> items = runTodoTest();

        model.addAttribute("todos", items);

        // but it's possible to update and find items like this
        // TodoService todoService = new TodoService();
        // todoService.update(new TodoItem(0, 0, "todo 2", "todo 3 details", TodoItem.createDate(2021, 1, 2, 10, 30)));
        // todoService.find(1);


        return "ToDoActivity";
    }

    private ArrayList<TodoItem> runTodoTest() {

        // run tests with update, finds, etc.
        ServiceTest.run();
        TodoService todoService = new TodoService();

        // find all items in database
        return todoService.find();
    }


    @GetMapping("/MyConnect")
    String MyConnect(Model model) {
        MyConnect test = new MyConnect(test1.id2);
        model.addAttribute("assignment1", test.return1());
        model.addAttribute("assignment2", test.return2());
        model.addAttribute("assignment3", test.return3());

        model.addAttribute("assignmentLink1", test.return1link());
        model.addAttribute("assignmentLink2", test.return2link());
        model.addAttribute("assignmentLink3", test.return3link());

        model.addAttribute("assignment1desc", test.return1desc());
        model.addAttribute("assignment2desc", test.return2desc());
        model.addAttribute("assignment2desc", test.return3desc());

        return "MyConnect";
    }

    @GetMapping("/Minilabs")
    String Minilabs(Model model) {
        return "Minilabs";
    }

    @GetMapping("/GautamAPMiniLab")
    public String test(@RequestParam(name = "minSteps", required = true, defaultValue = "1000") int minSteps, @RequestParam(name = "steps", required = true, defaultValue = "100") int steps, Model model){
        main stepFRQ = new main(minSteps);
        stepFRQ.addDailySteps(steps);
        model.addAttribute("activeSteps", stepFRQ.activeDays());
        model.addAttribute("averageSteps", stepFRQ.averageSteps());
        model.addAttribute("totalSteps", stepFRQ.getTotalSteps());

        return "GautamAPMiniLab";
    }

    @GetMapping("/GautamInheritance")
    public String test(@RequestParam(name = "role", required = true, defaultValue = "Staffer") String role,
                       @RequestParam(name = "deadline", required = true, defaultValue = "100") int deadline,
                       Model model){
        model.addAttribute("role", role);
        model.addAttribute("deadline", deadline);

        String roleA = role.toString();
        int deadlineA = deadline;

        if (role.equals("Editor")) {
            Editor editorA = new Editor(deadlineA, roleA, 90);
            model.addAttribute("roleN", editorA.getRole());
            model.addAttribute("deadlineN", editorA.deadlineStatus());
            model.addAttribute("deadlineStatus", editorA.pagesToDo());
        } else if (role.equals("Staffer")) {
            Staffer stafferA = new Staffer("Staffer", deadline);
            model.addAttribute("roleN", stafferA.getRole());
            model.addAttribute("deadlineN", "100");
            model.addAttribute("deadlineStatus", stafferA.todo());
        }

        return "GautamInheritance";
    }

    @GetMapping("/GautamLinkedList")
    public String sort(
            @RequestParam(name = "inputA", required = true, defaultValue = "0") String inputA,
            @RequestParam(name = "inputB", required = true, defaultValue = "0") String inputB,
            @RequestParam(name = "inputC", required = true, defaultValue = "0") String inputC,
            @RequestParam(name = "inputD", required = true, defaultValue = "0") String inputD,
            Model model
    ){
        String[] sortArray = {inputA, inputB, inputC, inputD};

        //Linked list times
        long start = System.nanoTime();
        GLinkedList list1 = new GLinkedList(sortArray);
        model.addAttribute("listA", Arrays.toString(list1.sort()));
        long end = System.nanoTime();
        long timeRes = end - start;

        long startB = System.nanoTime();
        list1.add();
        long endB = System.nanoTime();
        long timeAdd = endB - startB;

        long startC = System.nanoTime();
        list1.remove();
        long endC = System.nanoTime();
        long timeRemove = endC - startC;

        //array list times
        long startA = System.nanoTime();
        GArrayList array1 = new GArrayList(sortArray);
        model.addAttribute("listA", Arrays.toString(array1.sort()));
        long endA = System.nanoTime();
        long timeResA = endA - startA;

        long startE = System.nanoTime();
        array1.add();
        long endE = System.nanoTime();
        long timeAddA = endE - startE;

        long startD = System.nanoTime();
        array1.remove();
        long endD = System.nanoTime();
        long timeRemoveA = endD - startD;

        model.addAttribute("timeA", timeRes);
        model.addAttribute("timeB", timeAdd);
        model.addAttribute("timeC", timeRemove);
        model.addAttribute("timeD", timeResA);
        model.addAttribute("timeE", timeAddA);
        model.addAttribute("timeF", timeRemoveA);
        return "GautamLinkedList";

    }

    @GetMapping("/GautamRecursion")
    public String gautamRecurse(@RequestParam(name = "sNum", required = true, defaultValue = "2") Integer sNum,
                                Model model
    ){
        model.addAttribute("num1", sNum);
        model.addAttribute("fact1", GautamRecursion.gfactorial(sNum));

        return "GautamRecursion";
    }

    @GetMapping("/GautamIntSort")
    public String sorter(
            @RequestParam(name = "id0", required = true, defaultValue = "0") Integer id0,
            @RequestParam(name = "id1", required = true, defaultValue = "0") Integer id1,
            @RequestParam(name = "id2", required = true, defaultValue = "0") Integer id2,
            @RequestParam(name = "id3", required = true, defaultValue = "0") Integer id3,
            @RequestParam(name = "id4", required = true, defaultValue = "0") Integer id4,
            @RequestParam(name = "id5", required = true, defaultValue = "0") Integer id5,
            @RequestParam(name = "id6", required = true, defaultValue = "0") Integer id6,
            Model model,
            @RequestParam(name = "sortType", required = true, defaultValue = "Sort - Bubble") String sortType
    ){

        int[] arrayToSort = {id0, id1, id2, id3, id4, id5, id6};

        model.addAttribute("sortA", sortType);

        long start = System.nanoTime();

        if(sortType.equals("Sort - Bubble")){
            com.minilabs.gautam.SortsInt.Bubble bubbleSorter = new Bubble();
            model.addAttribute("final", Arrays.toString(bubbleSorter.sortBubble(arrayToSort)));
        } else if (sortType.equals("Sort - Selection")){
            com.minilabs.gautam.SortsInt.Selection selSorter = new Selection();
            model.addAttribute("final", Arrays.toString(selSorter.sortSelection(arrayToSort)));
        } else if (sortType.equals("Sort - Insertion")){
            com.minilabs.gautam.SortsInt.Insertion inSorter = new Insertion();
            model.addAttribute("final", Arrays.toString(inSorter.sortInsertion(arrayToSort)));
        }

        long end = System.nanoTime();
        long time = end - start;

        model.addAttribute("time", time);
        return "GautamIntSort";
    }

    @GetMapping("/GautamPOJOSort")
    public String sorter1(
            @RequestParam(name = "id0", required = true, defaultValue = "0") String id0,
            @RequestParam(name = "id1", required = true, defaultValue = "0") String id1,
            @RequestParam(name = "id2", required = true, defaultValue = "0") String id2,
            @RequestParam(name = "id3", required = true, defaultValue = "0") String id3,
            @RequestParam(name = "id4", required = true, defaultValue = "0") String id4,
            @RequestParam(name = "id5", required = true, defaultValue = "0") String id5,
            @RequestParam(name = "id6", required = true, defaultValue = "0") String id6,
            Model model,
            @RequestParam(name = "sortType", required = true, defaultValue = "Sort - Bubble") String sortType
    ){

        NameG[] sortingArray =   {new NameG(id0),
                new NameG(id1),
                new NameG(id2),
                new NameG(id3),
                new NameG(id4),
                new NameG(id5),
                new NameG(id6)};

        model.addAttribute("sortA", sortType);

        long start = System.nanoTime();

        if(sortType.equals("Sort - Bubble")){
            com.minilabs.gautam.SortsPOJO.Bubble bubbleSorter = new com.minilabs.gautam.SortsPOJO.Bubble();
            model.addAttribute("finalArray", Arrays.toString(bubbleSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Sort - Selection")){
            com.minilabs.gautam.SortsPOJO.Selection selSorter = new com.minilabs.gautam.SortsPOJO.Selection();
            model.addAttribute("finalArray", Arrays.toString(selSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Sort - Insertion")){
            com.minilabs.gautam.SortsPOJO.Insertion inSorter = new com.minilabs.gautam.SortsPOJO.Insertion();
            model.addAttribute("finalArray", Arrays.toString(inSorter.sortArr(sortingArray)));
        } else {
            com.minilabs.gautam.SortsPOJO.Bubble defaultSorter = new com.minilabs.gautam.SortsPOJO.Bubble();
            model.addAttribute("finalArray", Arrays.toString(defaultSorter.sortArr(sortingArray)));
        }

        long end = System.nanoTime();
        long time = end - start;

        model.addAttribute("time", time);
        return "GautamPOJOSort";
    }

    @GetMapping("/GautamStringSorts")
    public String sorter2(
            @RequestParam(name = "id0", required = true, defaultValue = "0") String id0,
            @RequestParam(name = "id1", required = true, defaultValue = "0") String id1,
            @RequestParam(name = "id2", required = true, defaultValue = "0") String id2,
            @RequestParam(name = "id3", required = true, defaultValue = "0") String id3,
            @RequestParam(name = "id4", required = true, defaultValue = "0") String id4,
            @RequestParam(name = "id5", required = true, defaultValue = "0") String id5,
            @RequestParam(name = "id6", required = true, defaultValue = "0") String id6,
            Model model,
            @RequestParam(name = "sortType", required = true, defaultValue = "Bubble Sort") String sortType
    ){

        String[] sortingArray = {id0, id1, id2, id3, id4, id5, id6};

        model.addAttribute("sortA", sortType);

        long start = System.nanoTime();

        if (sortType.equals("Bubble Sort")){
            com.minilabs.gautam.SortsString.Bubble bubbleSorter = new com.minilabs.gautam.SortsString.Bubble();
            model.addAttribute("finalArray", Arrays.toString(bubbleSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Selection Sort")){
            com.minilabs.gautam.SortsString.Selection selSorter = new com.minilabs.gautam.SortsString.Selection();
            model.addAttribute("finalArray", Arrays.toString(selSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Insertion Sort")){
            com.minilabs.gautam.SortsString.Insertion inSorter = new com.minilabs.gautam.SortsString.Insertion();
            model.addAttribute("finalArray", Arrays.toString(inSorter.sortArr(sortingArray)));
        } else {
            com.minilabs.gautam.SortsString.Bubble defaultSorter = new com.minilabs.gautam.SortsString.Bubble();
            model.addAttribute("finalArray", Arrays.toString(defaultSorter.sortArr(sortingArray)));
        }

        long end = System.nanoTime();
        long time = end - start;

        model.addAttribute("time", time);
        return "GautamStringSorts";
    }

}
