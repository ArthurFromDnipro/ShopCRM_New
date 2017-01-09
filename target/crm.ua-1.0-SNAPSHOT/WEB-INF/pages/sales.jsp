<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sales</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h3><a href="/sales">Продажи</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">

                    <li>
                        <button type="button" id="back" class="btn btn-default navbar-btn">Назад
                        </button>
                    </li>

                </ul>
                <form class="navbar-form navbar-left" role="search" action="/sales" method="get">
                    <div class="form-group">
                        <input type="date" value="${dateStart}" class="form-control" name="dateFrom"
                               placeholder="${dateStart}">
                        <input type="date" value="${dateEnd}" class="form-control" name="dateTo"
                               placeholder="${dateEnd}">
                    </div>
                    <button type="submit" class="btn btn-default">Фильтр</button>
                </form>

            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <table class="table table-striped">
        <thead>
        <tr>
            <td><b>Дата заказа</b></td>
            <td><b>Дата отправки</b></td>
            <td><b>Наименование</b></td>
            <td><b>Артикул</b></td>
            <td><b>Вес</b></td>
            <td><b>Кол-во</b></td>
            <td><b>Доставка</b></td>
            <td><b>Сумма</b></td>
            <td><b>Статус оплаты</b></td>
            <td><b>Клиент</b></td>
            <td><b>НП номер</b></td>
            <td><b>Номер заказа</b></td>
            <td><b>Комментарий</b></td>
            <td><b>Город</b></td>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="order">
            <c:forEach items="${order.getOrderDetails()}" var="orderDetail">
                <tr>
                    <td><fmt:formatDate value="${order.getOrderDate()}" pattern="dd.MM.yyyy"/></td>
                    <td><fmt:formatDate value="${order.getDateSent()}" pattern="dd.MM.yyyy"/></td>
                    <td>${orderDetail.getProduct().getProductDescriptionsUA().getName()}</td>
                    <td>${orderDetail.getProduct().getModel()}</td>
                    <td>${orderDetail.getProduct().getWeight()*orderDetail.getCount()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${orderDetail.getCount()>1}">
                                <b>${orderDetail.getCount()}</b>
                            </c:when>
                            <c:otherwise>
                                ${orderDetail.getCount()}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${order.getDeliveryCost()*(orderDetail.getCount()*orderDetail.getPrice()-orderDetail.getDiscount())/order.getOrderSum()}</td>
                    <td>${orderDetail.getCount()*orderDetail.getPrice()-orderDetail.getDiscount()}</td>
                    <td>${order.getPaymentStatus().getPaymentStatus()}</td>
                    <td>
                        <c:choose>
                            <c:when test="${order.getOrderDetails().size()>1}">
                                <b>${order.getClient().getFirstLastName()}</b>
                            </c:when>
                            <c:otherwise>
                                ${order.getClient().getFirstLastName()}
                            </c:otherwise>
                        </c:choose>

                    </td>
                    <td>${order.getNpDocNumber()}</td>
                    <td>${order.getId()}</td>
                    <td>${order.getComments()}</td>
                    <td>${order.getClient().getNpCities().getDescription()}</td>
                </tr>
            </c:forEach>
        </c:forEach>
    </table>
</div>

<script>


    $('#back').click(function () {
        window.location.href = '/';
    });


</script>
</body>
</html>