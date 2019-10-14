package test.designpattern.action.command;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/13
 */
public class TVOnCommand implements Command {

    // 将执行者与具体命令动作绑定
    private TVReceiver tvReceiver;

    public TVOnCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        tvReceiver.on();
    }

    @Override
    public void undo() {
        tvReceiver.off();
    }
}
