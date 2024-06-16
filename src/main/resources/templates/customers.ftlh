<!DOCTYPE html>
<html>
<head>
    <title>Customers</title>
</head>
<body>
    <h1>Customers</h1>
    <form action="/customers" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br>
        <button type="submit">Add Customer</button>
    </form>

    <h2>Customer List</h2>
    <ul>
    <#list customers as customer>
        <li>${customer.name} - ${customer.email} - ${customer.phoneNumber}</li>
    </#list>
    </ul>
    <a href="/">Back to Home</a>
</body>
</html>
