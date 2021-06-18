package com.overflow.main;

import com.overflow.main.minilabs.dhruvS.Inheritance.Cookie;
import com.overflow.main.minilabs.dhruvS.LinkList.linklist;
import com.overflow.main.minilabs.dhruvS.Recursion.Euclid;
import com.overflow.main.minilabs.dhruvS.Sorts.Sorts;
import com.overflow.main.minilabs.gautam.APMiniLab.main;
import com.overflow.main.minilabs.gautam.Inheritance.Editor;
import com.overflow.main.minilabs.gautam.Inheritance.Staffer;
import com.overflow.main.minilabs.gautam.LinkedLists.GArrayList;
import com.overflow.main.minilabs.gautam.LinkedLists.GLinkedList;
import com.overflow.main.minilabs.gautam.Recursion.GautamRecursion;
import com.overflow.main.minilabs.gautam.SortsInt.Bubble;
import com.overflow.main.minilabs.gautam.SortsInt.Insertion;
import com.overflow.main.minilabs.gautam.SortsInt.Selection;
import com.overflow.main.minilabs.gautam.SortsPOJO.NameG;
import com.overflow.main.myconnect.Login;
import com.overflow.main.myconnect.MyConnect;
import com.overflow.main.todo.data.TodoItem;
import com.overflow.main.todo.service.TodoService;
import com.overflow.main.todo.tests.ServiceTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.overflow.main.todo.data.TodoItem;
import com.overflow.main.todo.service.TodoService;
import com.overflow.main.todo.tests.ServiceTest;


import java.util.ArrayList;
import java.util.Arrays;

@Controller
@ComponentScan()
public class AppController {

    Login test1;
    final String defaultID = "6936~2PaPvl1PokvPAStmvyrgfi4Q0Ob3r3pidU4aRycGbZJCodzySjR6B5SNwnnaZ92c";
    String titleUpdate, descUpdate;
    int yearUpdate, dateUpdate, monthUpdate, hourUpdate, minUpdate;
    TodoService todoService = new TodoService();

    @GetMapping("/")
    String index() {
        return "index";
    }

    @GetMapping("/Deployment")
    String deployment() {
        return "Deployment";
    }

