

//Entity: Entity2
//Entity2. (Button) View: CuentaNueva
//Evento ExecuteCommand: Permite personalizar la acción a ejecutar de un command o de un ActionControl.
task.executeCommand.VA_VABUTTONPSQMDBC_172227 = function(  entities, executeCommandEventArgs ) {

    executeCommandEventArgs.commons.execServer = true;
    
    //Crea un numero de cuenta unico
    const obtenerNumeroCuenta = () => {
        return Math.floor(Math.random() * 1000000000 + 1000000000);
    } 
    
    entities.Cuenta.numeroCuenta = obtenerNumeroCuenta(); 
    entities.Cuenta.codigoCliente = entities.Cliente._data[0].cedula;

    var saldo = entities.Cuenta.saldo;
    var mensajeError = "Saldo insuficiente";
    
    if(saldo < 0){
        executeCommandEventArgs.commons.messageHandler.showMessagesError(mensajeError);
    }

};