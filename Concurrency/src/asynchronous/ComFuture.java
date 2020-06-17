package asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComFuture {

	public static void main(String[] args) {
		ExecutorService es= Executors.newFixedThreadPool(4);
		CompletableFuture.supplyAsync(()->1, es)
		.thenApplyAsync(e -> addOne(e), es)
		.thenApplyAsync(e -> addOne(e), es)
		.thenAcceptAsync(e -> System.out.println(e), es)
		.thenRunAsync(() -> es.shutdown());

	}
	private static int  addOne(int e) {
		return e+1;
	}

}
