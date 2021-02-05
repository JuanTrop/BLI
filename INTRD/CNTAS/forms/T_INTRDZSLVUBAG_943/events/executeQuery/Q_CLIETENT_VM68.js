
//ClienteQuery Entity: Cliente
task.executeQuery.Q_CLIETENT_VM68 = function(executeQueryEventArgs){
    executeQueryEventArgs.commons.execServer = true;
    //executeQueryEventArgs.commons.serverParameters.Cliente = true;
    executeQueryEventArgs.parameters.cedula = executeQueryEventArgs.commons.api.vc.model.BusquedaCliente.cedula;
};