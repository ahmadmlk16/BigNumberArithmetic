
/**
 * class that handles the addition, multiplication and exponents
 * 
 * @author omaralshikh, ahmad malik
 * @version 7/10/2020
 */
public class Operator {

    /**
     * Addition method that performs addition between two numbers represented in
     * Linked Lists. This method covers multiple cases which include handling
     * the
     * carry case
     *
     * @param num1
     *            first number to be added
     * @param num2
     *            second number to be added
     * @return LinkedList<Integer> the result the result obtained from the
     *         addition
     *         represented as a LinkedList.
     */
    public static LinkedList<Integer> addition(
        LinkedList<Integer> num1,
        LinkedList<Integer> num2) {

        /*
         * result will represent the result obtained from performing the
         * operation
         */
        LinkedList<Integer> result = new LinkedList<Integer>();

        /* Get the size of the numbers given */
        int size1 = num1.size();
        int size2 = num2.size();

        /*
         * Iterator will be used to determine how man time the a for loop needs
         * to
         * iterate between the linked Lists to successfully perform the addition
         */
        int iterator = size1;
        /* Iterator is set to the the size of the larger number */
        if (size2 > size1) {
            iterator = size2;
        }

        /*
         * n1 and n2 will be used to represent each number in the Linked Lists
         */
        Integer n1;
        Integer n2;
        /* The addition of n1 and n2 will be stored into r */
        Integer r;
        /*
         * Will be used to as a carry of the addition performed between n1 and
         * n2
         */
        Integer carry = 0;

        /*
         * Loop through the linked lists adding each individual number and
         * carrying a
         * carry as necessary
         */
        for (int i = 0; i < iterator; i++) {

            /* Obtain n1 and n2 */
            n1 = num1.get(i);
            n2 = num2.get(i);

            /*
             * if n2 is a larger number then n1(by tens) then n1 will be null
             * towards the
             * end of the for loop
             */
            if (n1 == null) {
                /*
                 * Add carry from previous loop iteration to result as well as
                 * n2
                 */
                r = n2 + carry;
                /* add r mod 10 into the result LinkedList */
                result.add(r % 10);
                /* Reset the carry to zero */
                carry = 0;

                /*
                 * If r is greater then 9 then another carry needs to be stored
                 * for the next
                 * iteration
                 */
                if (r > 9) {
                    /* Set the carry */
                    carry = (r % 100) / 10;
                    /*
                     * If this is the last loop iteration add the carry to the
                     * result Linked List
                     */
                    if (i == iterator - 1) {
                        result.add(carry);
                    }
                }

            }
            /*
             * if n1 is a larger number then n2(by tens) then n3 will be null
             * towards the
             * end of the for loop
             */
            else if (n2 == null) {
                /*
                 * Add carry from previous loop iteration to result as well as
                 * n1
                 */
                r = n1 + carry;
                /* add r mod 10 into the result LinkedList */
                result.add(r % 10);
                /* Reset the carry to zero */
                carry = 0;
                /*
                 * If r is greater then 9 then another carry needs to be stored
                 * for the next
                 * iteration
                 */
                if (r > 9) {
                    /* Set the carry */
                    carry = (r % 100) / 10;
                    /*
                     * If this is the last loop iteration add the carry to the
                     * result Linked List
                     */
                    if (i == iterator - 1) {
                        result.add(carry);
                    }
                }
            }
            /* If both n1 and n2 exist */
            else {
                /*
                 * Add carry from previous loop iteration to result as well as
                 * n1 and n2
                 */
                r = n1 + n2 + carry;
                /* add r mod 10 into the result LinkedList */
                result.add(r % 10);
                /* Reset the carry to zero */
                carry = 0;
                /*
                 * If r is greater then 9 then another carry needs to be stored
                 * for the next
                 * iteration
                 */
                if (r > 9) {
                    /* Set the carry */
                    carry = (r % 100) / 10;
                    /*
                     * If this is the last loop iteration add the carry to the
                     * result Linked List
                     */
                    if (i == iterator - 1) {
                        result.add(carry);
                    }
                }
            }

        }
        /* Return the result represented in a linked list */
        return result;
    } // end addition


