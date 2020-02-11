
import java.util.Arrays;

/**@author wyatt
 *@version 12/3/19
 * sort class
 */
public class Sort 
{
    public static <E> long bubbleSort(E[] arr, Comparator comp)
    {
        try
        {
            long startTime = System.currentTimeMillis();
            long elapsedTime = System.currentTimeMillis() - startTime;
            long timeCheck = 1;
            for (int i = 0; i < arr.length; i++) 
            {
                elapsedTime = System.currentTimeMillis() - startTime;
                for (int j = 0; j < arr.length - (i+1); j++) 
                {
                    elapsedTime = System.currentTimeMillis() - startTime;
                    if(elapsedTime > 120000)
                    {
                        timeCheck = -1;
                        break;
                    }
                    E one = arr[j];
                    E two = arr[j+1];
                    if(comp.compare(one, two) > 0)
                    {
                        E temp = one;
                        arr[j] = two;
                        arr[j+1] = temp;
                    }
                }
                if(timeCheck == -1)
                    break;
            }
            if(timeCheck == -1)
                return timeCheck;
            else
                return System.currentTimeMillis() - startTime;
        }
        catch(OutOfMemoryError e)
        {
            return -1;
        }
        
    }
    public static <E> long enhancedBubbleSort(E[] arr, Comparator comp)
    {
        try
        {
            long startTime = System.currentTimeMillis();
            long elapsedTime = System.currentTimeMillis() - startTime;
            int timeCheck = 1;
            for (int i = 0; i < arr.length; i++) 
            {
                int changes = 0;
                for (int j = 0; j < arr.length - (i + 1); j++) 
                {
                    elapsedTime = System.currentTimeMillis() - startTime;
                    if(elapsedTime > 120000)
                    {
                        timeCheck = -1;
                        break;
                    }
                    E one = arr[j];
                    E two = arr[j+1];
                    if(comp.compare(one, two) > 0)
                    {
                        E temp = one;
                        arr[j] = two;
                        arr[j+1] = temp;
                        changes++;
                    }
                }
                if(timeCheck == -1)
                    break;
                if(changes == -1)
                {
                    break;
                }
            }
            if(timeCheck == -1)
                return timeCheck;
            else
                return System.currentTimeMillis() - startTime;
        }
        catch(OutOfMemoryError e)
        {
            return -1;
        }
    }
    public static <E> long insertionSort(E[] arr, Comparator comp)
    {
        try
        {
            long startTime = System.currentTimeMillis();
            int timeCheck = 1;
            for (int i = 0; i < arr.length; i++) 
            {
                E temp = arr[i];
                for (int j = i -1 ; j > 0; j--) 
                {
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    if(elapsedTime > 120000)
                    {
                        timeCheck = -1;
                        break;
                    }
                    E two = arr[j];
                    if(comp.compare(temp, two) > 0)
                    {
                        E x = temp;
                        arr[i] = two;
                        arr[j] = temp;
                    }
                }
                if(timeCheck == -1)
                    break;
            }
            if(timeCheck == -1)
                return timeCheck;
            else
                return System.currentTimeMillis() - startTime;
        }
        catch(OutOfMemoryError e)
        {
            return -1;
        }
    }
    public static <E> long selectionSort(E[] arr, Comparator comp)
    {
        try
        {
            long startTime = System.currentTimeMillis();
            int timeCheck = 1;
            for (int i = 0; i < arr.length; i++) 
            {
                E min = arr[i];
                for (int j = i; j < arr.length; j++) 
                {
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    if(elapsedTime > 120000)
                    {
                        timeCheck = -1;
                        break;
                    }
                    if(comp.compare(min, arr[j]) > 0)
                    {
                        E temp = arr[j];
                        arr[j] = min;
                        arr[i] = temp;
                    }
                }
                if(timeCheck == -1)
                    break;
            }
            if(timeCheck == -1)
                return timeCheck;
            else
                return System.currentTimeMillis() - startTime;
        }
        catch(OutOfMemoryError e)
        {
            return -1;
        }
    }
    /*public static <E> long quickSort(E[] arr, Comparator comp)
    {
        try
        {
            long startTime = System.currentTimeMillis();
            Queue<E> temp = new LinkedQueue<>();
            for (int i = 0; i < arr.length; i++) 
            {
                temp.enqueue(arr[i]);
            }
            int n = arr.length;
            if(n < 2) return 0; 
            E pivot = arr[0];
            Queue<E> one = new LinkedQueue<>();
            Queue<E> two = new LinkedQueue<>();
            Queue<E> three = new LinkedQueue<>();
            while(temp.isEmpty())
            {
                long elapsedTime = System.currentTimeMillis() - startTime; 
                if(elapsedTime > 120000)
                {
                    return -1;
                }
                E e = temp.dequeue();
                int c = comp.compare(e, pivot);
                if(c < 0)
                    one.enqueue(e);
                else if(c == 0)
                    two.enqueue(e);
                else
                    three.enqueue(e);
            }
            E[] arrOne = (E[]) (E) new Object[one.size()];
            for (int i = 0; i < arrOne.length; i++) 
            {
                arrOne[i] = temp.dequeue();
            }
            quickSort(arrOne, comp);
            E[] arrThree = (E[]) (E) new Object[three.size()];
            for (int i = 0; i < arrThree.length; i++) 
            {
                arrThree[i] = three.dequeue();
            }
            quickSort(arrThree, comp);
            while(!one.isEmpty())
                temp.dequeue();
            while(!two.isEmpty())
                temp.dequeue();
            while(!three.isEmpty())
                temp.dequeue();
            return System.currentTimeMillis() - startTime;
        }
        catch(OutOfMemoryError e)
        {
            return -1;
        }
    }*/
    public static <E> E[] mergeSort(E[] arr, Comparator comp)
    {
        try
        {
            int n = arr.length;
            if(n < 2) return arr;
            int mid = n/2;
            E[] S1 = Arrays.copyOfRange(arr, 0, mid);
            E[] S2 = Arrays.copyOfRange(arr, mid, n);
            mergeSort(S1, comp);
            mergeSort(S2, comp);
            merge(S1, S2, arr, comp);
            return arr;
        }
        catch(OutOfMemoryError e)
        {
            return arr;
        }
    }
    public static <E> void merge(E[] S1, E[] S2, E[] arr, Comparator comp)
    {
        int i = 0;
        int j = 0;
        while(i + j < arr.length)
        {
            if(j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                arr[i + j] = S1[i++];
            else
                arr[i + j] = S2[j++];
        }
    }
}
