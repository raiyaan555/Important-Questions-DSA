package Stack_and_Queues;

public class Circular_tour {
    int tour(int petrol[], int distance[])
    {
	// Your code here
	int start = 0;
	int requiredFuel = 0;
	int extraFuel = 0;
	for(int i=0;i<petrol.length;i++){
	    extraFuel += petrol[i]-distance[i];
	    
	    if(extraFuel<0){
	        start = i+1;
	        requiredFuel+=extraFuel;
	        extraFuel = 0;
	    }
	}
	if(requiredFuel+extraFuel>=0) return start;
	return -1;
    }
}
