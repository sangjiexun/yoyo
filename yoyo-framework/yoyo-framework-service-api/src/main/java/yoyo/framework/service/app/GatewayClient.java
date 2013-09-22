// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.service.app;
import java.util.logging.Logger;
import javax.ws.rs.core.Response.Status;
import yoyo.framework.standard.app.GatewayHeader;
import yoyo.framework.standard.app.GatewayModel;
import yoyo.framework.standard.app.GatewayUtil;
import yoyo.framework.standard.shared.StandardException;
/**
 * ゲートウェイサービスのクライアント
 * @author nilcy
 */
public final class GatewayClient {
    /** ロガー */
    private static final Logger LOG = Logger.getGlobal();
    /** 非公開コンストラクタ */
    private GatewayClient() {
    }
    /**
     * RPCサービスの実行
     * @param <T> ボディオブジェクト型
     * @param aHeader {@link GatewayModel#setHeader(GatewayHeader)}
     * @param aBody {@link GatewayModel#setBody(String)}
     * @return {@link GatewayModel}
     * @throws StandardException ステータスコードがOKでないとき
     */
    public static <T> GatewayModel submit(final GatewayHeader aHeader, final T aBody)
        throws StandardException {
        final GatewayService gateway = GatewayUtil.getProxy(GatewayService.class);
        final GatewayModel request = GatewayFactory.create(aBody);
        request.setHeader(aHeader);
        final GatewayModel returnModel = gateway.submit(request);
        if (returnModel.getStatus().getCode().intValue() != Status.OK.getStatusCode()) {
            LOG.info("returnModel is " + returnModel);
            throw new StandardException("", returnModel.getStatus().getMessage());
        }
        return returnModel;
    }
}
