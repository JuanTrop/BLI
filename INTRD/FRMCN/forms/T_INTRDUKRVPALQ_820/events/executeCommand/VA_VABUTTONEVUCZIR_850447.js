

//Entity: Entity1
//Entity1. (Button) View: FormCuentas
//Evento ExecuteCommand: Permite personalizar la acción a ejecutar de un command o de un ActionControl.
task.executeCommand.VA_VABUTTONEVUCZIR_850447 = function(  entities, executeCommandEventArgs ) {

    executeCommandEventArgs.commons.execServer = false;

    //Estableciendo datos de trabajo
    var saldoOrigen = entities.CuentaOrigen.saldo;
    var saldoDestino = entities.CuentaDestino.saldo;

    //Parametro de operacion
    var valorTransferencia = (Number.isNaN(entities.CuentaOrigen.valorTransferencia))? 0 : entities.CuentaOrigen.valorTransferencia;
    
    //Validacion saldo 
    if(valorTransferencia > saldoOrigen) {
        executeCommandEventArgs.commons.messageHandler.showMessagesError("Saldo insuficiente", true, null, 1000);
    } else{
        entities.CuentaDestino.saldo += valorTransferencia;
        entities.CuentaOrigen.saldo -= valorTransferencia;
    }


};