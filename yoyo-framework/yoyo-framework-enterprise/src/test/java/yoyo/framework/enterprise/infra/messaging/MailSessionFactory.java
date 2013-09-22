// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.messaging;
import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.mail.Session;
import yoyo.framework.enterprise.infra.messaging.PrimaryMailSession;
/**
 * メールセッションのファクトリ
 * @author nilcy
 */
public final class MailSessionFactory {
    /** 基礎メールセッション */
    @Produces
    @PrimaryMailSession
    @Resource(name = "mail/primary")
    private Session primaryMailSession;
    // /** 補助メールセッション */
    // @Produces
    // @SecondaryMailSession
    // @Resource(name = "mail/secondary")
    // private Session secondaryMailSession;
    /** コンストラクタ */
    public MailSessionFactory() {
    }
}
