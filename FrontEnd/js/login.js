var username=document.getElementById("username");
var noti_username=document.getElementById("tbTenDN");
function  checkUsername(){
            var re=/^[a-z0-9]+$/;
            if (username.value ==""){
                noti_username.innerHTML="*bắt buộc nhập";
                return false;
            }
            if (!re.test(username.value) ){
                noti_username.innerHTML="tên không chứa kí tự đặc biệt";
                return false;
            }
            noti_username.innerHTML="*";
            return true;
}
username.addEventListener("blur",checkUsername);

var password=document.getElementById("password");
var noti_password=document.getElementById("tbMK");
function checkPassword(){
    if (password.value ==""){
        noti_password.innerHTML="* bạn chưa nhập mật khẩu";
        return false;
    }
    noti_password.innerHTML="*";
    return true;
}
password.addEventListener("blur",checkPassword);

function validateLoginForm() {
    var isUsernameValid = checkUsername();
    var isPasswordValid = checkPassword();
    // Kiểm tra nếu tất cả các trường đều hợp lệ
    if (isUsernameValid && isPasswordValid) {
        setTimeout(function() {
            window.location.href = "Shop.html";
        }, 500);
        return true;
    } else {
        // Hiển thị thông báo lỗi hoặc thực hiện hành động khác
        alert("Vui lòng kiểm tra lại thông tin nhập.");
        return false;
    }
}
document.getElementById("btn-login").addEventListener("click",validateLoginForm);

