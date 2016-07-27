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
function sendUploadFile() {
	document.getElementById("reporte:rutaArchivo").value = document.getElementById("reporte:uploadFile").value;
}

function fileUploadDone(uploadSuccessful, resetForm, statusMessage, finalMessage, uploadFilePrefix) {
	var iframe = window.top.document.getElementById('fileReport');
	var innerDoc = (iframe.contentDocument) ? iframe.contentDocument : iframe.contentWindow.document;
	if (resetForm) {
		var ulObj = innerDoc.getElementById("uploadFile");
		ulObj.value = "";
		
	}
	innerDoc.getElementById("fileUploadForm:outputMessage").innerText = statusMessage;
	innerDoc.getElementById("fileUploadForm:finalMessage").innerText = finalMessage;
	innerDoc.getElementById("fileUploadForm:uploadFilePrefix").value = uploadFilePrefix;
	innerDoc.getElementById("fileUploadForm:uploadSuccessful").value = uploadSuccessful;
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