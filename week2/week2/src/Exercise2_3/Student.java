package Exercise2_3;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
