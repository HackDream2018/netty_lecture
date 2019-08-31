package test.designpattern.structure.adapter.objadapter;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/25
 */
public class Client {
    
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.charging(new AdapterVoltage(new Voltage220()));// 电压适合手机充电
    }
    
}
