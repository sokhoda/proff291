package Session13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Пк2 on 13.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session13/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        for(int i=1;i<7;i++){
            createEmploye(factory);
        }
        Company comp1=createCompany(factory);
        System.out.println(comp1.getBudget()+4.26);
        //Company comp2=createCompany(factory);

//        for(int i=1; i<4;i++){
//            hireEmploye(factory,1,i);
//        }
//        for(int i=4; i<7;i++){
//            hireEmploye(factory,2,i);
//        }

    }

    public static Company createCompany(SessionFactory factory) {
        Company aCompany=null;
        Session currSession = factory.openSession();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Company id");
        int id = Integer.parseInt(scan.nextLine());

        System.out.println("Enter Company name");
        String name = scan.nextLine();

        System.out.println("Enter Company buget");
        Double budget = Double.parseDouble(scan.nextLine());


        try {
            currSession.beginTransaction();
            aCompany = new Company(id, name, budget);
            currSession.save(aCompany);
            currSession.getTransaction().commit();
        } catch (Exception e) {
            currSession.getTransaction().rollback();
        } finally {
            currSession.close();
        }
        return aCompany;
    }

    public static  Employe createEmploye(SessionFactory factory) {
        Employe anEmploye=null;
        Session currSession = factory.openSession();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter Employe id");
//        int id = Integer.parseInt(scan.nextLine());

        try {
            currSession.beginTransaction();
            anEmploye = new Employe();
            currSession.save(anEmploye);
            currSession.getTransaction().commit();
        } catch (Exception e) {
            currSession.getTransaction().rollback();
        } finally {
            currSession.close();
        }
        return anEmploye;

    }

    public static void hireEmploye(SessionFactory factory, int companyId, int employeId) {
        Session currSession = factory.openSession();
        try {
            currSession.beginTransaction();
            Company thisCompany = (Company) currSession.get(Company.class, companyId);
            Employe thisEmploye = (Employe) currSession.get(Employe.class, employeId);
            thisCompany.getEmployes().add(thisEmploye);
            thisEmploye.setCompany(thisCompany);
            currSession.update(thisCompany);
            currSession.update(thisEmploye);
            currSession.getTransaction().commit();
        } catch (Exception e) {
            currSession.getTransaction().rollback();
        } finally {
            currSession.close();
        }
    }
}

