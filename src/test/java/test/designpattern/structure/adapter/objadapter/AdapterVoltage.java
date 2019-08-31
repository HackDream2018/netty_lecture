package test.designpattern.structure.adapter.objadapter;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public class AdapterVoltage implements IVoltage5 {

    private Voltage220 voltage220;

    // 通过构造器, 聚合src类到适配器
    public AdapterVoltage(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public Integer output5V() {
        int targetV = 0;
        if(null != voltage220) {
            Integer srcV = voltage220.output220V();
            targetV = srcV / 44;
        }
        return targetV;
    }

}
