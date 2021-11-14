package exercice1;
import java.util.*;


public class Panel {
	
	private int start;
	private int end;
	
	public Panel(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public static Iterator<Integer> panel1( int start, int end) {
		if (start > end) {
			throw new IllegalArgumentException();
		}
			
		return new Iterator<Integer>() {
			int count = start;

			@Override
			public boolean hasNext() {
				if( count<=end) {
					return true;
				}else {
					return false;
				}
				
			}

			@Override
			public Integer next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
					
				return count++;

			}
		};
	}
	
	public static Iterator<Integer> panelClassAnonyme( int start,  int end) {
		if (start > end) {
			throw new IllegalArgumentException();	
		}

		// An anonymous class
	    Iterator<Integer> iterator = new Iterator<Integer>() {
	      int count = start;

	      @Override
	      public boolean hasNext() {
	        return (count <= end);
	      }

	      @Override
	      public Integer next() {
	        return (count++);
	      }
	    }; // Anonymous inner class ends here

	    return iterator;
	  
	}

/**
 * for for each
 * @param start
 * @param end
 * @return
 */
	public static Iterable<Integer> panel2( int start,  int end) {
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return panel1(start, end);
			}
		};
	}

	
	//4 - abstarct class a un problem si on redefinie pas la method Iterator la liste sne poura pas etre modifier
	//les methdodes abstraites qui doivent etre implimenter sont : size - get - Iterator
	public static List<Integer> abstarctPanel( int start,  int end) {
		if (start > end) {
			throw new IllegalArgumentException();
		}
			
		return new AbstractList<Integer>() {
			@Override
			public int size() {
				return end - start + 1;
			}

			@Override
			public Integer get(int index) {
				return start + index;
			}

			
			@Override
			public Iterator<Integer> iterator() {
				return panel1(start, end);
			}
		};
		
		
	}
	
	public static List<Integer> panel( int start,  int end) {
		if (start > end) {
			throw new IllegalArgumentException();
		}
			
		return new AbstractList<Integer>() {
			@Override
			public int size() {
				return end - start + 1;
			}

			@Override
			public Integer get(int index) {
				return start + index;
			}

			
			@Override
			public Iterator<Integer> iterator() {
				return panel1(start, end);
			}
		};
		
	}
	
	public static void main(String[] args) {
		//1-
		Iterator<Integer> it = panel1(1, 5);
		for(;it.hasNext();)
			System.out.println(it.next());
		
		//2-
		
		Iterator<Integer> it2 = panelClassAnonyme(1, 5);
		for(;it2.hasNext();)
			System.out.println(it2.next());
		
		//3-
		for(int i:panel2(1,5)) {
			System.out.println(i);
		}
		
		//5-
		List<Integer> l = panel(3,6);
		for(int i:l) {
			System.out.println(i);
		}
		System.out.println(l.get(1));
		
	}
}
