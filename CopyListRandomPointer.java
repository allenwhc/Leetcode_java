import java.util.HashMap;

public class CopyListRandomPointer{
	public static class RandomListNode {
		int label;
		RandomListNode next,random;
		RandomListNode(int x){this.label=x;}
	}

	public static RandomListNode copyRandomList(RandomListNode head){
		if(head==null) return head;
		HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();

		//1. Copy each and every node in list and map into hash table
		RandomListNode original=head;
		RandomListNode copy=null;
		while(original!=null){
			copy=new RandomListNode(original.label);
			map.put(original,copy);
			original=original.next;
		}

		//2. Connect nodes in hash table
		for(RandomListNode origin:map.keySet()){
			copy=map.get(origin);
			copy.next=map.get(origin.next);
			copy.random=map.get(origin.random);
		}

		return map.get(head);
	}

	public static void printList(RandomListNode head){
		System.out.println("The randomly singly-linked list is: ");
		int i=1;
		while(head!=null){
			System.out.print("Node "+i+", label: "+head.label+", ");
			if(head.next==null)
				System.out.print("next node: null, ");
			else
				System.out.print("next node: "+head.next.label+", ");
			System.out.print("randomly pointed node: "+head.random.label);
			System.out.println();
			head=head.next;
			i++;
		}
	}

	public static void main(String[] args) {
		RandomListNode head=new RandomListNode(1);
		RandomListNode print=head, tail=head;
		RandomListNode n1=new RandomListNode(2);
		tail.next=n1;
		tail=tail.next;
		RandomListNode n2=new RandomListNode(3);
		tail.next=n2;
		tail=tail.next;
		RandomListNode n3=new RandomListNode(4);
		tail.next=n3;
		tail=tail.next;
		RandomListNode n4=new RandomListNode(5);
		tail.next=n4;
		tail=tail.next;
		RandomListNode n5=new RandomListNode(6);
		tail.next=n5;
		tail=tail.next;

		//Assign random pointers
		head.random=n2;
		n1.random=head;
		n2.random=n1;
		n3.random=n5;
		n4.random=n2;
		n5.random=head;

		printList(head);
		System.out.println("After copying: ");
		printList(copyRandomList(head));
	}
}