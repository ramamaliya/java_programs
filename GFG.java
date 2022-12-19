import java.util.*;
import java.util.Scanner;  

public class GFG {

	// Driver Code
	public static void main(String[] args)
	{

		// Declare and Initialize an array
		
		int n;  
try (Scanner sc = new Scanner(System.in)) {
	System.out.print("Enter the number of elements you want to store: ");  
	//reading the number of elements from the that we want to enter  
	n=sc.nextInt();  
	//creates an array in the memory of length 10  
	int[] array = new int[n];  
	System.out.println("Enter the elements of the array: ");  
	for(int i=0; i<n; i++)  
	{  
	//reading array elements from the user   
	array[i]=sc.nextInt();  
	}  
	
	
			Map<Integer, Integer> map = new HashMap<>();
			List<Integer> outputArray = new ArrayList<>();
	
			// Assign elements and their count in the list and map
			for (int current : array) {
				int count = map.getOrDefault(current, 0);
				map.put(current, count + 1);
				outputArray.add(current);
			}
	
			// Compare the map by value
			SortComparator comp = new SortComparator(map);
	
			// Sort the map using Collections CLass
			Collections.sort(outputArray, comp);
	
			// Final Output
			for (Integer i : outputArray) {
				System.out.print(i + " ");
			}
}
	}
}

// Implement Comparator Interface to sort the values
class SortComparator implements Comparator<Integer> {
	private final Map<Integer, Integer> freqMap;

	// Assign the specified map
	SortComparator(Map<Integer, Integer> tFreqMap)
	{
		this.freqMap = tFreqMap;
	}

	// Compare the values
	@Override
	public int compare(Integer k1, Integer k2)
	{

		// Compare value by frequency
		int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));

		// Compare value if frequency is equal
		int valueCompare = k1.compareTo(k2);

		// If frequency is equal, then just compare by value, otherwise -
		// compare by the frequency.
		if (freqCompare == 0)
			return valueCompare;
		else
			return freqCompare;
	}
}
