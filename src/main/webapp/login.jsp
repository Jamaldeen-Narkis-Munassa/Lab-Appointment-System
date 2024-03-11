<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style1.css">
    <title>Login</title>
</head>

<body>

    <div class="container" id="container">
        <div class="form-container sign-up">
            <form action="Register" method="post">
                <h1>Create Account</h1>
                <br>
                <input name="username" type="text" placeholder="Username" required>
                <input name="email" type="email" placeholder="Email" required>
                <input name="nic" type="text" placeholder="Nic" required>
                <input name="password" type="password" placeholder="Password" required>
                <button >Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="Login" method="post">
                <h1>Sign In</h1>
                <br>
                <input name="email" type="email" placeholder="Email" required>
                <input name="password" type="password" placeholder="Password" required>
                <button type="submit">Sign In</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back !</h1>
                    <p>Enter your personal details to use all</p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Welcome!</h1>
                    <p>Enter your personal details to use all </p>
                    <button class="hidden" id="register">Sign Up</button>
                </div>
            </div>
        </div>
    </div>

    <script src="css/script.js"></script>
</body>

</html>