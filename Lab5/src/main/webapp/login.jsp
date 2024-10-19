<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-lg-5">
            <%
                String flashMessage = (String) session.getAttribute("flashMessage");
                if (flashMessage != null) {
            %>
            <div class="alert alert-danger">
                <%= flashMessage %>
            </div>
            <%
                    session.removeAttribute("flashMessage"); // Remove after showing
                }
            %>
            <h3 class="text-center text-secondary mt-5 mb-3">User Login</h3>
            <form class="border rounded w-100 mb-5 mx-auto px-3 pt-3 bg-light" action="login" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" name="username" type="text" class="form-control" placeholder="Username"
                           value="<%=request.getAttribute("username")%>"
                    >
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" name="password" class="form-control" placeholder="Password"
                           value="<%=request.getAttribute("password")%>"
                    >
                </div>
                <div class="form-check mb-3">
                    <input class="form-check-input" type="checkbox" id="remember" name="remember">
                    <label class="form-check-label" for="remember">
                        Remember username & password
                    </label>
                </div>
                <div class="form-group">
                    <button class="btn btn-success px-5">Login</button>
                </div>
                <div class="text-center mt-3">
                    <p>Don't have an account yet?
                        <a href="/register">Register here</a>
                    </p>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
