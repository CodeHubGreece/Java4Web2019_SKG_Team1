var megaAppointments = [];

$('#getApointments,.close').click(function () {

    var fromDate = $('#fromdate').val();
    var toDate = $('#todate').val();
    fromDate = fromDate + " 00:00:00";
    toDate = toDate + " 23:59:59";
    var description = $("#description").val();

    //get appointments
    $.ajax({
        url: ROOT_PATH + '/appointments/dates-description',
        type: 'post',
        data: JSON.stringify({
            'fromDate': fromDate,
            'toDate': toDate,
            'description': description,
        }),
        dataType: 'json',
        contentType: 'application/json',
        success: function (response) {
            console.log(response);
            megaAppointments = response;
            showAppointments()
        }
    });
});


function showAppointments() {
    $('#appointmentTables').empty();


    let content = '<table id="appTable" class="table table-striped" style="word-break: break-word;">';
    content += '<thead class = "thead-light"><tr>' +
        '<th scope="col">#</th>' +
        '<th scope="col">Patient</th>' +
        '<th scope="col">Date</th>' +
        '<th scope="col">Time</th>' +
        '<th scope="col">Description</th>' +
        '<th scope="col">Notes</th>' +
        '</tr></thead><tbody>';


    var rowcount = 1;
    var dateoptions = { year: 'numeric', month: 'short', day: '2-digit' };
    megaAppointments.forEach(element => {
        let dateTime = new Date(element.datetime);// get datetime
        let date = dateTime.toLocaleDateString(navigator.language, dateoptions);//get date
        let time = dateTime.toISOString().slice(11, 16);//get  time and remove seconds

        content += '<tr>' +
            '<th scope="row">' + rowcount + '</th>' +
            '<td>' + element.citizen.firstName + " " + element.citizen.lastName + '</td>' +
            '<td>' + date + '</td>' +
            '<td>' + time + '</td>' +
            '<td style="max-width: 150px;">' + element.description + '</td>' +
            '<td style="max-width: 150px;">' + element.notes + '</td>' +
            '<td><button id="' + element.id + '" type="button" onclick="viewCitizen(' + (rowcount - 1) + ')" class="btn btn-success">View</button></td>' +
            '</tr>';

        rowcount++;
        // var btn = document.getElementById(element.id);
        // btn.onclick = function () { updateAppointment(rowcount); };
    }); //(let i = 0; i < megaAppointments.length; i++) {}
    content += '</tbody></table>';

    $('#appointmentTables').append(content);

    // for (let i = 0; i < megaAppointments.length; i++) {

    //     var btn = document.getElementById(megaAppointments[i].id);
    //     btn.onclick = function () { viewCitizen(i); };

    // }
}

function viewCitizen(index) {
    $("#tableName").html(megaAppointments[index].citizen.firstName);
    $("#tableSurname").html(megaAppointments[index].citizen.lastName);
    $("#tableAmka").html(megaAppointments[index].citizen.amka);
    $("#tableEmail").html(megaAppointments[index].citizen.email);
    $("#tableNumber").html(megaAppointments[index].citizen.phoneNumber);

    $('#myModal').modal();

}

