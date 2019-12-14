package test.designpattern.action.responsibilitychain;

/**
 * @version v1.0
 * @author: TianXiang
 * @description:
 * @date: 2019/12/14
 */
public class Client {
    
    public static void main(String[] args) {
        // 发起采购请求
        PurchaseRequest request = new PurchaseRequest(2, 60000F);
        // 创建采购审批人
        Handler departmentHandler = new DepartmentHandler("departmentHandler");
        Handler collegeHandler = new CollegeHandler("collegeHandler");
        Handler viceSchoolHandler = new ViceSchoolHandler("viceSchoolHandler");
        Handler schoolHandler = new SchoolHandler("schoolHandler");
        // 为每个审批人处理器设置下个处理器对象(①可以形成环链;②认为校长是最后一级的处理者单链表就行)
        departmentHandler.setHandler(collegeHandler);
        collegeHandler.setHandler(viceSchoolHandler);
        viceSchoolHandler.setHandler(schoolHandler);
        schoolHandler.setHandler(departmentHandler);
        // 任意一个处理器开始处理请求
        schoolHandler.processRequest(request);
    }
    
}
