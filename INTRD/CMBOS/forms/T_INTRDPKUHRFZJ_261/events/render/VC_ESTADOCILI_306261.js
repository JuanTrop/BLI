
    
//Evento render : Se ejecuta antes de renderizar un control, permite realizar personalizaciones visuales
//ViewContainer: FormEstadoCivil
task.render = function (entities, renderEventArgs){

    renderEventArgs.commons.execServer = false;
    renderEventArgs.commons.api.viewState.hide('G_ESTADOCIII_840399');

};