package ptit.android.intentdemo.model;

import java.io.Serializable;

public class Student implements Serializable {
    private int image;
    private String name;

    public Student() {
    }

    public Student(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