    /**
     * 
     * Multiplication method that performs multiplication between two numbers
     * represented in Linked Lists. This method covers multiple cases which
     * include
     * handling the carry case
     * 
     * @param num1
     *            first number to be multiplied
     * @param num2
     *            second number to be multiplied
     * @return LinkedList<Integer> LinkedList of multiplied number
     */
    @SuppressWarnings("unchecked")
    public static LinkedList<Integer> multi(
        LinkedList<Integer> num1,
        LinkedList<Integer> num2) {

        /*
         * result will represent the result obtained from performing the
         * operation
         */
        LinkedList<Integer> result = new LinkedList<Integer>();

        /* Get the size of the numbers given */
        int size1 = num1.size();
        int size2 = num2.size();
        /* Will be used to as a carry of the multiplication performed */
        Integer carry = 0;

        /*
         * Size1 will be used by default for the number of times a for loop will
         * iterate
         * through the two linked list of numbers to perform the Multiplication.
         * However
         * if size2 is greater then size1 then these two linked lists need to be
         * swapped
         * with the use of a temp linked list
         */
        if (size2 > size1) {
            int temp = size1;
            size1 = size2;
            size2 = temp;
            LinkedList<Integer> tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        /*
         * This Stack will contain all of the Linked Lists of numbers to be
         * added. This
         * is the same as when multiplication is done by hand. After the
         * multiplication
         * all of the resultant numbers need to be added to obtain the final
         * result.
         */
        @SuppressWarnings("rawtypes")
        Stack<LinkedList> numbersToAdd = new Stack<LinkedList>();

        /*
         * This int will keep track of the amount of numbers in the numbersToAdd
         * Stack
         */
        int numOfNumbersToAdd = 0;

        /* Iterate through the Linked Lists to multiply */
        for (int i = 0; i < size1; i++) {
            /*
             * This List is used for the current result which is obtained
             * through each
             * iteration
             */
            LinkedList<Integer> multLine = new LinkedList<Integer>();

            /*
             * Add the trailing zeros to multLine in each iteration an
             * additional zero is
             * added
             */
            if (i > 0) {
                for (int k = 0; k < i; k++) {
                    multLine.add(0);
                }
            }

            /*
             * Uses a nested for loop to iterate through each multiplication
             * cycle
             */
            for (int j = 0; j < size2; j++) {
                /*
                 * res contains each result from each multiplication between two
                 * numbers
                 */
                int res = num1.get(i) * num2.get(j);
                /* Add carry to the res */
                res = res + carry;
                /* reset the carry */
                carry = 0;
                /*
                 * If the result is greater then 9 a new carry needs to be set
                 * for the next
                 * iteration
                 */
                if (res > 9) {
                    carry = (res % 100) / 10;
                    res = res % 10;
                }
                /* Add the res into multLine */
                multLine.add(res);
                if (j == size2 - 1 && carry != 0) {
                    multLine.add(carry);
                    carry = 0;
                }
            }
            /*
             * For each iteration of the outer for loop push multLine to numbers
             * to add
             */
            numbersToAdd.push(multLine);
            /* update numOfNumbersToAdd */
            numOfNumbersToAdd++;
        }

        /*
         * After all of the multiplication operations have been completed, all
         * numbers
         * in the numbersToAdd stack need to be added
         */

        /* If numbersToAdd only contains 1 number return that number */
        if (numOfNumbersToAdd == 1) {
            return numbersToAdd.pop();
        }
        /*
         * Iterate through the numbersToAdd stack and call the Addition method
         * to add
         * them all
         */
        for (int s = 0; s < numOfNumbersToAdd - 1; s++) {
            /* first number to be added */
            LinkedList<Integer> n1 = new LinkedList<Integer>();
            /* second number to be added */
            LinkedList<Integer> n2 = new LinkedList<Integer>();

            /* Pop two numbers from the stack */
            n1 = numbersToAdd.pop();
            n2 = numbersToAdd.pop();

            /* calculate the result using the addition method */
            result = addition(n1, n2);
            /* Push the result back into the numbersToAdd stack */
            numbersToAdd.push(result);

        } // for loop for adding in multi

        /*
         * When there is only one number left in the Stack return it as the
         * result
         */
        return numbersToAdd.pop();

    } // end multi


    /**
     * Exponent method that performs num ^ pow between the given arguments
     * represented as
     * Linked Lists. This method covers multiple cases which include seperatly
     * handling
     * a power of 0, a power of 1, a power of 2 and Even power, and Odd power.
     * 
     * @param num
     *            Number to be powered
     * @param pow
     *            The power to be given
     * @return LinkedList<Integer> List with the powered number
     */
    public static LinkedList<Integer> exp(
        LinkedList<Integer> num,
        LinkedList<Integer> pow) {

        /*
         * result will represent the result obtained from performing the
         * operation
         */
        LinkedList<Integer> result = new LinkedList<Integer>();

        /* Convert the power to an Array */
        Object[] power = pow.toArray();
        /* Store length of power array */
        int length = power.length;
        /* Declare a new intArray to copy the power array to */
        Integer[] intArray = new Integer[length];
        /* copy the power array to intArray */
        System.arraycopy(power, 0, intArray, 0, length);
        /* Reverse the intArray */
        intArray = reverseIntArray(intArray);
        /* Convert the int array to an int and store into p */
        int p = toInt(intArray);

        /* If the power is 0 then add 1 to the result and return result */
        if (p == 0) {
            result.add(1);
            return result;
        }
        /*
         * If the power is 1 then return the num as 1 power will not affect the
         * num
         */
        if (p == 1) {
            return num;
        }
        /*
         * If the power is 2 then return the num multiplied by itself by calling
         * the
         * multi function
         */
        if (p == 2) {
            return multi(num, num);
        }
        /* If the power is even go into the if block */
        if (p % 2 == 0) {
            /* Make 2 copys of num */
            LinkedList<Integer> numCpy1 = num.getCopy();
            LinkedList<Integer> numCpy2 = num.getCopy();
            /* multiply the two copies and store them into newNum */
            LinkedList<Integer> newNum = multi(numCpy1, numCpy2);
            /* Divide the power by 2 */
            p = p / 2;

            /* Make another copy of num */
            LinkedList<Integer> numCpy3 = newNum.getCopy();

            /*
             * call the multi function the amount of the power to multiply
             * newNum by nums copy
             */
            for (int i = 0; i < p - 1; i++) {
                newNum = multi(newNum, numCpy3);
                result = newNum;
            }
        }
        /* If the power is odd go into the else block */
        else {
            /* Make 2 copys of num */
            LinkedList<Integer> numCpy1 = num.getCopy();
            LinkedList<Integer> numCpy2 = num.getCopy();
            /* multiply the two copies and store them into newNum */
            LinkedList<Integer> newNum = multi(numCpy1, numCpy2);
            /* Divide the power - 1 by 2 */
            p = (p - 1) / 2;

            /* Make another copy of num */
            LinkedList<Integer> numCpy3 = newNum.getCopy();

            /*
             * call the multi function the amount of the power to multiply
             * newNum by nums copy
             */
            for (int i = 0; i < p - 1; i++) {
                newNum = multi(newNum, numCpy3);
            }

            /* call the multi function once more to obtain the result */
            result = multi(newNum, num);
        }

        /* Return the result obtained */
        return result;

    } // end exp


    /**
     * This method transforms an Integer Array into an Integer e.g [1,2,3] is
     * returned as 123
     * 
     * @param array
     *            the Array be transformed to an int
     * @return int the Array transformed into an int
     */
    public static int toInt(Integer[] array) {
        /* Result will hold final int */
        int result = 0;
        /* Offset is used to perform calculations to every tenth */
        int offset = 1;
        /* Iterate through the array and add to result, while updating offset */
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i] * offset;
            offset *= 10;
        }
        /* Return the resultant int value */
        return result;
    }


    /**
     * This method reverses the contents of an array. e.g [1, 2, 3] is returned
     * as
     * [3, 2, 1]
     *
     * @param array
     *            Array to be reversed
     * @return Integer[] The Array reversed
     */
    public static Integer[] reverseIntArray(Integer[] array) {
        /* store the size of the array */
        int size = array.length;
        /* use to access the given array in reverse order */
        int counter = size - 1;
        /* Declare a new Array which will contain the reversed contents */
        Integer[] reversedArray = new Integer[size];
        /*
         * Iterate through the given array and stores its values into the
         * reversedArray
         */
        for (int i = 0; i < size; i++) {
            reversedArray[i] = array[counter];
            counter--;
        }
        /* Return a new pointer to the newly created reversedArray */
        return reversedArray;
    }


    /**
     * This method refines a fileLine given and prints it: The following cases
     * are
     * refined: Leading zeros in numbers are removed. Unnecessary spaces are
     * removed. Leading white space's are removed.
     * 
     * @param fileLine
     *            The fileLine to be refined and printed
     */
    void splitAndPrint(String fileLine) {

        /*
         * Replace all whitespace found in the beginning and ends of the
         * fileLine. Then
         * split the fileLine into an array of individual strings. These Strings
         * are
         * split with reference to white space found between each string
         */
        String[] splited = fileLine.replaceAll("(^\\s+|\\s+$)", "").split(
            "\\s+");

        /* Iterate through the splited array to print its contents */
        for (int k = 0; k < splited.length; k++) {

            /* Remove leading zeros */
            int i = 0;
            while (i < splited[k].length() && splited[k].charAt(i) == '0'
                && splited[k].length() != 1 && !splited[k].matches("^[0]+$")) {
                i++;
            }

            /* Convert fileLine into StringBuffer as Strings are immutable. */
            StringBuffer sb = new StringBuffer(splited[k]);

            /*
             * The StringBuffer replace function removes i characters from given
             * index (0
             * here)
             */
            sb.replace(0, i, "");

            /* If the String only contains n 0's print one 0 */
            if (splited[k].matches("^[0]+$")) {
                System.out.print("0 ");
            }
            /* Otherwise print the string buffer */
            else {
                System.out.print(sb + " "); // return in String
            }
        }
    }

} // end class
