package ptit.android.kt1_b19dccn333.model;

import java.util.Date;

public class Project {
    private String name;
    private String startDay;
    private String endDay;
    private boolean isFinished;

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Project() {
    }

    public Project(String name, String startDay, String endDay, boolean isFinished) {
        this.name = name;
        this.startDay = startDay;
        this.endDay = endDay;
        this.isFinished = isFinished;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}
