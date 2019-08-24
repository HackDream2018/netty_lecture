package test.designpattern.create.builder.usebuilder;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/8/24
 */
public class Client {
    
    public static void main(String[] args) {
        /*普通房- 打地基
        普通房- 砌墙
        普通房- 封顶*/
        House commonHouse = new DirectorHouse(new CommonHouseImpl()).build();

        /*高楼房- 打地基
        高楼房- 砌墙
        高楼房- 封顶*/
        House highBuilding = new DirectorHouse(new HighBuildingImpl()).build();
    }


}
