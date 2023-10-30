package exrcise.one.equals_and_hashcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static class Student{
        private String name;
        private int age;
        private String type;
        public Student(String name, int age, String type) {
            this.name = name;
            this.age = age;
            this.type = type;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(type,student.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
    public static void main(String[] args) {
        Student s1 = new Student("dat",19, "sv");
        Student s2 = new Student("dat",19, "sv");
        Student s3 = new Student("dat",19, "hs");
        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.forEach((a)-> System.out.println(a.getAge() + a.getName() + a.getType()));
        System.out.println(s1.equals(s2));
    }
}
