// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.domain;

import yoyo.framework.standard.domain.AbstractSpecification;

@SuppressWarnings("all")
public class FalseSpecification extends AbstractSpecification<Object> {
    @Override
    public boolean isSatisfiedBy(final Object o) {
        return false;
    }
}