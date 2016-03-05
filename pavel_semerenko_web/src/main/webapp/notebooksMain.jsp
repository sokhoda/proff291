<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
    <script>
        var filled_data = "filled_data";
        function addNotebook(){
            clearEmptyObj();
            var empty_obj = document.getElementById("empty_obj");

            var filled_data_node = document.createElement("form");
            filled_data_node.setAttribute("id", filled_data);
            filled_data_node.setAttribute("action", "/addNotebook.sepadmi");
            filled_data_node.setAttribute("method", "post");

            var input_serial_node = document.createElement("input");
            input_serial_node.setAttribute("name", "serial");
            var input_vendor_node = document.createElement("input");
            input_vendor_node.setAttribute("name", "vendor");
            var input_model_node = document.createElement("input");
            input_model_node.setAttribute("name", "model");
            var input_manufacture_date_node = document.createElement("input");
            input_manufacture_date_node.setAttribute("name", "manufacture_date");
            var input_price_node = document.createElement("input");
            input_price_node.setAttribute("name", "price");
            input_price_node.setAttribute("type", "number");
            var submit_node = document.createElement("input");
            submit_node.setAttribute("type", "submit");
            submit_node.setAttribute("value", "SAVE");

            empty_obj.appendChild(filled_data_node);
            filled_data_node.appendChild(createText("serial number"));
            filled_data_node.appendChild(input_serial_node);
            filled_data_node.appendChild(document.createElement("br"));
            filled_data_node.appendChild(createText("serial number"));
            filled_data_node.appendChild(input_vendor_node);
            filled_data_node.appendChild(document.createElement("br"));
            filled_data_node.appendChild(createText("model"));
            filled_data_node.appendChild(input_model_node);
            filled_data_node.appendChild(document.createElement("br"));
            filled_data_node.appendChild(createText("manufacture date"));
            filled_data_node.appendChild(input_manufacture_date_node);
            filled_data_node.appendChild(document.createElement("br"));
            filled_data_node.appendChild(createText("price"));
            filled_data_node.appendChild(input_price_node);
            filled_data_node.appendChild(document.createElement("br"));
            filled_data_node.appendChild(submit_node);

            function createText(text) {
                var text_node = document.createElement("input");
                text_node.setAttribute("type", "text");
                text_node.setAttribute("value", text);
                text_node.disabled = true;
                return text_node;
            }
        }

        function showAllNotebooks(){
            clearEmptyObj();
            var empty_obj = document.getElementById("empty_obj");
        }

        function clearEmptyObj(){
            var empty_obj = document.getElementById("empty_obj");
            var filled_data_node = document.getElementById(filled_data);
            if(filled_data_node != null){
                empty_obj.removeChild(filled_data_node);
            }
        }
    </script> PS i cannot say it to you right now but I love you You are my soulmatye. despite of the fact I don't believe in soulmates. That's how I love you!!!!

    <input type="button" onclick="addNotebook()" value="add notebook" /><br />
    <input type="button" onclick="showAllNotebooks()" value="show all notebooks" /><br />
    ${server_message}
    <form id="empty_obj">

    </form>
</body>
</html>