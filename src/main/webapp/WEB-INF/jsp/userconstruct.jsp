<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Табличная вёрстка</title>
    <meta charset="UTF-8" />

    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script defer src="../../resources/js/Canvas.js"></script>
    <script>

        var x0, y0, r0, x, y, cordX, cordY;
        var cordsX = [], cordsY = [];
        $( document ).ready(function() {
            document.getElementById("btn").onclick =
                function(){
                    console.log(x0);
                    console.log($('#Y'));
                    console.log(r0);
                    sendAjaxForm('results', 'math_form', 'Controller');
                    return false;
                };
        });

        function sendAjaxForm(results, math_form, url) {
            //validate_form('math_form')
            if(validate_form('math_form')){
                document.getElementById('X').style.background = 'rgb(255, 255, 255)';
                document.getElementById('Y').style.background = 'rgb(255, 255, 255)';
                document.getElementById('R').style.background = 'rgb(255, 255, 255)';
                console.log("Отправляем");
                console.log(x0);
                console.log($('#Y'));
                console.log(r0);
                $.post(
                    "/dots", //url страницы (action_ajax_form.php)
                    {
                        X: x0,
                        Y: $('#Y').val(),
                        R: r0
                    },
                    function(response) { //Данные отправлены успешно
                        var row = document.createElement("tr");
                        row.innerHTML = response;
                        document.getElementById("results").parentElement.insertBefore(row,document.getElementById("results"));
                    }
                );
            }
        }

        function validate_form (math_form )
        {
            valid = true;

            if (isNaN(x0)||(x0 != 0)&&(x0 != -1)&&(x0 != 1)&&(x0 != -1.5)&&(x0 != 1.5)&&(x0 != 2)&&(x0 != -2)&&(x0 != -0.5)&&(x0 != 0.5))
            {
                document.getElementById('X').style.background = 'rgb(255, 100, 100)';
                valid = false;
            }
            if ((isNaN($('#Y').val()))||($('#Y').val() > 3)||($('#Y').val() < -3))
            {
                document.getElementById('Y').style.background = 'rgb(255, 100, 100)';
                valid = false;
            }
            if (isNaN(r0)||(r0 != 1.5)&&(r0 != 1)&&(r0 != 2)&&(r0 != 2.5)&&(r0 != 3))
            {
                document.getElementById('R').style.background = 'rgb(255, 100, 100)';
                valid = false;
            }

            return valid;
        }
    </script>

    <link rel="shortcut icon" href="/img/logo.ico" type="image/x-icon">
    <style type="text/css">
        @font-face {
            font-family: "RobotoBold";
            font-style: normal;
            font-weight: normal;
        }
        @font-face {
            font-family: "Roboto";
            font-style: normal;
            font-weight: normal;
        }
        @font-face {
            font-family: "Cinzel";
            font-style: normal;
            font-weight: normal;
        }
        @font-face {
            font-family: "Flower";
            font-style: normal;
            font-weight: normal;
        }
        html, body, table, tbody{
            height: 100%;
            width: 100%;
            padding: 0;
            margin: 0;
        }
        form{
            margin:auto;
            height:100%;
        }
        td > input{
            display: block;
            margin:0 auto;
        }
        td{
            padding: 0;
        }
        td.result{
            vertical-align: top;
        }
        span.result:first-letter{
            color: #000000;
        }
        td[rowspan]{
            background-color: #295699;
        }
        li{
            margin-bottom: 10%;
            font-size: 30px;
        }
        *{
            font-family: "Roboto", serif;
            margin: 0;
        }
        select{
            width: 80%;
        }
        li > input{
            width: 80%;
        }
        #egg{
            color: #F2FEFF;
            font-family: Flower, serif;
            font-size: 45px;
            text-align: center;
        }
        #egg:hover{
            color: #F2F2F2;
            font-family: Flower, serif;
            font-size: 45px;
            text-align: center;
        }
        #hiden{
            color: #FFFFFF;
            font-family: Flower, serif;
            font-size: 158px;
            text-align: center;
        }
        #header{
            font-family: "RobotoBold", Arial, serif;
            color: #F2FEFF;
            font-size: 45px;
            letter-spacing: -0.61px;
        }
        #var{
            font-size: 15px;
            letter-spacing: +0.11px;
        }
        #leftfield{
            background-color: #295699;
        }
    </style>
