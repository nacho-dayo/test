package sort;

import java.util.ArrayList;
import java.util.Arrays;


public class Solution {

	public static class bubbleSort {
		//冒泡排序
		  public static int[] sort (int[] array) {
		      if (array.length == 0)
		          return array;
		      for (int i = 0; i < array.length; i++)
		          for (int j = 0; j < array.length - 1 - i; j++)
		              if (array[j + 1] < array[j]) {
		                  int temp = array[j + 1];
		                  array[j + 1] = array[j];
		                  array[j] = temp;
		              }
		      return array;
		  }
	}
	
	public static class selectionSort {
		  //选择排序
		  public static int[] sort(int[] array) {
			    if (array.length == 0)
			        return array;
			    for (int i = 0; i < array.length; i++) {
			        int minIndex = i;
			        for (int j = i; j < array.length; j++) {
			            if (array[j] < array[minIndex]) 
			                minIndex = j; 
			        }
			        int temp = array[minIndex];
			        array[minIndex] = array[i];
			        array[i] = temp;
			    }
			    return array;
		  } 
	}
	
	public static class CountingSort {
		//计数排序
		public static int[] sort(int[] array) {
		    if (array.length == 0) return array;
		    int bias, min = array[0], max = array[0];
		    for (int i = 1; i < array.length; i++) {
		        if (array[i] > max)
		            max = array[i];
		        if (array[i] < min)
		            min = array[i];
		    }
		    bias = 0 - min;
		    int[] bucket = new int[max - min + 1];
		    Arrays.fill(bucket, 0);
		    for (int i = 0; i < array.length; i++) {
		        bucket[array[i] + bias]++;
		    }
		    int index = 0, i = 0;
		    while (index < array.length) {
		        if (bucket[i] != 0) {
		            array[index] = i - bias;
		            bucket[i]--;
		            index++;
		        } else
		            i++;
		    }
		    return array;
		}
	}
	public static class RadixSort {
		//基数排序
	public static int[] sort(int[] array) {
		    if (array == null || array.length < 2)
		        return array;
		    int max = array[0];
		    for (int i = 1; i < array.length; i++) {
		        max = Math.max(max, array[i]);
		    }
		    int maxDigit = 0;
		    while (max != 0) {
		        max /= 10;
		        maxDigit++;
		    }
		    int mod = 10;
		    int div = 1;
		    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
		    for (int i = 0; i < 10; i++)
		        bucketList.add(new ArrayList<Integer>());
		    for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
		        for (int j = 0; j < array.length; j++) {
		            int num = (array[j] % mod) / div;
		            bucketList.get(num).add(array[j]);
		        }
		        int index = 0;
		        for (int j = 0; j < bucketList.size(); j++) {
		            for (int k = 0; k < bucketList.get(j).size(); k++)
		                array[index++] = bucketList.get(j).get(k);
		            bucketList.get(j).clear();
		        }
		    }
		    return array;
		}	
	}
	
	public static void main(String[] args)
	{
		int[] arr1 = {74,2,46,53,16,38,42,70,9,16,74,47,65,41,50,54,63,49,39,20,19,12,47,39,66,32,26,10,39,59,26,31,59,70,34,25,58,75,14,18,9,38,63,72,29};
		int[] arr2 = {63,77,42,30,34,61,80,44,26,37,60,8,61,69,45,38,13,26,48,34,59,71,10,52,35,58,59,24,39,2,3,53,77,44,33,29,23,31,72,79,67,2,5,78,69};
		int[] arr3 = {48,67,33,72,33,17,81,22,57,51,8,34,61,30,23,61,31,74,56,73,58,35,46,7,57,43,24,58,46,53,77,44,38,28,67,69,75,66,41,51,68,79,3,47,27};
		int[] arr4 = {4,3,25,80,56,71,19,32,54,2,41,17,75,10,29,49,67,42,73,46,36,29,16,39,43,40,17,7,68,49,51,22,50,27,21,56,16,38,38,21,70,29,36,16,38};
		arr1 = bubbleSort.sort(arr1);
		arr2 = CountingSort.sort(arr2);
		arr3 = selectionSort.sort(arr3);
		arr4 = RadixSort.sort(arr4);
		for (int i : arr1) {
			System.out.print(i);
			System.out.print(' ');
		}System.out.println();
		for (int i : arr2) {
			System.out.print(i);
			System.out.print(' ');
		}System.out.println();
		for (int i : arr3) {
			System.out.print(i);
			System.out.print(' ');
		}System.out.println();
		for (int i : arr4) {
			System.out.print(i);
			System.out.print(' ');
		}System.out.println();
	}	
}
