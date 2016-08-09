package com.neu.Array;

public class TagSBucket {
	
	    		private boolean bValid;
	    		private int nMin;
	    		private int nMax;
	    		
	    		public TagSBucket(){
	    			   bValid = false;
	    			   nMin = 0;
	    			   nMax = 0;
	    		}
	    		
	    		/**
	    		 * Put num into bucket
	    		 * @param n
	    		 */
	    		public void Add(int n){ 
	    			   if(!bValid){
	    				      nMin = nMax = n;
	    				      bValid = true;
	    			   }else{
	    				      if(nMax  < n){
	    				    	     nMax = n;
	    				      }else if(nMin > n){
	    				    	     nMin = n;
	    				      }
	    			   }
	    		}

				public int getnMin() {
					return nMin;
				}

				public void setnMin(int nMin) {
					this.nMin = nMin;
				}

				public int getnMax() {
					return nMax;
				}

				public void setnMax(int nMax) {
					this.nMax = nMax;
				}

				public boolean isbValid() {
					return bValid;
				}

				public void setbValid(boolean bValid) {
					this.bValid = bValid;
				} 		
}
