let delete_form = document.getElementById('deletehr-validation');
//window.onload = fetch_courses;
console.log(delete_form);
delete_form.addEventListener('submit', async (e) => {
    e.preventDefault();
    e.stopPropagation();
    if (delete_form.checkValidity() === true) {
        let response = await fetch('http://localhost:8080/project3-1.0-SNAPSHOT/api/organization_hr/delete/'+document.getElementById('hr_id').value, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
            })
        });
        let result = await response;
        console.log(result);
    }
    delete_form.classList.add('was-validated');
});