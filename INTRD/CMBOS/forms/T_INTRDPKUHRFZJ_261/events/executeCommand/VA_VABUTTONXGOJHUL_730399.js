

//Entity: EstadoCivil
//EstadoCivil. (Button) View: FormEstadoCivil
//Evento ExecuteCommand: Permite personalizar la acción a ejecutar de un command o de un ActionControl.
task.executeCommand.VA_VABUTTONXGOJHUL_730399 = function(  entities, executeCommandEventArgs ) {

    executeCommandEventArgs.commons.execServer = false;
    
    executeCommandEventArgs.commons.api.viewState.hide('G_ESTADOCIII_840399');
    
    entities.Ciudadano.estadoCivil = "";
    
    entities.Ciudadano.actividadActual = "";

};