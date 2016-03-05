
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>KEYS GENERATOR</title>
</head>
<body>

<script>
    // create array of keys
    var matrix=[];

    // default constructor for mix key generator
    function Generator (){
        this._startIndex=0;
        this._endIndex=61;
        this._field=0;

    }

    // default constructor for symbol key generator
    function GeneratorS(){
        this._startIndex=0;
        this._endIndex=52;
        this._field=1;
    }

    // default constructor for int key generator
    function GeneratorI(){
        this._startIndex=52;
        this._endIndex=61;
        this._field=2;
    }


    // main method for key generator
    Generator.prototype.make=function  () {

        var result="1";
        var find="true";
        while ((find)||(result=="1"))
        {
            var i = 0;
            result="";

            while (i < 10) {

                var symba = Math.floor(Math.random() * (this._endIndex - this._startIndex + 1)) + this._startIndex;
                var proto = symba;

                if ((symba < 26)) {
                    proto += 65;

                }

                if ((symba >= 26) && (symba < 52)) {
                    proto += 71;

                }

                if (symba >= 52) {
                    proto -= 4;
                }

                var chr = String.fromCharCode(proto);
                result += chr;
                i++
            }

            find=findKey(result);
        }

        matrix.push(result);
        document.getElementById("code"+this._field).value=result;

    }


    // check uniq key
    function findKey(result){
        var size=matrix.length;
        var i=0;
        while(i<size){

            if(matrix[i]==result){
                alert("Find duplicate "+  matrix[i]);
                return true;
            }
            i++;
        }
        return false;
    }

    //method inheritage
    GeneratorS.prototype=Object.create(Generator.prototype);
    GeneratorS.prototype.constructor=GeneratorS;

    GeneratorI.prototype=Object.create(Generator.prototype);
    GeneratorI.prototype.constructor=GeneratorI;


    var worker= new Generator();
    var workerS = new GeneratorS();
    var workerI = new GeneratorI();

    //create page design
    var i=0;
    while (i<3){
    var code = document.createElement("input");
    code.id = "code"+i;
    code.style.position = 'absolute';
    code.style.top = 40+(i*30);
    code.style.left = 20;
    document.body.appendChild(code);

    var but = document.createElement("button");
    but.id = "but"+i;
    but.style.position = 'absolute';
    but.style.top = 40+(i*30);
    but.style.left = 220;
    document.body.appendChild(but);

        i++;
    }

    document.getElementById("but0").textContent="MixSymbGenerator";
    document.getElementById("but1").textContent="LettersGenerator";
    document.getElementById("but2").textContent="IntegersGenerator";


    // add function to button
    document.getElementById("but0").addEventListener("click", function() {
       worker.make();
    });

    document.getElementById("but1").addEventListener("click", function() {
        workerS.make();
    });

    document.getElementById("but2").addEventListener("click", function() {
        workerI.make();
    });


</script>


</body>
</html>
