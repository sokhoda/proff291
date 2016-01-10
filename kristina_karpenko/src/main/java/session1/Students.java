package session1;

import java.util.Comparator;

//Есть класс студент. у него есть 2 строки: имя, фамилия. Пол. Возраст. Колл денег на карте стипендии.
// Нужно инкапсуляцию. 3 конструктора. переопред toString? equals
public class Students {
   private String  name;
   private String  serName;
   private boolean sex;
   private int     age;
   private double  salary;

    Students(){

    }
   Students( String name, String serName){
        this.name = name;
        this.serName = serName;
           }

    public Students( String name, String serName, boolean sex,int age){
      this(name,serName);
        this.sex = sex;
        this.age = age;

    }

    public Students( String name, String serName, boolean sex,int age, double salary){
        this(name,serName,sex,age);
        this.salary = salary;
    }

    public boolean isSex() {
        return sex;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSerName() {
        return serName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
     @Override
    public String toString(){
         return "Students{ Name:"+name+"    SerName:"+ serName +"   Age:"+age+"   Sex:    "+ sex+"   Salary:      "+ salary+"   }";
     }

    @Override
    public boolean equals(Object o){
        if(o==null) return false;
        if(this == o) return true;
        if(this.getClass() == o.getClass()) return  true;
            Students s = (Students)o;
        if(this.name==s.getName()&& serName==s.getSerName()&&this.sex == s.isSex() &&this.age==s.getAge()&&this.salary==s.getSalary()&&
                Double.compare(this.getSalary(),s.getSalary())==0)
            return true;
        return false;
    }

}
