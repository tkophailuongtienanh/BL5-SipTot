/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function upDate(previewPic) {
    var a = "url(" + previewPic.src + ")";
    document.getElementById('image').style.backgroundImage = "url(" + previewPic + ")";
    document.getElementById('image').innerHTML = "check";
    document.write("check");
    alert("check 2");
}


