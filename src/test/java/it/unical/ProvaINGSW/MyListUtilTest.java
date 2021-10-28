package it.unical.ProvaINGSW;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MyListUtilTest 
{

	private static MyListUtil myListUtil;
	private static List<Integer> list;
	
	@BeforeClass
	public static void beforeClass() {
		myListUtil = new MyListUtil();
		list = new ArrayList<Integer>();
		inizializzaLista();
	}
	
	private static void inizializzaLista() {
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(19);
		list.add(4);
		list.add(24);
		list.add(0);		
	}
	
	@Before
	public void before() {
		System.out.println("Prima di ogni test - before");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Dopo tutti i test - afterClass");
	}
	
	@After
	public void after() {
		System.out.println("Dopo ogni test - after");
	}
	
    @Test
    public void orderInvalidoTest() {
        assertEquals(null, myListUtil.sort(list, -1));
        assertEquals(null, myListUtil.sort(list, 2));
        assertEquals(null, myListUtil.sort(list, 3));
        assertNotEquals(null, myListUtil.sort(list, 1));
        assertNotEquals(null, myListUtil.sort(list, 0));        
    }
    
    @Test
    public void listaInvalidaTest() {
    	List<Integer> l = new ArrayList<Integer>();
    	assertEquals(null, myListUtil.sort(l, 1));     
    }
    
    /*
     	list.add(2);
		list.add(5);
		list.add(1);
		list.add(19);
		list.add(4);
		list.add(24);
		list.add(0); 
     
     */
    
    @Test
    public void crescente() {
    	assertEquals(Arrays.asList(0, 1, 2, 4, 5, 19, 24), myListUtil.sort(list, 0));     
    }
    
    @Test
    public void decrescente() {
    	assertEquals(Arrays.asList(24, 19, 5, 4, 2, 1, 0), myListUtil.sort(list, 1));        
    }
}
