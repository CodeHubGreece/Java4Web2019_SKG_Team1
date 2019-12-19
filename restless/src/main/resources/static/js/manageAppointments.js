var megaAppointments = [];


$(document).ready(function () {


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


    function showSpecialty(specialties) {
        var options = $("#specialtyDropdown");
        //don't forget error handling!
        $.each(specialties, function (index, item) {
            console.log(item);
            options.append($("<option />").val(item.id).text(item.specialty));
        });
    }
});


$('#getApointments,.close').click(function () {

    var fromDate = $('#fromdate').val();
    var toDate = $('#todate').val();
    fromDate = fromDate + " 00:00:00";
    toDate = toDate + " 23:59:59";
    var specialtyId = $("#specialtyDropdown option:selected").val();

    //get appointments
    $.ajax({
        url: ROOT_PATH + '/appointments/dates-specialty',
        type: 'post',
        data: JSON.stringify({
            'fromDate': fromDate,
            'toDate': toDate,
            'specialtyId': specialtyId,
        }),
        dataType: 'json',
        contentType: 'application/json',
        success: function (response) {
            console.log(response);
            megaAppointments = response;
            showAppointments();
        }
    });
});


// function organiseAppointments(appointmentsArray) {
//     megaAppointments = [];
//     for (var i = 0; i < appointmentsArray.length; i++) {
//         for (var j = 0; j < appointmentsArray[i].length; j++) {
//             megaAppointments.push(appointmentsArray[i][j]);
//         }
//     }
//     showAppointments();
// }

function showAppointments() {
    $('#appointmentTables').empty();

    let content = '<table id="appTable" class="table table-striped" style="word-break: break-word;">';
    content += '<thead class = "thead-light"><tr>' +
        '<th scope="col">#</th>' +
        '<th scope="col">Doctor</th>' +
        '<th scope="col">Date</th>' +
        '<th scope="col">Time</th>' +
        '<th scope="col">Description</th>' +
        '<th scope="col">Notes</th>' +
        '</tr></thead><tbody>';

    console.log(megaAppointments);

    var rowcount = 1;
    var dateoptions = { year: 'numeric', month: 'short', day: '2-digit' };
    megaAppointments.forEach(element => {
        let dateTime = new Date(element.datetime);// get datetime
        let date = dateTime.toLocaleDateString(navigator.language, dateoptions);//get date
        let time = dateTime.toISOString().slice(11,16);//get  time and remove seconds

        content += '<tr>' +
            '<th scope="row">' + rowcount + '</th>' +
            '<td>' + element.doctor.firstName + " " + element.doctor.lastName + '</td>' +
            '<td>' + date + '</td>' +
            '<td>' + time + '</td>' +
            '<td style="max-width: 150px;">' + element.description + '</td>' +
            '<td style="max-width: 150px;">' + element.notes + '</td>' +
            '<td><button id="' + element.id + '" type="button" onclick="updateAppointment(' + (rowcount-1) + ')" class="btn btn-success">Edit</button></td>' +
            '</tr>';

            rowcount++;
        // var btn = document.getElementById(element.id);
        // btn.onclick = function () { updateAppointment(rowcount); };
    }); //(let i = 0; i < megaAppointments.length; i++) {}
    content += '</tbody></table>';

    $('#appointmentTables').append(content);

    // megaAppointments.forEach(element => {
    //     var btn = document.getElementById(element.id);
    //     btn.onclick = function () { updateAppointment(btn.id); };
    // });
}


function updateAppointment(index) {

    console.log(index);
    let dateTime = new Date(megaAppointments[index].datetime);// get datetime
    console.log(dateTime);
    dateTimeString = dateTime.toISOString().slice(0,10) + " " + dateTime.toISOString().slice(11,16);
    // dateTime.setHours(dateTime.getHours() + 24);//this 24 is so fucking dumb



    $("#appointmentDateTime").val(dateTimeString);
    $('#descriptionUpdate').val(megaAppointments[index].description);
    $('#observationUpdate').val(megaAppointments[index].notes);
    $('#hiddenAppointentID').val(index);


    $('#myModal').modal();
}

function saveChanges() {
    let index = $('#hiddenAppointentID').val();
    let newDateTime = $('#appointmentDateTime').val();
    let jsonDateTime = newDateTime + ":00";

    let newDescription = $('#descriptionUpdate').val();
    let newNotes = $('#observationUpdate').val();
    let appId = megaAppointments[index].id;
    console.log(appId);


    //update
    $.ajax({
        url: ROOT_PATH + '/appointments/update',
        type: 'PUT',
        dataType: 'json',
        data: JSON.stringify({
            'id': appId,
            // 'citizenId': megaAppointments[index].citizenId,
            // 'doctorId': megaAppointments[index].doctorId,
            'datetime': jsonDateTime,
            'description': newDescription,
            'notes': newNotes,
        }),
        contentType: 'application/json',
        success: function (result) {
            $('#updateSuccess').html("Appointment updated successfully");

        },
        error: function (response) {
            responseJson=JSON.stringify(response);
            alert("NOT Saved: " + responseJson.message);
        }
    });
}

function deleteAppointment() {
    let index = $('#hiddenAppointentID').val();
    let appId = megaAppointments[index].id;
    //delete
    $.ajax({
        url: ROOT_PATH + '/appointments/' + appId,
        type: 'DELETE',
        success: function (result) {
            $('#updateSuccess').html("Appointment deleted successfully");

        },
        error: function (response) {
            responseJson=JSON.stringify(response);
            alert("NOT Saved: " + responseJson.message);
        }
    });
}

$('.close').click(function () {
    $('#updateSuccess').html("");
});