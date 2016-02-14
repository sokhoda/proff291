package HibernateAuth;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.Region;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Locale;


/**
 * Created by Павло on 03.02.2016.
 */
public interface MyObjDAO {
    public void getAllUsers();

}


public class Auth extends JFrame implements MyObjDAO {


    Connection conn = null;
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    RegForm rf = null;
    private JTextField tf1 = new JTextField(20);
    private JTextField tf2 = new JTextField(20);
    private JLabel l1 = new JLabel("Введіть логін та пароль");
    private JLabel l2 = new JLabel("");
    private JButton b1 = new JButton("  Війти    ");
    private JButton b2 = new JButton("Зареєструватися");

    private JLabel l3 = new JLabel("Введіть логін та пароль");
    private JLabel l4 = new JLabel("");
    private JTextField tf3 = new JTextField(20);
    private JTextField tf4 = new JTextField(20);
    private JTextField tf5 = new JTextField(20);
    private JButton b3 = new JButton("      Зареєструватися    ");

    public Auth() {
        Locale.setDefault(Locale.ENGLISH);

        setTitle("Авторизація");

        setLayout(new FlowLayout());
        add(l1);
        add(tf1);
        tf1.setText("adm");
        add(tf2);

        add(b1);
        add(b2);
        add(l2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (CheckUser(tf1.getText(), tf2.getText())) {
                        l2.setText("Ви пройшли авторизацію");
                    } else {
                        l2.setText("Введіть вірний логін і пароль");
                    }
                } catch (Exception f) {
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    rf = new RegForm();

                } catch (Exception f) {
                }
            }
        });
    }

    public static void main(String[] args) {

        Auth auth = new Auth();

        ////////////////////////////////////
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("HibernateAuth/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            Region ua = new Region("EuroUkraina");
            session = factory.openSession();
            log.info("Connection established");
            // System.out.println("Connection established");
            log.info(session);
            session.beginTransaction();
            session.save(ua);
            session.getTransaction().commit();

            ua.setName("AsiaUkraina");
            session.beginTransaction();
            session.update(ua);
            session.getTransaction().commit();
            session.beginTransaction();
            Region ua1 = (Region) session.get(Region.class, new Long(55));
            System.out.println(ua1);
            //   Actor actor = (Actor)session.get(Actor.class,new Long(1));
            session.getTransaction().commit();
            //  session.beginTransaction();
            //  session.delete(ua);
            //  session.getTransaction().commit();


        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("HibernateAuth/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    public void getAllUsers() {


    }


    /////////////////////////////////////

    boolean AddUser(String n, String p) {
        try {
            System.out.println("Application started...");
            conn = DriverManager.getConnection(url, "Authorization", "Authorization");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT NAME,PASSWORD FROM USERS");
            if (n.length() > 0 && p.length() > 0) {
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                    if (n.equals(rs.getString(1))) {
                        System.out.println(rs.getString(1));
                        return false;
                    }
                }

                ResultSet rsi = stm.executeQuery("INSERT INTO USERS(NAME, PASSWORD) VALUES ('" + n + "','" + p + "')");
                return true;

            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Application closed...");
                } catch (SQLException e) {
                }
            }
        }

        return true;
    }

    boolean CheckUser(String n, String p) {
        try {
            System.out.println("Application started...");
            conn = DriverManager.getConnection(url, "Authorization", "Authorization");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT NAME,PASSWORD FROM USERS");

            if (n.length() > 0 && p.length() > 0) {
                while (rs.next()) {
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                    if ((n.equals(rs.getString(1))) && (p.equals(rs.getString(2)))) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Application closed...");
                } catch (SQLException e) {
                }
            }
        }

        return false;
    }

    class RegForm extends JFrame {
        RegForm() {
            setTitle("Реєстрація");
            setLayout(new FlowLayout());
            add(l3);
            add(tf3);
            add(tf4);
            add(tf5);
            add(b3);
            add(l4);
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(300, 300);
            setVisible(true);


            b3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String sr = "";
                    try {
                        if (tf4.getText().equals(tf5.getText())) {
                            if ((AddUser(tf3.getText(), tf4.getText()))) {
                                sr = "Ви пойшли реєстрацію";
                            } else {
                                sr = "Такий користувач уже зареєстрований ";

                            }
                        } else {
                            sr = "Паролі не співпадають";
                        }
                        l4.setText(sr);
                    } catch (Exception f) {
                    }
                }
            });

        }
    }

}