    @GetMapping("/API")
    String API() {
        return "API";
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

    @GetMapping("/MyConnect")
    String MyConnect(Model model) {
        MyConnect test = new MyConnect(test1.id2);
        model.addAttribute("assignment1", test.return1());
        model.addAttribute("assignment2", test.return2());
        model.addAttribute("assignment3", test.return3());

        model.addAttribute("assignmentLink1", test.return1link());
        model.addAttribute("assignmentLink2", test.return2link());
        model.addAttribute("assignmentLink3", test.return3link());
        return "MyConnect";
    }

    @GetMapping("/Minilabs")
    String Minilabs(Model model) {
        return "Minilabs";
    }

    @GetMapping("/dhruvSLinkList")
    public String sort(
            @RequestParam(name = "inputA", required = true, defaultValue = "abc") String inputA,
            @RequestParam(name = "inputB", required = true, defaultValue = "bcd") String inputB,
            @RequestParam(name = "inputC", required = true, defaultValue = "cde") String inputC,
            Model model
    ){
        String[] sortArray = {inputA, inputB, inputC};

        linklist list = new linklist(sortArray);

        model.addAttribute("listA", Arrays.toString(list.sort()));

        return "dhruvSLinkList";

    }

    @GetMapping("/dhruvSInheritance")
    public String mnmCookie(@RequestParam(name = "chocChipNum", required = true, defaultValue = "10") int chocChipNum,
                            @RequestParam(name = "cookieDiameter", required = true, defaultValue = "6") int cookieDiameter, Model model){

        model.addAttribute("chocChipNum", chocChipNum);
        model.addAttribute("cookieDiameter", cookieDiameter);

        int ChocChipNum = chocChipNum;
        int CookieDiameter = cookieDiameter;

        Cookie.mnmCookie cookie = new Cookie.mnmCookie(ChocChipNum, CookieDiameter, 10);



        model.addAttribute("newMnMCount", cookie.toString());

        return "dhruvSInheritance";
    }



    @GetMapping("/dhruvRecursion")
    public String dhruvRecursion(@RequestParam(name = "num1", required = true, defaultValue = "2") Integer num1, @RequestParam(name = "num2", required = true, defaultValue = "9") Integer num2,
                                 Model model
    ){
        model.addAttribute("gcf", Euclid.gcd(num1, num2));

        return "dhruvRecursion";
    }

    @GetMapping("/dhruvSorts")
    public String dhruvSorts(@RequestParam(name = "num1", required = true, defaultValue = "2") int num1, @RequestParam(name = "num2", required = true, defaultValue = "9") int num2, Model model,
                             @RequestParam(name = "num3", required = true, defaultValue = "7") int num3, @RequestParam(name = "num4", required = true, defaultValue = "4") int num4, @RequestParam(name = "num5", required = true, defaultValue = "5") int num5, @RequestParam(name = "num6", required = true, defaultValue = "6") int num6
    ){
        Sorts a = new Sorts(num1, num2, num3, num4, num5, num6);
        model.addAttribute("bubblesort", Arrays.toString(a.bubbleSort(num1, num2, num3, num4, num5, num6)));
        model.addAttribute("insertionsort", Arrays.toString(a.insertionSort(num1, num2, num3, num4, num5, num6)));
        model.addAttribute("selectionsort", Arrays.toString(a.selectionSort(num1, num2, num3, num4, num5, num6)));



        return "dhruvSorts";
    }

    @GetMapping("/dhruvArray")
    public String dhruvArray(@RequestParam(name = "num1", required = true, defaultValue = "2") int num1, @RequestParam(name = "num2", required = true, defaultValue = "9") int num2, Model model,
                             @RequestParam(name = "num3", required = true, defaultValue = "7") int num3, @RequestParam(name = "num4", required = true, defaultValue = "4") int num4, @RequestParam(name = "num5", required = true, defaultValue = "5") int num5, @RequestParam(name = "num6", required = true, defaultValue = "6") int num6
    ){



        //   String a = arr[0] + ", " + arr[2] + ", " + arr[4];
      //  String b = arr[1] + ", " + arr[3] + ", " + arr[5];
System.out.println(Arrays.toString(array(num1, num2, num3, num4, num5, num6)));


        model.addAttribute("arr1", Arrays.toString(array(num1, num2, num3, num4, num5, num6)));
        model.addAttribute("arr2",Arrays.toString(array2(num1, num2, num3, num4, num5, num6)));


        return "dhruvArray";
    }

    public int[] array(int a, int b, int c, int d, int e, int f) {
        int[] arr = {a, c, e};
      //  String arr = arra[0] + ", " + arra[2] + ", " + arra[4];
        return  arr;
    }

    public int[] array2(int a, int b, int c, int d, int e, int f) {
        int[] arr2 = {b, d, e};
     //   String arr2 = arra2[1] + ", " + arra2[3] + ", " + arra2[5];
        return  arr2;
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
            Bubble bubbleSorter = new Bubble();
            model.addAttribute("final", Arrays.toString(bubbleSorter.sortBubble(arrayToSort)));
        } else if (sortType.equals("Sort - Selection")){
            Selection selSorter = new Selection();
            model.addAttribute("final", Arrays.toString(selSorter.sortSelection(arrayToSort)));
        } else if (sortType.equals("Sort - Insertion")){
            Insertion inSorter = new Insertion();
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
            com.overflow.main.minilabs.gautam.SortsPOJO.Bubble bubbleSorter = new com.overflow.main.minilabs.gautam.SortsPOJO.Bubble();
            model.addAttribute("finalArray", Arrays.toString(bubbleSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Sort - Selection")){
            com.overflow.main.minilabs.gautam.SortsPOJO.Selection selSorter = new com.overflow.main.minilabs.gautam.SortsPOJO.Selection();
            model.addAttribute("finalArray", Arrays.toString(selSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Sort - Insertion")){
            com.overflow.main.minilabs.gautam.SortsPOJO.Insertion inSorter = new com.overflow.main.minilabs.gautam.SortsPOJO.Insertion();
            model.addAttribute("finalArray", Arrays.toString(inSorter.sortArr(sortingArray)));
        } else {
            com.overflow.main.minilabs.gautam.SortsPOJO.Bubble defaultSorter = new com.overflow.main.minilabs.gautam.SortsPOJO.Bubble();
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
            com.overflow.main.minilabs.gautam.SortsString.Bubble bubbleSorter = new com.overflow.main.minilabs.gautam.SortsString.Bubble();
            model.addAttribute("finalArray", Arrays.toString(bubbleSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Selection Sort")){
            com.overflow.main.minilabs.gautam.SortsString.Selection selSorter = new com.overflow.main.minilabs.gautam.SortsString.Selection();
            model.addAttribute("finalArray", Arrays.toString(selSorter.sortArr(sortingArray)));
        } else if (sortType.equals("Insertion Sort")){
            com.overflow.main.minilabs.gautam.SortsString.Insertion inSorter = new com.overflow.main.minilabs.gautam.SortsString.Insertion();
            model.addAttribute("finalArray", Arrays.toString(inSorter.sortArr(sortingArray)));
        } else {
            com.overflow.main.minilabs.gautam.SortsString.Bubble defaultSorter = new com.overflow.main.minilabs.gautam.SortsString.Bubble();
            model.addAttribute("finalArray", Arrays.toString(defaultSorter.sortArr(sortingArray)));
        }

        long end = System.nanoTime();
        long time = end - start;

        model.addAttribute("time", time);
        return "GautamStringSorts";
    }


    @GetMapping("/ToDoActivity/ToDoCreate")
    public String todoCreate() {
        TodoItem item = new TodoItem(0, 0, "New Task", "New Task Details", TodoItem.createDate(2021, 6, 15, 10, 00));
        todoService.update(item);
        return "redirect:/ToDoActivity";
    }

    @GetMapping("/ToDoActivity/ToDoUpdate")
    public String todoUpdatePage(@RequestParam(name = "titleUpdate", defaultValue = "abc") String title,
                                 @RequestParam(name = "descriptionUpdate", defaultValue = "abc") String description,
                                 @RequestParam(name = "yearUpdate", defaultValue = "abc") int year,
                                 @RequestParam(name = "dateUpdate", defaultValue = "abc") int date,
                                 @RequestParam(name = "monthUpdate", defaultValue = "abc") int month,
                                 @RequestParam(name = "hourUpdate", defaultValue = "abc") int hour,
                                 @RequestParam(name = "minUpdate", defaultValue = "abc") int min,
                                 Model model) {
        titleUpdate = title;
        descUpdate = description;
        yearUpdate = year;
        monthUpdate = month;
        dateUpdate = date;
        hourUpdate = hour;
        minUpdate = min;

        return "redirect:/ToDoActivity";
    }

    @GetMapping("/TodoActivity/ToDoUpdate/{id}")
    public String todoUpdate(@PathVariable("id") long id, Model model) {
        TodoItem item = todoService.find((int)id);

        TodoItem todo = new TodoItem(item.getId(), item.getUserId(), titleUpdate, descUpdate, TodoItem.createDate(yearUpdate, monthUpdate, dateUpdate, hourUpdate, minUpdate));
        todoService.update(todo);

        return "redirect:/ToDoActivity";
    }
    @GetMapping("/TodoActivity/ToDoDelete/{id}")
    public String todoDelete(@PathVariable("id") long id) {
        todoService.delete((int)id);
        return "redirect:/ToDoActivity";
    }


    @GetMapping("/ToDoActivity")
    String ToDoActivity(@RequestParam(name = "id4", required = true, defaultValue = defaultID) String id1, Model model) {
        ArrayList<TodoItem> items = todoService.find();

        model.addAttribute("todos", items);

        return "ToDoActivity";
    }

    @GetMapping("/ToDoActivity/ToDoGenerateTest")
    String ToDoGenerateTest(@RequestParam(name = "id4", required = true, defaultValue = defaultID) String id1, Model model) {

        // get items from a test
        ServiceTest.generateSampleItems();

        TodoService todoService = new TodoService();
        ArrayList<TodoItem> items = todoService.find();

        model.addAttribute("todos", items);

        // but it's possible to update and find items like this
/*
        TodoService todoService = new TodoService();
        todoService.update(new TodoItem(0, 0, "todo 2", "todo 3 details", TodoItem.createDate(2021, 1, 2, 10, 30)));
        todoService.find(1);
*/


        return "ToDoActivity";
    }

}
