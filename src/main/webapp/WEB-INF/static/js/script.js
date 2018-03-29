function checkPass(){
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('passwordinput');
    var pass2 = document.getElementById('confirm_password');

    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');

    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";

    //Compare the values in the password field
    //and the confirmation field
    if(pass1.value == pass2.value){
        //The passwords match.
        //Set the color to the good color and inform
        //the user that they have entered the correct password
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}

function checkEmail() {
    var email = document.getElementById('email');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!filter.test(email.value)) {
        email.focus;
        email.style.backgroundColor = "#ff6666";
        return false;
    }else{
        email.style.backgroundColor = "#66cc66";
        return true;
    }
}


function phonenumber() {
  var phone = document.getElementById('phone');
  var filter = /^\+?([0-9]{3})\)?[ ]?([0-9]{3})[ ]?([0-9]{4})$/;
  if(!filter.test(phone.value)) {
        phone.style.backgroundColor = "#ff6666";
        return false;
  }else {
        phone.style.backgroundColor = "#66cc66";
        return true;
  }
}

function checkData() {
    var birthday = document.getElementById('birthday');
    var filter = /([12]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01]))$/;
    if (!filter.test(birthday.value)) {
        birthday.focus;
        birthday.style.backgroundColor = "#ff6666";
        return false;
    }else{
         birthday.style.backgroundColor = "#66cc66";
         return true;
    }
}




