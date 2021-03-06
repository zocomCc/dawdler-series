/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.anywide.dawdler.core.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * 
 * @Title:  DataProcessWorkerPool.java
 * @Description:   数据处理的线程池   
 * @author: jackson.song    
 * @date:   2015年04月21日    
 * @version V1.0 
 * @email: suxuan696@gmail.com
 */
public class DataProcessWorkerPool {
	private static final DataProcessWorkerPool processWorkerPool = new DataProcessWorkerPool();
	private ExecutorService executor;
	private DataProcessWorkerPool() {
//		executor=Executors.newCachedThreadPool((r)->new Thread(r,"processWorker#"));
//		executor=Executors.newCachedThreadPool();
		/*executor=new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                2L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());*/
//		executor=Executors.newCachedThreadPool(new DefaultThreadFactory(DataProcessWorkerPool.class));
//		executor=Executors.newWorkStealingPool();
		executor=Executors.newFixedThreadPool(200,new DefaultThreadFactory(DataProcessWorkerPool.class));
	}
	public static DataProcessWorkerPool getInstance(){
		return processWorkerPool;
	}
	public void execute(Runnable command){
		executor.execute(command);
	}
	public void shutdown() {
		executor.shutdown();
	}
	public void shutdownNow() {
		executor.shutdownNow();
	}
}
