package NotebookShop;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//import java.sql.Date;


@WebServlet("/NotebookShop.html")
public class NotebookShop extends HttpServlet {


    public void init() {
    }

    public void doGet(HttpServletRequest sq, HttpServletResponse sp) throws IOException {
        sp.setContentType("text/html");
        sp.setCharacterEncoding("utf-8");
        PrintWriter out = sp.getWriter();
        out.print("<html>");
        out.print("<form method=\"GET\"" + " \"action=\"/NotebookShop.html\">");
        out.print("<HEAD> <TITLE>");
        out.print("Магазин ноутбуків");
        out.print("</TITLE></HEAD><BODY>");


        out.print("Виберіть потрібну дію" + "<br/>" + "<p></p>");
        out.print("<table>");
        out.print("<tbody>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Додати до списку ноутбук");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Додати ноутбук                     \" id=\"1\"/>");
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td>");
        out.print("Показати список ноутбуків");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Показати список                    \" id=\"2\"/>");
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Видалити ноутбук по ID");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Видалити ноутбук                  \" id=\"3\"/>");
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Змінити ціну ноутбука по ID");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Змінити ціну                           \" id=\"4\"/>");
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Змінити серійний номер та виробника по ID");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Змінити серійний N,виробника\" id=\"5\"/>");
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Видалити ноутбук по назві");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Видалити по назві                  \" id=\"6\"/>");
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Отримати ноутбук по виробнику");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Отримати по виробнику          \" id=\"7\"/>");
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Отримати ноутбук по ціні та року виготовлення");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Отримати по ціні                     \" id=\"8\"/>");
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Отримати ноутбук по діапазону цін до вказаної дати");
        out.print("</td>");
        out.print("<td>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Отримати по діапазону цін      \" id=\"9\"/>");
        out.print("</td>");
        out.print("</tr>");


        out.print("</tbody>");
        out.print("</table>");


        String sub = sq.getParameter("submit").trim();
        System.out.println(sub);

        if (sub.equals("Додати ноутбук")) {
            out.print("<br/>" + "<p></p>");
            out.print("Додати ноутбук" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Серійний номер");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"serial\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Виробник");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"vendor\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Модель");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"model\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Дата виготовлення");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"manufacture_date\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Ціна");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"price\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Додати ноутбук \" id=\"11\"/>");

            boolean fladd = true;
            String sserial = sq.getParameter("serial").trim();
            System.out.println(sserial);
            out.print("<br/>" + "<p></p>");
            if (sserial.length() == 0) {
                out.print("Введіть серійний номер" + "<br/>" + "<p></p>");
                fladd = false;
            }
            String svendor = sq.getParameter("vendor").trim();
            System.out.println(svendor);
            if (svendor.length() == 0) {
                out.print("Введіть постачальника" + "<br/>" + "<p></p>");
                fladd = false;
            }
            String smodel = sq.getParameter("model").trim();
            System.out.println(smodel);
            if (smodel.length() == 0) {
                out.print("Введіть модель" + "<br/>" + "<p></p>");
                fladd = false;
            }


            String sDate = sq.getParameter("manufacture_date").trim();
            System.out.println(sDate);
            Date smanufacture_date = new Date(100);
            try {
                smanufacture_date = new SimpleDateFormat("dd.MM.yyyy").parse(sDate);
            } catch (Exception e) {
                out.print("Введіть дату" + "<br/>" + "<p></p>");
                fladd = false;
            }

            String prices = sq.getParameter("price").trim();
            System.out.println(prices);
            Double sprice = 0.0;
            try {

                sprice = Double.valueOf(prices);

            } catch (Exception e) {
                out.print("Введіть ціну" + "<br/>" + "<p></p>");
                fladd = false;
            }

            if (fladd == true) {
                HiberNotebook hn = new HiberNotebook();
                hn.nl.setSerial(sserial);
                hn.nl.setVendor(svendor);
                hn.nl.setModel(smodel);
                hn.nl.setManufacture_date(smanufacture_date);
                hn.nl.setPrice(sprice);
                if (hn.AddNotebook()) {
                    out.print("Ноутбук добавлено в базу" + "<br/>" + "<p></p>");
                } else {
                    out.print("Помилка додавання в базу" + "<br/>" + "<p></p>");
                }
            }


        } else if (sub.equals("Показати список")) {
            HiberNotebook hn = new HiberNotebook();
            out.print("<br/>" + "<p></p>");
            out.print("Список ноутбуків" + "<br/>" + "<p></p>");

            out.print("<table border=\"2\">");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Номер ID");
            out.print("</td>");

            out.print("<td>");
            out.print(" Серійний номер ");
            out.print("</td>");
            out.print("<td>");
            out.print("    Виробник    ");
            out.print("</td>");
            out.print("<td>");
            out.print("     Модель     ");
            out.print("</td>");

            out.print("<td>");
            out.print("Дата виготовлення");
            out.print("</td>");
            out.print("<td>");
            out.print("  Ціна  ");
            out.print("</td>");
            out.print("</tr>");

            List<notebookslist> nl = hn.ShowList();
            Iterator inl = nl.iterator();
            while (inl.hasNext()) {
                notebookslist nle = (notebookslist) inl.next();


                out.print("<tr>");
                out.print("<td>");
                out.print(nle.getId().toString());
                out.print("</td>");

                out.print("<td>");
                out.print(nle.getSerial().toString());
                out.print("</td>");
                out.print("<td>");
                out.print(nle.getVendor().toString());
                out.print("</td>");
                out.print("<td>");
                out.print(nle.getModel().toString());
                out.print("</td>");

                out.print("<td>");
                out.print(nle.getManufacture_date().toString());
                out.print("</td>");
                out.print("<td>");
                out.print(nle.getPrice().toString());
                out.print("</td>");
                out.print("</tr>");
            }
            out.print("</tbody>");
            out.print("</table>");

        } else if (sub.equals("Видалити ноутбук")) {
            out.print("<br/>" + "<p></p>");
            out.print("Видалити ноутбук по ID" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть ID");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"id3\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");

            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Видалити ноутбук\" id=\"12\"/>");

            boolean fladd = true;
            String sid3 = sq.getParameter("id3").trim();
            System.out.println(sid3);
            out.print("<br/>" + "<p></p>");
            long id3 = 0;
            if (sid3.length() == 0) {
                out.print("Введіть ID" + "<br/>" + "<p></p>");
                fladd = false;
            } else {
                try {
                    id3 = Long.parseLong(sid3);
                } catch (Exception e) {
                    out.print("Введіть ID" + "<br/>" + "<p></p>");
                    fladd = false;
                }
            }


            if (fladd == true) {
                HiberNotebook hn = new HiberNotebook();
                hn.nl.setId(id3);
                if (hn.DeleteNotebook()) {
                    out.print("Ноутбук видалений із бази" + "<br/>" + "<p></p>");
                } else {
                    out.print("Помилка видалення" + "<br/>" + "<p></p>");
                }
            }

        } else if (sub.equals("Змінити ціну")) {
            out.print("<br/>" + "<p></p>");
            out.print("Змінити ціну ноутбука по ID" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть ID");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"id4\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть ціну");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"price4\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Змінити ціну\" id=\"13\"/>");

            boolean fladd = true;
            String sid4 = sq.getParameter("id4").trim();
            System.out.println(sid4);
            out.print("<br/>" + "<p></p>");
            long id4 = 0;
            if (sid4.length() == 0) {
                out.print("Введіть ID" + "<br/>" + "<p></p>");
                fladd = false;
            } else {
                try {
                    id4 = Long.parseLong(sid4);
                } catch (Exception e) {
                    out.print("Введіть ID" + "<br/>" + "<p></p>");
                    fladd = false;
                }
            }
            String sprise4 = sq.getParameter("price4").trim();
            System.out.println(sprise4);
            out.print("<br/>" + "<p></p>");
            double price4 = 0;
            if (sprise4.length() == 0) {
                out.print("Введіть ціну" + "<br/>" + "<p></p>");
                fladd = false;
            } else {
                try {
                    price4 = Double.parseDouble(sprise4);
                } catch (Exception e) {
                    out.print("Введіть ціну" + "<br/>" + "<p></p>");
                    fladd = false;
                }
            }

            if (fladd == true) {
                if (fladd == true) {
                    HiberNotebook hn = new HiberNotebook();
                    hn.nl.setId(id4);
                    hn.nl.setPrice(price4);
                    if (hn.UpdatePrice()) {
                        out.print("Нова ціна встановлена" + "<br/>" + "<p></p>");
                    } else {
                        out.print("Помилка " + "<br/>" + "<p></p>");
                    }
                }


            }

        } else if (sub.equals("Змінити серійний N,виробника")) {
            out.print("<br/>" + "<p></p>");
            out.print("Змінити серійний номер та виробника по ID" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть ID");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"id5\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть серійний номер");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"serial5\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть виробника");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"vendor5\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Змінити серійний N,виробника\" id=\"14\"/>");

            boolean fladd = true;
            String sid5 = sq.getParameter("id5").trim();
            System.out.println(sid5);
            out.print("<br/>" + "<p></p>");
            long id5 = 0;
            if (sid5.length() == 0) {
                out.print("Введіть ID" + "<br/>" + "<p></p>");
                fladd = false;
            } else {
                try {
                    id5 = Long.parseLong(sid5);
                } catch (Exception e) {
                    out.print("Введіть ID" + "<br/>" + "<p></p>");
                    fladd = false;
                }
            }
            String serial5 = sq.getParameter("serial5").trim();
            System.out.println(serial5);
            out.print("<br/>" + "<p></p>");
            if (serial5.length() == 0) {
                out.print("Введіть серійний номер" + "<br/>" + "<p></p>");
                fladd = false;
            }

            String vendor5 = sq.getParameter("vendor5").trim();
            System.out.println(vendor5);
            out.print("<br/>" + "<p></p>");
            if (vendor5.length() == 0) {
                out.print("Введіть виробника" + "<br/>" + "<p></p>");
                fladd = false;
            }


            if (fladd == true) {
                if (fladd == true) {
                    HiberNotebook hn = new HiberNotebook();
                    hn.nl.setId(id5);
                    hn.nl.setSerial(serial5);
                    hn.nl.setVendor(vendor5);
                    if (hn.UpdateSerialVendor()) {
                        out.print("Серійний номер та виробник змінено" + "<br/>" + "<p></p>");
                    } else {
                        out.print("Помилка " + "<br/>" + "<p></p>");
                    }
                }


            }
        } else if (sub.equals("Видалити по назві")) {
            out.print("<br/>" + "<p></p>");
            out.print("Видалити ноутбук по назві" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть назву моделі ноутбука");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"model6\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");

            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Видалити по назві\" id=\"15\"/>");

            boolean fladd = true;
            String model6 = sq.getParameter("model6").trim();
            System.out.println(model6);
            out.print("<br/>" + "<p></p>");
            if (model6.length() == 0) {
                out.print("Введіть модель ноутбука" + "<br/>" + "<p></p>");
                fladd = false;
            }


            if (fladd == true) {
                HiberNotebook hn = new HiberNotebook();
                hn.nl.setModel(model6);
                if (hn.DeleteNotebookByName()) {
                    out.print("Ноутбук видалений із бази" + "<br/>" + "<p></p>");
                } else {
                    out.print("Помилка видалення" + "<br/>" + "<p></p>");
                }
            }
        } else if (sub.equals("Отримати по виробнику")) {
            out.print("<br/>" + "<p></p>");
            out.print("Отримати ноутбук по виробнику" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть назву виробника");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"vendor7\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");

            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Отримати по виробнику\" id=\"16\"/>");

            boolean fladd = true;
            String vendor7 = sq.getParameter("vendor7").trim();
            System.out.println(vendor7);
            out.print("<br/>" + "<p></p>");
            if (vendor7.length() == 0) {
                out.print("Введіть модель ноутбука" + "<br/>" + "<p></p>");
                fladd = false;
            }


            if (fladd == true) {
                //////////////////////
                HiberNotebook hn = new HiberNotebook();
                hn.nl.setVendor(vendor7);
                out.print("<br/>" + "<p></p>");
                out.print("Список ноутбуків" + "<br/>" + "<p></p>");

                out.print("<table border=\"2\">");
                out.print("<tbody>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Номер ID");
                out.print("</td>");

                out.print("<td>");
                out.print(" Серійний номер ");
                out.print("</td>");
                out.print("<td>");
                out.print("    Виробник    ");
                out.print("</td>");
                out.print("<td>");
                out.print("     Модель     ");
                out.print("</td>");

                out.print("<td>");
                out.print("Дата виготовлення");
                out.print("</td>");
                out.print("<td>");
                out.print("  Ціна  ");
                out.print("</td>");
                out.print("</tr>");

                List<notebookslist> nl = hn.ShowListByVendor();
                Iterator inl = nl.iterator();
                while (inl.hasNext()) {
                    notebookslist nle = (notebookslist) inl.next();


                    out.print("<tr>");
                    out.print("<td>");
                    out.print(nle.getId().toString());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(nle.getSerial().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getVendor().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getModel().toString());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(nle.getManufacture_date().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getPrice().toString());
                    out.print("</td>");
                    out.print("</tr>");
                }
                out.print("</tbody>");
                out.print("</table>");
                ////////////////////
            }
        } else if (sub.equals("Отримати по ціні")) {
            out.print("<br/>" + "<p></p>");
            out.print("Отримати ноутбук по ціні" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть ціну");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"price8\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");

            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Отримати по ціні\" id=\"17\"/>");

            boolean fladd = true;
            String price8 = sq.getParameter("price8").trim();

            out.print("<br/>" + "<p></p>");
            double dprice = 0;
            if (price8.length() > 0) {
                try {
                    dprice = Double.parseDouble(price8);
                    System.out.println(dprice);
                } catch (Exception e) {
                    out.print("Введіть ціну" + "<br/>" + "<p></p>");
                    fladd = false;
                }

            } else {
                out.print("Введіть ціну" + "<br/>" + "<p></p>");
                fladd = false;
            }


            if (fladd == true) {

                HiberNotebook hn = new HiberNotebook();
                hn.nl.setPrice(dprice);
                out.print("<br/>" + "<p></p>");
                out.print("Список ноутбуків" + "<br/>" + "<p></p>");

                out.print("<table border=\"2\">");
                out.print("<tbody>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Номер ID");
                out.print("</td>");

                out.print("<td>");
                out.print(" Серійний номер ");
                out.print("</td>");
                out.print("<td>");
                out.print("    Виробник    ");
                out.print("</td>");
                out.print("<td>");
                out.print("     Модель     ");
                out.print("</td>");

                out.print("<td>");
                out.print("Дата виготовлення");
                out.print("</td>");
                out.print("<td>");
                out.print("  Ціна  ");
                out.print("</td>");
                out.print("</tr>");

                List<notebookslist> nl = hn.ShowListByPrice();
                Iterator inl = nl.iterator();
                while (inl.hasNext()) {
                    notebookslist nle = (notebookslist) inl.next();


                    out.print("<tr>");
                    out.print("<td>");
                    out.print(nle.getId().toString());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(nle.getSerial().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getVendor().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getModel().toString());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(nle.getManufacture_date().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getPrice().toString());
                    out.print("</td>");
                    out.print("</tr>");
                }
                out.print("</tbody>");
                out.print("</table>");
                ////////////////////
            }
        } else if (sub.equals("Отримати по діапазону цін")) {
            out.print("<br/>" + "<p></p>");
            out.print("Отримати по діапазону цін до вкзаної дати" + "<br/>" + "<p></p>");

            out.print("<table>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть ціну");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"price9\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть ціну");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"price10\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");
            out.print("<tr>");
            out.print("<td>");
            out.print("Введіть дату");
            out.print("</td>");
            out.print("<td>");
            out.print("<input type=\"text\" name=\"date9\" size=\"20\"/>");
            out.print("</td>");
            out.print("</tr>");

            out.print("</tbody>");
            out.print("</table>");
            out.print("<input type=\"submit\" name=\"submit\"  value=\"Отримати по діапазону цін\" id=\"20\"/>");

            boolean fladd = true;
            String price9 = sq.getParameter("price9").trim();

            out.print("<br/>" + "<p></p>");
            double dprice9 = 0;
            if (price9.length() > 0) {
                try {
                    dprice9 = Double.parseDouble(price9);
                    System.out.println(dprice9);
                } catch (Exception e) {
                    out.print("Введіть ціну" + "<br/>" + "<p></p>");
                    fladd = false;
                }

            } else {
                out.print("Введіть ціну" + "<br/>" + "<p></p>");
                fladd = false;
            }

            String price10 = sq.getParameter("price10").trim();


            double dprice10 = 0;
            if (price10.length() > 0) {
                try {
                    dprice10 = Double.parseDouble(price10);
                    System.out.println(dprice10);
                } catch (Exception e) {
                    out.print("Введіть ціну" + "<br/>" + "<p></p>");
                    fladd = false;
                }

            } else {
                out.print("Введіть ціну" + "<br/>" + "<p></p>");
                fladd = false;
            }


            String sDate = sq.getParameter("date9").trim();
            System.out.println(sDate);
            Date smanufacture_date = new Date(100);
            try {
                smanufacture_date = new SimpleDateFormat("dd.MM.yyyy").parse(sDate);
            } catch (Exception e) {
                out.print("Введіть дату" + "<br/>" + "<p></p>");
                fladd = false;
            }


            System.out.println(fladd);
            if (fladd == true) {
                //////////////////////
                HiberNotebook hn = new HiberNotebook();
                hn.nl.setPrice(dprice9);
                hn.hnprise = dprice10;
                hn.nl.setManufacture_date(smanufacture_date);


                out.print("<br/>" + "<p></p>");
                out.print("Список ноутбуків" + "<br/>" + "<p></p>");

                out.print("<table border=\"2\">");
                out.print("<tbody>");
                out.print("<tr>");
                out.print("<td>");
                out.print("Номер ID");
                out.print("</td>");

                out.print("<td>");
                out.print(" Серійний номер ");
                out.print("</td>");
                out.print("<td>");
                out.print("    Виробник    ");
                out.print("</td>");
                out.print("<td>");
                out.print("     Модель     ");
                out.print("</td>");

                out.print("<td>");
                out.print("Дата виготовлення");
                out.print("</td>");
                out.print("<td>");
                out.print("  Ціна  ");
                out.print("</td>");
                out.print("</tr>");

                List<notebookslist> nl = hn.ShowListByDatePrice();
                Iterator inl = nl.iterator();
                while (inl.hasNext()) {
                    notebookslist nle = (notebookslist) inl.next();


                    out.print("<tr>");
                    out.print("<td>");
                    out.print(nle.getId().toString());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(nle.getSerial().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getVendor().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getModel().toString());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(nle.getManufacture_date().toString());
                    out.print("</td>");
                    out.print("<td>");
                    out.print(nle.getPrice().toString());
                    out.print("</td>");
                    out.print("</tr>");
                }
                out.print("</tbody>");
                out.print("</table>");
                ////////////////////
            }

        }


        out.print("</BODY>");
        out.print("</form>");
        out.print("</html>");
        out.close();


    }
}

