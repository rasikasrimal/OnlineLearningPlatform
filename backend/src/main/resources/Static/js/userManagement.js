// Fetch All Users
function fetchAllUsers() {
    fetch('http://localhost:8080/api/v1/users')
        .then(response => response.json())
        .then(data => {
            displayUsers(data, 'allUsersTableBody');
        });
}

// Display Users in Table
function displayUsers(users, tableId) {
    let userTable = document.getElementById(tableId);
    userTable.innerHTML = '';
    users.forEach(user => {
        let row = `<tr>
      <td>${user.id}</td>
      <td>${user.username}</td>
      <td>${user.email}</td>
      <td>
        <button class="update" onclick="fetchUser(${user.id})">Update</button>
        <button class="delete" onclick="deleteUser(${user.id})">Delete</button>
      </td>
    </tr>`;
        userTable.innerHTML += row;
    });
}

// Fetch User by ID (for Update)
function fetchUser(id) {
    fetch(`http://localhost:8080/api/v1/users/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById("userId").value = data.id;
            document.getElementById("username").value = data.username;
            document.getElementById("email").value = data.email;
            document.getElementById("password").value = ''; // Clear password field on fetch
        });
}

// Create or Update User
function saveUser() {
    let id = document.getElementById("userId").value;
    let username = document.getElementById("username").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    let method = id ? 'PUT' : 'POST';
    let url = id ? `http://localhost:8080/api/v1/users/${id}` : 'http://localhost:8080/api/v1/users';

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, email, password })
    })
        .then(() => {
            fetchAllUsers();
            clearForm();
        });
}

// Delete User
function deleteUser(id) {
    fetch(`http://localhost:8080/api/v1/users/${id}`, {
        method: 'DELETE'
    })
        .then(() => fetchAllUsers());
}

// Search Users by ID
function searchUserById() {
    let id = document.getElementById("searchId").value;
    fetch(`http://localhost:8080/api/v1/users/${id}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('User not found');
            }
        })
        .then(data => {
            displayUsers([data], 'searchResultTableBody'); // Display the single user found
            document.getElementById("errorMessage").innerText = ''; // Clear any previous error message
        })
        .catch(error => {
            document.getElementById("searchResultTableBody").innerHTML = ''; // Clear search result table
            document.getElementById("errorMessage").innerText = error.message; // Display error message
        });
}

// Clear form after save or update
function clearForm() {
    document.getElementById("userId").value = '';
    document.getElementById("username").value = '';
    document.getElementById("email").value = '';
    document.getElementById("password").value = '';
}

// Initial Load
window.onload = function() {
    fetchAllUsers();
};
