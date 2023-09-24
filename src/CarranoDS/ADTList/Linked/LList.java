package CarranoDS.ADTList.Linked;

public class LList<T> //implements ListInterface<T>
{
    private Node firstNode;
    private int length;

    public LList(){
        clear();
    }

    public final void clear(){
        firstNode = null;
        length = 0;
    }

    private Node getNodeAt(int givenPosition){
       assert !isEmpty() && (1<= givenPosition) && (givenPosition<=length);
       Node currentNode = firstNode;

       for(int count=1;count< givenPosition; count++){
           currentNode = currentNode.next;
       }
       assert currentNode!=null;

       return currentNode;
    }

    public boolean isEmpty(){
        boolean result;
        if(length==0){
            assert firstNode == null;
            result = true;
        }else{
            assert firstNode!=null;
            result = false;
        }
        return result;
    }

    public boolean add(T newEntry){
        Node newNode = new Node(newEntry);

        if(isEmpty())
            firstNode=newNode;
        else
        {
         Node lastNode = getNodeAt(length);
         lastNode.next = newNode;
        }
        length++;
        return true;
    }

    private boolean add (int  newPosition, T newEntry){
        boolean isSuccessful = true;
        if((newPosition >=1) && (newPosition <=length+1)){
            Node newNode = new Node(newEntry);
            if(isEmpty() || (newPosition==1)){
                newNode.next = firstNode;
                firstNode = newNode;
            }else{
                Node nodeBefore = getNodeAt(newPosition-1);
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                nodeBefore.next=newNode;
            }
            length++;
        }else{
            isSuccessful=false;
        }


        return isSuccessful;
    }

    public T remove(int givenPosition){
        T result = null;
        if ((givenPosition >=1) && (givenPosition <=length)){
            assert !isEmpty();
            if (givenPosition ==1)
            {
               result = (T) firstNode.data;
               firstNode = firstNode.next;
//               if(length==1)
//                   lastNode = null;
            }else{
                Node nodeBefore = getNodeAt(givenPosition-1);
                Node nodeToRemove = nodeBefore.next;
                Node nodeAfter = nodeToRemove.next;
                nodeBefore.next = nodeAfter;
                result = (T) nodeToRemove.data;
//                if(givenPosition ==length){
//                    lastNode = nodeBefore;
//                }
            }
            length--;
        }
        return result;
    }

    public boolean replace(int givenPosition, T newEntry)
    {
        boolean isSuccessful = true;
        if((givenPosition>=1) && (givenPosition <=length)){
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            desiredNode.data = newEntry;
        }else
            isSuccessful = false;

        return isSuccessful;
    }

    public T getEntry(int givenPosition)
    {
        T result = null;
        if((givenPosition>=1) && (givenPosition<=length))
        {
            assert !isEmpty();
            result = (T) getNodeAt(givenPosition).data;
        }
        return result;
    }

    public boolean contains(T anEntry){
        boolean found =false;
        Node currentNode = firstNode;

        while(!found && (currentNode!=null)){
            if(anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }

        return found;
    }

}
