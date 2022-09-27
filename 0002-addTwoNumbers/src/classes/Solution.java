package classes;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// l1 and l2 are linked lists and they represents reversed numbers, with each node being a digit.
    	ListNode listNode = new ListNode();
        
        //counter is made with multiplers of 10, with n zeros, as n is ListNode length
        //making copy of l1 to calculate list length
        ListNode l1Aux = l1;     
        int l1Length = listNodeLength(l1Aux);
        ListNode l2Aux = l2;
        int l2Length = listNodeLength(l2Aux);
        
        int l1Counter = addLeadingZerosToInt(l1Length);
        int l2Counter = addLeadingZerosToInt(l2Length);
        
        //cycling list nodes to convert from list node to int
        int l1Number = 0;
        int l2Number = 0;
        int auxNumber = 0;
        //l1
        while(l1!=null) {
        	auxNumber = l1.val*l1Counter;
        	l1Number += auxNumber;
        	l1=l1.next;
        }
        //l2
        while(l2!=null) {
        	auxNumber = l2.val*l2Counter;
        	l2Number += auxNumber;
        	l2=l2.next;
        }
        
        //reversing order
        l1Number = reverseNumber(l1Number);
        l2Number = reverseNumber(l2Number);
        int sum = l1Number+l2Number;
        sum = reverseNumber(sum);
        
        System.out.println(l1Number + " + "+l2Number+" = "+sum);
        
        //creating list to return
        //for sum.length { listNode.val & next }
        
    	return listNode;
    }

	private int addLeadingZerosToInt(int length) {
		int converted=1;
		for(int i=0;i<length;i++) {
			converted=converted*10;
		}
		return converted;
	}

	private int listNodeLength(ListNode list) {
		int length=0;
		while(list!=null) {
			length++;
			list=list.next;
        }
		return length;
	}
	
	public int reverseNumber(int x) {
		int reverse = 0;  
	      while(x != 0){  
	          int remainder = x % 10;  
	          reverse = reverse * 10 + remainder;  
	          x = x/10;  
	      }  
	      System.out.println("The reverse of the given number "+x+"  is: " + reverse);  
	      return reverse;
	}
}