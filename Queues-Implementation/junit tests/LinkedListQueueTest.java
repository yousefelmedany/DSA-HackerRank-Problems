import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListQueueTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testDequeue() {
        LinkedListQueue queue =new LinkedListQueue();
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(3);
		Object tmp =queue.dequeue();
		assertEquals(5,tmp);
	}

	@Test
	final void testIsEmpty() {
        LinkedListQueue queue =new LinkedListQueue();
		queue.enqueue(5);
		queue.enqueue(4);
		queue.dequeue();
		boolean check=queue.isEmpty();
		assertEquals(false,check);
	}

	@Test
	final void testSize() {
        LinkedListQueue queue =new LinkedListQueue();
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(3);
		int tmp =queue.size();
		assertEquals(3,tmp);
	}

}
