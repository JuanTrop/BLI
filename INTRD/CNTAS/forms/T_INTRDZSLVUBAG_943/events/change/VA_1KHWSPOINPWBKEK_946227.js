

//Entity: Entity2
//Entity2.attribute1 (ComboBox) View: CuentaNueva
//Evento Change: Se ejecuta al cambiar el valor de un InputControl.
task.change.VA_1KHWSPOINPWBKEK_946227 = function(  entities, changedEventArgs ) {

    changedEventArgs.commons.execServer = false;
    
    var valor = changedEventArgs.newValue;
    
    if(valor === 'A'){
        changedEventArgs.commons.api.viewState.show('VA_VABUTTONXSXYYEE_462227'); //Muestra corrientes
        changedEventArgs.commons.api.viewState.hide('VA_VABUTTONPSQMDBC_172227'); //Esconde corrientes
    } else {
        changedEventArgs.commons.api.viewState.show('VA_VABUTTONPSQMDBC_172227'); //Muestra corrientes
        changedEventArgs.commons.api.viewState.hide('VA_VABUTTONXSXYYEE_462227'); //Esconde ahorros
    }
};