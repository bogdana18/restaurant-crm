<!DOCTYPE html>
<html>
<head>
    <title>Update Inventory</title>
</head>
<body>
    <h1>Update Inventory</h1>
    <form action="/inventory/update" method="post">
        <input type="hidden" name="inventoryId" value="${inventory.inventoryId}">
        <label for="ingredient">Ingredient:</label>
        <input type="text" id="ingredient" name="ingredient" value="${inventory.ingredient}" required><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" value="${inventory.quantity}" required><br>
        <label for="unit">Unit:</label>
        <input type="text" id="unit" name="unit" value="${inventory.unit}" required><br>
        <button type="submit">Update Inventory</button>
    </form>
    <a href="/inventory">Back to Inventory List</a>
</body>
</html>
