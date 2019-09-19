package org.janchi.tests.hibernate.batchfetching;

import org.hibernate.SessionEventListener;

class StatementCounter implements SessionEventListener {
	private int counter;

	@Override
	public void transactionCompletion(boolean successful) {

	}

	@Override
	public void jdbcConnectionAcquisitionStart() {

	}

	@Override
	public void jdbcConnectionAcquisitionEnd() {

	}

	@Override
	public void jdbcConnectionReleaseStart() {

	}

	@Override
	public void jdbcConnectionReleaseEnd() {

	}

	@Override
	public void jdbcPrepareStatementStart() {

	}

	@Override
	public void jdbcPrepareStatementEnd() {

	}

	@Override
	public void jdbcExecuteStatementStart() {

	}

	@Override
	public void jdbcExecuteStatementEnd() {
		counter++;
	}

	@Override
	public void jdbcExecuteBatchStart() {

	}

	@Override
	public void jdbcExecuteBatchEnd() {

	}

	@Override
	public void cachePutStart() {

	}

	@Override
	public void cachePutEnd() {

	}

	@Override
	public void cacheGetStart() {

	}

	@Override
	public void cacheGetEnd(boolean hit) {

	}

	@Override
	public void flushStart() {

	}

	@Override
	public void flushEnd(int numberOfEntities, int numberOfCollections) {

	}

	@Override
	public void partialFlushStart() {

	}

	@Override
	public void partialFlushEnd(int numberOfEntities, int numberOfCollections) {

	}

	@Override
	public void dirtyCalculationStart() {

	}

	@Override
	public void dirtyCalculationEnd(boolean dirty) {

	}

	@Override
	public void end() {

	}

	public int getCounter() {
		return counter;
	}
}
