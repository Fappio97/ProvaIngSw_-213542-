package it.unical.ProvaINGSW;

import java.util.ArrayList;
import java.util.List;

public class MyListUtil 
{
	/*
    order = 0 //Ascendente

    order = 1 //Dicendente
	*/  
	public List<Integer> sort(List<Integer> list, int order){
		
		if(order < 0 || order > 1)
			return null;
		
		if(list.size() == 0)
			return list;
		
		List<Integer> l = new ArrayList<Integer>();
		
		l = list;

		if(order == 0) {
			for(int i = 0; i < l.size(); ++i) {
				for(int j = i + 1; j < l.size(); ++j) {
					if(l.get(j) < l.get(i)) {
						Integer tmp = l.get(i);
						l.set(i, l.get(j));
						l.set(j, tmp);
					}
				}
			}
		} else {
			for(int i = 0; i < l.size(); ++i) {
				for(int j = i + 1; j < l.size(); ++j) {
					if(l.get(j) > l.get(i)) {
						Integer tmp = l.get(i);
						l.set(i, l.get(j));
						l.set(j, tmp);
					}
				}
			}
		}
		return l;  
    }

}
