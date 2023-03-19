package Homework.Chapter9.HouseService;

import Homework.Chapter9.Untility.Utility;
import Homework.Chapter9.domain.House;

public class HouseService {
    private int idCounter = 1;//记录当前的id增长到哪个值了
    private House[] houses;//保存House对象
    private int houseNumbers = 1;//记录当前有多少个房屋信息
//构造器
    public HouseService(int size) {
        houses = new House[size];//当创建HoseService对象，指定数组大小
        houses[0] = new House(1,"jack","112","海碇区",2000,"未出租");
    }
    public House[] list(){
        return houses;
    }
    //add 方法，添加新对象，返回boolean
    public boolean add(House newHouse){
        if(houseNumbers == houses.length){
            System.out.println("数组已满不能再添加了...");
            return false;
        }
        houses[houseNumbers++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }
    //find方法，查找房源，返回House
    public House find(int findId) {
        for (int i = 0; i < houseNumbers; i++) {
            if (houses[i].getId() == findId) {
                return houses[i];
            }
        }
        return  null;
    }
    //删除房屋，返回boolean
    public boolean delId(int deleteId){
        int index = -1;
        for(int i = 0; i < houseNumbers; i++){
            if(houses[i].getId() == deleteId){
                index = i;
            }
        }
        if(index == -1){
            return false;
        }
        for(int i = index; i < houseNumbers - 1; i++){
            houses[index] = houses[index+1];
        }
        houses[--houseNumbers] = null;
        return true;
    }
}
