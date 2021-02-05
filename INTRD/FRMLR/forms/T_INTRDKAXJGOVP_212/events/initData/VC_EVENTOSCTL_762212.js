
     
//Evento initData : Inicialización de datos del formulario, después de este evento se realiza el seguimiento de cambios en los datos
//ViewContainer: EventosCliente
task.initData.VC_EVENTOSCTL_762212 = function (entities, initDataEventArgs){

    initDataEventArgs.commons.execServer = false;
    initDataEventArgs.commons.api.viewState.disable('VA_VABUTTONCJJTCMU_223237');
};