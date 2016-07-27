function activaCalendar(data) {
	var loading = document.getElementById("image");
    var buttonElement = data.source;
	if (data.status === "begin"){
        loading.style.display = "block";
        buttonElement.disabled = true;		
	} else if (data.status === "complete"){

	} else if (data.status === 'success') {
	    $(".dateIni").datepicker({
	
	     });
	    $(".dateFin").datepicker({
	
	     }); 
        loading.style.display = "none";
        buttonElement.disabled = false;
	 }
}

function sendHiddenValue(){
	document.getElementById("logs:fechaIni").value = document.getElementById("logs:dateIni").value;
	document.getElementById("logs:fechaFin").value = document.getElementById("logs:dateFin").value;

 }

function postLogout(data) {
	if (data.status === "begin"){
		
	} else if (data.status === "complete"){

	} else if (data.status === 'success') {
		window.parent.location.href = "seeyou.jsp";
	 }
}
function validaMonto(){
	if(document.getElementById("ampliaBolson:inputBolsonMonto").value === ""){
		return false;
	}
	return confirm('¿Desea actualizar el monto del Bolsón?');
}

function monitor(data){
    var loading = document.getElementById("image");
    var buttonElement = data.source;
    if(data.status == "begin"){
        loading.style.display = "block";
        buttonElement.disabled = true;
    }
    else if(data.status == "success"){
        loading.style.display = "none";
        buttonElement.disabled = false;
    }
}
