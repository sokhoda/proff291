<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>

<html>
    <head>
        <title>Proff29</title>
        <style>
            textarea { width: 100%; border: 1px solid #333; padding: 4px; }
            ul { width: 100px; height: 430px;  padding: 30px 30px 10px 30px; }

        </style>
    </head>
        <body>
        <%
            request.getRequestDispatcher("/pages/authentification.jsp").forward(request, response);
        %>
           <%-- <h1>Hello proff29!!!</h1>
            <p>Para</p>
            <a href = "http://google.com.ua">Link</a>
            <br/>
            <img height="100px" width="100px" src="img/cartons-gratuits-rennes3.jpg"
            <br/>
            <q> quotation</q>
            <br/>
            <ol start="3" type="A">
                <li>item</li>
                <li>item</li>
                <li>item</li>
            </ol>
            <ul>
                <li>item1</li>
                <li>item2</li>
                <li>item3</li>
            </ul>
            --%>
            <%!
                public void globalMethod(){

                }
                int field = 0;
            %>
           ${name}
            <%
                String name = (String) request.getAttribute("name");
                Date date = new Date();
                out.println(date);
                request.getRequestDispatcher("/pages/authentification.jsp").forward(request,
                        response);
            %>
           <br/>
           <%=  "это счетчик посещений 1:" + field++ %>

            <table border="1" width="100%">
                <thead>
                    <tr>
                        <th colspan="2">SW Development</th>
                        <th colspan="2">SW Testing</th>
                        <th colspan="2">SW Distribution</th>
                        <th colspan="2">Поддержка ПО</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                       <td colspan="8">
                           <a href="http://www.thesitewizard.com/" target="_top">
                               <img src="http://www.thesitewizard.com/images/tsw468x60-2.gif" border="0" alt="Free Tutorials on PHP, CGI, Site Design, Promotion, Revenue and Programming at thesitewizard.com" width="468" height="60" /></a>
                           <a href="http://www.thesitewizard.com/" target="_top">
                               <img src="http://www.thesitewizard.com/images/tsw468x60php.gif" border="0" alt="Free Tutorials on Site Design, Promotion, Revenue and Programming at thesitewizard.com" width="468" height="60" /></a>

                       </td>

                    </tr>
                    <tr>
                        <td><a href="http://google.com.ua">XP Dev</a></td>
                        <td><a href="">AMM Dev</a></td>
                        <td><a href="">Module</a></td>
                        <td><a href="">testing 1</a></td>
                        <td><a href="">distrib 1</a></td>
                        <td><a href="">distrib 2</a></td>
                        <td><a href="">VIP поддержка</a></td>
                        <td><a href="">Golden поддержка</a></td>
                    </tr>
                    <tr>
                        <td colspan="2" >
                            <ul>
                                <li>строка 1, кратк. содерж.</li>
                                <li>строка 2, кратк. содерж.</li>
                                <li>строка 3, кратк. содерж.</li>
                            </ul>
                        </td>
                        <td>
                            <form action="/form" method="POST">
                                <input type="text" name="login" value="Noname"/>
                                <input type="password" name="pass"
                                       value=""/>
                                <input type="submit"  value="post"/>
                            </form>
                        </td>
                        <td colspan="5" valign="top">
                            <img height="100px" width="100px"
                            src="img/Ubahn.jpg" align="left"
                                 style="margin-right: 20px">
                            <p>
                            Books:
                            English Vocabulary in Use Elementary
                            English Vocabulary in Use Pre-intermediate & Intermediate
                            English Vocabulary in Use Upper-intermediate & Advanced
                            Test Your English Vocabulary in Use Pre-intermediate & Intermediate
                            Test Your English Vocabulary in Use Upper-intermediate & Advanced
                            This was David Penny’s research topic.
                            • Want a (Java) program to help a software company plan
                            new releases of their software (340 refers to person-days):
                            $ java Plan features.xml Planetaria 340
                            • xml file contains sized (in coder days), prioritized
                            (hi,med,low), feature requests for various products
                            – includes list of requesting customers with how much they want it
                            (1-10).
                            • Suggest an "optimal" release plan given the available
                            capacity (in coder days).
                            • Sample output
                            Nowadays president has the power over Police, army, judges, Cabinet of Ministers (executive). In the government we have the majority of criminalized pro presidential "Regional Party".
                            Viktor Yanukovych is sort of dictator and want us to be a slaves in our own, native Ukraine.

                            Let me say you some chronology of the events in Ukraine, how it was, how this war,rebel started.

                            The protest started in twenty first of November 2013 after refusing governemt to sign EU Association Agreement.
                            Many young people 18-22 years old - students were manifesting their disagreement in Kyiv on the main square, hearth of Kyiv, called "Maidan Nezalezhnosti" (in engl. "Independence Square"). Than Late at night about 4:00 30.11.2013 the PEACEFUL rally was very brutally, bestially broken up by special departments of police, armed with batons. You people were batonned untill the blood coming from their heads, fractures and so on.
                            And after that brutal night of 30.11.2013 Ukrainians from all over the county, but more from the western part came to Maidan showing that police were doing illegally, "Our children were beaten illegally, police had no right to do that" and so on. People were protesting and demanding that guilty persons in the government, who gave that command were punished, demanding to hold the criminal investigation against them.
                            But president and all the mafia, that is with him only frightened us with more brutal force, police, jail and so on.

                            We do want to enter the EU, to have basic human rights, right to work, to earn merited simply to live with dignity.

                            Nowadays government is resigned. But people peaceful are under pursuit and prosecutions.

                            Look, Russia intervene in all this closely. President of Ukraine looks like obey the commands of the Russian president Putin.
                            We don't want to cooperate with Russia, frankly speaking we don't like russians. Russian police special services are shooting in our brothers and sisters, shooting them, kidnapping and torturing them.
                            Our ukrainian police special service "Berkut" (that is in ukrainian "golden eagle") is cruelly beating with
                            batons, also use grenades tear-gas, toxic substances, guns with rubber bullets.  Sorry for telling you emotionally all this stuff, but I'm very excited about the future of my country and want to do my best to built a democratic society, not a prison.
                            About 9 people are dead ( some are shot with military guns, some as a result of diseases, caught cold being attacked from the water jet under the temperature below -10 C, which is in the international agreements forbidden and is treated as tortures).
                            About 1200 are wounded, some tens are disappeared without a trace.
                        </p>

                          <%--<textarea readonly name="text1" rows="40"--%>
                                    <%--contenteditable="false">--%>
                            <%--Books:--%>
                            <%--English Vocabulary in Use Elementary--%>
                            <%--English Vocabulary in Use Pre-intermediate & Intermediate--%>
                            <%--English Vocabulary in Use Upper-intermediate & Advanced--%>
                            <%--Test Your English Vocabulary in Use Pre-intermediate & Intermediate--%>
                            <%--Test Your English Vocabulary in Use Upper-intermediate & Advanced--%>
                            <%--</textarea>--%>

                        </td>
                    </tr>
                </tbody>
                <tfoot>
                    <td colspan="8" align="center">
                        Copyright, All rights reserved, Kyiv, 2016
                    </td>
                </tfoot>
            </table>

        </body>
</html>