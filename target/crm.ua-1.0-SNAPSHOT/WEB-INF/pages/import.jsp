<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Import from Opencart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3><a href="/import">Заказы</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <form class="navbar-form navbar-left" role="search" action="/import" method="get">
                    <div class="form-group">
                        <input type="date" value="${dateImport}" class="form-control" name="date_Import"
                               placeholder="Дата">
                    </div>
                    <button type="submit" class="btn btn-default">Обновить</button>
                </form>
                <ul id="groupList" class="nav navbar-nav">
                    <li>
                        <button type="button" id="load_orders" class="btn btn-default navbar-btn">Загрузить заказы
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
    <table class="table table-striped">
        <thead>
        <tr>
            <td><b>№</b></td>
            <td><b>Клиент</b></td>
            <td><b>Телефон</b></td>
            <td><b>Email</b></td>
            <td><b>Город</b></td>
            <td><b>Область</b></td>
            <td><b>Оплата</b></td>
            <td><b>Доставка</b></td>
            <td><b>Склад НП</b></td>
            <td><b>Сумма</b></td>
        </tr>
        </thead>
        <c:forEach items="${orders_opencart}" var="order_o">
            <tr>
                <td>${order_o.getOrderId()}</td>
                <td>${order_o.getFirstname()} ${order.getLastname()} </td>
                <td>${order_o.getTelephone()}</td>
                <td>${order_o.getEmail()}</td>
                <td>${order_o.getPaymentCity()}</td>
                <td>${order_o.getPaymentZone()}</td>
                <td>${order_o.getPaymentMethodShort()}</td>
                <td>${order_o.getShippingMethod()}</td>
                <td>${order_o.getOrderSimpleField().getShippingNewPochtaId()}</td>
                <td>${order_o.getTotal()*order_o.getCurrencyValue()}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <br>
    <br>


    <table class="table table-striped">
        <thead>
        <tr>
            <td><b>№</b></td>
            <td><b>Имя</b></td>
            <td><b>Фамилия</b></td>
            <td><b>Город</b></td>
            <td><b>Склад НП</b></td>
            <td><b>Телефон</b></td>
            <td><b>Адрес</b></td>
            <td><b>Оплата</b></td>
            <td><b>Доставка</b></td>
            <td><b>Комментарий</b></td>
        </tr>
        </thead>
        <c:forEach items="${orders_crm}" var="order_c">
            <tr>
                <td>${order_c.getOrder().getOrderId()}</td>
                <td>${order_c.getClient().getFirstName()}</td>
                <td>${order_c.getClient().getLastName()}</td>
                <td>${order_c.getClient().getNpCities().getDescription()}</td>
                <td>${order_c.getClient().getNpWarehouses().getDescription()}</td>
                <td>${order_c.getClient().getTel()}</td>
                <td>${order_c.getClient().getAddress()}</td>
                <td>${order_c.getPaymentType().getPaymentType()}</td>
                <td>${order_c.getDeliveryType().getDeliveryType()}</td>
                <td>${order_c.getComments()}</td>

            </tr>
        </c:forEach>
    </table>


</div>

<script>


    $('#load_orders').click(function () {
        window.location.href = '/import/start';
    });

    $('#back').click(function () {
        window.location.href = '/';
    });
</script>

</body>
</html>
