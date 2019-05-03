public class Human {
    //thuoc tinh
    String name;
    int age;
    String gender;
    //ham tao
    public Human() {
        name ="Humman";
        age = 20;
        gender = "male";
    }
    // ham tao day du
    public Human(String name,int age,String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    //phuong thuc
    public void eat() {
        System.out.println(name+"Eeating..");
    }
    public void sleep() {
        System.out.println(name + "Sleeping..");
    }
}
