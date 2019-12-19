

//FETCH SPECIALTIES
$('document').ready(function () {
    $.ajax({
        url: ROOT_PATH + '/specialties',
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (response) {
            console.log(response[0].specialty);
            showSpecialty(response);
        }
    });
});





//SHOW SPECIALTIES
function showSpecialty(specialties) {
    var options = $("#specialtyDropdown");
    //don't forget error handling!
    $.each(specialties, function (index, item) {
        console.log(item);
        options.append($("<option />").val(item.id).text(item.specialty));
    });
}


//FETCH DOCTORS
function fetchDoctors() {
    console.log("changed specialty");
    var specialtyId = $("#specialtyDropdown option:selected").val();
    if (specialtyId !== "default") {
        console.log(specialtyId);

        $.ajax({
            url: ROOT_PATH + '/appointments/doctors',
            type: 'post',
            data: { 'specialtyId': specialtyId },
            // dataType: 'json',
            // contentType: 'application/json',
            success: function (response) {
                console.log(response);
                showDocs(response);
            }
        });
    }
}


//SHOW DOCTORS

function showDocs(doctors) {
    if (!$('#doctorDropdown').length) {
        console.log("docs dont exists");
        $('#docDiv').append('<select class="selection-2" id="doctorDropdown"><option>Select doctors</option></select>');
    }
    else console.log("docs exist");

    var options = $("#doctorDropdown");
    $('#doctorDropdown').empty();
    $('#doctorDropdown').append($("<option />").text("Select Doctor"));
    //  $('#doctorDropdown').append('<select id="doctorDropdown"><option>Select doctors</option></select>');
    $.each(doctors, function (index, item) {
        var docName = item.firstName + " " + item.lastName;
        options.append($("<option />").val(item.id).text(docName));
    });



}

//CREATE APPOINTMENT
$('#storeAppointments').click(function () {
    console.log("hi");
    var datetimeField = $('#appointmentDateTime').val();
    var jsonDateTime = datetimeField + ":00";

    var docId = $('#doctorDropdown').val();
    var description = document.getElementById("description").value;
    var notes = document.getElementById("notes").value;


    console.log(jsonDateTime);
    console.log(docId);
    console.log(description);
    console.log(notes);



    //create appointment
    $.ajax({
        url: ROOT_PATH + '/appointments/new',
        type: 'post',
        data: JSON.stringify({
            'doctorId': docId,
            'datetime': jsonDateTime,
            'description': description,
            'notes': notes
        }),
        dataType: 'json',
        contentType: 'application/json',
        success: function (response) {
            console.log(response);
            window.location.replace(ROOT_PATH + "/citizens/dashboard.html");
        }
    });
});
