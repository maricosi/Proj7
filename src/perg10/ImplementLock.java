package perg10;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ImplementLock implements Lock, Serializable{

	private static final long serialVersionUID = 1L;


	// Our internal helper class
	private static class Sync extends AbstractQueuedSynchronizer {

		private static final long serialVersionUID = 1L;

		// Report whether in locked state
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}


		// Acquire the lock if state is zero
		public boolean tryAcquire(int acquires) {
			assert acquires == 1; // Otherwise unused

			if(!hasQueuedPredecessors()){
				if (compareAndSetState(0, 1)) {
					setExclusiveOwnerThread(Thread.currentThread());
					
					return true;
				}
			}
			return false;

		}

		// Release the lock by setting state to zero
		protected boolean tryRelease(int releases) {
			assert releases == 1; // Otherwise unused
			if (getState() == 0) throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

	}

	// The sync object does all the hard work. We just forward to it.
	private final Sync sync = new Sync();

	public void lock(){
		sync.acquire(1);
		
	}

	public boolean tryLock(){ 
		return sync.tryAcquire(1);
	}

	public void unlock(){
		
		sync.release(1);
	}

	public Condition newCondition(){ 
		return null;
	}

	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	public boolean tryLock(long timeout, TimeUnit unit)
			throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(timeout));
	}
}
