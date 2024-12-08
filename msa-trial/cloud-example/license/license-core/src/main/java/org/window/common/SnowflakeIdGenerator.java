package org.window.common;

import org.springframework.stereotype.Component;

@Component
class SnowflakeIdGenerator implements SnowflakeGenerator {
  private final long epoch = 1609459200000L; // Jan 1, 2021
  private final long workerIdBits = 5L;
  private final long dataCenterIdBits = 5L;
  private final long sequenceBits = 12L;

  private final long maxWorkerId = (1L << workerIdBits) - 1;
  private final long maxDataCenterId = (1L << dataCenterIdBits) - 1;
  private final long sequenceMask = (1L << sequenceBits) - 1;

  private final long workerIdShift = sequenceBits;
  private final long dataCenterIdShift = sequenceBits + workerIdBits;
  private final long timestampShift = sequenceBits + workerIdBits + dataCenterIdBits;

  private long workerId;
  private long dataCenterId;
  private long sequence = 0L;
  private long lastTimestamp = -1L;

  public SnowflakeIdGenerator(long workerId, long dataCenterId) {
    if (workerId > maxWorkerId || workerId < 0) {
      throw new IllegalArgumentException("Worker ID must be between 0 and " + maxWorkerId);
    }
    if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
      throw new IllegalArgumentException("Data Center ID must be between 0 and " + maxDataCenterId);
    }
    this.workerId = workerId;
    this.dataCenterId = dataCenterId;
  }

  public synchronized long nextId() {
    long timestamp = System.currentTimeMillis();  // systemcall ->

    if (timestamp < lastTimestamp) {
      throw new RuntimeException("Clock moved backwards. Refusing to generate ID.");
    }

    if (timestamp == lastTimestamp) {
      sequence = (sequence + 1) & sequenceMask;
      if (sequence == 0) {
        timestamp = waitNextMillis(lastTimestamp);
      }
    } else {
      sequence = 0L;
    }

    lastTimestamp = timestamp;

    return ((timestamp - epoch) << timestampShift)
        | (dataCenterId << dataCenterIdShift)
        | (workerId << workerIdShift)
        | sequence;
  }

  private long waitNextMillis(long lastTimestamp) {
    long timestamp = System.currentTimeMillis();
    while (timestamp <= lastTimestamp) {
      timestamp = System.currentTimeMillis();
    }
    return timestamp;
  }
}
