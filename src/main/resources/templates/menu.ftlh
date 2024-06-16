<!DOCTYPE html>
<html>
<head>
    <title>Menu Management</title>
</head>
<body>
    <h1>Menu List</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Category</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <#list menuItems as menuItem>
            <tr>
                <td>${menuItem.name}</td>
                <td>${menuItem.description}</td>
                <td>${menuItem.price}</td>
                <td>${menuItem.category}</td>
                <td>
                    <a href="/menu/delete/${menuItem.menuItemId}">Delete</a>
                    <a href="/menu/${menuItem.menuItemId}">Update</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <h2>Add Menu Item</h2>
    <form action="/menu" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required><br>
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" required><br>
        <label for="category">Category:</label>
        <input type="text" id="category" name="category" required><br>
        <button type="submit">Add Menu Item</button>
    </form>
    <a href="/">Back to Home</a>
</body>
</html>
