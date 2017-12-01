
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Data<Type> {


	private HashMap<Type, TreeSet<Integer>> map;
	private ArrayList<Type> list;



	public Data() {

		// create the map and the list
		this.map = new HashMap<Type, TreeSet<Integer>>();
		this.list = new ArrayList<Type>();

	}


	public void insert(Type val) {

		// add the value to the list
		list.add(val);

		// if the map does not contain the added value
		// create a new HashSet
		// else get the HashSet and add the index 
		if (!map.containsKey(val)) {
			TreeSet<Integer> aSet = new TreeSet<Integer>();
			aSet.add(list.size() - 1);
			map.put(val, aSet);
		}
		else {
			map.get(val).add(list.size() - 1);
		}
	}


	/**
	 * Get a copy of the stored list.
	 * We won't return the actual list because any modification of the list 
	 * will ruin the map.
	 * @return a copy of the stored list.
	 */
	public ArrayList<Type> getCopyList() {

		return new ArrayList<Type>(list);
	}



	/**
	 * This method will use the removeFirst method to remove the given element.
	 * @param elem the deleted element.
	 */
	public void remove(Type elem) {
		removeFirst(elem);
	}


	/**
	 * This method will remove all occurrence of the given element.
	 * @param elem the deleted element.
	 */
	public void removeAll(Type elem) {
		
		// if the map does not contain the wanted element, the method will return
		if (!map.containsKey(elem))
			return;
		
		int nbrRep = map.get(elem).size();
		do {
			remove(elem);
			nbrRep--;
		} while(nbrRep != 0);
		
	}



	/**
	 * This method will remove the first occurrence of the given 
	 * element if it does exist.
	 * @param elem the deleted element.
	 */
	public void removeFirst(Type elem) {

		removeWhich(elem, true);

	}


	public void removeLast(Type elem) {

		removeWhich(elem, false);
	}


	private void removeWhich(Type elem, boolean notLast) {

		// if the map does not contain the wanted element, the method will return
		if (!map.containsKey(elem))
			return;

		// swap the first occurrence of the element with the last element
		swapWithLast(elem, notLast);


		// remove the wanted element from the list
		list.remove(list.size() - 1);
		
		// remove the element from the map if it was unique
		if (map.get(elem).isEmpty())
			map.remove(elem);
	}


	public Type getRandom() {
		return list.get((int) (Math.random() % list.size()));
	}


	private void swapWithLast(Type val, boolean notLast) {
		
		
		int indexVal;
		if (notLast)
			// first index of the given value
			indexVal = map.get(val).first();
		else
			// last index of the given value
			indexVal = map.get(val).last();

		// index of the last element of the list
		int indexLast = list.size() - 1;


		// swap the indexes in the map 
		// but do not add the index of the last element to the removed element
		map.get(val).remove(indexVal);

		map.get(list.get(indexLast)).remove(indexLast);
		map.get(list.get(indexLast)).add(indexVal);


		// swap the elements in the list
		list.set(indexVal, list.get(indexLast));
		list.set(indexLast, val);
	}





}
