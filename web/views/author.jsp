<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page='header.jsp'></jsp:include>


<main  class="container">
		<div class="row no-gutters author">
			<div class="col-md-2 authorname">
				<h5 class="authortitle">Authors</h5>
				<ul> 
				    <c:forEach items="${authors}" var="au">
						<li><a href="javascript:void(0)" class="ajaxAuthorName"> ${au}</a></li>
					</c:forEach>
				
				</ul>
			</div>
      		<div class="col-md-10 authorbook">
				<h5 class="authortitle">Books of this Author </h5>
				<div class="row authorbooks">
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
  		</div>
</main>
<script>

</script>
<jsp:include page='footer.jsp'></jsp:include>