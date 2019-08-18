package test.designpattern.create.prototype;


import java.io.Serializable;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/18
 */

public class FriendSheep implements Cloneable, Serializable {
    private String name;

    public FriendSheep(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        }catch (Exception e) {}
        return null;
    }
}
