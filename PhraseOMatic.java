public class PhraseOMatic{

	public static void main(String args[]){
	
	String[] wordList1 = {"one1","one2","one3","one4"};
	String[] wordList2 = {"two1","two2","two3","two4"};
	String[] wordList3 = {"three1","three2","three3","three4"};

	int length1 = wordList1.length;
	int length2 = wordList2.length;
	int length3 = wordList3.length;

	int rand1 = (int)(Math.random()*length1);
	int rand2 = (int)(Math.random()*length2);
	int rand3 = (int)(Math.random()*length3);
	
	String phrase = wordList1[rand1] + " " + wordList2[rand2] + " " + wordList3[rand3];
	
	System.out.println(phrase);
	
	for(int x=0;x<10;x++){
	System.out.println(Math.random()*length1);
	}

	}

}