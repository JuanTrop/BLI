
     
//Evento initData : Inicialización de datos del formulario, después de este evento se realiza el seguimiento de cambios en los datos
//ViewContainer: FormCuentas
task.initData.VC_CUENTASUWG_409820 = function (entities, initDataEventArgs){

    initDataEventArgs.commons.execServer = false;
    
    entities.CuentaOrigen.numeroCuenta =1234;    
    entities.CuentaDestino.numeroCuenta =4567;

    entities.CuentaOrigen.saldo = 2000;
    entities.CuentaDestino.saldo = 1000;
    
    //Numero de cuenta de origen deshabilitado
    initDataEventArgs.commons.api.viewState.disable('VA_1YAOQJSBMVWEYIK_550447');
    //Saldo de cuenta de origen deshabilitado
    initDataEventArgs.commons.api.viewState.disable('VA_2BQNPPKBSTPRTMA_821447');
    //Numero de cuenta destino deshabilitado
    initDataEventArgs.commons.api.viewState.disable('VA_2HNLPJTBAVAKLLS_923447');
    //Saldo de cuenta de destino deshabilitado
    initDataEventArgs.commons.api.viewState.disable('VA_3ZBNWQTFJLDNZUB_815447');

    

};