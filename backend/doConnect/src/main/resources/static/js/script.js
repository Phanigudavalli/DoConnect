const BASE_URL = 'http://localhost:8080/api/users';

document.getElementById('admin-login-btn').addEventListener('click', function() {
    showLoginForm('Admin');
    setActiveButton('admin');
});

document.getElementById('user-login-btn').addEventListener('click', function() {
    showLoginForm('User');
    setActiveButton('user');
});

document.getElementById('register-link').addEventListener('click', function() {
    showRegistrationForm();
});

document.getElementById('login-link').addEventListener('click', function() {
    showLoginForm();
});

function showLoginForm(userType) {
    const loginForm = document.getElementById('login-form');
    const registrationForm = document.getElementById('registration-form');
    loginForm.classList.remove('hidden');
    registrationForm.classList.add('hidden');

    const message = document.getElementById('message');
    message.textContent = `Logging in as ${userType}`;
}

function showRegistrationForm() {
    const loginForm = document.getElementById('login-form');
    const registrationForm = document.getElementById('registration-form');
    loginForm.classList.add('hidden');
    registrationForm.classList.remove('hidden');
}

function setActiveButton(type) {
    const adminButton = document.getElementById('admin-login-btn');
    const userButton = document.getElementById('user-login-btn');

    adminButton.classList.remove('selected');
    userButton.classList.remove('selected');

    if (type === 'admin') {
        adminButton.classList.add('selected');
    } else {
        userButton.classList.add('selected');
    }
}

document.getElementById('form').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    console.log(username);
    console.log(password);
    
    console.log("trying to fetch data");

    fetch(`${BASE_URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, password })
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error('Login failed: Invalid username or password');
        }
    })
    .then(message => {
		console.log("success");
		console.log(message);
       // document.getElementById('message').textContent = message;
    })
    .catch(error => {
		console.log(error);
        document.getElementById('message').textContent = error.message;
    });
    console.log("end");
    
});

document.getElementById('reg-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const fullName = document.getElementById('full-name').value;
    const lastName = document.getElementById('last-name').value;
    const email = document.getElementById('email').value;
    const regUsername = document.getElementById('reg-username').value;
    const regPassword = document.getElementById('reg-password').value;
	
	const user = {
        username: regUsername,
        password: regPassword,
        active: true, // Set to true by default
        roles: [] // If you want to assign roles, include them here
    };

    // API call for registration
    fetch(`${BASE_URL}/register`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
			body: JSON.stringify(user)
    })
    .then(response => {
        if (response.ok) {
            return response.text();
        } else {
            throw new Error('Registration failed');
        }
    })
    .then(message => {
        document.getElementById('reg-message').textContent = message; // Display success message
        // Optionally clear the form or redirect
    })
    .catch(error => {
        document.getElementById('reg-message').textContent = error.message; // Display error message
    });
});
