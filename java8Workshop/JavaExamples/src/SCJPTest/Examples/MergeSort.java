package SCJPTest.Examples;

public class MergeSort extends Propagate {
	
	public static void main(String[] args){
		int arr[] = new int[]{5,2,4,14, 15, 3,6,9,10,8};
		int resArr[] = mergeSort(arr);
		for(int i : resArr)
		System.out.print(i + " ");
	}
	
	public static int[] mergeSort(int[] arr ){
		int length = arr.length;
		int[] sarr1 = new int[arr.length/2];
		int[] sarr2 = new int[arr.length - sarr1.length];
		for(int i=0;i<arr.length/2; ++i){
			sarr1[i] = arr[i];
		}
		for(int i= arr.length/2, j=0; i <arr.length && j < sarr2.length; ++i, ++j){
			sarr2[j] = arr[i];
		}
		
		
		if(sarr1.length == 1 || sarr2.length == 1){
			return compare(sarr1, sarr2);
		}
		else
		{
			int[] rarr1 = mergeSort(sarr1);
			int[] rarr2 = mergeSort(sarr2);
			int[] rarr = mergeSortedArr(rarr1, rarr2);
			return rarr;	
		}

//1368
//2457


	}
	public static int[] mergeSortedArr(int[] arr1, int[] arr2) {
		
		int[] resArr = new int[arr1.length +  arr2.length];	
		//for(int i=0,k=0;i<arr1.length;++i,++k)
		int i=0,j=0,k=0;
		boolean iIncl = false, jIncl = false;
		while(k < resArr.length ){
			if(i < arr1.length || j < arr2.length){
				if(arr1[i]<=arr2[j] && !iIncl){
					resArr[k] = arr1[i];
					++i;
					++k;
				}
				else if( !jIncl){
					resArr[k] = arr2[j];
					++j;
					++k;
				}
			}
			
			if( k < resArr.length){
				if(i == arr1.length && j < arr2.length)  {
					resArr[k] = arr2[j]; 
					++k; ++j;
					--i;
					iIncl = true;
				}
				else if(j == arr2.length && i < arr1.length){
					resArr[k] = arr1[i]; 
					++k; ++i;
					jIncl = true;
				}
			}
		}
		return resArr;
	}
	
	public static int[] compare(int[] arr1, int[] arr2){
		int i1=arr1[0],i2=arr2[0],i3=0;
		if(arr1.length > arr2.length && arr1.length>1)
			i3= arr1[1];
		else if (arr2.length > 1)
			i3 = arr2[1];
		int[] sortedarray = null;
		
		if(i3==0)
		{
			sortedarray = i1 < i2? new int[]{i1,i2}: new int[]{i2,i1};
		}
		else{
			sortedarray = new int[3];
			if(i1 < i2 && i1 < i3 && i2 < i3){
				sortedarray = new int[]{i1, i2, i3};
				// i1 - i2 - i3
			}
			else if(i1 < i2 && i1 < i3 && i3 < i2){
				// i1 - i3 - i2
				sortedarray = new int[]{i1, i3, i2};
			}
			else if(i3 < i1 && i3 < i2 && i1 < i2 ){
				// i3 - i1 - i2
				sortedarray = new int[]{i3, i1, i2};
			}
			else if(i3 < i1 && i3 < i2 && i1 < i2){
				// i3 - i2 - i1
				sortedarray = new int[]{i3, i2, i1};
			}
			else if(i2 < i1 && i2 < i3 && i1 < i3){
				// i2 - i1 - i3
				sortedarray = new int[]{i2, i1, i3};
			}
			else if(i2 < i1 && i2 < i3 &&  i3 < i1){
				// i2 - i3 - i1
				sortedarray = new int[]{i2, i3, i1};
			}

		}
		return sortedarray;
	}
}
//2-3-4-5
//6-8-9-10