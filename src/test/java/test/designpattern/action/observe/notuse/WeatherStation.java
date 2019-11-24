package test.designpattern.action.observe.notuse;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/11/24
 */
public class WeatherStation {

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
     * 第三方网站(被观察者)
     */
    private Wechat wechat;

    public WeatherStation(Wechat wechat) {
        this.wechat = wechat;
    }

    /**
     * 将最新天气数据推送给第三方网站
     */
    public void setData(Float temperature, Float pressure, Float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }

    public void dataChange() {
        wechat.updateWeather(getTemperature(), getPressure(), getHumidity());
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getHumidity() {
        return humidity;
    }
}
