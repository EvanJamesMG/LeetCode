
/*
ά��һ������Ϊk��window, ÿ�μ���µ�ֵ�Ƿ���ԭ�������е�����ֵ�Ĳ�ֵ��С�ڵ���t��.���������forѭ���ᳬʱO(nk). 
ʹ��treeset( backed by binary search tree) ��subSet����,���Կ�������. ���Ӷ�Ϊ O(n logk)
*/
/*	 public class Solution {
	     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	         if(k < 1 || t < 0)
	             return false;
	         TreeSet<Integer> set = new TreeSet<Integer>();
	         for(int i = 0; i < nums.length; i++){
	             int n = nums[i];
	             if(set.floor(n) != null && n <= t + set.floor(n) || 
	                     set.ceiling(n) != null && set.ceiling(n) <= t + n)
	                 return true;
	             set.add(n);
	             if (i >= k)
	                 set.remove(nums[i - k]);
	         }
	         return false;
	     }
	 }*/

	import java.util.SortedSet; 
	public class test {
	    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
	    	if (k < 1 || t < 0)
	    		return false;
	     
	    	SortedSet<Long> set = new TreeSet<Long>();
	     
	    	for (int j = 0; j < nums.length; j++) {
	    		long leftBoundary = (long) nums[j] - t;
	    		long rightBoundary = (long) nums[j] + t + 1;
	    		SortedSet<Long> subSet = set.subSet(leftBoundary, rightBoundary);//�Ƿ��ؼ��ϵĸߵ�(������)��
	     
	    		if (!subSet.isEmpty())
	    			return true;
	     
	    		set.add((long) nums[j]);
	     
	    		if (j >= k) {
	    			set.remove((long) nums[j - k]);
	    		}
	    	}
	     
	    	return false;
	    }
	}

