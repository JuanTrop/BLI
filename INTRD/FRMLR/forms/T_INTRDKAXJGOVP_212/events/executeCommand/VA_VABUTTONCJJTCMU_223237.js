

//Entity: Persona
//Persona. (Button) View: EventosCliente
//Evento ExecuteCommand: Permite personalizar la acción a ejecutar de un command o de un ActionControl.
task.executeCommand.VA_VABUTTONCJJTCMU_223237 = function(  entities, executeCommandEventArgs ) {

    executeCommandEventArgs.commons.execServer = false;
    entities.Persona.nombre = " ";
    entities.Persona.nombreCompleto = " ";
    entities.Persona.apellido = " ";
    executeCommandEventArgs.commons.api.viewState.disable('VA_VABUTTONCJJTCMU_223237');

    
};