// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.ws.hello;
import javax.jws.WebParam;
import yoyo.actor.service.app.ws.hello.HelloService;
/**
 * Hello service.
 * @author nilcy
 */
// @Stateless
// @WebService(portName = "HelloPort", serviceName = "HelloService", name = "Hello", targetNamespace
// = "http://yoyo.com/ws/hello", endpointInterface = "yoyo.actor.app.ws.hello.HelloService")
public class HelloServiceImpl implements HelloService {
    /** コンストラクタ */
    public HelloServiceImpl() {
        super();
    }
    /** {@inheritDoc} */
    @Override
    // @WebMethod
    public Object sayHello(@WebParam(name = "name") final String aName) {
        return "Hello " + aName + " !";
    }
}
