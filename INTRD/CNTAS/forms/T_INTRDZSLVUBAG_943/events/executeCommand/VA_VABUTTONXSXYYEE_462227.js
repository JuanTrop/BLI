

//Entity: Entity2
//Entity2. (Button) View: CuentaNueva
//Evento ExecuteCommand: Permite personalizar la acción a ejecutar de un command o de un ActionControl.
task.executeCommand.VA_VABUTTONXSXYYEE_462227 = function(  entities, executeCommandEventArgs ) {
    
    const obtenerNumeroCuenta = () => {
        return Math.floor(Math.random() * 1000000000 + 1000000000);
    } 
    
    entities.Cuenta.numeroCuenta = obtenerNumeroCuenta(); 
    entities.Cuenta.codigoCliente = entities.Cliente._data[0].cedula;

    
    executeCommandEventArgs.commons.execServer = true;
    //executeCommandEventArgs.commons.serverParameters.Entity2 = true;
    var saldo = entities.Cuenta.saldo;
    var mensajeError = "Saldo insuficiente"
    if(saldo < 0){
        executeCommandEventArgs.commons.messageHandler.showMessagesError(mensajeError);
    }

};