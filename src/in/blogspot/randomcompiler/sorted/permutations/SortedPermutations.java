package in.blogspot.randomcompiler.sorted.permutations;

public class SortedPermutations {
    public static void sortedPermutations(StringBuilder input) {
        if(input == null) {
            return;
        }
        System.out.println("Before: " + input.toString());
        quickSort(input, 0, input.length()-1);
        System.out.println("After: " + input.toString());
        
        printSortedPermutations(input, new StringBuilder(input.toString()), 0);
    }

    private static void printSortedPermutations(StringBuilder input, StringBuilder permute, int fixIndex) {
        for(int i=0; i<input.length(); i++) {
            permute.setCharAt(fixIndex, input.charAt(i));
            if(fixIndex == input.length()-1) {
                System.out.println(permute.toString());
            } else {
                printSortedPermutations(input, permute, fixIndex+1);
            }
        }
    }

    private static void quickSort(StringBuilder input, int start, int end) {
        if(start < end) {
            int pivot = partition(input, start, end);
            quickSort(input, start, pivot-1);
            quickSort(input, pivot+1, end);
        }
    }

    private static int partition(StringBuilder input, int start, int end) {
        int lessWritePointer = 0;
        int moreWritePointer = end;
        char pivotElement = input.charAt(end);
        for(int i=0; i<end; i++) {
            if(input.charAt(i) <= pivotElement) {
                swap(input, lessWritePointer, i);
                ++lessWritePointer;
            } else if(input.charAt(i) > pivotElement) {
                swap(input, moreWritePointer, i);
                --moreWritePointer;
            }
        }
        input.setCharAt(lessWritePointer, pivotElement);
        return lessWritePointer;
    }

    private static void swap(StringBuilder input, int i, int j) {
        char temp = input.charAt(i);
        input.setCharAt(i, input.charAt(j));
        input.setCharAt(j, temp);
    }
}
