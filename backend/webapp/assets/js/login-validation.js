let login_form = document.getElementById('login-validation');
login_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();

    if(login_form.checkValidity() === true) {
        document.getElementById("submit-button").style.display = "none";
        document.getElementById("spinner-button").style.display = "block";
        let response = await fetch('http://localhost:8080/project3-1.0-SNAPSHOT/api/employee/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                email: document.getElementById('email').value,
                password: document.getElementById('password').value
            })
        });
        let result = await response;
        console.log(response);
        if(result['status'] === 200){
            let data = response.json();
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            sessionStorage.setItem('id', data["employee_id"]);
           // location.href = "addhr.html";
            location.href = "buttons.html";
        }else{
            document.getElementById("submit-button").style.display = "block";
            document.getElementById("spinner-button").style.display = "none";

            document.getElementById("login-alert").style.display = "block";
        }
    }
});