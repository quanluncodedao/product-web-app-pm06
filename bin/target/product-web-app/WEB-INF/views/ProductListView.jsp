<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
    <!--su dung JSTL-->
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>

        <!DOCTYPE html>
        <html>

        <head>
            <title>
                Product List
            </title>
        </head>

        <body>

            <h1>Product List Page</h1>
            <!--header-->
            <jsp:include page="header.jsp"></jsp:include>
            <!--menu-->
            <jsp:include page="menu.jsp"></jsp:include>

            <table border="1" cellpadding="5" cellspacing="1">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Price</th>
                </tr>

                <!--for-->
                <!--JSTL và EL-->
                <c:if test="${not empty list}">
                    <c:forEach var="p" items="${list}">
                        <tr>
                            <td>${p.code}</td>
                            <td>${p.name}</td>
                            <td>${p.price}</td>
                        </tr>
                    </c:forEach>

                </c:if>

                <!-- <tr>
                <td>P002</td>
                <td>C# Core</td>
                <td>100</td>
            </tr> -->
            </table>
            <a href="createProduct">Create a new product</a>

            <!--footer-->

            <jsp:include page="footer.jsp"></jsp:include>

        </body>

        </html>