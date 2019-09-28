package test.designpattern.structure.composite;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/14
 */
public class Client {
    public static void main(String[] args) {
        // 从大到小创建对象
        AbsComponent university = new University("清华大学", "清华大学耶~~");
        AbsComponent college = new College("清华大学研究院", "清华大学研究院耶~~");
        AbsComponent computerDepartment = new Department("清华大学计算机科学系", "清华大学计算机科学系耶~~");
        AbsComponent buildDepartment = new Department("清华大学建筑工程系", "清华大学建筑工程系耶~~");

        // 将小的组合进大的
        college.add(computerDepartment);
        college.add(buildDepartment);
        university.add(college);

//        university.print();
//        college.print();
//        computerDepartment.print();

    }
    
}
