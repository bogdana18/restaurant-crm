<!DOCTYPE html>
<html>
<head>
    <title>Inventory Management</title>
</head>
<body>
    <h1>Inventory List</h1>
    <table>
        <thead>
            <tr>
                <th>Ingredient</th>
                <th>Quantity</th>
                <th>Unit</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <#list inventoryList as inventory>
            <tr>
                <td>${inventory.ingredient}</td>
                <td>${inventory.quantity}</td>
                <td>${inventory.unit}</td>
                <td>
                    <a href="/inventory/delete/${inventory.inventoryId}">Delete</a>
                    <a href="/inventory/${inventory.inventoryId}">Update</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <h2>Add Inventory</h2>
    <form action="/inventory" method="post">
        <label for="ingredient">Ingredient:</label>
        <input type="text" id="ingredient" name="ingredient" required><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br>
        <label for="unit">Unit:</label>
        <input type="text" id="unit" name="unit" required><br>
        <button type="submit">Add Inventory</button>
    </form>
    <a href="/">Back to Home</a>
</body>
</html>
