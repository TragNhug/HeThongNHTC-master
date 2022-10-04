/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function deleteEmployee(id)
{
    fetch(`/HeThongNHTC/admin/employee/${id}`, {
        method: "delete"
    }).then(function () {
        location.reload();
    })
}
function viewUpdate(id){
   
    fetch(`/HeThongNHTC/api/updateEmployee/${id}`, {
        method: "post"
    }).then(function (res) {
        return res.json()
    }).then(function (data) {
        document.getElementById("firstname").value=data.firstname;
        document.getElementById("lastname").value=data.lastname;
        document.getElementById("email").value=data.email;
        document.getElementById("phone").value=data.phone;
        document.getElementById("username").value=data.username;
       
        document.getElementById("image").value=data.image;
        
        
    })
}
