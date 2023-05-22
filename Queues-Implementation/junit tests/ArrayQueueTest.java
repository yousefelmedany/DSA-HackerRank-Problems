import junit.framework.TestCase;

public class ArrayQueueTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testDequeue() {
			ArrayQueue queue =new ArrayQueue();
			queue.enqueue(5);
			queue.enqueue(4);
			queue.enqueue(3);
			Object tmp =queue.dequeue();
			assertEquals(5,tmp);
	}

	public final void testIsEmpty() {
		ArrayQueue queue =new ArrayQueue();
		queue.enqueue(5);
		queue.enqueue(4);
		queue.dequeue();
		boolean check=queue.isEmpty();
		assertEquals(false,check);
	}

	public final void testSize() {
		ArrayQueue queue =new ArrayQueue();
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(3);
		int tmp =queue.size();
		assertEquals(3,tmp);
	}

}
