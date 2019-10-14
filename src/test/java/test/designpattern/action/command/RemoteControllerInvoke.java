package test.designpattern.action.command;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/10/13
 */
public class RemoteControllerInvoke {

    // 开关按钮的命令集
    private Command[] onCommands;
    private Command[] offCommands;

    // 撤销命令
    private Command undoCommand;

    /**
     * 初始所有按钮: 假设目前遥控器上有5款智能家居
     */
    public RemoteControllerInvoke() {
        onCommands = new Command[5];
        offCommands = new Command[5];

        for(int i = 0; i < 5; i++) {
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    /**
     * 遥控器上的家居电器绑定命令
     * @param no 智能家居在遥控器上的类型编号
     * @return
     */
    public void setComand(int no, Command onCommand, Command offCommand) {
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    /**
     * 按下打开按钮
     */
    public void onButton(int no) {
        onCommands[no].execute();
        // 记录这次命令用于撤销
        undoCommand = onCommands[no];
    }

    /**
     * 按下关闭按钮
     */
    public void offButton(int no) {
        offCommands[no].execute();
        // 记录这次命令用于撤销
        undoCommand = offCommands[no];
    }

    /**
     * 按下撤销按钮
     */
    public void undoButton(int no) {
        undoCommand.undo();
    }

}
