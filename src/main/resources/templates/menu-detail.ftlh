<!DOCTYPE html>
<html>
<head>
    <title>Update Menu Item</title>
</head>
<body>
    <h1>Update Menu Item</h1>
    <form action="/menu/update" method="post">
        <input type="hidden" name="menuItemId" value="${menuItem.menuItemId}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${menuItem.name}" required><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="${menuItem.description}" required><br>
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" value="${menuItem.price}" required><br>
        <label for="category">Category:</label>
        <input type="text" id="category" name="category" value="${menuItem.category}" required><br>
        <button type="submit">Update Menu Item</button>
    </form>
    <a href="/menu">Back to Menu List</a>
</body>
</html>
