/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


function themGioHang(id,idRes)
{
    fetch(`/HeThongNHTC/api/addCart/${idRes}/${id}`, {
        method: "get"
    }).then(function () {
        button = document.getElementById(id);

//        if (button.innerHTML != "Đã chọn")
//        {
//            button.innerHTML = "Đã chọn";
//            button.style.backgroundColor="red";
//        } else
//        {
//           button.innerHTML = "Chon";
//            button.style.backgroundColor="blue";
//        }

    })
}


function check(id,idRes){
    fetch(`/HeThongNHTC/api/getBill`, {
        method: "get"}).then(function (res) {
        return res.json();

    }).then(function (data) {
        
        if(data.idRes != idRes)
            alert("Khác Nhà Hàng")
        else {
            if(id.includes("L")){
               if(id.substring(1) != data.lobby.id)
                   {
                       alert("Đã chọn Lobby")

                   }
            }
            
             if(id.includes("M")){
               if(id.substring(1) != data.menu.id)
                   {
                       alert("Đã chọn Menu")

                   }
            }
        }
            
       
    })
}

