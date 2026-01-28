<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Profile</title>
</head>
<body>
<h1>Your Profile</h1>
<p>Name: ${sessionScope.user.name}</p>
<p>Email: ${sessionScope.user.email}</p>
<a href="studentDashboard.jsp">Back to Dashboard</a>
</body>
</html>
