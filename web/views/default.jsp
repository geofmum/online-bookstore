<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<main  class="container">

    <div class="banner">


        <div id="myCarouselBanner" class="carousel slide" data-ride="carousel">

            <div class="carousel-inner">
                <div class="carousel-item active">

                    <p><q>I do believe something very magical can happen when you read a book.</q> &#8208; <strong>J.K. Rowling</strong></p>

                </div>
                <div class="carousel-item">
                    <p><q>Books are mirrors: you only see in them what you already have inside you.</q> &#8208; <strong>Carlos Ruiz Zafon</strong></p>
                </div>
                <div class="carousel-item">
                    <p><q>A room without books is like a body without a soul.</q> &#8208; <strong>Cicero </strong></p>
                </div>
            </div>
            <a class="carousel-control-prev" href="#myCarouselBanner" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#myCarouselBanner" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    </div>


    <div class="bookdetails">
        <h4 class="text-info underline">Best Seller <a href="category?c=1" class="float-right font-italic showall">Show all >></a></h4>
        <div class="row">
            <c:forEach items="${books}" var="book">
            <div class="col-md-3">
                <div class="book">
						<div class="book-img">
							<c:if test="${book.discount != 0}"><span>Save ${book.discount}%</span></c:if>
							
							<a href="book-details?id=${book.id}"><img src="${book.thumb_url}" class="center"  height="200" alt=""></a>
						</div>
						<div class="book-body">
							<h5 class="book-title"><a href="book-details?id=${book.id}">${book.title}</a> </h5>
							<p class="book-text">${book.computeDescription()}<br>
								<span class="text-danger">$${book.computeDiscountedPrice()}</span>
								<c:if test="${book.price ne book.computeDiscountedPrice()}"><strike>$${book.price}</strike></c:if> </p>
							<a href="book-details?id=${book.id}" class="btn btn-warning btn-sm"><i class="fas fa-shopping-cart"></i> Add to cart</a>
						</div>
					</div>
            </div>
            </c:forEach>
        </div>
    </div>

    <div class="bookdetails">
        <h4 class="text-info underline">Romance Books <a href="category?c=4" class="float-right font-italic showall">Show all >></a></h4>
        <div class="row">
            <c:forEach items="${romanceBooks}" var="book">
                <div class="col-md-3">
                    <div class="book">
						<div class="book-img">
							<c:if test="${book.discount != 0}"><span>Save ${book.discount}%</span></c:if>
							
							<a href="book-details?id=${book.id}"><img src="${book.thumb_url}" class="center"  height="200" alt=""></a>
						</div>
						<div class="book-body">
							<h5 class="book-title"><a href="book-details?id=${book.id}">${book.title}</a> </h5>
							<p class="book-text">${book.computeDescription()}<br>
								<span class="text-danger">$${book.computeDiscountedPrice()}</span>
								<c:if test="${book.price ne book.computeDiscountedPrice()}"><strike>$${book.price}</strike></c:if> </p>
							<a href="book-details?id=${book.id}" class="btn btn-warning btn-sm"><i class="fas fa-shopping-cart"></i> Add to cart</a>
						</div>
					</div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="bookdetails">
        <h4 class="text-info underline">Fantasy Books <a href="category?c=3" class="float-right font-italic showall">Show all >></a></h4>
        <div class="row">
            <c:forEach items="${FantasyBooks}" var="book">
                <div class="col-md-3">
                    <div class="book">
						<div class="book-img">
							<c:if test="${book.discount != 0}"><span>Save ${book.discount}%</span></c:if>
							
							<a href="book-details?id=${book.id}"><img src="${book.thumb_url}" class="center"  height="200" alt=""></a>
						</div>
						<div class="book-body">
							<h5 class="book-title"><a href="book-details?id=${book.id}">${book.title}</a> </h5>
							<p class="book-text">${book.computeDescription()}<br>
								<span class="text-danger">$${book.computeDiscountedPrice()}</span>
								<c:if test="${book.price ne book.computeDiscountedPrice()}"><strike>$${book.price}</strike></c:if> </p>
							<a href="book-details?id=${book.id}" class="btn btn-warning btn-sm"><i class="fas fa-shopping-cart"></i> Add to cart</a>
						</div>
					</div>
                </div>
            </c:forEach>

        </div>
    </div>
    <div class="bookdetails">
        <h4 class="text-info underline">Drama Books <a href="category?c=2" class="float-right font-italic showall">Show all >></a></h4>
        <div class="row">
            <c:forEach items="${DramaBooks}" var="book">
                <div class="col-md-3">
                    <div class="book">
						<div class="book-img">
							<c:if test="${book.discount != 0}"><span>Save ${book.discount}%</span></c:if>
							
							<a href="book-details?id=${book.id}"><img src="${book.thumb_url}" class="center"  height="200" alt=""></a>
						</div>
						<div class="book-body">
							<h5 class="book-title"><a href="book-details?id=${book.id}">${book.title}</a> </h5>
							<p class="book-text">${book.computeDescription()}<br>
								<span class="text-danger">$${book.computeDiscountedPrice()}</span>
								<c:if test="${book.price ne book.computeDiscountedPrice()}"><strike>$${book.price}</strike></c:if> </p>
							<a href="book-details?id=${book.id}" class="btn btn-warning btn-sm"><i class="fas fa-shopping-cart"></i> Add to cart</a>
						</div>
					</div>
                </div>
            </c:forEach>

        </div>
    </div>

</main>
<section class="testimonial">
    <div class="container">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="rounded-circle" src="resources/images/testi1.jpg" alt="First slide">
                    <p><q>Now two or three times a year (especially after Christmas) my family shops on<br>
                        the Bookshelf &#8208; it's a tradition!</q> </p>
                    <p class="font-italic">&#8208; Sarah Jefferson</p>
                </div>
                <div class="carousel-item">
                    <img class="rounded-circle" src="resources/images/testi2.jpg" alt="Second slide">
                    <p><q> three times a year (especially after Christmas) my family shops on<br>
                        the Bookshelf Now two or!</q></p>
                    <p class="font-italic">&#8208; Mike Haferson</p>
                </div>
                <div class="carousel-item">
                    <img class="rounded-circle" src="resources/images/testi3.jpg" alt="Third slide">
                    <p><q>Now two or three times a year (especially after Christmas) my family shops on<br>
                        the Bookshelf  tradition!</q></p>
                    <p class="font-italic">&#8208; Nathan Burns</p>
                </div>
            </div>
            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</section>