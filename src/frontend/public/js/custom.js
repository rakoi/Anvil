$(document).ready(function () {
    $('.alert').fadeOut(15000);
    $('#parcelId').focus();
    //check if user has trip  started trip befor loading parcel

    if(document.getElementById('tripid')){
    var tripId=document.getElementById('tripid').value;
    }
    if (tripId==""){
        $('#loadparcelsbtn').addClass('disabled');

        $('#loadparcelsbtn').attr('disabled', true);
        $('#notify').text('Start Trip To Load parcels')
    }
});






function validatePhoneNumbers() {
    validateSenderPhoneNumber();
    validaterecieverPhoneNumber();

}

function sendersphoneNoValidation() {


    if (!validateSenderPhoneNumber()) {
        document.getElementById("sPhoneValidation").innerText = "Enter valid phone number in the format +2547XXXXXXXX";
        $('#submit').addClass('disabled');
        $('#submit').attr('disabled', true);
        $('#warn').text("Enter valid senders phone number");

    }else{
        $('#warn').text("");
        document.getElementById("sPhoneValidation").innerText = "";
        $('#submit').attr('disabled', false);
        $('#loadparcelsbtn').removeClass('disabled');
        fetchSenderByPhoneNumber();

    }
}


function recieversphoneNoValidation() {
    if (!validaterecieverPhoneNumber()) {
        document.getElementById("rPhoneNumberValidation").innerText = "Enter valid phone number in the format +2547XXXXXXXX";
        $('#submit').addClass('disabled');
        $('#submit').attr('disabled', true);
        $('#warn').text("Enter valid Consignee phone number");

    } else {
        document.getElementById("rPhoneNumberValidation").innerText = "";
        $('#submit').attr('disabled', false);
        $('#warn').text("");
        $('#loadparcelsbtn').removeClass('disabled');
        fetchConsigneeByPhoneNumber()
    }
}

function validateSenderPhoneNumber() {
    var phonenumber = document.getElementById("sPhoneNumber").value;
    var phonenoregex = /^\+?[0-9]{3}[0-9]{9}$/;
    var isValid = phonenumber.match(phonenoregex);


    return isValid;

}

function validaterecieverPhoneNumber() {
    var phonenumber = document.getElementById("rPhoneNumber").value;
    var phonenoregex = /^\+?[0-9]{3}[0-9]{9}$/;
    var isValid = phonenumber.match(phonenoregex);

    return isValid

}


$(document).ready(function () {
    $('#parcelstable').DataTable({
        "pagingType": "numbers", //,
        "order": [[0, "desc"]]
        // "simple" option for 'Previous' and 'Next' buttons only
    });
    $('.dataTables_length').addClass('bs-select');
});

function printLabel() {




        var printContents = document.getElementById('label').innerHTML;
        var originalContent = document.body.innerHTML;
        document.body.innerHTML = printContents;

    setTimeout(function () {
        window.print();

        document.body.innerHTML = originalContent;
    }, 250);
    //


}
 function printLabels() {
    var printContents = document.getElementById('labels').innerHTML;
    var originalContent = document.body.innerHTML;
    document.body.innerHTML = printContents;

    setTimeout(function () {
        window.print();

        document.body.innerHTML = originalContent;
    }, 250);
    //

}
function printLoadedParcels() {
    var printContents = document.getElementById('parcelsList').innerHTML;
    var originalContent = document.body.innerHTML;
    document.body.innerHTML = printContents;

    setTimeout(function () {
        window.print();
        document.body.innerHTML = originalContent;
    }, 250);
    //

}

function printReciept() {

    var printContents = document.getElementById('reciept').innerHTML;
    var originalContent = document.body.innerHTML;
    document.body.innerHTML = printContents;

    setTimeout(function () {
        window.print();
        document.body.innerHTML = originalContent;
    }, 250);
    //


}