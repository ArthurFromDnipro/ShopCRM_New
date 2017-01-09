<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop CRM</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h3><a href="/">Заказы</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li>
                        <button type="button" id="create_orders" class="btn btn-default navbar-btn">Создать заказ
                        </button>
                    </li>
                    <li>
                        <button type="button" id="import_orders" class="btn btn-default navbar-btn">Импортировать
                        </button>
                    </li>
                    <li>
                        <button type="button" id="payment_check" class="btn btn-default navbar-btn">Оплаты</button>
                    </li>
                    <li>
                        <button type="button" id="send_orders" class="btn btn-default navbar-btn">Отправка<c:if test="${toSendCount>0}">(${toSendCount})</c:if></button>
                    </li>
                    <li>
                        <button type="button" id="sms_send" class="btn btn-default navbar-btn">Отправка СМС
                        </button>
                    </li>
                    <li>
                        <button type="button" id="review_request" class="btn btn-default navbar-btn">Запрос отзывов<c:if test="${reviewCount>0}">(${reviewCount})</c:if>
                        </button>
                    </li>
                    <li>
                        <button type="button" id="old_deliveries" class="btn btn-default navbar-btn">Незабранные посылки<c:if test="${oldDevCount>0}">(${oldDevCount})</c:if>
                        </button>
                    </li>
                    <li>
                        <button type="button" id="update_status" class="btn btn-default navbar-btn">Обновить статусы
                        </button>
                    </li>
                    <li>
                        <button type="button" id="sales" class="btn btn-default navbar-btn">Продажи
                        </button>
                    </li>

                </ul>
                <form class="navbar-form navbar-left" role="search" action="/" method="get">
                    <div class="form-group">
                        <input type="text" value="${name}" class="form-control" name="name"
                               placeholder="фильтр по клиенту">
                        <input type="text" value="${tel}" class="form-control" name="tel"
                               placeholder="фильтр по телефону">
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
            <td><b>№</b></td>
            <td><b>Дата</b></td>
            <td><b>Клиент</b></td>
            <td><b>Телефон</b></td>
            <td><b>Тип доставки</b></td>
            <td><b>Тип оплаты</b></td>
            <td><b>Статус доставки</b></td>
            <td><b>Статус оплаты</b></td>
            <td><b>Статус заказа</b></td>
            <td><b>Канал</b></td>
            <td><b>Сумма</b></td>
            <td><b>Редактировать</b></td>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>
                    <a href="/quickview/${order.getId()}?name=${name}&tel=${tel}&dateFrom=${dateStart}&dateTo=${dateEnd}#quickview">${order.getId()}</a>
                </td>
                <td>
                    <a href="/quickview/${order.getId()}?name=${name}&tel=${tel}&dateFrom=${dateStart}&dateTo=${dateEnd}#quickview"><fmt:formatDate value="${order.getOrderDate()}" pattern="dd.MM.yyyy"/></a>
                </td>
                <td>
                    <a href="/quickview/${order.getId()}?name=${name}&tel=${tel}&dateFrom=${dateStart}&dateTo=${dateEnd}#quickview">${order.getClient().getFirstLastName()}</a>
                </td>
                <td>
                    <a href="/quickview/${order.getId()}?name=${name}&tel=${tel}&dateFrom=${dateStart}&dateTo=${dateEnd}#quickview">${order.getClient().getTel()}</a>
                </td>
                <td>${order.getDeliveryType().getDeliveryType()}</td>
                <td>${order.getPaymentType().getPaymentType()}</td>
                <td>${order.getDeliveryStatus().getDeliveryStatus()}</td>
                <td>${order.getPaymentStatus().getPaymentStatus()}</td>
                <td>${order.getOrderStatus().getOrderStatus()}</td>
                <td>${order.getChannelType().getChannelType()}</td>
                <td>${order.getOrderSum()}</td>
                <td><a href="/order/${order.getId()}">Редактировать</a></td>


            </tr>
        </c:forEach>
    </table>

    <a id="quickview"></a>
    <c:if test="${quickview ne null}">
    <div class="panel panel-primary">
        <div class="panel-heading">Заказ ${quickview.getId()}</div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="25%"><b>Наименование</b></th>
                    <th width="12.5%"><b>Артикул</b></th>
                    <th width="12.5%"><b>Цена</b></th>
                    <th width="12.5%"><b>Кол-во</b></th>
                    <th width="12.5%"><b>Сумма</b></th>
                    <th width="12.5%"><b>Скидка</b></th>
                    <th width="12.5%"><b>Сумма со скидкой</b></th>
                </tr>
                </thead>
                <c:forEach items="${quickview.getOrderDetails()}" var="details">
                    <tr>
                        <td width="25%">${details.getProduct().getProductDescriptionsUA().getName()}</td>
                        <td width="12.5%">${details.getProduct().getModel()}</td>
                        <td width="12.5%">${details.getPrice()}</td>
                        <td width="12.5%">${details.getCount()}</td>
                        <td width="12.5%">${details.getPrice()*details.getCount()}</td>
                        <td width="12.5%">${details.getDiscount()}</td>
                        <td width="12.5%">${details.getPrice()*details.getCount()-details.getDiscount()}</td>
                    </tr>
                </c:forEach>
            </table>
            </c:if>

        </div>

        <script>


            $('#create_orders').click(function () {
                window.location.href = '/create_orders';
            });

            $('#import_orders').click(function () {
                window.location.href = '/import';
            });

            $('#send_orders').click(function () {
                window.location.href = '/send_orders';
            });
            $('#payment_check').click(function () {
                window.location.href = '/payment';
            });
            $('#sms_send').click(function () {
                window.location.href = '/sms_send';
            });

            $('#review_request').click(function () {
                window.location.href = '/review_request';
            });
            $('#old_deliveries').click(function () {
                window.location.href = '/old_deliveries';
            });
            $('#update_status').click(function () {
                window.location.href = '/update_status';
            });
            $('#sales').click(function () {
                window.location.href = '/sales';
            });


        </script>
</body>
</html>