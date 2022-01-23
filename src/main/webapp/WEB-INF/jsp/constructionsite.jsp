<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Construct your graph here</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <script src="fancy_dropdown.js"></script>
</head>

<body>
<p>Создайте график</p>
<c:forEach items="${FigureOptions}" var="opt" >
    <img src="../../${opt.path}"/>
</c:forEach>
<p>Первая четверть</p>

<select>
    <option>Треугольник</option>
    <option>Квадрат</option>
    <option>Круг</option>
</select>
<p>Вторая четверть</p>
<select>
    <option>Треугольник</option>
    <option>Квадрат</option>
    <option>Круг</option>
</select>
<p>Третья четверть</p>
<select>
    <option>Треугольник</option>
    <option>Квадрат</option>
    <option>Круг</option>
</select>
<p>Четвёртая четверть</p>
<select>
    <option>Треугольник</option>
    <option>Квадрат</option>
    <option>Круг</option>
</select>


</body>
</html>
