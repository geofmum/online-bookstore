<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='header.jsp'></jsp:include>

<main  class="container">
<div class="bookdetails">
    <h4 class="text-info underline">${cat}</h4>
    <div class="row">
        <c:forEach items="${books}" var="book">
            <div class="col-md-3">
                <div class="book">
                    <div class="book-img">
                        <c:if  test="${book.discount != 0}"><span>Save ${book.discount}%</span></c:if>
                        <c:set var="discountedPrice" value="#{book.price-(book.price*book.discount/100)}"  />

                        <a href="book-details?id=${book.id}"><img src="${book.thumb_url}" class="center"  height="200" alt=""></a>
                    </div>
                    <div class="book-body">
                        <h5 class="book-title"><a href="book-details?id=${book.id}">${book.title}</a> </h5>
                        <p class="book-text">${book.description}<br>
                            <span class="text-danger">$${book.computeDiscountedPrice()}</span>
                            <c:if test="${book.price ne discountedPrice}"><strike>$${book.price}</strike></c:if> </p>
                        <a href="#" class="btn btn-warning btn-sm"><i class="fas fa-shopping-cart"></i> Add to cart</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</main>
<jsp:include page='footer.jsp'></jsp:include>