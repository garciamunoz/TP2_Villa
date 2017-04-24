function mensajeModal(mensaje){
	$('#spnMessage').text(mensaje);
	$('#dialog-message').dialog('open');
}

function isNumeric(event){
	var key = (event.keyCode || event.which);
	var value = String.fromCharCode(key); 
    var isNumber = false;
    if(!isNaN(value) || key == '8'){
    	isNumber = true;
    }    
    return isNumber;
}

function isNumericDecimal(event){
	var key = (event.keyCode || event.which);
	var value = String.fromCharCode(key); 
    var isNumber = false;
    if(!isNaN(value) || key == '8' || key == '46'){
    	isNumber = true;
    }    
    return isNumber;
}

$(document).ready(function () {
    $('input').bind('copy paste', function (e) {
       e.preventDefault();
    });
});
