import java.util.Arrays;
import java.util.ArrayList;

public class SubSortThenMerge_Sorter extends Sorter{
    /**
      Construct an instance to process the user's data
     */
    public SubSortThenMerge_Sorter( 
        ArrayList< String> usersData) {
        super(usersData);
        mySort();
    } 
    public void mySort() {
        elements = iterateSort(0, elements.size()-1);
    }
    
    public ArrayList <String> iterateSort( int indexStart, int indexEnd) {
        // tells us where the iteration starts and ends
        System.out.println("indexStart: " + indexStart + "indexEnd: " + indexEnd);
        // create a new list to hold the information
        ArrayList<String> list = new ArrayList<String>(elements.size());
        // base case
        if (indexEnd - indexStart == 1) {
            // a really scuffed way to sort a list of size 2
            if (elements.get(indexStart).compareTo(elements.get(indexEnd)) > 0) {
                list.add(elements.get(indexStart));
                list.add(elements.get(indexEnd));
            }
            // the other way a list of size 2 can be sorted
            else {
                list.add(elements.get(indexStart));
                list.add(elements.get(indexEnd));
            }
            return list;
        }
        // deprecated code with base case 1
        // if (indexEnd <= indexStart) {
            // list.add(elements.get(indexStart));
            // return list;
        // }
        // }
        else {
            // again splits it into first and second cases
            System.out.println("First list: " + (indexStart) + " to " + (indexEnd / 2));
            // adds the elements of the first list into the list, accounting for the shift in index to start at 0
            for (int i = 0;
                 i < ((indexEnd + indexStart) / 2 -indexStart) ;
                 i ++) {
                 list.add(iterateSort(indexStart, (indexEnd +indexStart) / 2).get(i));
                 }
            System.out.println("Second list: " + (indexEnd / 2) + " to " + (indexEnd));
            // adds the elements of the second list into the list, accounting for the shift in index to start at 0
            for (int i = 0;
                 i < ((indexEnd - indexStart) - ((indexEnd + indexStart) / 2 -indexStart));
                 i ++) {
                 list.add(iterateSort((indexEnd +indexStart) / 2, indexEnd).get(i));
                 }
            // constructs a merger instance with the items in the list
            Merger merger = new Merger(list); 
            // merges the list based on the two list
            merger.merge(0, (indexEnd - indexStart) / 2, indexEnd - indexStart);
            System.out.println(merger);
            // returns merger
            return merger.usersData;     
   
        }
    }   
}