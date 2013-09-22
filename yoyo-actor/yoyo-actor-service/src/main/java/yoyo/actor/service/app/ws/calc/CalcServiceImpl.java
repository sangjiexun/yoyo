// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.ws.calc;
import javax.jws.WebParam;
import yoyo.actor.service.app.ws.calc.CalcFactory;
import yoyo.actor.service.app.ws.calc.CalcRequest;
import yoyo.actor.service.app.ws.calc.CalcResponse;
import yoyo.actor.service.app.ws.calc.CalcService;
/**
 * Calculator service.
 * @author nilcy
 */
// @Stateless
// @WebService(portName = "CalcPort", serviceName = "CalcService", name = "Calc", targetNamespace =
// "http://yoyo.com/ws/calc", endpointInterface = "yoyo.actor.app.ws.calc.CalcService")
public class CalcServiceImpl implements CalcService {
    /** コンストラクタ */
    public CalcServiceImpl() {
    }
    /** {@inheritDoc} */
    @Override
    // @WebMethod
    public CalcResponse add(@WebParam(name = "request") final CalcRequest aRequest) {
        // final CalcRequest request = (CalcRequest) aRequest;
        return CalcFactory.createCalcResponse(aRequest.getParam1() + aRequest.getParam2());
    }
}
