<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заказ ${order.getId()}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="../../../css/stylesheet.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="container">
    <h2>Заказ ${order.getId()} от ${order.getOrderDate()}</h2>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li>
                        <button type="button" id="client_add" class="btn btn-default navbar-btn">Создать
                            клиента
                        </button>
                    </li>
                    <li>
                        <button type="button" id="client_choose" class="btn btn-default navbar-btn">Выбрать
                            клиента
                        </button>
                    </li>
                    <li>
                        <button type="button" id="client_edit" class="btn btn-default navbar-btn">Редактировать
                            клиента
                        </button>
                    </li>
                    <li>
                        <button type="button" id="save_order" class="btn btn-default navbar-btn">Сохранить</button>
                    </li>
                    <li>
                        <button type="button" id="back" class="btn btn-default navbar-btn">Назад</button>
                    </li>
                </ul>


            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div class="panel panel-primary">
        <div class="panel-heading">Клиент:</div>
        <div class="panel-body">
            <c:choose>
                <c:when test="${client_choose}">

                    <form class="form-inline" role="search"
                          action="/order/${order.getId()}/client_filter" method="get">
                        <div class="form-group">
                            <input type="text" name="filter_name" class="form-control" value="${filter_name}"
                                   placeholder="ФИО">
                        </div>
                        <div class="form-group">
                            <input type="text" name="filter_tel" class="form-control" value="${filter_tel}"
                                   placeholder="Тел">
                        </div>
                        <button type="submit" class="btn btn-default">Поиск</button>
                        <button type="button" id="cancel_edit" class="btn btn-default">Отмена</button>
                    </form>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th width="70%"><b>Фамилия Имя</b></th>
                            <th width="30%"><b>Телефон</b></th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${clients}" var="client">
                            <tr>
                                <td width="70%">
                                    <a href="/order/${order.getId()}/client_change/${client.getClient_ID()}">${client.getLastName()} ${client.getFirstName()} </a>
                                </td>
                                <td width="30%">
                                    <a href="/order/${order.getId()}/client_change/${client.getClient_ID()}">${client.getTel()} </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>


                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${client_edit}">
                            <form class="navbar-form navbar-left" role="search"
                                  action="/order/${order.getId()}/client_save" method="post">
                                <div class="form-group">
                                    <input type="text" name="firstName" class="form-control"
                                           value="${order.getClient().getFirstName()}"
                                           placeholder="Имя">
                                    <input type="text" name="lastName" class="form-control"
                                           value="${order.getClient().getLastName()}"
                                           placeholder="Фамилия">
                                    <input type="text" name="tel" class="form-control"
                                           value="${order.getClient().getTel()}"
                                           placeholder="Телефон">
                                    <input type="text" name="email" class="form-control"
                                           value="${order.getClient().getEmail()}"
                                           placeholder="Email">
                                </div>
                                <button type="submit" class="btn btn-default">Сохранить</button>
                                <button type="button" id="cancel_edit" class="btn btn-default">Отмена</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <div class="well">
                                <li>Фамилия и имя: ${order.getClient().getFirstLastName()} </li>
                                <li>Телефон: ${order.getClient().getTel()}</li>
                                <li>E-mail: ${order.getClient().getEmail()}</li>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>

        </div>

    </div>
    <!--             Адрес доставки            -->
    <div class="panel panel-primary">
        <div class="panel-heading">Адрес доставки:</div>
        <div class="panel-body">
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Область: ${order.getClient().getNpCities().getNpArea().getDescription()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu scrollable-menu" role="menu">
                    <c:forEach items="${areas}" var="npArea">
                        <li>
                            <a href="/order/${order.getId()}/order_area/${npArea.getRef()}">${npArea.getDescription()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Город: ${order.getClient().getNpCities().getDescription()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu scrollable-menu" role="menu">
                    <c:forEach items="${cities}" var="npCities">
                        <li>
                            <a href="/order/${order.getId()}/order_cities/${npCities.getRef()}">${npCities.getDescription()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Склад: ${order.getClient().getNpWarehouses().getDescription()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu scrollable-menu" role="menu">
                    <c:forEach items="${warehouses}" var="npWarehouses">
                        <li>
                            <a href="/order/${order.getId()}/order_warehouse/${npWarehouses.getRef()}">${npWarehouses.getDescription()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>


        </div>
    </div>
    <!--             Параметры заказа            -->
    <div class="panel panel-primary">
        <div class="panel-heading">Параметры заказа:</div>
        <div class="panel-body">
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Тип доставки: ${order.getDeliveryType().getDeliveryType()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <c:forEach items="${deliveryType}" var="dT">
                        <li><a href="/order/${order.getId()}/delivery_type/${dT.getId()}">${dT.getDeliveryType()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Тип оплаты: ${order.getPaymentType().getPaymentType()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <c:forEach items="${paymentType}" var="pT">
                        <li><a href="/order/${order.getId()}/payment_type/${pT.getId()}">${pT.getPaymentType()}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Канал: ${order.getChannelType().getChannelType()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${channelType}" var="cT">
                        <li><a href="/order/${order.getId()}/channel_type/${cT.getId()}">${cT.getChannelType()}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>

    <!--             Статусы заказа            -->
    <div class="panel panel-primary">
        <div class="panel-heading">Статусы заказа:</div>
        <div class="panel-body">
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Статус доставки: ${order.getDeliveryStatus().getDeliveryStatus()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <c:forEach items="${deliveryStatus}" var="dS">
                        <li>
                            <a href="/order/${order.getId()}/delivery_status/${dS.getId()}">${dS.getDeliveryStatus()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Статус оплаты: ${order.getPaymentStatus().getPaymentStatus()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <c:forEach items="${paymentStatus}" var="pS">
                        <li><a href="/order/${order.getId()}/payment_status/${pS.getId()}">${pS.getPaymentStatus()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="btn-group">
                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"
                        aria-expanded="false">
                    Статус заказа: ${order.getOrderStatus().getOrderStatus()}<span class="caret"></span>
                </button>
                <ul class="dropdown-menu" role="menu">
                    <c:forEach items="${orderStatus}" var="oS">
                        <li><a href="/order/${order.getId()}/order_status/${oS.getId()}">${oS.getOrderStatus()}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <!--Выбрать оплату -->
    <c:if test="${payments ne null}">
        <table class="table table-striped">
            <thead>
            <tr>
                <th width="12%"><b>Код</b></th>
                <th width="12%"><b>Дата</b></th>
                <th width="12%"><b>Сумма</b></th>
                <th width="40%"><b>Описание</b></th>
                <th width="12%"><b>Комментарий</b></th>
                <th width="12%"><b>Заказ</b></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${payments}" var="payment">
                <tr>
                    <td width="12%">${payment.getAppcode()}</td>
                    <td width="12%"><fmt:formatDate value="${payment.getTrandate()}" pattern="dd.MM.yyyy"/></td>
                    <td width="12%">${payment.getAmount()}</td>
                    <td width="40%">${payment.getTerminal()}</td>
                    <td width="12%">${payment.getDescription()}</td>
                    <td width="12%"><c:choose>
                        <c:when test="${payment.getOrder() ne null}">
                            ${payment.getOrder().getId()}
                        </c:when>
                        <c:otherwise>
                            <a href="/order/${order.getId()}/payment/${payment.getAppcode()}">Выбрать оплату</a>
                        </c:otherwise>
                    </c:choose>
                    </td width="12%">
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <div class="panel panel-primary">
        <div class="panel-heading">Комментарий:</div>
        <div class="panel-body">
            <c:choose>
                <c:when test="${comment_edit}">
                    <form class="navbar-form navbar-left" role="search"
                          action="/order/${order.getId()}/save_comment" method="post">
                        <div class="form-group">
                            <input type="text" name="comment" class="form-control" value="${order.getComments()}"
                                   placeholder="Комментарий">
                        </div>
                        <button type="submit" class="btn btn-default">Сохранить</button>
                        <button type="button" id="cancel_edit" class="btn btn-default">Отмена</button>
                    </form>
                </c:when>
                <c:otherwise>
                    ${order.getComments()}
                    <div class="btn-group">
                        <button type="button" id="edit_comment" class="btn btn-default navbar-btn">Редактировать
                        </button>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>

    </div>
    <!-- Добавление продуктов-->
    <a id="product_add"></a>
    <c:choose>
        <c:when test="${add_product}">
            <form class="form-inline" role="search"
                  action="/order/${order.getId()}/product_filter#product_add" method="get">
                <div class="form-group">
                    <div class="btn-group">
                        <div class="dropdown dropdown-submit-input">
                            <input type="hidden" name="category_input"/>
                            <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"> Категория: <c:if
                                    test="${currentCategory ne null}">${currentCategory.getParent().getCategoryDescriptionUA().getName()}->${currentCategory.getCategoryDescriptionUA().getName()}</c:if>
                                <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu scrollable-menu" role="menu">
                                <c:forEach items="${categores}" var="category">
                                    <li>
                                        <a href="#"
                                           data-value="${category.getCategoryId()}">${category.getParent().getCategoryDescriptionUA().getName()}->${category.getCategoryDescriptionUA().getName()}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="form-group">

                    <input type="text" name="filter_name" class="form-control" value="${currentName}"
                           placeholder="Фильтр">
                </div>
                <button type="submit" class="btn btn-default">Поиск</button>
                <button type="button" id="cancel_edit" class="btn btn-default">Отмена</button>
            </form>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="40%"><b>Наименование</b></th>
                    <th width="20%"><b>Артикул</b></th>
                    <th width="20%"><b>Вес</b></th>
                    <th width="20%"><b>Цена</b></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td width="40%">
                            <a href="/order/${order.getId()}/add_product/${product.getProductId()}#product">${product.getProductDescriptionsUA().getName()}</a>
                        </td>
                        <td width="20%">
                            <a href="/order/${order.getId()}/add_product/${product.getProductId()}#product">${product.getModel()}</a>
                        </td>
                        <td width="20%">${product.getWeight()}</td>
                        <td width="20%">${product.getCurrentPriceUAH(currentCurrency)}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


        </c:when>
    </c:choose>

    <!-- END Добавление продуктов-->

    <div class="panel panel-primary">
        <div class="panel-heading">Товары:</div>
        <div class="panel-body">
            <div class="btn-group">
                <button type="button" id="add_product" class="btn btn-default navbar-btn">Добавить</button>
            </div>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th width="25%"><b>Наименование</b></th>
                    <th width="8.3%"><b>Артикул</b></th>
                    <th width="8.3%"><b>Цена</b></th>
                    <th width="8.3%"><b>Кол-во</b></th>
                    <th width="8.3%"><b>Сумма</b></th>
                    <th width="8.3%"><b>Скидка</b></th>
                    <th width="8.3%"><b>Сумма со скидкой</b></th>
                    <th width="12.5%"><b>Редактировать</b></th>
                    <th width="12.5%"><b>Удалить</b></th>
                </tr>
                </thead>
                <c:forEach items="${order.getOrderDetails()}" var="details">
                    <c:if test="true"> <!--${details.getCount() ne 0}-->
                        <tr>
                            <c:choose>
                                <c:when test="${details.id ne product_edit}">
                                    <td width="25%">
                                        <a href="/order/${order.getId()}/product_edit/${details.id}#product">${details.getProduct().getProductDescriptionsUA().getName()}</a>
                                    </td>
                                    <td width="8.3%">
                                        <a href="/order/${order.getId()}/product_edit/${details.id}#product">${details.getProduct().getModel()}</a>
                                    </td>
                                    <td width="8.3%">${details.getPrice()}</td>
                                    <td width="8.3%">${details.getCount()}</td>
                                    <td width="8.3%">${details.getPrice()*details.getCount()}</td>
                                    <td width="8.3%">${details.getDiscount()}</td>
                                    <td width="8.3%">${details.getPrice()*details.getCount()-details.getDiscount()}</td>
                                    <td width="12.5%">
                                        <a href="/order/${order.getId()}/product_edit/${details.id}#product">Редактировать</a>
                                    </td>
                                    <td width="12.5%"><a
                                            href="/order/${order.getId()}/product_del/${details.id}#product">Удалить</a>
                                    </td>
                                </c:when>
                                <c:otherwise>

                                    <td width="25%">${details.getProduct().getProductDescriptionsUA().getName()}</td>
                                    <td width="5%">${details.getProduct().getModel()}</td>
                                    <form class="navbar-form navbar-left" role="search"
                                          action="/order/${order.getId()}/product_save/${details.id}#product"
                                          method="post">
                                        <!--                                    <div class="form-group"> -->
                                        <td width="8.3%"><input type="text" name="price" class="form-control"
                                                                value="${details.getPrice()}"
                                                                placeholder="Цена"></td>
                                        <td width="8.3%"><input type="text" name="count" class="form-control"
                                                                value="${details.getCount()}"
                                                                placeholder="Количество"></td>
                                        <td width="8.3%"></td>
                                        <td width="8.3%"><input type="text" name="discount" class="form-control"
                                                                value="${details.getDiscount()}"
                                                                placeholder="Скидка"></td>
                                        <td width="8.3%"></td>
                                        <!--                                    </div> -->
                                        <td width="13%">
                                            <button type="submit" class="btn btn-default">Сохранить</button>
                                        </td>
                                    </form>
                                    <td width="12%"><a href="/order/${order.getId()}#product">Отмена</a></td>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <a id="product"></a>


        </div>

    </div>


</div>

<script>

    (function ($) {

        $('.dropdown-submit-input .dropdown-menu a').click(function (e) {
            e.preventDefault();
            $(this).closest('.dropdown-submit-input').find('input').val($(this).data('value'));
            $(this).closest('form').submit();
        });

    })(jQuery);

    $('#client_edit').click(function () {
        window.location.href = '/order/${order.getId()}/client_edit';
    });
    $('#client_add').click(function () {
        window.location.href = '/order/${order.getId()}/client_add';
    });
    $('#client_choose').click(function () {
        window.location.href = '/order/${order.getId()}/client_choose';
    });


    $('#cancel_edit').click(function () {
        window.location.href = '/order/${order.getId()}';
    });

    $('#save_order').click(function () {
        window.location.href = '/order/${order.getId()}/save_order';
    });

    $('#back').click(function () {
        window.location.href = '/';
    });

    $('#edit_comment').click(function () {
        window.location.href = '/order/${order.getId()}/edit_comment';
    });

    $('#add_product').click(function () {
        window.location.href = '/order/${order.getId()}/add_product#product_add';
    });


</script>
</body>
</html>