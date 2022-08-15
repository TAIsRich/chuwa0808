package factory.simple_factory;

/*
*version v1.0
*@ClassName: Coffee
*@Description: general coffee
*@Author: TP
 */

public abstract class Coffee {

    public abstract String getName();

    //add sugar
    public void addSugar(){
        System.out.println("add sugar");
    }

    public void addMilk(){
        System.out.println("add milk");
    }
}
