<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    String excelName = (String) request.getAttribute("title") + "-信息导出";
    response.reset(); // 非常重要
    response.setContentType("application/vnd.ms-excel;charset=UTF-8");
    //根据用户浏览器获得下载信息
    String agent = (String) request.getHeader("USER-AGENT");
    excelName = new String(excelName.getBytes("GBK"), "ISO-8859-1");
    //导出的文件名
    response.setHeader("Content-Disposition", "attachment; filename=" + excelName + ".xls");
%>
<html>
<head>
    <title>数字科学计数法</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>

<table border="1">
    <tbody>
    <tr>
        <%-- 导出的时候会出现数字变成了科学记数法--%>
        <td style="mso-number-format:'\@';">1000000000</td>
    </tr>
    </tbody>
</table>
</body>
</html>
