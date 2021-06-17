package com.minilabs.gautam.Inheritance;
// specialized staffer. editors do more and have more responsibility
public class Editor extends Staffer{
    public int daysTillDeadline;
    public String weeklyMoto;

    public Editor(int c, String d, int e) {
        super(d, c);
        daysTillDeadline = e;
    }

    public Editor() {
        super("Editor", 10);
        pagesToDo = 10;
        weeklyMoto = "Get it done!";
    }

    public int deadlineStatus() {
        return daysTillDeadline;
    }

    public String getWeeklyMoto() {
        return weeklyMoto;
    }

    public int pagesToDo() {
        return pagesToDo;
    }
}
