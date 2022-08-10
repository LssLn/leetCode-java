package classes;

class Solution {
   /* Given a String which can contain only one between these character('I', 'V', 'X', 'L', 'C', 'D', 'M')
    * returns the associated integer
    */
    public int convert(String c){
    	int i=0;
    	
        switch(c) {
        case "I":
        	i= 1;
        	break;
        case "V":
        	i= 5;
        	break;
        case "X":
        	i= 10;
        	break;
        case "L":
        	i= 50;
        	break;
        case "C":
        	i= 100;
        	break;
        case "D":
        	i= 500;
        	break;
        case "M":
        	i= 1000;
        	break;
        }
        return i;
    }
    

    /* Given a String that can be made of only these characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')
     * returns the converted integer
     */
    public int romanToInt(String s) {
    	int result=0;
    	
        
        /* check if string contains minus case. 
         * If it does, return the calculated int with minus. The next char is skipped
         * If it does not, execute basic conversation.
         * 
         * There are six instances where subtraction is used:
			I can be placed before V (5) and X (10) to make 4 and 9. 
			X can be placed before L (50) and C (100) to make 40 and 90. 
			C can be placed before D (500) and M (1000) to make 400 and 900.
         */
        for(int j=0; j<s.length(); j++) {
        	String cCurrent = "" + s.charAt(j);
            String cNext = "";
        	if(j == s.length()-1) { //cNext is equal to cCurrent, last char in the String
        		cNext=cCurrent;
        	}else {
            	cNext = "" + s.charAt(j+1);
        	}
            
        	switch(cCurrent) {
        	//	I before V (5) and X (10) to make 4 and 9. 
	        	case "I":
	        		if("V".equals(cNext)) { // IV = 5 - 1
	        			result += 4;
	        			j++;
	        		}
	        		else if("X".equals(cNext)) { // IX = 10 -1
	        			result += 9;
	        			j++;
	        		}else { // no minus case - basic conversion
	        			int intCurrent = convert(cCurrent);
		                if(intCurrent!=0) {
		                    result += intCurrent;
		                }
	        		}
	        		break;
	        // X before L (50) and C (100) to make 40 and 90. 
	        	case "X":
	        		if("L".equals(cNext)) { // XL = 50 - 10
	        			result += 40;
	        			j++;
	        		}
	        		else if("C".equals(cNext)) { // IX = 100 - 10
	        			result += 90;
	        			j++;
	        		}else { // no minus case - basic conversion
	        			int intCurrent = convert(cCurrent);
		                if(intCurrent!=0) {
		                    result += intCurrent;
		                }
	        		}
	        		break;
	        // C before D (500) and M (1000) to make 400 and 900.
	        	case "C":
	        		if("D".equals(cNext)) { // XL = 500 - 100
	        			result += 400;
	        			j++;
	        		}
	        		else if("M".equals(cNext)) { // IX = 1000 - 100
	        			result += 900;
	        			j++;
	        		}else { // no minus case - basic conversion
	        			int intCurrent = convert(cCurrent);
		                if(intCurrent!=0) {
		                    result += intCurrent;
		                }
	        		}
	        		break;
	        	default:
	                int intCurrent = convert(cCurrent);
	                if(intCurrent!=0) {
	                    result += intCurrent;
	                }
	                break;

        	}

        }
        
        return result;
    }
}