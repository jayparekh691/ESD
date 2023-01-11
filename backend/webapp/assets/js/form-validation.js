let student_form = document.getElementById('form-validation');
//let course_form = document.getElementById('course-validation');
//window.onload = fetch_courses;
console.log(student_form);

student_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {


        let response = await fetch('http://localhost:8080/project3-1.0-SNAPSHOT/api/organization_hr/add/' + Number(document.getElementById('oid').value), {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({

                first_name: document.getElementById('first_name').value,
                last_name: document.getElementById('last_name').value,
                email: document.getElementById('email').value,
                contact_number: document.getElementById('contact_number').value
            })
        });
        let result = await response;
        console.log(response);

        if (response['status'] === 400) {
            alert(response['status']);
            document.getElementById("login-alert").style.display = "block";
            document.getElementById("login-success").style.display = "none";
        } else if (response['status'] === 200) {
            document.getElementById("login-success").style.display = "block";
            document.getElementById("login-alert").style.display = "none";

        } else {
            student_form.classList.add('was-validated');
        }
    }
});

// course_form.onsubmit = async (e) => {
//     e.preventDefault();
//     e.stopPropagation();
//     if (course_form.checkValidity() === true) {
//         let form_data = new FormData();
//         form_data.append('name', document.getElementById('name').value);
//         form_data.append('description', document.getElementById('description').value);
//         form_data.append('credits', document.getElementById('credits').value);
//         // $.ajax({
//         //   type: "POST",
//         //   url: "api/courses/register",
//         //   enctype: 'multipart/form-data',
//         //   data: form_data,
//         //   processData: false,
//         //   contentType: false,
//         // }).done(function(response, status) {
//         //   console.log(response, status);
//         // });
//         let response = await fetch('api/courses/register', {
//             method: 'POST',
//             body: form_data
//         });
//         let result = await response;
//         if (result['status'] === 203) {
//             document.getElementById("course-success").style.display = "none";
//             document.getElementById("course-alert").style.display = "block";
//
//         } else {
//             document.getElementById("course-alert").style.display = "none";
//             document.getElementById("course-success").style.display = "block";
//
//         }
//         console.log(result);
//     } else {
//         course_form.classList.add('was-validated');
//     }
// };

// async function fetch_courses() {
//     if (!sessionStorage.getItem('id')) {
//         location.href = "index.html";
//         return;
//     }
//     let response = await fetch("api/courses/get");
//     let courses = await response.json(); // read response body and parse as JSON
//     console.log(courses);
//     let courses_option = document.getElementById('courses');
//     courses_option.innerHTML = '<option value=""> Choose...</option>';
//
//     for (let i = 0; i < courses.length; i++) {
//         courses_option.innerHTML += '<option value="' + courses[i]['course_id'] + '">' + courses[i]['name'] + '</option>';
//     }
// }