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
               // console.log(response);
                showAppointments(response);

            }
        });
    });

    function showAppointments(appointmentsArray){
        var appointments = [];
        for(var i = 0; i < appointmentsArray.length; i++) {
            for(var j = 0; j < appointmentsArray[i].length; j++) {
                appointments.push(appointmentsArray[i][j]);

            }
        }
        console.log(appointments);
    }

});