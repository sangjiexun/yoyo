// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.screen.iface.jsf.converter;
import javax.faces.convert.FacesConverter;
import yoyo.actor.service.domain.misc.IndustryClass;
/**
 * Level converter.
 * @author nilcy
 */
@FacesConverter(value = "levelConverter", forClass = IndustryClass.class)
public final class LevelConverter extends AbstractEntityConverter {
    /** コンストラクタ */
    public LevelConverter() {
        super("levelAction");
    }
}
