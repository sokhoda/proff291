package HomeWork_ModuleTest;


/*
 * Created by User on 21.12.2015.
 */
public  class HomeWork_User implements Comparable<HomeWork_User> {

    private String login;
    private String pass;
    private String created;
    private double rang;
    private String sex;

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getCreated() {
        return created;
    }

    public double getRang() {
        return rang;
    }

    public String getSex() {
        return sex;
    }

    public HomeWork_User(String sex, double rang, String created, String pass, String login) {
        this.sex = sex;
        this.rang = rang;
        this.created = created;
        this.pass = pass;
        this.login = login;
    }



    @Override
    public boolean  equals(Object o){
        if (o==null|| getClass()!=o.getClass()){return false;}
        if(this==o){return true;}

        HomeWork_User hwu=(HomeWork_User) o;

        if(this.sex   != hwu.getSex()){return false;}
        if(this.rang  !=hwu.getRang()){return false;}
        if(this.created !=hwu.getCreated()){return false;}
        if(this.pass  !=hwu.getPass()){return false;}
        if(this.login !=hwu.getLogin()){return false;}
        return true;
    }

    @Override
    public int hashCode(){
        long numbRang= Double.doubleToLongBits(rang);
         int numbRang1= (int)(numbRang- (numbRang >>> 32));
        int result = login != null ? login.hashCode() : 0;
        result=31*result+(sex!=null ? sex.hashCode() : 0)+(numbRang1!=0 ? numbRang1 : 0)+(created!=null ? created.hashCode() : 0)
                        + (pass!=null ? pass.hashCode() : 0)+ (login!=null ? login.hashCode() : 0);
     return result;
    }

    @Override
    public int compareTo(HomeWork_User o) {
        HomeWork_User hwu= (HomeWork_User) o;
        return hwu.getLogin().length()-o.getLogin().length();
    }

    public static void  main (String []args){
        HomeWork_User us= new HomeWork_User("mail",234.5,"05.10.2015","milongiwit","doc");
        HomeWork_User us2= new HomeWork_User("mail",234.5,"05.10.2015","milongiwit","doc");
        System.out.println(us.hashCode());
        System.out.println(us.equals(us2));
//        System.out.println(us.getSex()+"=Sex "+us.getRang()+"=range "+us.getCreated()+"=created "+us.getPass()+"=pass "+us.getLogin());
//        System.out.println(us.getSex().hashCode()+"=Sex "+us.getRang()+"=range "+us.getCreated().hashCode()+"=created "+us.getPass().hashCode()+"=pass "+us.getLogin().hashCode());
    }


}
