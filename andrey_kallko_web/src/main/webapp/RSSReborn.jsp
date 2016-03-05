<%--
  Created by IntelliJ IDEA.
  User: elenabugercuk
  Date: 21.02.16
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>

<script>

    google.load("feeds", "1");
    var R = require("ramda");
</script>
<fieldset>
    <legend>RSS Channels</legend>
    Add RSS to List: <input type="text" name="txtCombo" id="txtCombo"/>
    <input type="button" value="Add " onclick="addCombo()">
    <input type="button" value="Delete " onclick="delCombo()">
    <br/>
    Existing Channels : <select name="combo" id="combo"></select>
</fieldset>

<script>



    var currentRSS=""; //url for current RSS Channel
    var count=0; //number of messages in Channel
    var auth=0; // number of uniq Author
    var mapAuth=new Array(); // Array to find uniq Author

var currentRSS=""; //url for current RSS Channel
var count=0; //number of messages in Channel
var auth=0; // number of uniq Author
var mapAuth=new Array(); // Array to find uniq Author


// Create 3 base Channels
var select = document.createElement("select");
var combo = document.getElementById("combo");

var option = document.createElement("option");
option.text = "http://rss.upi.com/news/news.rss";
option.value = "http://rss.upi.com/news/news.rss";
combo.add(option, null);

var option2 = document.createElement("option");
option2.text = "http://news.yahoo.com/rss";
option2.value = "http://news.yahoo.com/rss";
combo.add(option2, null);
currentRSS="http://news.yahoo.com/rss";

var option3 = document.createElement("option");
option3.text = "http://feeds.wired.com/wired/index";
option3.value = "http://feeds.wired.com/wired/index";
combo.add(option3, null);

