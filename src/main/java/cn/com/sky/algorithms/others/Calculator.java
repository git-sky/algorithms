package cn.com.sky.algorithms.others;

/**  
 * 大整数相加
 *   
 */  
public class Calculator {   
  
    /**  
     * use the recursion to add the big integer.  
     *   
     * @param num1  
     * @param num2  
     * @param isCarry  
     * @param result  
     */  
    public static void addBigInt(StringBuffer num1, StringBuffer num2, int pos,   
            boolean isCarry, StringBuffer result) {   
        if (pos < num1.length() || pos < num2.length()) {   
            int value = 0;   
            if (isCarry) {   
                value++;   
            }   
            char temp1 = pos < num1.length() ? num1.charAt(pos) : '0';   
            char temp2 = pos < num2.length() ? num2.charAt(pos) : '0';   
            value += add(temp1, temp2);   
            if (value >= 10) {   
                isCarry = true;   
                value -= 10;   
            } else {   
                isCarry = false;   
            }   
            result.append(value);   
            addBigInt(num1, num2, ++pos, isCarry, result);   
        } else {   
            if (isCarry) {   
                result.append('1');   
                addBigInt(num1, num2, ++pos, false, result);   
            }   
        }   
  
    }   
  
    /**  
     * add method for big number.  
     * @param num1  
     * @param num2  
     */  
    public static String addBigInt(StringBuffer num1, StringBuffer num2) {   
        StringBuffer result = new StringBuffer();   
  
        num1.reverse();   
        num2.reverse();   
  
        addBigInt(num1, num2, 0, false, result);   
  
        result.reverse();   
  
        return result.toString();   
    }   
  
    // array to priorly store all the data.   
    private static int add(char num1, char num2) {   
        return Integer.parseInt(String.valueOf(num1))   
                + Integer.parseInt(String.valueOf(num2));   
    }  
    
    public static void main(String args[]){
    	System.out.print(addBigInt(new StringBuffer("1211111111111111112222222222222222222222222222222222222222222222222222222222222222"),new StringBuffer("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000")));
    }
}  
