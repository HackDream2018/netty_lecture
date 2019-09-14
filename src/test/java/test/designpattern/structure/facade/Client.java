package test.designpattern.structure.facade;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/9/14
 */
public class Client {
    
    public static void main(String[] args) {
        FamilyWatchingFacade familyWatching = new FamilyWatchingFacade();
        familyWatching.ready();
        System.out.println("---------------------------------");
        familyWatching.end();
    }
    
}
