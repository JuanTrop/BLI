package com.cobiscorp.cobis.intrd.bli.services.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.cobiscorp.cobis.cwc.context.MapperManager;
import com.cobiscorp.cobis.cwc.kernel.sp.dto.MapperResult;
import com.cobiscorp.cobis.cwc.kernel.sp.impl.ExecutorSP;

import com.cobiscorp.cobis.intrd.model.CuentaCorriente;

import com.cobiscorp.designer.api.DataEntity;
import com.cobiscorp.designer.api.DataEntityList;
import com.cobiscorp.designer.api.DynamicRequest;
import com.cobiscorp.designer.bli.util.BLIUtils;
import com.cobiscorp.designer.bli.api.IBLIExecutor;
import com.cobiscorp.designer.exception.DesignerRuntimeException;
import com.cobiscorp.designer.bli.manager.BliManagerException;
import com.cobiscorp.cobis.cwc.server.information.ServerParamUtil;
import com.cobiscorp.cobis.commons.domains.log.ILogger;
import com.cobiscorp.cobis.commons.log.LogFactory;
import com.cobiscorp.ecobis.map.Mapper;
import com.cobiscorp.ecobis.map.dto.Result;
import com.cobiscorp.ecobis.map.enums.SqlType;

@Component
@Service({ IBLIExecutor.class })
@Properties({
  @Property(name = "task.module", value = "INTRD"),
  @Property(name = "bli.id", value = "BLI6088_bli_crearcuentacorriente")
})
public class BLI6088_bli_crearcuentacorriente implements IBLIExecutor {
  private static final ILogger logger = LogFactory.getLogger(BLI6088_bli_crearcuentacorriente.class);

  public void execute(DynamicRequest dynamicRequest) {
    Mapper mapper = null;
    try {
      DataEntity row = BLIUtils.getRowDataEntity(dynamicRequest);
      List<Object> outListEntities = new ArrayList<Object>();
      DataEntity rowCuentaCorriente;
      if (row != null && CuentaCorriente.ENTITY_NAME.equals(row.getEntityName())) {
        rowCuentaCorriente = row;
      } else {
        rowCuentaCorriente = BLIUtils.getDataEntity(dynamicRequest, CuentaCorriente.ENTITY_NAME);
        if (rowCuentaCorriente == null) {
          throw new DesignerRuntimeException("No existe entidad " + CuentaCorriente.ENTITY_NAME);
        }
      }

      Double wsaldoCuenta = rowCuentaCorriente.get(CuentaCorriente.SALDOCUENTA);
      String wnumeroCuenta = rowCuentaCorriente.get(CuentaCorriente.NUMEROCUENTA);
      String wcedulaCliente = rowCuentaCorriente.get(CuentaCorriente.CEDULACLIENTE);

      if (logger.isDebugEnabled()) {
        logger.logDebug("inputParameters: " + " SALDOCUENTA: " + wsaldoCuenta + " NUMEROCUENTA: " + wnumeroCuenta + " CEDULACLIENTE: " + wcedulaCliente);
      }

      mapper = MapperManager.get(Mapper.class);
      mapper.addInputParameter("@t_trn", SqlType.INT, "2518");

      if (wsaldoCuenta != null){
        mapper.addInputParameter("@i_saldo", SqlType.DOUBLE, BLIUtils.convertToType(wsaldoCuenta, String.class));
      }

      if (wnumeroCuenta != null){
        mapper.addInputParameter("@i_numero_cuenta", SqlType.VARCHAR, BLIUtils.convertToType(wnumeroCuenta, String.class));
      }

      if (wcedulaCliente != null){
        mapper.addInputParameter("@i_ced_cliente", SqlType.VARCHAR, BLIUtils.convertToType(wcedulaCliente, String.class));
      }
      boolean ret = mapper.execute(".cobis.g1_sp_cuenta_corriente");
      int retCode = mapper.returnCode();
      if (ret && (retCode == 0)) {




        if (logger.isDebugEnabled()) {
          logger.logDebug("returnCode: " + retCode);
        }
      } else {
        BliManagerException.handleMapperException(mapper);
      }
    } catch (Exception ex) {
      BliManagerException.handleBliException(ex);
    } finally {
      if (mapper != null)
        mapper.check();
    }
  }

}
