package Stack_and_Queues;

public class Custom_Queues {
    private static final int DEFAULT_SIZE = 10;
    private int[] data;

    int end = 0;

    public Custom_Queues() {
        this(DEFAULT_SIZE);
    }

    public Custom_Queues(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item){
        if(end ==data.length){
            return false;
        }

        data[end++] = item;
        return true;

    }

    public int remove() throws Exception{
        if(end<0){
            throw new Exception("Cannot remove empty Queue");
        }
        int rem = data[0];

        for(int i = 1; i<end; i++){
            data[i-1] = data[i];
        }
        end--;

        return rem;
    }

    public static void main(String[] args) throws Exception {
    Custom_Queues que = new Custom_Queues(5);

    que.insert(1);
    que.insert(2);
    que.insert(3);
    que.insert(4);
    que.insert(5);

    System.out.println(que.remove());
    System.out.println(que.remove());
    System.out.println(que.remove());
    System.out.println(que.remove());
    System.out.println(que.remove());
  
    
    

    }
}
