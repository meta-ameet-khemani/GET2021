var employeeName;
var employeeGender;
var employeeEmail;
var employeeID;
var employeePassword;
var employeeConfirmPassword;
var employeeContact;
var vehicleModel;
var vehicleNumber;
var vehicleType;
var amount;
var dailyRent;
var monthlyRent;
var yearlyRent;

function registerName () {
    employeeName = document.getElementById("name").value;
    document.getElementById("errormessage").innerHTML = "";
    if(validateName(employeeName)) {
        document.getElementById("employeeName").style.display = "none";
        document.getElementById("employeeGender").style.display = "block";
        document.getElementById("labelforgender").innerHTML = "Hello " + employeeName + ", Please Select Your Gender";
    } else {
        errorBorder("name");
        document.getElementById("name").innerHTML = employeeName;
        document.getElementById("errormessage").innerHTML = "Invalid Name";
    }
}

function registerGender (gender) {
    employeeGender = gender;
    document.getElementById("employeeGender").style.display = "none";
    document.getElementById("employeeEmail").style.display = "block";
}

function registerEmail () {
    employeeEmail = document.getElementById("inputemail").value;
    document.getElementById("errormessage").innerHTML = "";
    if(validateEmail(employeeEmail)) {
        document.getElementById("employeeEmail").style.display = "none";
        document.getElementById("employeeID").style.display = "block";
    }else{
        errorBorder("inputemail");
        document.getElementById("inputemail").innerHTML = employeeEmail;
        document.getElementById("errormessage").innerHTML = "Invalid Email";
    }
}
function registerEmployeeId () {
    employeeID = document.getElementById("inputemployeeid").value;
    document.getElementById("employeeID").style.display = "none";
    document.getElementById("employeePassword").style.display = "block";
}

function registerPassword (event) {
    employeePassword = document.getElementById("inputpassword").value;
    document.getElementById("errormessage").innerHTML = "";
    if(isSecurePassword(employeePassword)) {
        document.getElementById("inputpassword").style.border = "none";
        document.getElementById("inputpassword").style.borderBottom = "2px solid #000000";
        document.getElementById("errormessage").innerHTML = "Password Looks Fine You Can Go Ahead";
        document.getElementById("errormessage").style.color = "#000000";
        if (event.keyCode == 13) {
            document.getElementById("errormessage").innerHTML = "";
            document.getElementById("employeePassword").style.display = "none";
            document.getElementById("employeeConfirmPassword").style.display = "block";
        }
    } else {
        errorBorder("inputpassword");
        document.getElementById("inputpassword").innerHTML = employeePassword;
        document.getElementById("errormessage").innerHTML = "Invalid Password <br>"+
        "Password length must be >= 8 <br> Password must be alpha numeric<br>"+
        "It must have at least one apecial character";
        document.getElementById("errormessage").style.color = "#ff6600";
    }
}

function registerConfirmPassword (event) {
    employeeConfirmPassword = document.getElementById("inputconfirmpassword").value;
    if (event.key !== 'Enter') {
        employeeConfirmPassword += event.key;
    }
    document.getElementById("errormessage").innerHTML = "";
    if(validateConfirmPassword(employeePassword, employeeConfirmPassword)) {
        document.getElementById("inputconfirmpassword").style.border = "none";
        document.getElementById("inputconfirmpassword").style.borderBottom = "2px solid #000000";
        document.getElementById("errormessage").innerHTML = "Hey " + employeeName + " You can go ahead";
        if (event.keyCode == 13) {
            document.getElementById("errormessage").innerHTML = "";
            document.getElementById("employeeConfirmPassword").style.display = "none";
            document.getElementById("employeeContact").style.display = "block"; 
        }
    } else {
            errorBorder("inputconfirmpassword");
            document.getElementById("inputconfirmpassword").innerHTML = employeeConfirmPassword;
            document.getElementById("errormessage").innerHTML = "Password Mismatch";
    }
}

function registercontact (event) {
    employeeContact = document.getElementById("inputcontact").value;
    if (validateContact (employeeContact)) {
        document.getElementById("errormessage").innerHTML = "";
        if (event.keyCode == 13) {
            document.getElementById("register").style.display = "none";
            document.getElementById("vehicle").style.display = "block"; 
        }
    } else {
        errorBorder("inputcontact");
        document.getElementById("inputcontact").innerHTML = employeeContact;
        document.getElementById("errormessage").innerHTML = "Invalid Contact";
    }
    
}

function registerVehicleModel () {
    vehicleModel = document.getElementById("inputVehicleModel").value;
    document.getElementById("vehicleModel").style.display="none";
    document.getElementById("vehicleNumber").style.display="block";
}

function registerVehicleNumber () {
    vehicleNumber = document.getElementById("inputVehicleNumber").value;
    document.getElementById("vehicleNumber").style.display="none";
    document.getElementById("vehicleType").style.display="block";
}

function registertype (type) {    
    vehicleType = type;
    
    if("byCycle" === vehicleType){
        dailyRent = 0.070;
        monthlyRent = 1.40;
        yearlyRent = 6.99;
    }
    
    if("motorCycle" === vehicleType){
        dailyRent = 0.14;
        monthlyRent = 2.79;
        yearlyRent = 13.97;
    }
    
    if("fourWheeler" === vehicleType){
        dailyRent = 0.28;
        monthlyRent = 6.99;
        yearlyRent = 48.91;
    }

    document.getElementById("vehicleType").style.display = "none";
    document.getElementById("selectPlan").style.display = "block";
    document.getElementById('labelforplan').innerHTML = "Your Plans are for " + vehicleType;
    document.getElementById("radioforplan").innerHTML = '<input type="radio" name="inputplan" id="inputplan" value="' + dailyRent + '" onclick="registerplan('+dailyRent+');">' + dailyRent + ' $ Daily' +
     '<input type="radio" id="inputplan" name="inputplan" value="' + monthlyRent + '" onclick="registerplan('+monthlyRent+');">' + monthlyRent + ' $ Monthly '+
     '<input type="radio" id="inputplan" name="inputplan" value="' + yearlyRent + '" onclick="registerplan('+yearlyRent+');">' + yearlyRent + ' $ Yearly';
}

function registerplan (planamount) {
    amount = planamount;
    document.getElementById("sucessregister").innerHTML = "Congratualtions !!!  " + employeeName + 
    "<br> You have registerd your vehicle " + vehicleModel +
    " " + vehicleNumber + " sucessfully.<br>"+
    " You Have To Pay " + amount + ' $';

    document.getElementById("selectPlan").style.display = "none";
    document.getElementById("sucessregister").style.display = "block";
}

function errorBorder (inputId) {
    document.getElementById(inputId).style.border = "none";
    document.getElementById(inputId).style.borderBottom = "2px solid #ff6600";
}

function validateName (name) {
    var validName =  /^[a-zA-Z ]{2,30}$/;
    return validName.test(name);
}

function validateEmail (email) {
    var validMAilExpression = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email.length < 6 && email.length > 250) {
        return false;
    }
    return validMAilExpression.test(String(email).toLowerCase());
}

function isSecurePassword (password) {
    var validPassword =  new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
    return validPassword.test(password);
}

function validateConfirmPassword (password, confirmPassword) {
    if(password.localeCompare(confirmPassword) >= 1) {
        return false;
    } else {
        return true;
    }
}

function validateContact (number) {
    var validContact =  /^[0-9]{8,12}$/;
    return validContact.test(number);
}
