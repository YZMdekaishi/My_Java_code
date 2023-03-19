package Homework.Chapter9.HouseView;

import Homework.Chapter9.HouseService.HouseService;
import Homework.Chapter9.Untility.Utility;
import Homework.Chapter9.domain.House;

public class HouseView {
    private char choice = ' ';
    private boolean mark = true;
    private HouseService houseService = new HouseService(2);
    //修改
    public void amend(){
        System.out.println("==============修改房屋==============");
        System.out.println("请选择待修改房屋编号（-1退出）：");
        int amendId = Utility.readInt();
        if(amendId == -1){
            System.out.println("==============已退出修改房屋==============");
            return;//退出这个方法
        }
        if(houseService.find(amendId) == null){
            System.out.println("==============没有找到该房屋==============");
            return;
        }
        House house = houseService.find(amendId);
        if(house == null){
            System.out.println("==============修改房屋信息不存在=============");
            return;
        }
        System.out.print("姓名（" + house.getName() + "):");
        String name = Utility.readString(8,"");
        if(!"".equals(name)){
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("=============修改房屋信息成功============");
    }
    //退出
    public void exit(){
        char select = Utility.readConfirmSelection();
        if(select == 'Y'){
            mark = false;
        }
    }
    //删除房源
    public void deleteHouse(){
        System.out.println("==============删除房屋==============");
        System.out.println("请选择待删除房屋编号（-1退出）:");
        int deleteId = Utility.readInt();
        if(deleteId == -1){
            System.out.println("============已取消删除房屋============");
            return;//结束该方法
        }
        char choice = Utility.readConfirmSelection();
        if(choice == 'N'){
            System.out.println("============已取消删除房屋============");
            return;//结束该方法
        }
        if(houseService.delId(deleteId)){
            System.out.println("================房屋删除成功=============");
        }else{
            System.out.println("================该编号不存在=============");
        }

    }

    //查找房源
    public void searchHouse(){
        System.out.println("===============查找房屋==============");
        System.out.print("请输入你要查找的id:");
        int findId = Utility.readInt();
        if(houseService.find(findId) != null){
            System.out.println(houseService.find(findId));
        }else{
            System.out.println("==========未找到房屋==============");
        }

    }
    //编写addHouse() 接收输入，创建house对象，调用add方法
    public void addHouse(){
        System.out.println("===============添加房屋==============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        House newHouse = new House(0, name, phone, address, rent, state);
        if(houseService.add(newHouse)){
            System.out.println("===================添加房屋成功===========");
        }else{
            System.out.println("====================添加失败==============");
        }
    }
    //编写listHouses()显示房屋列表
    public void listHouse(){
        System.out.println("----------房屋列表----------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for(int i = 0; i < houses.length; i++){
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("----------房屋列表完成----------\n");
    }
    //显示主菜单
    public void maninMenu(){
        do {
            System.out.println("----------房屋出租系统----------");
            System.out.println("\t\t1 添 增 房 屋");
            System.out.println("\t\t2 查 找 房 屋");
            System.out.println("\t\t3 删 除 房 屋");
            System.out.println("\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t5 房 屋 列 表");
            System.out.println("\t\t6 退       出");
            System.out.print("请选择(1-6):");
            choice = Utility.readChar();
            switch (choice) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    searchHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    amend();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("你的输入有误，请重新输入!!");
            }
        }while (mark) ;
    }
}
