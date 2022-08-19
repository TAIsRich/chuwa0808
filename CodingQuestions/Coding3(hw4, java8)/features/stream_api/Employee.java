public class Employee {
    public int id;
    public String name;
    public int age;
    public int salary;
    public Employee(int id, String n, int a, int sa){
        this.id = id;
        this.name = n;
        this.age = a;
        this.salary = sa;
        System.out.println("testttttt");
        System.out.println(this.getID());
    }
    public int getID(){
        return id;
    }
    public int salaryGetter(){
        return salary;
    }
}
