let student_form = document.getElementById('addorg-validation');
//let course_form = document.getElementById('course-validation');
//window.onload = fetch_courses;
console.log(student_form);

student_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {

        let response = await fetch('http://localhost:8080/project3-1.0-SNAPSHOT/api/organization/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({

                name: document.getElementById('name').value,
                address: document.getElementById('address').value,
            })
        });
        let result = await response;
        console.log(response);
        if (response['status'] === 203) {
            document.getElementById("login-success").style.display = "none";
            document.getElementById("login-alert").style.display = "block";

        } else {
            document.getElementById("login-alert").style.display = "none";
            document.getElementById("login-success").style.display = "block";

        }
    } else {
        student_form.classList.add('was-validated');
    }
});
