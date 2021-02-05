

//Entity: EstadoCivil
//EstadoCivil.estadoCivil (ComboBox) View: FormEstadoCivil
//Evento Change: Se ejecuta al cambiar el valor de un InputControl.
task.change.VA_2326RFJSLUFKNCO_873399 = function(  entities, changedEventArgs ) {

    changedEventArgs.commons.execServer = false;
    
    changedEventArgs.commons.api.viewState.show('G_ESTADOCIII_840399', false);
    
    var estadoCivil = entities.EstadoCivil.estadoCivil;
    
    entities.Ciudadano.estadoCivil = (estadoCivil == 'SO')? 'Soltero' : 'Casado';
    entities.Ciudadano.actividadActual = (estadoCivil == 'SO')? 'Listo pa la farra' : 'Lavando platos';


};