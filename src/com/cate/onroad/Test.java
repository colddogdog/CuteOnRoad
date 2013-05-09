/**
 * Project: cate on road
 * 
 * File Created at 2013-3-5
 * $Id$
 * 
 * Copyright 2010 dianping.com.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Dianping Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with dianping.com.
 */
package com.cate.onroad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * TODO Comment of Test
 * 
 * @author xinxuan.lin
 * 
 */
public class Test {
	public static void main(String args[]) throws Exception {
		List<Module> list = new ArrayList<Module>();
		Module m1 = new Module(1);
		Module m2 = new Module(1);
		Module m5 = new Module(2);
		Module m3 = new Module(1);
		Module m4 = new Module(2);
		Module m6 = new Module(3);
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);

		Collections.sort(list, new ModuleComparator());
		int count = 0;
		Domain domain = null;
		Module lastM = null;
		List<Domain> domains = new ArrayList<Domain>();
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				domain = new Domain();
				domains.add(domain);
				lastM = list.get(i);
				if (count == 0) {
					domain.setModule1(list.get(i));
					count++;
				}
			} else {
				Module thisM = list.get(i);
				if (lastM != null) {
					if (thisM.getId() == lastM.getId()) {
						if (count == 0) {
							domain = new Domain();
							domain.setModule1(thisM);
							domains.add(domain);
							count++;
						} else if (count == 1) {
							domain.setModule2(thisM);
							count++;
						} else {
							domain.setModule3(thisM);
							count = 0;
						}
					} else {
						count = 1;
						domain = new Domain();
						lastM = thisM;
						domain.setModule1(thisM);
						domains.add(domain);
					}
				}
			}
		}
		System.out.println("a");
	}
}
