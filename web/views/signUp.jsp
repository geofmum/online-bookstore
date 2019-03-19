<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<script src="<c:url value="/resources/js/sign-up.js"/>"> </script>--%>
<jsp:include page='header.jsp'></jsp:include>

<div class="container signup">


    <div class="signupcont">
        <div class="alert alert-info" role="alert">
            Signup
        </div>

        <form  method="post" id="myForm">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="name">Name</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Name" required />
                </div>
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" required />
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="phone">Phone Number</label>
                    <input type="tel" name="phone" class="form-control" id="phone" placeholder="Phone Number" />
                </div>
                <div class="form-group col-md-6">
                    <label for="pass">Password</label>
                    <input type="password" name="pass" class="form-control" id="pass" placeholder="Password" required />
                </div>
            </div>
            <div class="form-group">
                <label for="street">Address</label>
                <input type="text" name="street" class="form-control" id="street" placeholder="1234 Main St">
            </div>
            <div class="form-group">
                <label for="apt">Address 2</label>
                <input type="text" name="apt" class="form-control" id="apt" placeholder="Apartment, studio, or floor">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="city">City</label>
                    <input type="text" name="city" class="form-control" id="city">
                </div>
                <div class="form-group col-md-4">
                    <label for="state">State</label>
                    <input name="state" class="form-control" id="state" placeholder="Enter a state">
                </div>
                <div class="form-group col-md-2">
                    <label for="zip">Zip</label>
                    <input type="text" name="zip" class="form-control" id="zip">
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input name="check" class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Check me out
                    </label>
                </div>
            </div>
            <button type="button" id="signup" class="btn btn-primary">Sign up</button>
        </form>
    </div>

</div>
<jsp:include page='footer.jsp'></jsp:include>