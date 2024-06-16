<!DOCTYPE html>
<html>
<head>
    <title>Supplies Management</title>
</head>
<body>
    <h1>Supplies List</h1>
    <table>
        <thead>
            <tr>
                <th>Inventory ID</th>
                <th>Quantity</th>
                <th>Date Supplied</th>
                <th>Supplier Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <#list supplyList as supply>
            <tr>
                <td>${supply.inventoryId}</td>
                <td>${supply.quantity}</td>
                <td>${supply.dateSupplied}</td>
                <td>${supply.supplierName}</td>
                <td>
                    <a href="/inventory/supplies/delete/${supply.supplyId}">Delete</a>
                    <a href="/inventory/supplies/${supply.supplyId}">Update</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <h2>Add Supply</h2>
    <form action="/inventory/supplies" method="post">
        <label for="inventoryId">Inventory ID:</label>
        <input type="text" id="inventoryId" name="inventoryId" required><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br>
        <label for="dateSupplied">Date Supplied:</label>
        <input type="date" id="dateSupplied" name="dateSupplied" required><br>
        <label for="supplierName">Supplier Name:</label>
        <input type="text" id="supplierName" name="supplierName" required><br>
        <button type="submit">Add Supply</button>
    </form>
    <a href="/">Back to Home</a>
</body>
</html>
