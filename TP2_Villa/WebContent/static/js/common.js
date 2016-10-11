function mensajeModal(mensaje){
	$('#spnMessage').text(mensaje);
	$('#dialog-message').dialog('open');
}

function isNumeric(value){
    var isNumber = false;
    for(var i = 0; i < value.length() - 1; i++) {
        var caracter = value.charAt(i);
        if(caracter < '0' || caracter > '9')
            break;
        isNumber = true;
    }
    return isNumber;
}