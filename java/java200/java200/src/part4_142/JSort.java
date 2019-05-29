package part4_142;

public class JSort {
	public static void QuickSort(int[] nn, int start, int end) {
		int left = start;
		int right = end;
		int mid = nn[(start+end)/2];
		
		do {
			while ((nn[left]<mid) && (left < end)) {
				left++;
			}
			
			while ((mid<nn[right]) && (right > start)) {
				right--;
			}
			
			if (left <= right) {
				int temp = nn[left];
				nn[left] = nn[right];
				nn[right] = temp;
				left++;
				right--;
			}
		} while (left < right);
		
		if (start < right) {
			QuickSort(nn, start, right);
		}
		
		if (left < end) {
			QuickSort(nn, left, end);
		}
	}
	
	public static void QuickSort(int[] n) {
		QuickSort(n, 0, n.length-1);
	}
	
	public static void print(int[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + "");
		}
		System.out.println();
	}
}
