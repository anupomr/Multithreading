package asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComFuture {

	public static void main(String[] args) {
		ExecutorService es= Executors.newFixedThreadPool(4);
		CompletableFuture.supplyAsync(()->1, es)
		.thenApplyAsync(e -> addOne(e), es)
		//.thenApplyAsync(e -> addOne(e/0), es)
		.thenApplyAsync(e -> addOne(e), es)
		.exceptionally(throwable -> handleIt(throwable))
		.thenAcceptAsync(e -> System.out.println(e), es)
		.thenRunAsync(() -> es.shutdown());

		CompletableFuture<Integer> cf3 = new CompletableFuture();
		CompletableFuture<Integer> cf1 = cf3.thenApply(e -> e*10)
										.thenApply(e -> e +10);
		
		//.thenAccept(e -> System.out.println(e));
		
		cf3.complete(1);
		
		CompletableFuture<Integer> cf4 = new CompletableFuture();
		CompletableFuture<Integer> cf2 = cf4.thenApply(e -> e*10)
				.thenApply(e -> e +10);	
		
		
		cf4.complete(1);
		cf2.thenCombine(cf1, (r1,r2) -> r1+r2)
		.thenAccept(e -> System.out.println(e));
	}
	private static int handleIt(Throwable t) {
		System.out.println("Exception Occured "+t);
		return 0;
	}
	private static int  addOne(int e) {
		return e+1;
	}

}
