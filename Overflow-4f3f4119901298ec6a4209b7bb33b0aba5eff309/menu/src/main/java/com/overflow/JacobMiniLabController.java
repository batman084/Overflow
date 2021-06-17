package com.overflow;

import com.minilabs.jacob.lists.*;
import com.minilabs.jacob.recursion.Main;
import com.minilabs.jacob.sorts.*;
import com.minilabs.jacob.recursion.*;
import com.minilabs.jacob.inheritence.*;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class JacobMiniLabController implements WebMvcConfigurer {

    @GetMapping("/JacobMinilabInheritence")
    public String jacobInheritence() {
        return "JacobMinilabInheritence";
    }

    @GetMapping("/JacobMiniLabRecursion")
    public String jacobRecursion() {
        return "JacobMiniLabRecursion";
    }

    @GetMapping("/JacobMinilabSort")
    public String jacobSort() {
        return "JacobMinilabSort";
    }

    @GetMapping("/JacobMinilabList")
    public String jacobList() {
        return "JacobMinilabList";
    }

    @GetMapping(value = "/JacobMinilabInheritence/test/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String testInheritence() {
        StringBuilder sb = new StringBuilder();

        Truck truck = new Truck(8, 25, 1); //polymorphism ex w/ method overloading
        Truck differentTruck = new Truck();
        Vehicle car = new Vehicle(4, 10);

        sb.append("truck speed: " + truck.getSpeed() + "\n"); // 25
        sb.append("car speed: " + car.getSpeed() + "\n"); // 10

        sb.append("increasing truck speed by 15\n");
        truck.increaseSpeed(15);

        sb.append("increasing car speed by 10\n");
        car.increaseSpeed(10);

        sb.append("truck speed: " + truck.getSpeed() + "\n"); // 25
        sb.append("car speed: " + car.getSpeed() + "\n"); // 10

        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabRecursion/test/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String testRecursion() {
        StringBuilder sb = new StringBuilder();

        sb.append("Runing factorial for 15 \n");

        int result = Main.recursiveFactorial(15);
        sb.append("Result = " + result + "\n");
        
        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabList/add-head/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String testListAddHead() {

        StringBuilder sb = new StringBuilder();

        LinkedList list = new LinkedList();

        sb.append("testing addHead......\n");
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: 1" + "\n");
        list.addHead(1);
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: 6" + "\n");
        list.addHead(6);
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: -1" + "\n");
        list.addHead(-1);
        sb.append("list: " + list.toString() + "\n");

        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabList/add-tail/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String testListAddTail() {
        StringBuilder sb = new StringBuilder();
        LinkedList list = new LinkedList();

        sb.append("testing addTail......");
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: 1" + "\n");
        list.addTail(1);
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: 6" + "\n");
        list.addTail(6);
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: -1" + "\n");
        list.addTail(-1);
        sb.append("list: " + list.toString() + "\n");

        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabList/add-at/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String testListAddAt() {
        StringBuilder sb = new StringBuilder();
        LinkedList list = new LinkedList();

        sb.append("testing addAt....." + "\n");
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: 1 at index 0" + "\n");
        list.addAt(1, 0);
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: 6 at index 0" + "\n");
        list.addAt(6, 0);
        sb.append("list: " + list.toString() + "\n");

        sb.append("adding: -1 at index 1" + "\n");
        list.addAt(-1, 1);
        sb.append("list: " + list.toString() + "\n");

        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabList/remove/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String testListRemove() {
        StringBuilder sb = new StringBuilder();

        LinkedList list = new LinkedList();

        sb.append("testing removeAt......" + "\n");
        list.addHead(1);
        list.addHead(6);
        list.addHead(0);
        list.addHead(4);
        list.addHead(-1);
        sb.append("list: " + list.toString() + "\n");

        sb.append("removing at index 2" + "\n");
        list.removeAt(2);

        sb.append("list: " + list.toString() + "\n");

        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabList/sort/", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String testListSort() {
        StringBuilder sb = new StringBuilder();
        LinkedList list = new LinkedList();

        sb.append("testing sort...... " + "\n");
        list.addHead(1);
        list.addHead(6);
        list.addHead(0);
        list.addHead(4);
        list.addHead(-1);

        sb.append("list: " + list.toString() + "\n");
        list.sort();
        sb.append("list: " + list.toString() + "\n");

        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabSort/selection/integer/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortSelectionIntegerAscending() {
        return sortSelectionInteger(true);
    }

    @GetMapping(value = "/JacobMinilabSort/selection/integer/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortSelectionIntegerDescending() {
        return sortSelectionInteger(false);
    }

    @GetMapping(value = "/JacobMinilabSort/selection/string/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortSelectionStringAscending() {
        return sortSelectionString(true);
    }

    @GetMapping(value = "/JacobMinilabSort/selection/string/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortSelectionStringDescending() {
        return sortSelectionString(false);
    }

    @GetMapping(value = "/JacobMinilabSort/selection/pojo/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortSelectionPojoAscending() {
        return sortSelectionPojo(true);
    }

    @GetMapping(value = "/JacobMinilabSort/selection/pojo/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortSelectionPojoDescending() {
        return sortSelectionPojo(false);
    }

    private String sortSelectionInteger(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Selection Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        int [] data = createIntegerData();
        SelectionSort sort = new SelectionSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    private String sortSelectionString(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Selection Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        String [] data = createStringData();
        SelectionSort sort = new SelectionSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    private String sortSelectionPojo(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Selection Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        Animal[] data = createPojoData();
        SelectionSort sort = new SelectionSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }


    @GetMapping(value = "/JacobMinilabSort/insertion/integer/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortInsertionIntegerAscending() {
        return sortInsertionInteger(true);
    }

    @GetMapping(value = "/JacobMinilabSort/insertion/integer/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortInsertionIntegerDescending() {
        return sortInsertionInteger(false);
    }

    @GetMapping(value = "/JacobMinilabSort/insertion/string/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortInsertionStringAscending() {
        return sortInsertionString(true);
    }

    @GetMapping(value = "/JacobMinilabSort/insertion/string/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortInsertionStringDescending() {
        return sortInsertionString(false);
    }

    @GetMapping(value = "/JacobMinilabSort/insertion/pojo/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortInsertionPojoAscending() {
        return sortInsertionPojo(true);
    }

    @GetMapping(value = "/JacobMinilabSort/insertion/pojo/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortInsertionPojoDescending() {
        return sortInsertionPojo(false);
    }

    private String sortInsertionInteger(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Insertion Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        int [] data = createIntegerData();
        InsertionSort sort = new InsertionSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    private String sortInsertionString(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Insertion Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        String [] data = createStringData();
        InsertionSort sort = new InsertionSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    private String sortInsertionPojo(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Insertion Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        Animal[] data = createPojoData();
        InsertionSort sort = new InsertionSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    @GetMapping(value = "/JacobMinilabSort/bubble/integer/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortBubbleIntegerAscending() {
        return sortBubbleInteger(true);
    }

    @GetMapping(value = "/JacobMinilabSort/bubble/integer/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortBubbleIntegerDescending() {
        return sortBubbleInteger(false);
    }

    @GetMapping(value = "/JacobMinilabSort/bubble/string/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortBubbleStringAscending() {
        return sortBubbleString(true);
    }

    @GetMapping(value = "/JacobMinilabSort/bubble/string/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortBubbleStringDescending() {
        return sortBubbleString(false);
    }

    @GetMapping(value = "/JacobMinilabSort/bubble/pojo/asc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortBubblePojoAscending() {
        return sortBubblePojo(true);
    }

    @GetMapping(value = "/JacobMinilabSort/bubble/pojo/dsc", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody()
    public String sortBubblePojoDescending() {
        return sortBubblePojo(false);
    }

    private String sortBubbleInteger(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Bubble Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        int [] data = createIntegerData();
        BubbleSort sort = new BubbleSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    private String sortBubbleString(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Bubble Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        String [] data = createStringData();
        BubbleSort sort = new BubbleSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    private String sortBubblePojo(boolean ascending) {
        StringBuilder sb = new StringBuilder();
        sb.append("Bubble Sort " + (ascending ? "(ascending)" : "(descending)") + "\n");

        Animal[] data = createPojoData();
        BubbleSort sort = new BubbleSort();

        log(sb, "Before: ", data);
        sort.sort(data, ascending);
        log(sb, "After : ", data);

        return sb.toString();
    }

    private void log(StringBuilder sb, String message, int [] data) {
        sb.append(message + ": ");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i] + ",");
        }
        sb.append("\n");
    }

    private void log(StringBuilder sb, String message, String [] data) {
        sb.append(message + ": ");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i] + ",");
        }
        sb.append("\n");
    }

    private void log(StringBuilder sb, String message, Animal[] data) {
        sb.append(message + ": ");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i] + ",");
        }
        sb.append("\n");
    }

    private int [] createIntegerData() {
        return new int[] { 1, 10, -8, 3, 0, 12};
    }

    private String [] createStringData() {
        return new String[] { "plum", "melon", "apple", "pear", "eggplant" };
    }

    private Animal [] createPojoData() {
        return new Animal[] {
                new Animal(4, "cat"),
                new Animal(2, "ape"),
                new Animal(4, "mouse"),
                new Animal(0, "snake"),
                new Animal(4, "dog"),
        };
    }
}
