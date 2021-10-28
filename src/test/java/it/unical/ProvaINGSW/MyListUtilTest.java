package it.unical.ProvaINGSW;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MyListUtilTest 
{

	private static MyListUtil myListUtil;
	private static List<Integer> list;
	private static DateTime time;
	@BeforeClass
	public static void beforeClass() {
		time = new DateTime();
		System.out.println("Data ed orario inizio di tutti i test " + time.toString().substring(0, 23).replace("T", " "));
		
		myListUtil = new MyListUtil();
		
		list = new ArrayList<Integer>();
		inizializzaLista();
		
	}
	
	private static void inizializzaLista() {
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(23);
		list.add(4);
		list.add(24);
		list.add(0);		
	}
	
	@Before
	public void before() {
		time = DateTime.now();		
		System.out.println("Data ed orario inizio del singolo test " + time.toString().substring(0, 23).replace("T", " "));	
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("Data ed orario fine del singolo test " + time.toString().substring(0, 23).replace("T", " "));
	}
	
	@After
	public void after() {
		System.out.println("Data ed orario fine di tutti i test " + time.toString().substring(0, 23).replace("T", " "));
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
    
    @Test
    public void crescenteTest() {
    	assertEquals(Arrays.asList(0, 1, 2, 4, 5, 23, 24), myListUtil.sort(list, 0));
    	//assertEquals(Arrays.asList(0, 1, 2, 4, 5, 23, 24), myListUtil.sort(Arrays.asList(2, 5, 4, 23, 24, 1, 0), 0));     
    }
    
    @Test
    public void decrescenteTest() {
    	assertEquals(Arrays.asList(24, 23, 5, 4, 2, 1, 0), myListUtil.sort(list, 1));        
    }
}
