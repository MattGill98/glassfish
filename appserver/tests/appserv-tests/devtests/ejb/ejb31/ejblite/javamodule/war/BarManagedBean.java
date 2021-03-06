/*
 * Copyright (c) 2017, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.acme;

import jakarta.annotation.*;
import jakarta.ejb.EJB;
import jakarta.annotation.Resource;
import javax.sql.DataSource;

@ManagedBean
public class BarManagedBean {

    @EJB StatelessBean s;
    @Resource(name="jdbc/__default") DataSource ds;

    @PostConstruct
    private void init() {
	System.out.println("In BarManagedBean::init() ");
    }

   public void bar() {
       System.out.println("In BarManagedBean::bar() ");
    }


    @PreDestroy
    private void destroy() {
	System.out.println("In BarManagedBean::destroy() ");
    }

    public String toString() {
	return "BarManagedBean this = " + super.toString() + 
	    " s = " + s + " , ds = " + ds;

    }

}
