<!DOCTYPE html>
<html>
<head>
    <title>Update Supply</title>
</head>
<body>
    <h1>Update Supply</h1>
    <form action="/inventory/supplies/update" method="post">
        <input type="hidden" name="supplyId" value="${supply.supplyId}">
        <label for="inventoryId">Inventory ID:</label>
        <input type="text" id="inventoryId" name="inventoryId" value="${supply.inventoryId}" required><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="${supply.quantity}" required><br>
        <label for="dateSupplied">Date Supplied:</label>
        <input type="date" id="dateSupplied" name="dateSupplied" value="${supply.dateSupplied}" required><br>
        <label for="supplierName">Supplier Name:</label>
        <input type="text" id="supplierName" name="supplierName" value="${supply.supplierName}" required><br>
        <button type="submit">Update Supply</button>
    </form>
    <a href="/inventory/supplies">Back to Supplies List</a>
</body>
</html>
