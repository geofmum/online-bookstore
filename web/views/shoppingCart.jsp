<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='header.jsp'></jsp:include>

<div class="container shopping-cart">
    <div class="row">
        <div class="col-md-9 row">
            <h1 class="col">Shopping cart</h1>
            <div class="col-2">
                <button id="checkout" class="btn-primary btn btn-block" type="button">Checkout</button>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-9">
            <div class="cart-details">
                <div class="row row-header">
                    <div class="book-thumb col-md-2"></div>
                    <div class="book-details col-md-6">Item</div>
                    <div class="quantity col-md-2">Quantity</div>
                    <div class="price col-md-2">Price</div>
                </div>
                <c:forEach items="${items}" var="item">
                    <div class="row item">
                        <div class="book-thumb col-md-2"><img src="${item.book.thumb_url}" alt=""></div>
                        <div class="book-details col-md-6">
                            <div class="book-title">
                                    ${item.book.title}
                            </div>
                            <div class="book-description">
                                <small>${item.book.description}</small>
                            </div>
                        </div>
                        <div class="quantity col-md-2">${item.quantity}</div>
                        <div class="price col-md-2">${item.book.price}</div>
                    </div>
                </c:forEach>
                <div class="row row-footer">
                    <div class="col-md-2"></div>
                    <div class="col-md-6">
                        <div class="book-title">
                            ${item.book.title}
                        </div>
                        <div class="book-description">
                            <small>${item.book.description}</small>
                        </div>
                    </div>
                    <div class="col-md-2">Total</div>
                    <div class="col-md-2"><span class="currency-symbol">$</span>${cartTotal}</div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page='footer.jsp'></jsp:include>
