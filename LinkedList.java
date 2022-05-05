
class LinkedList

{
    int node;
    LinkedList next;
    StringBuilder reprString = new StringBuilder();
    
    //Constructor of LinkedList Class
    LinkedList(int node, LinkedList next)
    {
        this.node = node;
        this.next = next;
    }

    //Inherited toString() Method needs to be overridden
    @Override
    public String toString()
    {
        return this.printOutList();
    }
    
    public void addListItem (int number)
    //add item to linked list, keep order of the list and put item to the right place.
    {   
        
        if (this.node > number) 
        {
            int tempNode = this.node;
            LinkedList tempNext = this.next; 

            this.node = number;
            this.next = new LinkedList(tempNode, tempNext);
            return;
            
        }
        
        else if (this.next == null)
        {
            this.next = new LinkedList(number, null);
            return;
        }

        else
        {
            this.next.addListItem(number);
        }

    }

    public boolean searchListItem(int number)
    //go through list to find number, return true if list contains number, else false
    {   
        
        if (this.node == number)
        {
            return true;
        }

        else if (this.node != number && this.next != null)
        {
            return this.next.searchListItem(number);
        }

        return false;
        
    }

    public void removeListItem(int number)
    //should remove a list item and link the item before and the next item togehter. linkage of list should remain existing
    {

        if (this.node != number && this.next != null)
        {
            this.next.removeListItem(number);
        }

        else if (this.node == number)
        {
            this.node = this.next.node;
            this.next = this.next.next;

        }

        else if (this.searchListItem(number) == false)
        {
            System.out.println("Result: Number does not exist in ListItem");;
        }

    }

    private String printOutList()
    {
        reprString.append(this.node + " -> ");
            
        if (this.next != null)
        {
            reprString.append(this.next.printOutList());
        };
        
        if (this.next == null)
        {
            reprString.append("null");

        }
       
        return reprString.toString();
    }

    public static void main (String [] args)

    {
       
    }
}
