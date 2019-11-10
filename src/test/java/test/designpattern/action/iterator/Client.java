package test.designpattern.action.iterator;

import java.util.ArrayList;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/10
 */
public class Client {

    public static void main(String[] args) {
        // 创建学校下的学院
        ArrayList<CollegeAggregate> collegeAggregates = new ArrayList<>();
        ComputerCollegeAggregate computerCollegeAggregate = new ComputerCollegeAggregate();
        InfoCollegeAggregate infoCollegeAggregate = new InfoCollegeAggregate();
        collegeAggregates.add(computerCollegeAggregate);
        collegeAggregates.add(infoCollegeAggregate);

        // 输出学院信息
        PrintCollegeInfo printCollegeInfo = new PrintCollegeInfo(collegeAggregates);
        printCollegeInfo.printCollege();
    }

}
