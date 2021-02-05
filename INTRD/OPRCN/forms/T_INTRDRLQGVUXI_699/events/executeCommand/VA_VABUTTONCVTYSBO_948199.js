

//Entity: Suma
//Suma. (Button) View: Calculadora
//Evento ExecuteCommand: Permite personalizar la acción a ejecutar de un command o de un ActionControl.
task.executeCommand.VA_VABUTTONCVTYSBO_948199 = function(  entities, executeCommandEventArgs ) {

    executeCommandEventArgs.commons.execServer = true;
    
    var sumando_1 = entities.Suma.numero1;
    var sumando_2 = entities.Suma.numero2;
    
    /*
    if(!Number.isNaN(sumando_1) && !Number.isNaN(sumando_2)){
        entities.Suma.resultado = sumando_1 + sumando_2;
        
        executeCommandEventArgs.commons.api.viewState.enable('VA_VABUTTONCCLUXUC_558199');
    }
    */
};