</head>
<body>
<form name="math_form" action="" method="post">
    <table >
        <tr height = "10%" width="100%" style = "background-color: #CC4230">
            <td width="12%" rowspan="3"></td>
            <th width="76%" align="left" id="header" colspan="3">
            <td width="12%" rowspan="3"></td>
        </tr>
        <tr>
            <td width="20%">
                <ul>
                    <li id="X" height = "33%">
                        <span>X:</span>
                        <script>
                            function xCheck(x) {
                                x0 = x
                            }
                            function rCheck(r) {
                                r0 = r
                            }
                        </script>
                        <button type="button" class="xValue" onclick="xCheck(-2)" value="-2">-2</button>
                        <button class="xValue" type="button" onclick="xCheck(-1.5)" value="-1.5">-1.5</button>
                        <button class="xValue" type="button" onclick="xCheck(-1)" value="-1">-1</button>
                        <button class="xValue" type="button" onclick="xCheck(-0.5)" value="-0.5">-0.5</button>
                        <button class="xValue" type="button" onclick="xCheck(0)" value="0">0</button>
                        <button class="xValue" type="button" onclick="xCheck(0.5)" value="0.5">0.5</button>
                        <button class="xValue" type="button" onclick="xCheck(1)" value="1">1</button>
                        <button class="xValue" type="button" onclick="xCheck(1.5)" value="1.5">1.5</button>
                        <button class="xValue" type="button" onclick="xCheck(2)" value="2">2</button>

                    </li height = "33%">
                    <li>
                        <span>Y:</span>
                        <input height="89%" name="Y" id="Y" required placeholder="(-3 ... 3)">
                    </li>
                    <li id="R" height = "33%">
                        <span>R:</span>
                        <button class="rValue" type="button" onclick="rCheck(1)" value="1">1</button>
                        <button class="rValue" type="button" onclick="rCheck(1.5)" value="1.5">1.5</button>
                        <button class="rValue" type="button" onclick="rCheck(2)" value="2">2</button>
                        <button class="rValue" type="button" onclick="rCheck(2.5)" value="2.5">2.5</button>
                        <button class="rValue" type="button" onclick="rCheck(3)" value="3">3</button>
                    </li>
                </ul>
                <input type="submit" id="btn" value="Отправить">
            </td>
            <td width="30%">
                <canvas id="canvas" width="700" height="700"></canvas>
                <script>
                    function getPosition(e){
                        var x = y = 0;

                        if (!e) {
                            var e = window.event;
                        }

                        if (e.pageX || e.pageY){
                            x = e.pageX;
                            y = e.pageY;
                        } else if (e.clientX || e.clientY){
                            x = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
                            y = e.clientY + document.body.scrollTop + document.documentElement.scrollTop;
                        }

                        return {x: x, y: y}
                    }

                    function getCoords(elem) { // кроме IE8-
                        var box = elem.getBoundingClientRect();

                        return {
                            top: box.top + pageYOffset,
                            left: box.left + pageXOffset
                        };

                    }
                    function draw(item)
                    {

                    }
                    // Отслеживание события загрузки страницы
                    window.addEventListener('load', function() {
                        var cx = document.getElementById("canvas").getContext("2d");
                        // Создание объекта картинки
                        var img = new Image();
                        // Назначение путь до картинки
                        //submittedStructure.forEach(draw);
                        // Вывод картинки
                        //img.onload = function (ev) { cx.drawImage(img, 0, 0); };
                        $('body').mousemove(function(e){
                            if(r0 != undefined){
                                var cord = getPosition(e);
                                var pos = getCoords(document.getElementById("canvas"));
                                //cx.clearRect(0,0,268,267);
                                //cx.drawImage(img, 0, 0);
                                var R = r0;
                                cordX = 0;
                                cord.x -= pos.left
                                cord.y -= pos.top;
                                x = (((cord.x-380)/300*R*2).toFixed()/2);
                                y = (((cord.y - 300)/290)*(-1)*R);
                                /*if(x > 2){
                                    x = 2;
                                }
                                if(x < -2){
                                    x = -2;
                                }
                                if(y > 3){
                                    y = 3;
                                }
                                if(y < -3){
                                    y = -3;
                                }*/
                                cordX = 353 + parseFloat((290*x/R).toFixed());
                                cordY = 300 + parseFloat((-290*y/R).toFixed());
                                /*cx.beginPath();
                                cx.arc(cordX, cordY, 3, 0, 2*Math.PI, false);
                                cx.fillStyle = 'red';
                                cx.fill();
                                cx.lineWidth = 1;
                                cx.strokeStyle = 'red';
                                cx.stroke();*/
                                for(i = 0; i < cordsX.length; i++){
                                    cx.beginPath();
                                    cx.arc(cordsX[i], cordsY[i], 3, 0, 2*Math.PI, false);
                                    cx.fillStyle = 'red';
                                    cx.fill();
                                    cx.lineWidth = 1;
                                    cx.strokeStyle = 'red';
                                    cx.stroke();
                                }
                                //console.log(cordX + " " + x + " " + cord.x + " " + cord.y);
                            }
                        })
                        document.getElementById("canvas").addEventListener("click", function(e){
                            if(r0 != undefined){
                                x0 = x;
                                document.getElementById("Y").value = y;
                                cordsX.push(cordX);
                                cordsY.push(cordY);
                                console.log(x0 + " " + document.getElementById("Y").value + " " + r0);
                                sendAjaxForm('results', 'math_form', '/dots');
                                return false;
                            }else {
                                document.getElementById('R').style.background = 'rgb(255, 100, 100)';
                            }
                        })
                    });
                </script>
            </td>
            <td width="26%">
                <span id="egg">Easter egg</span>
            </td>
        </tr>
        <tr height = "30%">
            <td class = "result">
                <span class = "result">Результаты:</span>
            </td>
            <tr>
            <td>X</td>
            <td>Y</td>
            <td>R</td>
            <td>T</td>
            </tr>
            <tr colspan="2" id="results" style="vertical-align: top;"></tr>
        </tr>
    </table>

</form>
<c:if test="${submittedStructure !=null}">
    <p>Graph:</p>
    <%--<canvas id="canvas" width="1000" height="1000"></canvas>--%>
    <img id="Pallet" src="../../resources/static/background/pallet.png" hidden/>

    <c:forEach items="${submittedStructure}" var="rf" varStatus="loop">
        <c:if test="${rf.quarter==1}">
            <img id="0Q" src="${rf.path}" hidden/>
        </c:if>
        <c:if test="${rf.quarter==2}">
            <img id="1Q" src="${rf.path}" hidden/>
        </c:if>
        <c:if test="${rf.quarter==3}">
            <img id="2Q" src="${rf.path}" hidden/>
        </c:if>
        <c:if test="${rf.quarter==4}">
            <img id="3Q" src="${rf.path}" hidden/>
        </c:if>

    </c:forEach>

</c:if>
</body>
</html>
