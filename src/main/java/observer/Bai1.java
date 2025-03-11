package observer;
import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void update(String message);
}

// Interface Subject
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

// Lớp học (Subject)
class Classroom implements Subject {
    private String className;
    private List<Observer> students = new ArrayList<>();

    public Classroom(String className) {
        this.className = className;
    }

    @Override
    public void registerObserver(Observer observer) {
        students.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        students.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer student : students) {
            student.update(message);
        }
    }

    public void announce(String message) {
        System.out.println("Lớp trưởng thông báo: " + message);
        notifyObservers(message);
    }
}

// Sinh viên (Observer)
class Student implements Observer {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("+ "+name + " nhận được thông báo: " + message);
    }
}

// Demo
public class Bai1 {
    public static void main(String[] args) {
        Classroom classroom = new Classroom("Lớp KTPM17");

        Student student1 = new Student("Trần Đình Kiên");
        Student student2 = new Student("Lê Hoàng Khang");
        Student student3 = new Student("Nguyễn Thanh Cảnh");
        Student student4 = new Student("Nguyễn Xuân Nam");
        Student student5 = new Student("Hồ Thị Như Tâm");
        classroom.registerObserver(student1);
        classroom.registerObserver(student2);
        classroom.registerObserver(student3);
        classroom.registerObserver(student4);
        classroom.registerObserver(student5);
        classroom.announce("Họp nhóm vào lúc 12h30 thứ sáu.");
    }
}