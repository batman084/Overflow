package com.minilabs.gautam.Inheritance;
// main template class. each person in the yearbook staff starts off as a staffer and is technically a staffer
public class Staffer {
    public String role = "Staffer";
    public int pagesToDo = 4;
    public boolean deadlineMet = false;

    public Staffer (String a, int b) {
        role = a;
        pagesToDo = b;
    }

    public boolean deadlineStatue() {
        return deadlineMet;
    }

    public int todo() {
        return pagesToDo;
    }

    public void setRole(String a) {
        role = a;
    }

    public String getRole() {
        return role;
    }
}
