package test.designpattern.action.command;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/13
 */
public class AirConditioningOffCommand implements Command {

    // 将执行者与具体命令动作绑定
    private AirConditioningReceiver airConditioningReceiver;

    public AirConditioningOffCommand(AirConditioningReceiver airConditioningReceiver) {
        this.airConditioningReceiver = airConditioningReceiver;
    }

    @Override
    public void execute() {
        airConditioningReceiver.off();
    }

    @Override
    public void undo() {
        airConditioningReceiver.on();
    }
}
