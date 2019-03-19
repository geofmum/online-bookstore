<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='header.jsp'></jsp:include>

<div class="container book-details">
    <div class="row">
        <div class="col-md-5 left-column">
            <img class="book-cover" src="${book.thumb_url}" alt="${book.title}">
        </div>
        <div class="col-md-7 right-column">
            <h2>${book.title}</h2>
            <h3>by <span class="book-author">Michelle Obama</span></h3>
            <hr/>
            <div id="package-type" class="book-package-type">Hardcover</div>
            <div class="price d-flex align-content-end">
                <div>
                    <span class="currency-symbol">$</span><span data-quoted-price="${book.price}" id="price-quoted"
                                                                class="price-quoted">${book.price}</span>
                </div>
                <div class="price-discount align-self-end">
                    <span class="scalar-discount"><span class="currency-symbol">$</span><span
                            id="discount-amount">${discount_amount}</span></span>
                    <span class="vector-discount">Save <span data-discount="${book.discount}" id="percent-value"
                                                             class="percent-value">${percent_discount}%</span></span>
                </div>
            </div>
            <ul id="price-list" class="price-list d-flex ">
                <li data-package="hardcover" class="price-option selected">
                    <div class="price-group-name">Hardcover</div>
                    <div class="price-value">${book.price}</div>
                </li>

                <li data-package="audiobook" class="price-option">
                    <div class="price-group-name">Audiobook</div>
                    <div class="price-value">${book.price}</div>
                </li>

                <li data-package="largeprint" class="price-option">
                    <div class="price-group-name">Large Print</div>
                    <div class="price-value">${book.price}</div>
                </li>
            </ul>

            <ul class="delivery-options">
                <li class="delivery-option">
                    <label>
                        <input type="radio" name="delivery" value="ship">
                        Ship this item to my Address
                    </label>
                </li>
                <li class="delivery-option">
                    <label>
                        <input type="radio" name="delivery" value="pickup" checked>
                        Buy Online, Pick up at nearby Store
                    </label>
                </li>
            </ul>

            <div class="call-to-action d-flex">
                <button data-book-id="${book.id}" class="btn btn-primary mr-md-3" id="add-to-cart">Add to Cart</button>
                <c:if test="${userid == null}">
                    <a href="/signup" class="btn btn-outline-secondary" type="button">Sign in to Purchase Instantly
                    </a>
                </c:if>
                <c:if test="${userid != null}">
                    <a href="/cart" class="btn btn-outline-secondary" type="button" id="buy-it-now">Buy it now
                    </a>
                </c:if>
            </div>

            <h3 class="book-summary">Book Summary</h3>
            <p class="description">${book.description}</p>
        </div>
    </div>
</div>
<jsp:include page='footer.jsp'></jsp:include>