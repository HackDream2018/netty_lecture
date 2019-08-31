package test.designpattern.structure.adapter.objadapter;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public class Phone {

    /**
     * 5V电压充电
     */
    public void charging(IVoltage5 voltage5) {
        if(5 == voltage5.output5V()) {
             System.out.println("电压适合手机充电");
        }else if(5 < voltage5.output5V()){
            System.out.println("手机要炸");
        }
    }

}
