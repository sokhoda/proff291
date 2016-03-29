function addToTableBodyExample(surname, FirstName, LastName){
    /* объявляем и заполняем переменные, где entry это массив */
    var entry = [surname, FirstName, LastName],
        tableContent = "<tr>";

    /* используем цикл for для записи в переменную tableContent
      три ячейки поочереди, внутри коих значения ячеек entry */
    for(var i = 0; i < 3; i++){
        tableContent += "<td>" + entry[i] + "</td>";
    };

    /* закрываем строку таблицы внутри переменной */
    tableContent += "</tr>";

    /* добавляем значение переменной tableContent в конец тега tbody
      обращаясь к последнему через идентификатор tableBodyExample */
    tableBodyExample.innerHTML += tableContent;
};