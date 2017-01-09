<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send info sms</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3><a href="/sms_send">Отправка СМС</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <form class="navbar-form navbar-left" role="search" action="/sms_send" method="get">
                        <div class="form-group">
                            <input type="date" value="${date_orders}" class="form-control" name="date_orders"
                                   id="date_orders"
                                   placeholder="Дата">
                        </div>
                        <button type="submit" class="btn btn-default">Загрузить</button>
                    </form>
                    <input type="datetime-local" value="${date_send}" class="form-control" name="date_send"
                           id="date_send"
                           placeholder="Время отправки">
                    <li>
                        <button type="button" id="send_start" class="btn btn-default navbar-btn">Отправить SMS
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
            <td></td>
            <td><b>№</b></td>
            <td><b>Имя Фамилия</b></td>
            <td><b>Город</b></td>
            <td><b>Склад НП</b></td>
            <td><b>Телефон</b></td>
            <td><b>Тип Оплата</b></td>
            <td><b>Статус оплаты</b></td>
            <td><b>Тип доставки</b></td>
            <td><b>Статус доставки</b></td>
            <td><b>Сумма</b></td>
            <td><b>Id Клиента НП</b></td>
            <td><b>Накладная НП</b></td>
            <td><b>Комментарий</b></td>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td><input type="checkbox" name="toSend[]" value="${order.getId()}" checked
                           id="checkbox_${order.getId()}"/></td>
                <td>${order.getId()}</td>
                <td>${order.getClient().getFirstName()} ${order.getClient().getLastName()}</td>
                <td>${order.getClient().getNpCities().getDescription()}</td>
                <td>${order.getClient().getNpWarehouses().getDescription()}</td>
                <td>${order.getClient().getTel()}</td>
                <td>${order.getPaymentType().getPaymentType()}</td>
                <td>${order.getPaymentStatus().getPaymentStatus()}</td>
                <td>${order.getDeliveryType().getDeliveryType()}</td>
                <td>${order.getDeliveryStatus().getDeliveryStatus()}</td>
                <td>${order.getOrderSum()}</td>
                <td>
                    <c:if test="${not empty order.getClient().getNpCounterparty()}">${order.getClient().getNpCounterparty().getRef()}</c:if>
                </td>
                <td>${order.getNpDocNumberFormat()}</td>
                <td>${order.getComments()}</td>

            </tr>
        </c:forEach>
    </table>


</div>

<script>

    $('#send_start').click(function () {
        var data = {'toSend[]': [], 'date_send': $("#date_send").val(), 'date_orders': $("#date_orders").val()};
        $(":checked").each(function () {
            data['toSend[]'].push($(this).val());
        });
        $.post("/sms_send/start", data, function (data, status) {
            window.location.reload();
        });
    });

    $('#back').click(function () {
        window.location.href = '/';
    });
</script>

</body>
</html>
