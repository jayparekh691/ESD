


let student_form = document.getElementById('searchorghr-validation');
//let course_form = document.getElementById('course-validation');
//window.onload = fetch_courses;
console.log(student_form);

student_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (student_form.checkValidity() === true) {
        let response = await fetch('http://localhost:8080/project3-1.0-SNAPSHOT/api/organization_hr/get/'+document.getElementById('o_id').value, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({

             //   email: document.getElementById('email').value,
            })
        });
        let result = await response.json();
        console.log(result);
        let table_data = document.getElementById('Organization_HR');
        table_data.innerHTML = '';
        alert("hi");
        for (let i = 0; i < result.length; i++) {
            //<th scope="row">'+(i+1)+'</th>\n

            let tr_data = document.createElement('tr');
            tr_data.innerHTML = //'<th scope="row"></th>\n' +
                '               <td>' + result[i]['hr_id'] + '</td>\n' +
                '               <td>' + result[i]['first_name'] + '</td>\n' +
                '               <td>' + result[i]['last_name'] + '</td>\n' +
                '               <td>' + result[i]['email'] + '</td>\n' +
                '               <td>' + result[i]['contact_number'] + '</td>\n'+
                '               <td>' + result[i]['o_id'] + '</td>\n';
            table_data.appendChild(tr_data);
        }
    } else {
        student_form.classList.add('was-validated');
    }
});