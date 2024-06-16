<!DOCTYPE html>
<html>
<head>
    <title>Orders</title>
</head>
<body>
    <h1>Orders</h1>
    <form action="/orders" method="post">
        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId" required><br>
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" required><br>
        <label for="totalPrice">Total Price:</label>
        <input type="number" step="0.01" id="totalPrice" name="totalPrice" required><br>
        <button type="submit">Add Order</button>
    </form>

    <h2>Order List</h2>
    <ul>
    <#list orders as order>
        <li>${order.customerId} - ${order.status} - ${order.totalPrice}</li>
    </#list>
    </ul>
    <a href="/">Back to Home</a>
</body>
</html>
