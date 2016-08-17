package com.neu.DynamicProgramming;

import java.util.Comparator;

/**
 *  The <tt>TagTaskComparator</tt> Java  provides a comparator for 
 *  comparing t1's R0 with t2's R0
 *  <p>
 *  
 *  @author Johnqiu
 */
public class TagTaskComparator implements Comparator<TagTask>{

	@Override
	public int compare(TagTask t1, TagTask t2) {
		return t2.getRO() - t1.getRO();  // descending order
	}

}
