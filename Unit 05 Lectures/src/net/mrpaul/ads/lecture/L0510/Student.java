// Case Study: Student class
package net.mrpaul.ads.lecture.L0510;

/**
Represents a student with a name and several test scores
*/

public class Student{

   /**
   The minimum score (0)
   */
   public static int MIN_SCORE = 0;
   /**
   The maximum score (100)
   */
   public static int MAX_SCORE = 100;

   private String name;
   private int[] tests;   

   /**
   Default: name is "" and each of 3 scores is 0
   */
   public Student(){
      this("");
   }

   /**
   Name is nm and each of 3 scores is 0
   @param nm the name of the student
   */
   public Student(String nm){
      this(nm, 3);
   }

   /**
   Name is nm and each of n scores is 0
   @param nm the name of the student
   @param n is the number of scores, each 0
   */
   public Student(String nm, int n){
      name = nm;
      tests = new int[n];
      for (int i = 0; i < tests.length; i++)
         tests[i] = 0;
   }

   /**
   Name is nm and the scores are taken from array t
   @param nm the name of the student
   @param t an array of test scores
   */
   public Student(String nm, int[] t){
      name = nm;
      tests = new int[t.length];
      for (int i = 0; i < tests.length; i++)
         tests[i] = t[i];
   }
    
   /**
   Builds a copy of a student
   @param s the student to be copied
   */
   public Student(Student s){
      this(s.name, s.tests);
   }
    
   /**
   Changes the studentÕs name
   @param nm the new name
   */
   public void setName (String nm){
      name = nm;
   }
    
   /**
   @return the student's name
   */
   public String getName (){
      return name;
   }
    
   /**
   @param i the ith
   @param score the ith score
   @throws IllegalArgumentException if i < 1 or i > number of scores
   @throws IllegalArgumentException if score < MIN_SCORE or score > MAX_SCORE
   */
   public void setScore (int i, int score){
      if (i < 1 || i > tests.length)
         throw new IllegalArgumentException(
                   "i must be >= 1 and <= " + tests.length);
      if (score < MIN_SCORE || score > MAX_SCORE)
         throw new IllegalArgumentException(
                   "score must be >= " +
                   MIN_SCORE + " and <= " + MAX_SCORE);
      tests[i - 1] = score;
   }

   /**
   @param i the ith
   @throws IllegalArgumentException if i < 1 or i > number of scores
   @return the student's ith score
   */
   public int getScore (int i){
      if (i < 1 || i >= tests.length)
         throw new IllegalArgumentException(
                   "i must be >= 1 and <= " + tests.length);
      return tests[i - 1];
   }
   
   /**
   @return the student's average score
   */
   public int getAverage(){
      int sum = 0;
      for (int score : tests)
         sum += score;
      return sum / tests.length;
   }
    
   /**
   @return the student's highest score
   */
   public int getHighScore(){
      int highScore = tests[0];
      for (int score : tests)
         highScore = Math.max (highScore, score);
      return highScore;
   }
    
   /**
   @return the student's string representation
   */
   public String toString(){
      String str = "Name:    " + name  + "\n";
      for (int i = 0; i < tests.length; i++){
         str += "test " + i + ":  " + tests[i] + "\n";
      }
      str += "Average: " + getAverage();
      return str;
   } 

   /**
   @return null if there are no errors or an appropriate error message
   */
   public String validateData(){
      if (name.equals ("")) return "SORRY: name required";
      for (int score : tests){
         if (score < 0 || score > 100){
            String str = "SORRY: must have "+ 0
                         + " <= test score <= " + 100;  
            return str;
         }
      }
      return null;
   }  
}

