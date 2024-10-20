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

    // Add your login logic here (e.g., API call)
    console.log('Username:', username);
    console.log('Password:', password);

    document.getElementById('message').textContent = 'Login successful!'; // Simulated success
});

document.getElementById('reg-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const fullName = document.getElementById('full-name').value;
    const lastName = document.getElementById('last-name').value;
    const email = document.getElementById('email').value;
    const regUsername = document.getElementById('reg-username').value;
    const regPassword = document.getElementById('reg-password').value;

    // Add your registration logic here (e.g., API call)
    console.log('Registering Full Name:', fullName);
    console.log('Registering Last Name:', lastName);
    console.log('Registering Email:', email);
    console.log('Registering Username:', regUsername);
    console.log('Registering Password:', regPassword);

    document.getElementById('reg-message').textContent = 'Registration successful!'; // Simulated success
});
