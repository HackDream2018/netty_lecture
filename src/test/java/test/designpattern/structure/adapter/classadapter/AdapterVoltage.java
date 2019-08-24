package test.designpattern.structure.adapter.classadapter;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public class AdapterVoltage extends Voltage220 implements IVoltage5{

    @Override
    public Integer output5V() {
        Integer srcV = output220V();
        Integer targetV = srcV / 44;
        return targetV;
    }

}
