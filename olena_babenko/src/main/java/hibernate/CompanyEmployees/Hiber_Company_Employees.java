package hibernate.CompanyEmployees;

import hibernate.CompanyEmployees.Company;
import hibernate.CompanyEmployees.Employee;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.Region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

/**
 * Created by lenchi on 13.02.16.
 *
 * нужно создать сущность компанию с именем, деньгами и набором сотрудников
 создать сущность сотрудника идентификатор и ссылку на компанию

 Что сделать:
 создать две компании и трудоустроить в них в кажду по три сотрудника
 *
 */
public class Hiber_Company_Employees {
        private static Logger log = Logger.getLogger(Hiber_Company_Employees.class);

        public static void main(String[] args) throws IOException {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();

            SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
            log.info("Reference to SessionFactory " + factory);

            Session session = null;
            try {
                session = factory.openSession();
                Company company1 = new Company("CompanyName1", 100);
                Company company2 = new Company("CompanyName2", 100);
                session.beginTransaction();

                Employee employee1 = new Employee();
                Employee employee2 = new Employee();
                Employee employee3 = new Employee();
                Employee employee4 = new Employee();
                Employee employee5 = new Employee();

                //тут нанимаешь (пропиши двухстороннюю связь, то есть
                //от компании к сотруднику и наоборот
                company1.hireEmpl(employee1);
                employee1.setCompany(company1);

                company1.hireEmpl(employee2);
                employee2.setCompany(company1);

                company1.hireEmpl(employee3);
                employee3.setCompany(company1);

                company2.hireEmpl(employee4);
                employee4.setCompany(company2);

                session.save(company1);
                session.save(company2);
                session.save(employee1);
                session.save(employee2);
                session.save(employee3);
                session.save(employee4);
                session.save(employee5);

                session.getTransaction().commit();

                session.beginTransaction();
                //Task2: пользователь вводит ИД компании и видит всех сотрудников из этой компании
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter company ID: ");
                String compId = reader.readLine();

                Query query = session.createQuery("from Company company where company.id = "+compId);
                List<Company> list = query.list();
                //log.info(list);
                System.out.println(">>> "+list);

                log.info("Connection established");
                log.info(session);
            } catch (HibernateException e) {
                log.error("Open session failed", e);

                //откат транзакции в случае её неудачного выполнения
                if(session!=null){
                    session.getTransaction().rollback();
                }

            } finally {
                if (session != null) {
                    session.close();
                }
                factory.close();
            }
        }

        private static SessionFactory getSessionFactory() {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();

            return cfg.buildSessionFactory(standardServiceRegistry);
        }
    }
