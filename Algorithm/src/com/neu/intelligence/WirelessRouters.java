package com.neu.intelligence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 * @author Johnqiu
 *
 */
public class WirelessRouters {
	
	/**
	 * count satification of each room
	 * @param roomlists
	 * @param sat
	 * @return list
	 */
	public List countSat(ArrayList roomlists, int[] sat){
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int i = 1; i < roomlists.size(); i++){
			ArrayList list = (ArrayList) roomlists.get(i);
			int sum = 0;
			for(int j=0; j < list.size(); j++){
				sum  = sum + sat[(int) list.get(j)];
			}
			map.put(i, sum);
		}
		
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>() {
            public int compare(Entry<Integer,Integer> o1, Entry<Integer,Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
		return list;
	}
	
	public int getRoom(ArrayList roomlists, int[] sat, int roomid){
		ArrayList currentlist = (ArrayList) roomlists.get(roomid); // currest list has biggest sat
		int maxid = 0;
		int maxSat = 0;
		for(int i = 1; i < roomlists.size(); i++){
			if(i == roomid) continue;
			ArrayList temp = (ArrayList) roomlists.get(i);
			temp.removeAll(currentlist);
			int tempsat = 0;
			for(int j=0; j < temp.size(); j++){
				tempsat = tempsat + sat[(int) temp.get(j)];
			}
			if(tempsat > maxSat){
				maxSat = tempsat;
				maxid = i;
			}
		}
		return maxid;
	}

	/**
	 * merge two list
	 * @param roomlists
	 * @param room1
	 * @param room2
	 * @return
	 */
	public ArrayList mergeList(ArrayList roomlists, int room1, int room2){
		ArrayList list1 = (ArrayList) roomlists.get(room1); 
		ArrayList list2 = (ArrayList) roomlists.get(room2);
		list2.removeAll(list1);
		list1.addAll(list2);
		roomlists.set(room1, list1);
		return roomlists;
	}
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int[] sat = new int[n+1];
		
		WirelessRouters wr = new WirelessRouters();
		
		ArrayList roomlists = new ArrayList();
		ArrayList rlist = new ArrayList();
		rlist.add(0);
		roomlists.add(rlist);
		
		for(int i=1; i <= n; i++){
			sat[i] = cin.nextInt();
			ArrayList roomlist = new ArrayList();
			roomlist.add(i);
			roomlists.add(roomlist);
		}
		for(int j=0; j < n-1; j++){
			int room1 = cin.nextInt();
			int room2 = cin.nextInt();
			ArrayList rlist1 = (ArrayList) roomlists.get(room1);
			rlist1.add(room2);
			roomlists.set(room1, rlist1);
			ArrayList rlist2 = (ArrayList) roomlists.get(room2);
			rlist2.add(room1);
			roomlists.set(room2, rlist2);
		}
		
		List satlist = wr.countSat(roomlists, sat); 
		Map.Entry<Integer,Integer> map = (Entry<Integer, Integer>) satlist.get(0);
		
		for(int k = 1; k < m; k++){
			int roomid = wr.getRoom(roomlists, sat, map.getKey());
			roomlists = wr.mergeList(roomlists, map.getKey(), roomid);
		}
		
		if(m > 1){
			satlist = wr.countSat(roomlists, sat); 
			map = (Entry<Integer, Integer>) satlist.get(0);
		}
		System.out.println(map.getValue());
	}

}
