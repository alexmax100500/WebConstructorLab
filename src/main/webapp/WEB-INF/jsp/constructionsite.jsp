<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <title>Construct your graph here</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <script defer src="../../resources/js/UpdateValsOnChange.js"></script>
    <script defer src="../../resources/js/Canvas.js"></script>
</head>

<body>
<h3><a href="/">Главная</a></h3>
<p>Создайте график</p>
<form th:action="@{/constructionsite}" method="post">
    <table>
        <th><p>Первая четверть</p></th>
        <th><p>Вторая четверть</p></th>
        <th><p>Третья четверть</p></th>
        <th><p>Четвёртая четверть</p></th>
        <tr>
            <c:forEach begin="1" end="4" varStatus="loop">

                <td>
                    <%--<select onchange="getval(this);">
                        <option value="triangle">Треугольник</option>
                        <option value="square">Квадрат</option>
                        <option value="circle">Круг</option>
                    </select>--%>
                    <c:forEach items="${FigureOptions}" var="opt">
                        <c:if test="${loop.current==opt.quarter}">
                            <input type="radio" value="${opt.path} ${opt.figure}" name="same${loop.index}"/>
                            <img src="${opt.path}" width="50" height="50"/>
                        </c:if>
                    </c:forEach>
                </td>
            </c:forEach>
        </tr>
    </table>
    <table>
        <th>
           X
        </th>
        <th>
            Y
        </th>
        <th>
            R
        </th>
        <tr>
            <td>
            <input type="radio" value="radio" name="Xinput">
            <p>radio</p>
            <input type="radio" value="button" name="Xinput">
            <p>button</p>
            <input type="radio" value="select" name="Xinput">
            <p>select</p>
            <input type="radio" value="text" name="Xinput">
            <p>text</p>
            <input type="radio" value="checkbox" name="Xinput">
            <p>checkbox</p>
            <input type="text"  name="Xresthiction">
            <p>restriction</p>
            </td>
<td>
            <input type="radio" value="radio" name="Yinputt">
            <p>radio</p>
            <input type="radio" value="button" name="Yinputt">
            <p>button</p>
            <input type="radio" value="select" name="Yinputt">
            <p>select</p>
            <input type="radio" value="text" name="Yinputt">
            <p>text</p>
            <input type="radio" value="checkbox" name="Yinputt">
            <p>checkbox</p>
            <input type="text"  name="Yrestriction">
            <p>restriction</p>
</td>
        <td>

            <input type="radio" value="radio" name="Rinputt">
            <p>radio</p>
            <input type="radio" value="button" name="Rinputt">
            <p>button</p>
            <input type="radio" value="select" name="Rinputt">
            <p>select</p>
            <input type="radio" value="text" name="Rinputt">
            <p>text</p>
            <input type="radio" value="checkbox" name="Rinputt">
            <p>checkbox</p>
            <input type="text"  name="Rrestriction">
            <p>restriction</p>
        </td>
        </tr>
    </table>
    <div><input type="submit"/></div>
</form>

<c:if test="${ReadyFigures !=null}">
    <p>Graph:</p>
    <canvas id="canvas" width="1000" height="1000"></canvas>
    <img id="Pallet" src="../../resources/static/background/pallet.png" hidden/>

    <c:forEach items="${ReadyFigures}" var="rf" varStatus="loop">
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
