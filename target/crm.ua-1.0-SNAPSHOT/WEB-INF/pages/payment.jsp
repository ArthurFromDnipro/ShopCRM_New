<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3><a href="/payment">Оплаты</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul id="groupList" class="nav navbar-nav">
                    <li>
                        <button type="button" id="update" class="btn btn-default navbar-btn">Обновить
                        </button>
                    </li>
                    <li>
                        <button type="button" id="back" class="btn btn-default navbar-btn">Назад
                        </button>
                    </li>
                </ul>

            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <c:choose>
        <c:when test="${orders eq null}">
            <table class="table table-striped">
                <thead>
                <tr>
                    <td><b>Код</b></td>
                    <td><b>Дата</b></td>
                    <td><b>Сумма</b></td>
                    <td><b>Описание</b></td>
                    <td><b>Комментарий</b></td>
                    <td><b>Заказ</b></td>
                </tr>
                </thead>
                <c:forEach items="${payments}" var="payment">
                    <tr>
                        <td>${payment.getAppcode()}</td>
                        <td><fmt:formatDate value="${payment.getTrandate()}" pattern="dd.MM.yyyy"/></td>
                        <td>${payment.getAmount()}</td>
                        <td>${payment.getTerminal()}</td>
                        <td>${payment.getDescription()}</td>
                        <td><c:choose>
                            <c:when test="${payment.getOrder() ne null}">
                                ${payment.getOrder().getId()}
                            </c:when>
                            <c:otherwise>
                                <a href="/payment/${payment.getAppcode()}">Выбрать заказ</a>
                            </c:otherwise>
                        </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            ${payment_c.getAppcode()} - <fmt:formatDate value="${payment_c.getTrandate()}" pattern="dd.MM.yyyy"/> -
            <b>${payment_c.getAmount()}</b>
            ${payment_c.getTerminal()}
            ${payment_c.getDescription()}
            <table class="table table-striped">
                <thead>
                <tr>
                    <td><b>№</b></td>
                    <td><b>Дата</b></td>
                    <td><b>Клиент</b></td>
                    <td><b>Телефон</b></td>
                    <td><b>Город</b></td>
                    <td><b>Тип доставки</b></td>
                    <td><b>Тип оплаты</b></td>
                    <td><b>Статус доставки</b></td>
                    <td><b>Статус оплаты</b></td>
                    <td><b>Статус заказа</b></td>
                    <td><b>Канал</b></td>
                    <td><b>Сумма</b></td>
                    <td><b>Выбрать заказ</b></td>
                </tr>
                </thead>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>
                            <a href="/payment/${payment_c.getAppcode()}/order/${order.getId()}">${order.getId()}</a>
                        </td>
                        <td>
                            <a href="/payment/${payment_c.getAppcode()}/order/${order.getId()}">${order.getOrderDate()}</a>
                        </td>
                        <td>
                            <a href="/payment/${payment_c.getAppcode()}/order/${order.getId()}">${order.getClient().getFirstLastName()}</a>
                        </td>
                        <td>
                            <a href="/payment/${payment_c.getAppcode()}/order/${order.getId()}">${order.getClient().getTel()}</a>
                        </td>
                        <td>${order.getClient().getNpCities().getDescription()}</td>
                        <td>${order.getDeliveryType().getDeliveryType()}</td>
                        <td>${order.getPaymentType().getPaymentType()}</td>
                        <td>${order.getDeliveryStatus().getDeliveryStatus()}</td>
                        <td>${order.getPaymentStatus().getPaymentStatus()}</td>
                        <td>${order.getOrderStatus().getOrderStatus()}</td>
                        <td>${order.getChannelType().getChannelType()}</td>
                        <td>${order.getOrderSum()}</td>
                        <td><a href="/payment/${payment_c.getAppcode()}/order/${order.getId()}">Прикрепить</a></td>
                    </tr>
                </c:forEach>
            </table>


        </c:otherwise>

    </c:choose>


</div>

<script>


    $('#update').click(function () {
        window.location.href = '/payment';
    });

    $('#back').click(function () {
        window.location.href = '/';
    });
</script>

</body>
</html>
