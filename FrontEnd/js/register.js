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

var rpassword=document.getElementById("rpassword");
var noti_rpassword=document.getElementById("tbXNMK");
function checkrPassword(){
    if (rpassword.value ==""){
        noti_rpassword.innerHTML="* bạn chưa xác nhận mật khẩu";
        return false;
    }
    if (password.value!=rpassword.value){
        noti_rpassword.innerHTML="* mật khẩu xác nhận chưa đúng"
        return false;
    }
    noti_rpassword.innerHTML="*";
    return true;
}
rpassword.addEventListener("blur",checkrPassword);

var email=document.getElementById("email");
var noti_email=document.getElementById("tbEmail");
function  checkEmail(){
            var re=/^[a-zA-Z0-9]+@gmail\.com$/;
            if (email.value ==""){
                noti_email.innerHTML="*bắt buộc nhập";
                return false;
            }
            if (!re.test(email.value) ){
                noti_email.innerHTML="email không đúng";
                return false;
            }
            noti_email.innerHTML="*";
            return true;
}
email.addEventListener("blur",checkEmail);

var phone=document.getElementById("phone");
var noti_phone=document.getElementById("tbPhone");
function  checkPhone(){
            var re=/^\d{10}$/;
            if (phone.value ==""){
                noti_phone.innerHTML="*bắt buộc nhập";
                return false;
            }
            if (!re.test(phone.value) ){
                noti_phone.innerHTML="*sdt phải có 10 chữ số";
                return false;
            }
            noti_phone.innerHTML="*";
            return true;
}
phone.addEventListener("blur",checkPhone);

function validateForm() {
    var isUsernameValid = checkUsername();
    var isPasswordValid = checkPassword();
    var isRPasswordValid = checkrPassword();
    var isEmailValid = checkEmail();
    var isPhoneValid = checkPhone();

    // Kiểm tra nếu tất cả các trường đều hợp lệ
    if (isUsernameValid && isPasswordValid && isRPasswordValid && isEmailValid && isPhoneValid) {
        localStorage.setItem('hideDiv',true);
        var divHide=document.getElementById("logreg");
        if (divHide){
            divHide.style.display="none";
        }
        setTimeout(function() {
            window.location.href = "Login.html";
        }, 500);
        return true;
    } else {
        // Hiển thị thông báo lỗi hoặc thực hiện hành động khác
        alert("Vui lòng kiểm tra lại thông tin nhập.");
        return false;
    }
}

document.getElementById("registerBtn").addEventListener("click", validateForm);