/**
  @author Tony Nguyen cs251

  LineSorter takes two arguments, the first is the input file 
  and second is the output file.
  program opens buffer stream to first file, reads and sorts
  lines of string from longest length to shortest, outputs
  to output file given.


 */


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LineSorter {


  public static void main(String[] args) throws IOException {

    List<String> list = new ArrayList<>();

    try(
        BufferedReader in = new BufferedReader( new FileReader( args[0] ));
        PrintWriter out = new PrintWriter( new FileWriter( args[1] ))) {

      String line;
      while((line = in.readLine()) != null) {
        list.add(line);
      }

      Collections.sort( list , new Comparator<String>(){

          /**
            redefining comparison according to length,
            lowest length given higher precedence in the list
            so it will print from highest length to lowest.
           */ 
          @Override
          public int compare(String s1, String s2){
          if( s1.length() > s2.length()){
          return -1;
          } else if( s1.length() < s2.length()){
          return 1;
          } else {
          return s1.compareTo(s2); 
          }



          }

      }); 

      for(String temp : list){

        out.println(temp);    
      }
    }








  }

















}