var numberRSSChannels=3;

    // Create fields for statistics
    var stat1 = document.createElement("text");
    stat1.id="stat1";
    stat1.type="text";
    stat1.style.position="absolute";
    stat1.style.top=40;
    stat1.style.left=490;
    stat1.textContent="Numbers of RSS Channels " + numberRSSChannels;
    document.body.appendChild(stat1);

    var stat2 = document.createElement("text");
    stat2.id="stat2";
    stat2.type="text";
    stat2.style.position="absolute";
    stat2.style.top=40;
    stat2.style.left=760;
    stat2.textContent="Numbers of messages " + count;
    document.body.appendChild(stat2);

    var stat3 = document.createElement("text");
    stat3.id="stat3";
    stat3.type="text";
    stat3.style.position="absolute";
    stat3.style.top=40;
    stat3.style.left=990;
    stat3.textContent="Numbers of authors " + auth;
    document.body.appendChild(stat3);


    document.getElementById("combo").onmouseout=changeRSS;

    count=0;

    //create messages content
    function fillPage(obj) {

        var rad = document.createElement("input");
        rad.id = count;
        rad.type="radio";
        rad.style.position = 'absolute';
        rad.style.top = 120+count*30;
        rad.style.left = 30;
        rad.textContent=count;

        document.body.appendChild(rad);
        document.getElementById(count).onclick=readText;

        var rText=document.createElement("text");
        rText.id="rT"+count;
        rText.type="text";
        rText.style.position = 'absolute';
        rText.style.top = 120+count*30;
        rText.style.left = 55;
        rText.textContent="";
        document.body.appendChild(rText);

        document.getElementById(count).textContent=obj.content;
        document.getElementById("rT"+count).textContent=obj.title;

        addAuthor(obj.author);

        count++;
    }

    google.setOnLoadCallback(initialize());
    // Create array like a hash Map to find uniq Autors
    function addAuthor(sName){
        if ((sName==undefined)||(sName=="")){
            return;
        }

        if (mapAuth.length==0) {
            mapAuth.push(sName);
            return;
        }

        if (R.findIndex(sName, mapAuth)>=0){
            return;
        }
//
        mapAuth.push(sName);

    }

    // Create area for message output
    function addTextArea(){
        var textArea = document.createElement("box");
        textArea.id="tA";
        textArea.type="box";
        textArea.style.position = 'absolute';
        textArea.style.top =  550 //120+count*30;
        textArea.style.left = 850 //40;
        textArea.style.width=400;
        textArea.style.height=400;
        textArea.style.fontSize=20;
        textArea.textContent="";
        document.body.appendChild(textArea);
        document.getElementById("stat2").textContent="Numbers of messages " + count;
        document.getElementById("stat3").textContent="Numbers of authors " + mapAuth.length;
    }
    // output text message after chose one
    function readText(){
        this.checked=false;
        document.getElementById("tA").innerHTML = this.textContent;

        letterCount(document.getElementById("tA").textContent)

    }

    // count all kind of letters in message before create graph
    function letterCount(news) {
        var size=news.length;
        var letter = R.split("", news);
        var alph = R.repeat(0, size);


        i=0
        while (i<size){

            if((letter[i]=="a")||(letter[i]=="A")) {alph[0]++;}
            if((letter[i]=="b")||(letter[i]=="B")) {alph[1]++;}
            if((letter[i]=="c")||(letter[i]=="C")) {alph[2]++;}
            if((letter[i]=="d")||(letter[i]=="D")) {alph[3]++;}
            if((letter[i]=="e")||(letter[i]=="E")) {alph[4]++;}
            if((letter[i]=="f")||(letter[i]=="F")) {alph[5]++;}
            if((letter[i]=="g")||(letter[i]=="G")) {alph[6]++;}
            if((letter[i]=="h")||(letter[i]=="H")) {alph[7]++;}
            if((letter[i]=="i")||(letter[i]=="I")) {alph[8]++;}
            if((letter[i]=="j")||(letter[i]=="J")) {alph[9]++;}
            if((letter[i]=="k")||(letter[i]=="K")) {alph[10]++;}
            if((letter[i]=="l")||(letter[i]=="L")) {alph[11]++;}
            if((letter[i]=="m")||(letter[i]=="M")) {alph[12]++;}
            if((letter[i]=="n")||(letter[i]=="N")) {alph[13]++;}
            if((letter[i]=="o")||(letter[i]=="O")) {alph[14]++;}
            if((letter[i]=="p")||(letter[i]=="P")) {alph[15]++;}
            if((letter[i]=="q")||(letter[i]=="Q")) {alph[16]++;}
            if((letter[i]=="r")||(letter[i]=="R")) {alph[17]++;}
            if((letter[i]=="s")||(letter[i]=="S")) {alph[18]++;}
            if((letter[i]=="t")||(letter[i]=="T")) {alph[19]++;}
            if((letter[i]=="u")||(letter[i]=="U")) {alph[20]++;}
            if((letter[i]=="v")||(letter[i]=="V")) {alph[21]++;}
            if((letter[i]=="w")||(letter[i]=="W")) {alph[22]++;}
            if((letter[i]=="x")||(letter[i]=="X")) {alph[23]++;}
            if((letter[i]=="y")||(letter[i]=="Y")) {alph[24]++;}
            if((letter[i]=="z")||(letter[i]=="Z")) {alph[25]++;}

            i++;
        }

        i=0;
        var result=0;
        while(i<26){

            result+=alph[i];
            i++;
        }

        alph[26]=size-result; //alph[26] = numbers of nonLetter

        drawMyChart(alph);

    }
    // Change RSS Channel

    function changeRSS(){

        if(currentRSS==document.getElementById("combo").value){
            return;
        }

        currentRSS=document.getElementById("combo").value;


        try{
            document.body.removeChild(document.getElementById("tA"));}
        catch(exept) {};
        var i=0;
        while (i<count) {
            document.body.removeChild(document.getElementById(i));
            document.body.removeChild(document.getElementById("rT"+i));
            i++;
        }

        document.getElementById("chartContainer").style.display="none";
        google.setOnLoadCallback(initialize());
    }


    function delCombo() {
        var combo = document.getElementById("combo");
        var options = combo.options;
        var index = R.findIndex(currentRSS,options);
        combo.removeChild(options[index])


        numberRSSChannels--;
        document.getElementById("stat1").textContent="Numbers of RSS Channels " + numberRSSChannels;
        document.getElementById("combo").value="";
        currentRSS="";
        changeRSS();
    }





    // Add new url for new Channel
    function addCombo() {
        if (document.getElementById("txtCombo").value==""){
            return;
        }
        var textb = document.getElementById("txtCombo");
        var combo = document.getElementById("combo");

        var option = document.createElement("option");
        option.text = textb.value;
        option.value = textb.value;
        try {
            combo.add(option, null); //Standard
        }catch(error) {
            combo.add(option); // IE only
        }
        textb.value = "";
        numberRSSChannels++;
        document.getElementById("stat1").textContent="Numbers of RSS Channels " + numberRSSChannels;
    }


    // google feed
    function initialize() {

        count=0;
        mapAuth.length=0;

        var feed = new google.feeds.Feed(currentRSS);
        feed.setNumEntries(100);
        feed.setResultFormat(google.feeds.Feed.MIXED_FORMAT)
        feed.load(function(result) {
            if (!result.error) {

                for (var i = 0; i < result.feed.entries.length; i++) {
                    var entry = result.feed.entries[i];
                    fillPage(entry);

                }
                addTextArea();
            }
        });
    }



    // create graph with Canavas.JS
    function drawMyChart (data) {

        var chart = new CanvasJS.Chart("chartContainer", {
            title:{
                text: "Letters "
            },
            data: [
                {
                    // Change type to "doughnut", "line", "splineArea", etc.§
                    type: "doughnut",
                    dataPoints: [
                        { label: "a",  y: data[0]  },
                        { label: "b",  y: data[1]  },
                        { label: "c",  y: data[2]  },
                        { label: "d",  y: data[3]  },
                        { label: "e",  y: data[4]  },
                        { label: "f",  y: data[5]  },
                        { label: "g",  y: data[6]  },
                        { label: "h",  y: data[7]  },
                        { label: "i",  y: data[8]  },
                        { label: "j",  y: data[9]  },
                        { label: "k",  y: data[10]  },
                        { label: "l",  y: data[11]  },
                        { label: "m",  y: data[12]  },
                        { label: "n",  y: data[13]  },
                        { label: "o",  y: data[14]  },
                        { label: "p",  y: data[15]  },
                        { label: "q",  y: data[16]  },
                        { label: "r",  y: data[17]  },
                        { label: "s",  y: data[18]  },
                        { label: "t",  y: data[19]  },
                        { label: "u",  y: data[20]  },
                        { label: "v",  y: data[21]  },
                        { label: "w",  y: data[22]  },
                        { label: "x",  y: data[23]  },
                        { label: "y",  y: data[24]  },
                        { label: "z",  y: data[25]  },
                        //  { label: "Simbols",  y: data[26]  },


                    ]
                }
            ]
        });

        chart.render();
        document.getElementById("chartContainer").style.display="block";
    }


</script>
</body>
</html>
