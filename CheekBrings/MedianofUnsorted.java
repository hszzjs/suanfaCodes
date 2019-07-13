package com.company.CheekBrings;

/**
 * Author:   hszzjs
 * Date:     2019/3/7 10:58
 * E-mail:   hushaozhe@stu.xidian.edu.cn
 */
public class MedianofUnsorted {
    public static void Sort(int[] arr){
//        quicksort(arr,0,arr.length-1);
//        MergeSort(arr,0,arr.length-1);
//        InsertSort(arr);
//        heapSort(arr);
        BubbleSort(arr,arr.length);
    }

    /**
     * 数组快排，从两端指针进行处理
     * @param arr
     * @param left
     * @param right
     */
    public static void quicksort(int[] arr,int left,int right){
        int start=left,end=right;
        int base=arr[left];
        while (right>left){
            while (right>left && arr[right]>=base) {
                right--;
            }
            arr[left]=arr[right];
            while (right>left && arr[left]<=base) left++;
            arr[right]=arr[left];
        }
        arr[right]=base;
       if (left>start)quicksort(arr,start,left-1);
       if (end>right)quicksort(arr,right+1,end);
    }

    /**
     * 数组的归并排序，就是一分为二，两边排序合并。主要问题在于合并需要注意比较在临时数组进行排序
     * @param arr
     * @param left
     * @param right
     */
    public static void MergeSort(int[] arr,int left,int right){
        if (left>=right) return;
        int mid=(left+right)/2;
        MergeSort(arr,left,mid);
        MergeSort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr,int left,int mid,int right){
        //相较于链表可以直接插入删除，数组就需要开辟新的空间暂存数据
        int[] tmp=new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while (i<=mid && j<=right){
            tmp[k++]=arr[i]>=arr[j]?arr[j++]:arr[i++];
        }
        while (i<=mid){
            tmp[k++]=arr[i++];
        }
        while (j<=right){
            tmp[k++]=arr[j++];
        }
        i=0;
        while (left<=right){
            arr[left++]=tmp[i++];
        }
    }

    /**
     * 插入排序，就是从第二个元素开始与左边的部分进行比较，进行插入
     * @param arr
     */
    public static void InsertSort(int[] arr){
        int i,j;
        int insertNode;//要插入的数据
        for (i=1;i<arr.length;i++){//从数组中的第二个元素开始循环将数组中的元素插入
            insertNode=arr[i];
            j=i-1;
            while (j>=0 && insertNode<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=insertNode;
        }
    }

    /**
     * 冒泡排序
     * @param arr
     * @param n
     */
    public static void BubbleSort(int[] arr,int n){
        int tmp;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j+1]<arr[j]){
                    tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }

    /**
     * 堆排序：首先构建大根堆(O(n))，然后调整堆中顺序O(logn)
     * @param array
     * @return
     */
    //构建大根堆：将array看成完全二叉树的顺序存储结构
    private static int[] buildMaxHeap(int[] array){
        //从最后一个结点array.length-1的父节点(array.length-1-1)/2开始，直到根节点0，反复调整堆
        for(int i=(array.length-2)/2;i>=0;i--)
            adjustDownToUp(array,i,array.length);
        return array;
    }

    //将元素array[k]自下往上逐步调整树形结构
    private static void adjustDownToUp(int[] array,int k,int length){
        int temp=array[k];
        for (int i=2*k+1;i<length;i=2*i+1){//i为初始化为结点k的左孩子，沿结点较大的子节点向下调整
            if (i<length-1 && array[i]<array[i+1]) //取结点较大的子节点的下标
                i++;//如果结点的右孩子>左孩子，就取右孩子结点的下标
            if(temp>=array[i])//根节点>=左右子女中关键字较大者，调整结束
                break;
            else {//根节点>左右子女中关键字较大者
                array[k]=array[i];//将左右子节点中的较大值array[i]调整到双亲结点上
                k=i;//【关键】修改k值，以便继续向下调整
            }
        }
        array[k]=temp;//被调整的结点的值放入最终位置
    }

    //堆排序
    public static int[] heapSort(int[] array){
        array=buildMaxHeap(array);//初始建堆，array[0]为第一趟值最大的元素
        for (int i=array.length-1;i>=1;i--){
            int temp=array[0];//将堆顶元素和堆底元素进行交换，即得到当前最大元素正确的排序位置
            array[0]=array[i];
            array[i]=temp;
            adjustDownToUp(array,0,i);//整理，将剩余的元素整理成堆
        }
        return array;
    }

    //两个附加的函数：删除堆顶元素：先将堆的最后一个元素与堆顶元素交换，由于此时堆的性质被破坏，需要
    //对此时的根节点进行向下调整
    public static int[] deleteMax(int[] array){
        //将堆的最后一个元素与堆顶元素交换，堆底元素值设置为-999999
        array[0]=array[array.length-1];
        array[array.length-1]=-99999;
        //对此时的根节点进行向下调整
        adjustDownToUp(array,0,array.length);
        return array;
    }

    //堆的插入：先将新节点放在堆的末端，再对这个新节点执行向上调整操作
    //假设数组的最后一个元素array[array.length-1]为空，新插入的结点初始时放置在此处
    public static int[] insertData(int[] array,int data){
        array[array.length-1]=data;//将新节点放在堆的末端
        int k=array.length-1;//需要调整的结点
        int parent=(k-1)/2;//双亲结点
        while (parent>=0 && data>array[parent]){
            array[k]=array[parent];//双亲结点下调
            k=parent;
            if(parent!=0)
                parent=(parent-1)/2;//继续向上比较
            else break;//根节点已调整完毕，跳出循环
        }
        array[k]=data;//将插入的结点放到正确的位置
        return array;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,8,3,4,9,7,11,12,13,14,2,15,16,17};
        Sort(arr);
        for (int t:arr){
            System.out.println(t);
        }
    }
}
