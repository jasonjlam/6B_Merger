/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;
    int end0;
    

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }    

    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
          end0 = start1;
          usersData = recursiveMerge(start0, start1, nItems);        
    }
    
    public ArrayList<String> recursiveMerge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
          // base case if the first list is empty
          ArrayList<String> remainder = new ArrayList<String>();
          if (start0 == end0) {
              for (int i = start1; i < nItems; i++) {
                  remainder.add(usersData.get(i));          
              }
              return remainder;
          }
          else if (start1 == nItems) {
              for (int i = start0; i < end0; i++) {
                  remainder.add(usersData.get(i));          
              }
              return remainder;
          }
          // recursive case
          if (usersData.get(start0).compareTo(usersData.get(start1)) < 0){
              System.out.println(usersData.get(start0) + " if");
              
              return drop(recursiveMerge(start0 + 1, start1, nItems), usersData.get(start0));         
          }
          else {
              System.out.println(usersData.get(start1) + " else");
              return drop(recursiveMerge(start0, start1 + 1, nItems), usersData.get(start1));         
          }
        
    } 
    
    public static ArrayList<String> drop(ArrayList<String> list, String value) {
        list.add(0, value);
        return list;
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0){
                System.out.println(usersData.get(i) + ", " + usersData.get(i+1));
                return false;}
        return true;
    }
}