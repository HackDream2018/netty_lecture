package test.designpattern.action.observe.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description: 被观察者对象
 * @date: 2019/11/24
 */
public class Wechat {
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
    public void updateWeather(Float temperature, Float pressure, Float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display() {
         System.out.println(String.format("今天温度: %s", this.temperature));
         System.out.println(String.format("今天气压: %s", this.pressure));
         System.out.println(String.format("今天湿度: %s", this.humidity));
    }

}
