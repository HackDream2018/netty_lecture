package test.designpattern.sevenidea.singleresponsibility.violationreponsibility;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/7/20
 */
public class SingleResponsibility {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("轮船");
        vehicle.run("飞机");
    }

    /**
     * 交通工具
     */
    static class Vehicle {
        private void run(String vehicleName) {
            System.out.println(vehicleName + "在公路上跑~");
        }
    }

}
