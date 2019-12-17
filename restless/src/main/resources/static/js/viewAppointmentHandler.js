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


    function showSpecialty(specialties) {
        var options = $("#speciltyDropdown");
        //don't forget error handling!
        $.each(specialties, function(index,item) {
            console.log(item);
            options.append($("<option />").val(item.id).text(item.specialty));
        });
    }

    $('#getApointments').click(function(){

        var fromDate = $('#appointmentFromDate').val();
        var toDate = $('#appointmentToDate').val();
        var specialtyId =$ ( "#speciltyDropdown option:selected" ).val();

        //get appointments
        $.ajax({
            url: ROOT_PATH + '/appointment/dates-doctor',
            type: 'get',
            data: {
                'fromDate': fromDate,
                'toDate':toDate,
                'specialtyId':specialtyId,
            },
        //    dataType: 'json',
        //    contentType: 'application/json',
            success: function (response) {
                console.log(response);
                organiseAppointments(response);

            }
        });
    });


    function organiseAppointments(appointmentsArray){
        appointments = [];
        for (var i = 0; i < appointmentsArray.length; i++) {
            for (var j = 0; j < appointmentsArray[i].length; j++) {

                appointments.push(appointmentsArray[i][j]);


            }
        }

        console.log(appointments);
        showAppointments(appointments);
    }

    function showAppointments(appointments) {
        $('#appointmentTables').empty();

        var content = '<table width="100%" cellspacing="20">';
        content += '<tr><th>' + 'Doctor: ' + '</th>' +
            '<th id="test">' + 'Date:' + '</th>' +
            '<th align="center">' + 'Time: ' + '</th>' +
            '<th>' + 'Description: ' + '</th>' +
            '<th>' + 'Notes: ' + '</th>' +
            '</tr>';


        for (var i = 0; i < appointments.length; i++) {


                var dateTime = new Date(appointments[i].datetime );// get datetime
                dateTime.setHours(dateTime.getHours() - 2);//fix hour difference
                var date = dateTime.toLocaleDateString();//get date
                 var time = dateTime.toLocaleTimeString(navigator.language, {hour: '2-digit', minute:'2-digit'});//get  time and remove seconds



                 content += '<tr>' +
                '<td>' + appointments[i].doctor.firstName + '</td>' +
                '<td>' + date+ '</td>' +
                '<td>' + time + '</td>' +
                '<td>' + appointments[i].description + '</td>' +
                '<td>' + appointments[i].notes + '</td>' +
                     '<td><button id="'+ appointments[i].id  +'"onclick="">Update</button></td>'+
                '</tr>';

        }
        content+='<table/>';
        $('#appointmentTables').append(content);

        document.getElementById("test").setAttribute("align","right");
    }


   function updateAppointment(id){

        window.location = update.html;
       $('#appointmentUpdate').append(content);
    }

});