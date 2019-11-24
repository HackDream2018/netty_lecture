package test.designpattern.action.observe;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 具体被观察者
 * @date: 2019/11/24
 */
public class Wechat implements Observer {

    /**
     * 温度
     */
    private Float temperature;

    /**
     * 气压
     */
    private Float pressure;

    /**
     * 湿度
     */
    private Float humidity;

    /**
     * 由气象站调用
     */
    @Override
    public void update(Float temperature, Float pressure, Float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println(String.format("微信端 今天温度: %s", this.temperature));
        System.out.println(String.format("微信端 今天气压: %s", this.pressure));
        System.out.println(String.format("微信端 今天湿度: %s", this.humidity));
    }
}
