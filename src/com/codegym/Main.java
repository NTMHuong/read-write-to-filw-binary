package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("student.txt", students);

        List<Student> studentListFromFile = readObjectFromFile("student.txt");
        for (Student student : studentListFromFile) {
            System.out.println(student);
        }

    }

    private static List<Student> readObjectFromFile(String path) {
        List<Student> studentListFromFile = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentListFromFile = (List<Student>) ois.readObject();
            fis.close();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentListFromFile;
    }

    private static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
