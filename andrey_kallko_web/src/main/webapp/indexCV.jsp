<%--
  Created by IntelliJ IDEA.
  User: tri___ton
  Date: 01.02.16
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CV Kalko Andriy</title>
</head>
<body>

<script>
    var x;
    var y;
    var count=0;
    var i=0;
    var result=0;

    var img = document.createElement("img");
    img.id="mainphoto";
    img.width=430;
    img.height=300;
    img.src = "http://img-fotki.yandex.ru/get/5700/svetonebo.6e/0_e9607_dbee1194_L";
    document.body.appendChild(img);

    while (i<4) {
        var But = document.createElement("button");
        But.id = "but" + i;
        But.style.position = 'absolute';
        But.style.top = 320;
        But.style.left = 10 + 100 * i;
        document.body.appendChild(But);
        i++;
    }



    document.getElementById("but0").textContent="Like";
    document.getElementById("but0").style.left = 10;
    document.getElementById("but1").textContent="Unlike";
    document.getElementById("but1").style.left = 67;
    document.getElementById("but2").textContent="Start Resume Quest";
    document.getElementById("but2").style.left = 135;
    document.getElementById("but3").textContent="Stop Playing. Just Resume";
    document.getElementById("but3").style.left = 279;
    document.getElementById("but3").onmousemove=placeDiv;
    document.getElementById("but1").onclick=imgChange;
    document.getElementById("but2").onclick=qwestStart;
    document.getElementById("but0").onclick=like;


    var matrix = [ ["Telephone number","+380504033536", "from 10.00 till 23.00", "e-mail","kallko_andrey@yahoo.co.uk", "anytime","skype", "tri___ton", "when online", "General"],
        ["2012-2014","RA Kinograff","Creative Group Head","2010-2012", "RA Amvitamin", "Creative Director", "2005-2010", "RA Saatchi&Saatchi Ukraine", "from Copywriter to Creative Head", "Expirience"],
        ["2016", "IT Centre, Kyiv", "JAVA for profesional", "2015", "IT Centre, Kyiv", "OOP Java","2015","IT Centre, Kyiv","JAVA for beginers", "IT Education"],
    ["OOP Skills","Java","JavaFX","JavaScript","Eclipse","IntelLij IDEA","GitBlit","JDBC","MySQL", "Skills"],["Intermidiate English","Target-oriented thinking","Teamwork person","Without bad habbits",
            "Like to learning","Windows and Mac user","Creative","Punktual","Make a lot of mistakes, but once", "Personal qualities"]];


    var qMatrix = [["Birth year?", 1976, 1986, 1996, "undefined", "NOT NULL", 5,3,2,0,0],[
        "Education?", "High","Secondary", "So so", "in process", "Not found",5,2,1,0,3],
    ["Expirience?", "Wide Range specialist", "A lot, but not IT", "ITExpirience Exeption", "Advertising agencies", "Тo be continued...",2,3,0,5,0],
    ["Professional Skills?", "Java, JavaScript, JavaFX", "Eclipse, Intelliji IDEA, Tomcat, GitBlit", "JDBC, MySql", "All above", "Windows 3.1",3,3,3,5,0],
    ["Personal qualities?","Intermediate English","Creative" ," Target oriented" , "Teamplayer", "All above and very modest",3,3,3,3,0 ]]

    var rMatrix = ["You like X-ray, can see everything right through me. I am glad to meet your expectations. Invite me for an interview and I will not fail.",
        "It is difficult to hide something, from you. But if you invite me for an interview, I will be able to clear some details.", "You think its fun? I am too. Lets make creative products together."]


    function like(){
        alert("Hey, this is not Facebook!" + "\n" + "Lets go to work!")
        document.getElementById("but0").style.display="none";
        document.getElementById("but1").style.display="none";
    }

    function qwestStart(){
        document.body.removeChild(document.getElementById("but0"));
        document.body.removeChild(document.getElementById("but1"));
        document.body.removeChild(document.getElementById("but2"));
        document.body.removeChild(document.getElementById("but3"));
        i=0;
        count=0;

        alert ("Lets play a little bit" + "\n"+ "Answer some question, and make few sugestions about me.")
        var text= document.createElement("text");
        text.id="qwestion";
        text.style.position = 'absolute';
        text.style.top = 45;
        text.style.left = 525;

        document.body.appendChild(text);

        while (i<5){
            var rad = document.createElement("input");
            rad.id = "radio"+i;
            rad.type="radio";
            rad.style.position = 'absolute';
            rad.style.top = 75+i*50;
            rad.style.left = 500;

            document.body.appendChild(rad);
            document.getElementById("radio"+i).onclick=nextQwest;

            var ask = document.createElement("text")
            ask.id="answer"+i;
            ask.style.position = 'absolute';
            ask.style.top = 75+i*50;
            ask.style.left = 525;

            document.body.appendChild(ask);
            i++;
        }
        img.src == "http://img-fotki.yandex.ru/get/5700/svetonebo.6e/0_e9607_dbee1194_L";
        qwest()
    }

    function qwest(){

        i=0;
        document.getElementById("qwestion").textContent=qMatrix[count][0];
        while (i<5){

            document.getElementById("radio"+i).value = qMatrix[count][6+i];
            document.getElementById("answer"+i).textContent=qMatrix[count][1+i];
            i++;
        }
    }

    function nextQwest(){

        obj=this;
        result+=parseInt(this.value);
        this.checked=false;
        count++;
        if (count==5){
            qwestEnd();
            return;
        }
        qwest();
    }


    function qwestEnd(){

        i=1;
        if (result<7) {
            i=2;
        }
        if (result>20) {
            i=0;
        }
        alert("Game Over!"+ "\n" + "Result is " + result + "\n" +rMatrix[i]);
        i=0;
        document.body.removeChild(document.getElementById("qwestion"));
        while (i<5){
            document.body.removeChild(document.getElementById("radio" +i));
            document.body.removeChild(document.getElementById("answer"+i));
            i++;
        }
        startResume();
    }

    function imgChange(){

        if (img.src=="http://old.mmr.ua/files/news_tape/images/331/3/andrej-kalko-nikolaj-kovale_33103_s2.jpg"){
            img.src="http://p1.pichost.me/i/34/1568381.jpg";
            alert ("You break my heart!");

            setTimeout(qwestStart, 1000)
        //    qwestStart();
        }

        if ( img.src=="https://www.proza.ru/photos/culec.jpg"){
            img.src="http://old.mmr.ua/files/news_tape/images/331/3/andrej-kalko-nikolaj-kovale_33103_s2.jpg";
            alert ("One more chage.")
        }
        if (img.src == "http://img-fotki.yandex.ru/get/5700/svetonebo.6e/0_e9607_dbee1194_L"){
            img.src="https://www.proza.ru/photos/culec.jpg";
            alert ("Let's change it.")
        }
    }

    function placeDiv() {
        obj=this;
        y=Math.random()*500;
        x=Math.random()*1000;
        obj.style.position = "absolute";
        obj.style.left = x;
        obj.style.top = y;
        if (count==2) {
            document.body.removeChild(document.getElementById("but0"));
            document.body.removeChild(document.getElementById("but1"));
            document.body.removeChild(document.getElementById("but2"));
            document.body.removeChild(document.getElementById("but3"));
            startResume();
        }
        try {
        if (count==1) {
            document.getElementById("but3").textContent="Last time. PLS";
            count++;
        }
        if (count==0) {
            document.getElementById("but3").textContent="Are you shure?";
            count++;
        }
        } catch (Exeption) {
        }

    }



    function startResume() {
        img.src = "http://img-fotki.yandex.ru/get/5700/svetonebo.6e/0_e9607_dbee1194_L";
        if (count<5){
        alert("It can be fun!"+"\n"+"Realy." +"\n"+"But as you want.");}
        i=0;
        count=0;
        var cvTitle = document.createElement("text");
        cvTitle.type="text";
        cvTitle.style.position="absolute";
        cvTitle.style.top=40;
        cvTitle.style.left=480;
        cvTitle.style.fontSize=25;
        cvTitle.style.font="Verdana"
        cvTitle.textContent="KALKO ANDRIJ"
        document.body.appendChild(cvTitle);

        var cvChapter = document.createElement("text");
        cvChapter.id="cvChapter";
        cvChapter.type="text";
        cvChapter.style.position="absolute";
        cvChapter.style.top=44;
        cvChapter.style.left=740;
        cvChapter.style.fontSize=20;
        cvChapter.style.font="Verdana"
        cvChapter.textContent=matrix[count][9];
        document.body.appendChild(cvChapter);

        while (i<9){
            var tf=document.createElement("input");
            tf.type="textfield";
            tf.id="tf"+i;
            tf.style.position = 'absolute';
            tf.style.top = 90+(Math.floor(i/3)*80)+'px';
            tf.style.width=250;
            tf.style.fontSize=14;
            var leftY = 480+ (i%3)*260;
            tf.style.left=leftY+'px';
            tf.style.height=25;
            document.body.appendChild(tf);
            i++;
        }

        var buton = document.createElement("button");
        buton.id = "previous";
        buton.style.position = 'absolute';
        buton.style.top = 300;
        buton.style.left = 700;
        buton.style.width=90;
        buton.textContent = "previous";
        document.body.appendChild(buton);



        var buton2 = document.createElement("button");
        buton2.id = "next";
        buton2.style.position = 'absolute';
        buton2.style.top = 300;
        buton2.style.left = 800;
        buton2.style.width=90;
        buton2.textContent = "next";
        document.body.appendChild(buton2);


//        var adres = document.createElement("text");
//        adres.type="text";
//        adres.id="link";
//
//        adres.textContent="Link!!!!!";
//       // adres.onclick= redirect;
//        document.body.appendChild(adres);




        var adres = document.createElement('a');
        var linkText = document.createTextNode("Here");
        adres.appendChild(linkText);
        adres.href = "http://www.ex.ua/289411060828";
        adres.style.position = 'absolute';
        adres.style.top = 350;
        adres.style.left = 465;
        document.body.appendChild(adres);

        var addText=document.createElement("text");
        addText.id="addText";
        addText.style.position = 'absolute';
        addText.style.top = 351;
        addText.style.left = 505;
        addText.textContent="You can find my app HeadsUp Poker Trainer. It is still in creation process, but main functions already works."
        document.body.appendChild(addText);

        fillText();
    }

//    function redirect(){
//        location ='https://www.google.com.ua/';
//    }

    function nextpage(){
        count++;
        if (count==5) {
            count=0;
        }
        fillText();
    }


    function prevpage(){
        count--;
        if (count==-1) {
            count=4;
        }
        fillText();
    }


    function fillText() {

        i=0;
        document.getElementById("cvChapter").textContent=matrix[count][9];
        while (i<9){
        document.getElementById("tf"+i).value=matrix[count][i];
        i++;
        }
        document.getElementById("next").onclick=nextpage;
        document.getElementById("previous").onclick=prevpage;

    }



</script>

</body>
</html>
