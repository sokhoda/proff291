<%--
  Created by IntelliJ IDEA.
  User: al1
  Date: 21.11.15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="static hw7.notes.view.Servlet.*" %>
<%@ page import="hw7.notes.dao.VendorDao" %>
<%@ page import="hw7.notes.service.NotebookService" %>
<%@ page import="hw7.notes.domain.Vendor" %>
<%@ page import="hw7.notes.service.NotebookServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="hw7.notes.view.Menu" %>
<%--<%@ page errorPage="/hw7.notes/pages/generalErrorPage.jsp" %>--%>
<script src="/hw7.notes/JS/select.js" type="text/javascript">    </script>
<script src="/hw7.notes/JS/notebooks.js" type="text/javascript">    </script>

<html>

<%!
    VendorDao vendorDao;
    Integer mode;
    List<Vendor> vendor = null;
    String headPart;
    String venSelInx;
    String venSelVal;
%>
<%
    mode = String2Integer(getAttribValue(request, "mode"));
    headPart =  (mode == 0 ? "Add New" : "Update");
%>

<head>
    <title><%=headPart%> Vendor Type</title>
    <style>
        <%@include file='/hw7.notes/css/addNotebook.css' %>
    </style>
    <center><h1><%=headPart%> Vendor Type</h1></center><br>
</head>
<body>


<%
    vendorDao = ((NotebookServiceImpl) Menu.service).getVendorDao();

    if (mode == 1) {
        vendor = (List<Vendor>)vendorDao.findAll();
        venSelInx = (String) request.getAttribute("venSelInx");
        venSelVal = (String) request.getAttribute("venSelVal");
    }
    String vendorInputText = getAttribValue(request, "nameA");

    String[] message = getAttribArray(request);
//        message[0] = "brown";
//        message[1] = "";
%>

<form action="/AddVen" method="get">
    <img src="/hw7.notes/img/addLaptop1.jpg" align="left" style="margin-right: 20px">


    <div id="divVenSel">
        <label for="venSel">SELECT VENDOR:</label>
        <% if(vendor != null){
        %>
        <select size="<%vendor.size();%>" name="venSel" id="venSel"
                onchange="this.form.submit();">

            <option disabled>select item</option>
            <%
                int cnt = 1;
                for (Vendor v : vendor) {
                    if(venSelInx != null){
                        if (cnt == Integer.parseInt(venSelInx)){
            %>
                            <option value="<%=v.getId()%>" selected>
                    <%
                        }
                        else{
                    %>
                            <option value="<%=v.getId()%>">
                    <%
                        }
                    }
                    else {
                        if (venSelVal != null && v.getId() ==
                        Integer.parseInt(venSelVal)){
                    %>
                            <option value="<%=v.getId()%>" selected>
                    <%
                        }
                        else{
                    %>
                            <option value="<%=v.getId()%>">
                    <%
                        }
                    }
                    %>

                            <%=v.getName()%></option>
            <%
                        cnt++;
                    }
                }
            %>
        </select><br>
    </div>

    <label for="vendors">NAME:</label>
    <input  type="text" value="<%=vendorInputText%>" placeholder="TOSHIBA"
            name="name" id="vendors"><br>

    <br><br>
    <br><br>
    <p style="text-align: center;">
        <input type="submit" name="back" value="&longleftarrow; back">
        <input type="submit" name="add" value="Add" id="addBtn">
        <input type="submit" name="update" value="Update" id="updateBtn">

        <input type="button" value="Clear All"
               onclick="clearElemContent('vendors');
               clearElemContent('message');">
    </p>
    <br>
    <br>
    <label id="message" style="width: 100%; margin-top:10%; color:<%=message[0]%>;
            text-align: center; font-size:x-large"><%=message[1]%>
    </label>
</form>

<%
    if(mode == 1){ //update
%>
<script type="text/javascript">
    setVisibility('divVenSel', 'block');
    setVisibility('updateBtn','inline');
    setVisibility('addBtn','none');
</script>
<%
}
else{
%>
<script type="text/javascript">
    setVisibility('divVenSel', 'none');
    setVisibility('updateBtn','none');
    setVisibility('addBtn','inline');
</script>
<%
    }
%>
</body>
</html>