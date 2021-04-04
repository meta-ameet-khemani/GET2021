class Employee {

    id: string;
    name: string;
    gender: string;
    email: string;
    password: string;
    contact: number;

}

class Vehicle {

    model: string;
    number: string;
    type: string;

}

class VehiclePass {

    type: string;
    dailyCharge: number;
    monthlyChaarge: number;
    yearlyCharge: number;

}

class Pass {

    vehicle: Vehicle;
    selectedPeriod: string;
    amount: number;
    
}

let employee: Employee;
let vehicle: Vehicle;
let vehiclePass: VehiclePass;
let pass: Pass;

let validateContact = number => /^[0-9]{8,12}$/.test(number);

let validateConfirmPassword = (password, confirmPassword) => password.localeCompare(confirmPassword) == 0;

let isSecurePassword = (password) => new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})").test(password);

let validateName = (name) => /^[a-zA-Z ]{2,30}$/.test(name);

let validateEmail = (email) => {
    const validMAilExpression = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if(email.length < 6 && email.length > 250) {
        return false;
    }
    return validMAilExpression.test(String(email).toLowerCase());
}

function registerName () {
    employee.name = (<HTMLInputElement>document.getElementById("name")).value;
    document.getElementById("errormessage").innerHTML = "";
    if(validateName(employee.name)) {
        document.getElementById("employeeName").style.display = "none";
        document.getElementById("employeeGender").style.display = "block";
        document.getElementById("labelforgender").innerHTML = "Hello " + employee.name + ", Please Select Your Gender";
    } else {
        errorBorder("name");
        document.getElementById("name").innerHTML = employee.name;
        document.getElementById("errormessage").innerHTML = "Invalid Name";
    }
}

function registerGender (gender) {
    employee.gender = gender;
    document.getElementById("employeeGender").style.display = "none";
    document.getElementById("employeeEmail").style.display = "block";
}

function registerEmail () {
    employee.email = (<HTMLInputElement>document.getElementById("inputemail")).value;
    document.getElementById("errormessage").innerHTML = "";
    if(validateEmail(employee.email)) {
        document.getElementById("employeeEmail").style.display = "none";
        document.getElementById("employeeID").style.display = "block";
    }else{
        errorBorder("inputemail");
        document.getElementById("inputemail").innerHTML = employee.email;
        document.getElementById("errormessage").innerHTML = "Invalid Email";
    }
}
function registerEmployeeId () {
    employee.id = (<HTMLInputElement>document.getElementById("inputemployeeid")).value;
    document.getElementById("employeeID").style.display = "none";
    document.getElementById("employeePassword").style.display = "block";
}

function registerPassword (event) {
    employee.password = (<HTMLInputElement>document.getElementById("inputpassword")).value;
    document.getElementById("errormessage").innerHTML = "";
    if(isSecurePassword(employee.password)) {
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
        document.getElementById("inputpassword").innerHTML = employee.password;
        document.getElementById("errormessage").innerHTML = "Invalid Password <br>"+
        "Password length must be >= 8 <br> Password must be alpha numeric<br>"+
        "It must have at least one apecial character";
        document.getElementById("errormessage").style.color = "#ff6600";
    }
}

function registerConfirmPassword (event) {
    let employeeConfirmPassword = (<HTMLInputElement>document.getElementById("inputconfirmpassword")).value;
    if (event.key !== 'Enter') {
        employeeConfirmPassword += event.key;
    }
    document.getElementById("errormessage").innerHTML = "";
    if(validateConfirmPassword(employee.password, employeeConfirmPassword)) {
        document.getElementById("inputconfirmpassword").style.border = "none";
        document.getElementById("inputconfirmpassword").style.borderBottom = "2px solid #000000";
        document.getElementById("errormessage").innerHTML = "Hey " + employee.name + " You can go ahead";
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
    employee.contact = Number.parseInt((<HTMLInputElement>document.getElementById("inputcontact")).value);
    if (validateContact (employee.contact)) {
        document.getElementById("errormessage").innerHTML = "";
        if (event.keyCode == 13) {
            document.getElementById("register").style.display = "none";
            document.getElementById("vehicle").style.display = "block"; 
        }
    } else {
        errorBorder("inputcontact");
        document.getElementById("inputcontact").innerHTML = employee.contact.toString();
        document.getElementById("errormessage").innerHTML = "Invalid Contact";
    }
    
}

function registerVehicleModel () {
    vehicle.model = (<HTMLInputElement>document.getElementById("inputVehicleModel")).value;
    document.getElementById("vehicleModel").style.display="none";
    document.getElementById("vehicleNumber").style.display="block";
}

function registerVehicleNumber () {
    vehicle.number = (<HTMLInputElement>document.getElementById("inputVehicleNumber")).value;
    document.getElementById("vehicleNumber").style.display="none";
    document.getElementById("vehicleType").style.display="block";
}

function registertype (type) {    
    vehicle.type = type;
    
    if("byCycle" === vehicle.type){
        vehiclePass.dailyCharge = 0.070;
        vehiclePass.monthlyChaarge = 1.40;
        vehiclePass.yearlyCharge = 6.99;
    }
    
    if("motorCycle" === vehicle.type){
        vehiclePass.dailyCharge = 0.14;
        vehiclePass.monthlyChaarge = 2.79;
        vehiclePass.yearlyCharge = 13.97;
    }
    
    if("fourWheeler" === vehicle.type){
        vehiclePass.dailyCharge = 0.28;
        vehiclePass.monthlyChaarge = 6.99;
        vehiclePass.yearlyCharge = 48.91;
    }

    document.getElementById("vehicleType").style.display = "none";
    document.getElementById("selectPlan").style.display = "block";
    document.getElementById('labelforplan').innerHTML = "Your Plans are for " + vehicle.type;
    document.getElementById("radioforplan").innerHTML = '<input type="radio" name="inputplan" id="inputplan" value="' + vehiclePass.dailyCharge + '" onclick="registerplan('+vehiclePass.dailyCharge+', "daily");">' + vehiclePass.dailyCharge + ' $ Daily' +
     '<input type="radio" id="inputplan" name="inputplan" value="' + vehiclePass.monthlyChaarge + '" onclick="registerplan('+vehiclePass.monthlyChaarge+', "monthly");">' + vehiclePass.monthlyChaarge + ' $ Monthly '+
     '<input type="radio" id="inputplan" name="inputplan" value="' + vehiclePass.yearlyCharge + '" onclick="registerplan('+vehiclePass.yearlyCharge+', "yearly");">' + vehiclePass.yearlyCharge + ' $ Yearly';
}

function registerplan (planamount, period) {
    console.log(planamount, period);
    pass.selectedPeriod = period;
    pass.amount = planamount; 
    pass.vehicle = vehicle;
    
    // amount = planamount;
    document.getElementById("sucessregister").innerHTML = "Congratualtions !!!  " + employee.name + 
    "<br> You have registerd your vehicle " + vehicle.model +
    " " + vehicle.number + " sucessfully.<br>"+
    " You Have To Pay " + pass.amount + ' $';

    document.getElementById("selectPlan").style.display = "none";
    document.getElementById("sucessregister").style.display = "block";
}

function errorBorder (inputId) {
    document.getElementById(inputId).style.border = "none";
    document.getElementById(inputId).style.borderBottom = "2px solid #ff6600";
}
