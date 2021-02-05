

//Entity: Suma
//Suma. (Button) View: Calculadora
//Evento ExecuteCommand: Permite personalizar la acción a ejecutar de un command o de un ActionControl.
task.executeCommand.VA_VABUTTONCCLUXUC_558199 = function(  entities, executeCommandEventArgs ) {

    executeCommandEventArgs.commons.execServer = false;
    
    entities.Suma.numero1 = "";
    entities.Suma.numero2 = "";
    entities.Suma.resultado = "";

};