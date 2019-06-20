
package studinfomgmtsys;

/**
 * The purpose of this class is to create a graph based on students' classroom averages
 * @author Ralph Julsaint
 */
public class Graph {
    /**
     * This method creates a graph based on average
     * @param average
     * @return 
     */
    String getGraph(double average){
        int grade = 0;
        String graph = null;
        
        if (average == 100.00)
            grade = 10;
        else if (average >= 90.00 && average < 100.00)
            grade = 9;
        else if (average >= 80.00 && average < 90.00)
            grade = 8;
        else if (average >= 70.00 && average < 80.00)
            grade = 7;
        else if (average >= 60.00 && average < 70.00)
            grade = 6;
        else if (average >= 50.00 && average < 60.00)
            grade = 5;
        else if (average >= 40.00 && average < 50.00)
            grade = 4;
        else if (average >= 30.00 && average < 40.00)
            grade = 3;
        else if (average >= 20.00 && average < 30.00)
            grade = 2;
        else if (average >= 10.00 && average < 20.00)
            grade = 1;
       
        switch (grade){
            case 10:
                graph = String.format("%.2f: %s%n", average, "**********");
                break;
            case 9:
                graph = String.format("%.2f: %s%n", average, "*********");
                break;
            case 8:
                graph = String.format("%.2f: %s%n", average, "********");
                break;
            case 7:
                graph = String.format("%.2f: %s%n", average, "*******");
                break;
            case 6:
                graph = String.format("%.2f: %s%n", average, "******");
                break;
            case 5:
                graph = String.format("%.2f: %s%n", average, "*****");
                break;
            case 4:
                graph = String.format("%.2f: %s%n", average, "****");
                break;
            case 3:
                graph = String.format("%.2f: %s%n", average, "***");
                break;
            case 2:
                graph = String.format("%.2f: %s%n", average, "**");
                break;
            case 1:
                graph = String.format("%.2f: %s%n", average, "*");
                break;
            default:
                graph = String.format("%.2f: %s%n", average, "");
        }
        return graph;      
    }    
}
