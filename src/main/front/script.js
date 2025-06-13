function getEmployees() {
    fetch('http://localhost:8080/api/v1/employee/get-all')
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('employeeList');
            list.innerHTML = '';

            data.forEach(employee => {
                const li = document.createElement('li');
                li.textContent = `${employee.fullName} — ${employee.email}`;
                list.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Ошибка:', error);
            alert('Не удалось загрузить данные с сервера');
        });
}

function saveEmployee() {
    const fullName = document.getElementById('fullName').value;
    const phoneNumber = document.getElementById('phoneNumber').value;
    const email = document.getElementById('email').value;
    const position = document.getElementById('position').value;

    const employee = {
        fullName: fullName,
        phoneNumber: phoneNumber,
        email: email,
        position: position
    };

    fetch('http://localhost:8080/api/v1/employee/save_employee', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
    })
        .then(response => {
            if (response.ok) {
                alert("Сотрудник сохранён!");
                getEmployees(); // Обновляем список
            } else {
                alert("Ошибка сохранения сотрудника");
            }
        })
        .catch(error => {
            console.error('Ошибка:', error);
            alert("Не удалось сохранить сотрудника");
        });
}