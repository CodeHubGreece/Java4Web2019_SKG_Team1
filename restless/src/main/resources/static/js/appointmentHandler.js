

//FETCH SPECIALTIES
$('document').ready(function(){
    $.ajax({
        url:  ROOT_PATH + '/specialties',
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function(response){
            console.log(response[0].specialty);
            showSpecialty(response);
              }
    });

});

//SHOW SPECIALTIES
function showSpecialty(specialties) {
    var options = $("#speciltyDropdown");
    //don't forget error handling!
    $.each(specialties, function(index,item) {
        console.log(item);
        options.append($("<option />").val(item.id).text(item.specialty));
    });
}

//FETCH DOCTORS
$( "#speciltyDropdown" ).change(function() {
    var specialtyId =$ ( "#speciltyDropdown option:selected" ).val();
    if(specialtyId !== "default") {
        console.log(specialtyId);

        $.ajax({
            url: ROOT_PATH + '/doctor',
            type: 'get',
            data: {'specialtyId': specialtyId},
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                console.log(response);
                showDocs(response);
            }
        });
    }
});


//SHOW DOCTORS

function showDocs(doctors){
    if( !$('#doctorDropdown').length ){
       console.log("docs dont exists");
        $('#docDiv').append('<select id="doctorDropdown"><option>Select doctors</option></select>');
    }
    else console.log("docs exist");

    var options = $("#doctorDropdown");
    $('#doctorDropdown').empty();
    $('#doctorDropdown').append($("<option />").text("Select Doctor"));
  //  $('#doctorDropdown').append('<select id="doctorDropdown"><option>Select doctors</option></select>');
    $.each(doctors, function(index,item) {
        var docName = item.firstName + " " + item.lastName;
        options.append($("<option />").val(item.id).text(docName));
    });



}

//CREATE APPOINTMENT
$('#storeAppointments').click(function(){
    console.log("hi");
    var date = $('#appointmentDate').val();
    var time = $('#appointmentTime').val();
    var jsonDateTime =new Date((date + ' ' + time));

    var docId = $('#doctorDropdown').val();
    var citId = 5;
    var description = $('#description').val();
    var notes = $('#notes').val();



    //create appointment
    $.ajax({
        url: ROOT_PATH + '/appointment/new',
        type: 'post',
        data: JSON.stringify({
            'citizenId': citId,
            'doctorId':docId,
            'datetime': jsonDateTime,
            'description':description,
            'notes':notes
        }),
        dataType: 'json',
        contentType: 'application/json',
        success: function (response) {
            console.log(response);
        }
    });
});
