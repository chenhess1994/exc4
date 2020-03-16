package equiv;

import java.util.HashSet;
import java.util.Set;
/**
 * A generic class that supports the maintenance of equivalence
 * @author Idan & Chen
 *
 * @param <E>
 */
public class Equiv<E> {

	private Set<Set<E>> all = new HashSet<Set<E>>();
	
	
	/**
	 * Adding e1 and e2 to the Data Structure
	 * cases:
	 * 1. 	Data Structure is empty -> add e1,e2 to the Data Structure as is
	 * 2.	e1,e2 in the same group
	 * 3.	e1 or e2 found in one of the groups.
	 * 		in this case, it will add the one who didn't found to the one who found group
	 * 4.	e1,e2 didn't found. add them like case 1.
	 * @param e1 : Generic
	 * @param e2 : Generic
	 */
	public void add(E e1, E e2) {
		boolean found = false;
		Set<E> t1 = null, t2 = null;
		System.out.println("-------------------");

		System.out.println(e1 + " " + e2);

		if (!all.isEmpty()) {
			for (Set<E> e : all) {

				if (e.contains(e1) && e.contains(e2))
					return;

				if (e.contains(e1)) {
					found = true;
					t1 = e;
				}
				if (e.contains(e2)) {
					found = true;
					t2 = e;
				}

				if (t1 != null && t2 != null) {
					// if both already found stop the loop
					break;
				}

			} // for each

			// if e1 found
			if (t1 != null && t2 != null) {
				t1.addAll(t2);
				t2.clear();
			}
			// now, one of them is null, so we need to chain e1/2 to the found group
			else if (t1 != null)
				t1.add(e2);
			else if (t2 != null)
				t2.add(e1);

		} // !all.isEmpty()

		if (all.isEmpty() || !found) {
			System.out.println("Empty: Adding new e1,e2 set");
			t1 = new HashSet<E>();
			t1.add(e1);
			t1.add(e2);
			all.add(t1);
			System.out.println("Added: " + t1);
		}

		System.out.println(all);
	}
	/**
	 * Check if e1,e2 are in the same group
	 * @param e1 : Generic
	 * @param e2 : Generic
	 * @return
	 */
	public boolean are(E e1, E e2) {
		if (e1.equals(e2))
			return true;
		for (Set<E> e : all) {
			if (e.contains(e1) && e.contains(e2))
				return true;
		}
		return false;
	}// are

}
