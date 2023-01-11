


    let student_form = document.getElementById('searchorg-validation');
    //let course_form = document.getElementById('course-validation');
    //window.onload = fetch_courses;
    console.log(student_form);

    student_form.addEventListener('submit', async (e) => {
        e.preventDefault();
        e.stopPropagation();
        if (student_form.checkValidity() === true) {
            let response = await fetch('http://localhost:8080/project3-1.0-SNAPSHOT/api/organization/get', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                },
                body: JSON.stringify({

                    name: document.getElementById('name').value,
                })
            });
            let result = await response.json();
            console.log(result);
            let table_data = document.getElementById('Organization');
            table_data.innerHTML = '';
            alert("hi");
            for (let i = 0; i < result.length; i++) {
                //<th scope="row">'+(i+1)+'</th>\n

                let tr_data = document.createElement('tr');
                tr_data.innerHTML = //'<th scope="row"></th>\n' +
                    '               <td>' + result[i]['o_id'] + '</td>\n' +
                    '               <td>' + result[i]['name'] + '</td>\n' +
                    '               <td>' + result[i]['address'] + '</td>\n';
                table_data.appendChild(tr_data);
            }
        } else {
            student_form.classList.add('was-validated');
        }
    });