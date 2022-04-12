package com;

import Dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
        StudentDao sdao= (StudentDao) applicationContext.getBean("sdao");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1.INSERT\n2.UPDATE\n3.RETRIEVE\n4.DELETE\n5.EXIT");
            int ch=Integer.parseInt(br.readLine());
            switch (ch){
                case 1:
                    System.out.println("Enter Student Details");
                    Student student=new Student();
                    student.setId(Integer.parseInt(br.readLine()));
                    student.setName(br.readLine());
                    int i=sdao.insert(student);
                    if(i>0)
                        System.out.println("Success");
                    else
                        System.out.println("Try");
                    break;
                case 2:
                    System.out.println("Enter id,name");
                    int id=Integer.parseInt(br.readLine());
                    String name= br.readLine();
                    int i1=sdao.update(name,id);
                    if (i1>0)
                        System.out.println("Success");
                    else
                        System.out.println("Try Again");
                    break;
                case 3:
                    List<Student> studentList= sdao.fetch();
                    for(Student s:studentList){
                        System.out.println(s);
                    }
                    break;
                case 4:
                    System.out.println("Enter id");
                    int id1= Integer.parseInt(br.readLine());
                    int i2=sdao.delete(id1);
                    if(i2>0)
                        System.out.println("Success");
                    else
                        System.out.println("Try");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice");
            }
        }while (true);

    }
}
