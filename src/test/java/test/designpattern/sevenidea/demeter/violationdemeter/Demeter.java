package test.designpattern.sevenidea.demeter.violationdemeter;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/28
 */
public class Demeter {

    @Test
    public void testMethod() {
        TeacherManager teacherManager = new TeacherManager();
        teacherManager.printAllPerson(new StudentManager());
    }

    /**
     * 直接朋友: 本类的参数, 方法返回值, 成员变量
     * 其他朋友: 出现在本类局部方法中与本类不相关的局部变量
     */
    class TeacherManager {

        private List<Teacher> getTeacherInfo() {
            List<Teacher> listTeacher = new ArrayList<>();
            for (long i = 0; i < 10; i++) {
                Teacher teacher = new Teacher();
                teacher.setId(i);
                listTeacher.add(teacher);
            }
            return listTeacher;
        }

        // 输出一个班所有的老师和学生ID
        public void printAllPerson(StudentManager studentManager) {

            List<Teacher> teacherInfo = this.getTeacherInfo();
            for (Teacher teacher : teacherInfo) {
                System.out.println(teacher.getId());
            }

            System.out.println("---------------------------");

            List<Student> studentInfo = studentManager.getStudentInfo();
            for (Student student : studentInfo) {
                System.out.println(student.getId());
            }
        }
    }

    class StudentManager {

        public List<Student> getStudentInfo() {
            List<Student> listStudent = new ArrayList<>();
            for (long i = 0; i < 5; i++) {
                Student student = new Student();
                student.setId(i);
                listStudent.add(student);
            }
            return listStudent;
        }

    }

    class Teacher {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }

    class Student {
        private Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
